package org.pvemu.dofusmapparser.factory;

import java.util.EnumMap;
import java.util.Map;
import org.pvemu.dofusmapparser.common.DofusMapUtils;
import org.pvemu.dofusmapparser.data.ImmutableCell;
import org.pvemu.dofusmapparser.data.CellObject;
import org.pvemu.dofusmapparser.data.Layer;
import org.pvemu.dofusmapparser.factory.exception.BadMapDataException;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
abstract public class AbstractCellFactory<C extends ImmutableCell, O extends CellObject> implements CellFactory<C>{
    @Override
    public C makeCell(String cellData) throws BadMapDataException{
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
}
