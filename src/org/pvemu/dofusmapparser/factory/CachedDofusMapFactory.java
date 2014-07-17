package org.pvemu.dofusmapparser.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.pvemu.dofusmapparser.data.ImmutableCell;
import org.pvemu.dofusmapparser.data.ImmutableCellObject;
import org.pvemu.dofusmapparser.factory.exception.BadMapDataException;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class CachedDofusMapFactory extends ImmutableDofusMapFactory{
    final private Map<String, ImmutableCell> cells = new HashMap<>();
    final private List<ImmutableCellObject> objects = new ArrayList<>();
    


    @Override
    protected ImmutableCell makeCell(String cellData) throws BadMapDataException {
        if(!cells.containsKey(cellData)){
            cells.put(cellData, super.makeCell(cellData));
        }
        
        return cells.get(cellData);
    }

    @Override
    protected ImmutableCellObject getObject(int objectID, boolean flip, boolean interactive, int rotation) {
        ImmutableCellObject object = super.getObject(objectID, flip, interactive, rotation);
        
        for(ImmutableCellObject obj : objects){
            if(obj.equals(object))
                return obj; //get the cached object
        }
        
        //the object doesn't exists yet
        objects.add(object); //store the new object
        return object;
    }
    
}
