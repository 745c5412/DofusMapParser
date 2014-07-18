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
package org.pvemu.dofusmapparser.compressor;

import org.pvemu.dofusmapparser.common.DofusMapUtils;
import org.pvemu.dofusmapparser.data.Cell;
import org.pvemu.dofusmapparser.data.CellObject;
import org.pvemu.dofusmapparser.data.DofusMap;
import org.pvemu.dofusmapparser.data.Layer;
import org.pvemu.dofusmapparser.model.MapModel;
import org.pvemu.dofusmapparser.model.MapModelImpl;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class DofusMapCompressorImpl implements DofusMapCompressor{

    @Override
    public MapModel generateMapModel(DofusMap map) {
        return new MapModelImpl(
                map.getId(), 
                map.getWidth(),
                map.getHeight(),
                map.getBackground(),
                map.getAmbianceId(),
                map.getMusicId(),
                map.isOutdoor(),
                map.getCapabilities(),
                generateMapData(map)
        );
    }

    @Override
    public String generateMapData(DofusMap map) {
        int size = map.size();
        StringBuilder sb = new StringBuilder(size * 10);
        
        for(int i = 0; i < size; ++i){
            sb.append(compressCell(map.getCell(i)));
        }
        
        return sb.toString();
    }
    
    private String compressCell(Cell cell){
        CellObject ground = cell.getObject(Layer.GROUND);
        CellObject layer1 = cell.getObject(Layer.LAYER1);
        CellObject layer2 = cell.getObject(Layer.LAYER2);
        
        int[] _loc4 = new int[10];
        _loc4[0] = (cell.isActive() ? 1 : 0) << 5;
        _loc4[0] = _loc4[0] | (cell.isLineOfSight() ? (1) : (0));
        _loc4[0] = _loc4[0] | (ground.getObjectID() & 1536) >> 6;
        _loc4[0] = _loc4[0] | (layer1.getObjectID() & 8192) >> 11;
        _loc4[0] = _loc4[0] | (layer2.getObjectID() & 8192) >> 12;
        _loc4[1] = (ground.getRotation() & 3) << 4;
        _loc4[1] = _loc4[1] | cell.getGroundLevel() & 15;
        _loc4[2] = (cell.getMovement() & 7) << 3;
        _loc4[2] = _loc4[2] | ground.getObjectID() >> 6 & 7;
        _loc4[3] = ground.getObjectID() & 63;
        _loc4[4] = (cell.getGroundSlope() & 15) << 2;
        _loc4[4] = _loc4[4] | (ground.isFlip() ? (1) : (0)) << 1;
        _loc4[4] = _loc4[4] | layer1.getObjectID() >> 12 & 1;
        _loc4[5] = layer1.getObjectID() >> 6 & 63;
        _loc4[6] = layer1.getObjectID() & 63;
        _loc4[7] = (layer1.getRotation() & 3) << 4;
        _loc4[7] = _loc4[7] | (layer1.isFlip() ? (1) : (0)) << 3;
        _loc4[7] = _loc4[7] | (layer2.isFlip() ? (1) : (0)) << 2;
        _loc4[7] = _loc4[7] | (layer2.isInteractive() ? (1) : (0)) << 1;
        _loc4[7] = _loc4[7] | layer2.getObjectID() >> 12 & 1;
        _loc4[8] = layer2.getObjectID() >> 6 & 63;
        _loc4[9] = layer2.getObjectID() & 63;
        
        StringBuilder sb = new StringBuilder(10);
        
        for(int i : _loc4){
            sb.append(DofusMapUtils.getBase64Char((byte)i));
        }
        
        return sb.toString();
    }
    
}
