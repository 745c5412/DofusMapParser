package org.pvemu.dofusmapparser.data;

import java.util.Map;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class MutableCell extends Cell<MutableCellObject>{

    public MutableCell(boolean active, boolean lineOfSight, int movement, int groundSlope, int groundLevel, Map<Layer, MutableCellObject> objects) {
        super(active, lineOfSight, movement, groundSlope, groundLevel, objects);
    }

    @Override
    protected MutableCellObject getDefaultObject() {
        return new MutableCellObject();
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setLineOfSight(boolean lineOfSight) {
        this.lineOfSight = lineOfSight;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public void setGroundSlope(int groundSlope) {
        this.groundSlope = groundSlope;
    }

    public void setGroundLevel(int level) {
        this.groundLevel = level;
    }

    public void setObject(Layer layer, MutableCellObject obj) {
        if(obj == null)
            throw new NullPointerException("No null objects available !");
        
        objects.put(layer, obj);
    }
    
}
