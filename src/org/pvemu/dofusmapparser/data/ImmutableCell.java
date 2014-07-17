package org.pvemu.dofusmapparser.data;

import java.util.Map;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class ImmutableCell extends Cell<ImmutableCellObject>{
    final static private ImmutableCellObject DEFAULT_OBJECT = new ImmutableCellObject();

    public ImmutableCell(boolean active, boolean lineOfSight, int movement, int groundSlope, int groundLevel, Map<Layer, ImmutableCellObject> objects) {
        super(active, lineOfSight, movement, groundSlope, groundLevel, objects);
    }

    @Override
    protected ImmutableCellObject getDefaultObject() {
        return DEFAULT_OBJECT; //don't create a new copy -> this object is immutable !
    }
    
}
