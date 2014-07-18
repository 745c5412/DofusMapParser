/* 
 * Copyright (C) 2014 Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pvemu.dofusmapparser.factory;

import java.lang.reflect.Array;
import java.util.EnumMap;
import java.util.Map;
import org.pvemu.dofusmapparser.common.DofusMapUtils;
import org.pvemu.dofusmapparser.data.Cell;
import org.pvemu.dofusmapparser.data.CellObject;
import org.pvemu.dofusmapparser.data.DofusMap;
import org.pvemu.dofusmapparser.data.Layer;
import org.pvemu.dofusmapparser.factory.exception.BadMapDataException;
import org.pvemu.dofusmapparser.factory.exception.BadMapSizeException;
import org.pvemu.dofusmapparser.model.MapModel;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
abstract public class AbstractDofusMapFactory<M extends DofusMap, C extends Cell, O extends CellObject> implements DofusMapFactory<M>{
    @Override
    public M buildMap(int id, int width, int height, int background, int ambianceId, int musicId, boolean outdoor, int capabilities, String mapData) throws BadMapDataException, BadMapSizeException {
        if((mapData.length() % 10) != 0)
            throw new BadMapDataException("MapData length must be a multiple of 10");
        
        int size = mapData.length() / 10;
        int expected = DofusMapUtils.getMapSize(width, height);
        
        if(size != expected)
            throw new BadMapSizeException(expected, size);
        
        C[] cells = (C[])Array.newInstance(getCell(true, true, 0, 0, 0, null).getClass(), size);
        
        for(int i = 0; i < mapData.length(); i += 10){
            cells[i / 10] = makeCell(mapData.substring(i, i + 10));
        }
        
        return createMap(id, width, height, background, ambianceId, musicId, outdoor, capabilities, cells);
    }
    
    abstract protected M createMap(int id, int width, int height, int background, int ambianceId, int musicId, boolean outdoor, int capabilities, C[] cells);
    
    protected C makeCell(String cellData) throws BadMapDataException{
        if(cellData.length() != 10)
            throw new BadMapDataException("Invalid cellData '" + cellData + "' : expected a length of 10 but get " + cellData.length());
        
        byte[] _loc8 = new byte[cellData.length()];
        
        for(int i = 0; i < cellData.length(); ++i){
            _loc8[i] = DofusMapUtils.getHashIndex(cellData.charAt(i));
        }
        
        Map<Layer, O> objects = new EnumMap<>(Layer.class);
        
        objects.put(Layer.GROUND, getObject(
                ((_loc8[0] & 24) << 6) + ((_loc8[2] & 7) << 6) + _loc8[3], 
                ((_loc8[4] & 2) >> 1) == 1, 
                false, 
                (_loc8[1] & 48) >> 4
        ));
        
        objects.put(Layer.LAYER1, getObject(
                ((_loc8[0] & 4) << 11) + ((_loc8[4] & 1) << 12) + (_loc8[5] << 6) + _loc8[6], 
                (_loc8[7] & 8) >> 3 == 1, 
                false, 
                (_loc8[7] & 48) >> 4
        ));
        
        objects.put(Layer.LAYER2, getObject(
                ((_loc8[0] & 2) << 12) + ((_loc8[7] & 1) << 12) + (_loc8[8] << 6) + _loc8[9], 
                (_loc8[7] & 4) >> 2 == 1, 
                (_loc8[7] & 2) >> 1 == 1, 
                0
        ));
        
        boolean active = (((_loc8[0] & 32) >> 5) != 0);
        boolean lineOfSight = ((_loc8[0] & 1) == 1);
        int groundLevel = (_loc8[1] & 15);
        int movement = ((_loc8[2] & 56) >> 3);
        int groundSlope = ((_loc8[4] & 60) >> 2);
        
        return getCell(active, lineOfSight, movement, groundSlope, groundLevel, objects);
    }
    
    abstract protected C getCell(boolean active, boolean lineOfSight, int movement, int groundSlope, int groundLevel, Map<Layer, O> objects);
    abstract protected O getObject(int objectID, boolean flip, boolean interactive, int rotation);

    @Override
    public M buildMap(MapModel model) throws BadMapDataException, BadMapSizeException {
        return buildMap(
                model.getId(), 
                model.getWidth(), 
                model.getHeight(), 
                model.getBackground(), 
                model.getAmbianceId(), 
                model.getMusicId(),
                model.isOutdoor(), 
                model.getCapabilities(), 
                model.getMapData()
        );
    }
}
