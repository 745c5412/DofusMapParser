package org.pvemu.dofusmapparser.data;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class MutableCellObject extends CellObject{

    public MutableCellObject(int objectID, boolean flip, boolean interactive, int rotation) {
        super(objectID, flip, interactive, rotation);
    }

    public MutableCellObject() {
    }

    public void setObjectID(int id) {
        objectID = id;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }

    public void setInteractive(boolean interactive) {
        this.interactive = interactive;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
    
}
