package org.pvemu.dofusmapparser.data;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class ImmutableCellObject extends CellObject{ 

    public ImmutableCellObject(int objectID, boolean flip, boolean interactive, int rotation) {
        super(objectID, flip, interactive, rotation);
    }

    public ImmutableCellObject() {
    }
    
}
