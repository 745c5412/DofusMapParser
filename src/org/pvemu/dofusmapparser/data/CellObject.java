package org.pvemu.dofusmapparser.data;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
abstract public class CellObject{
    protected int objectID;
    protected boolean flip;
    protected boolean interactive;
    protected int rotation;

    public CellObject(int objectID, boolean flip, boolean interactive, int rotation) {
        this.objectID = objectID;
        this.flip = flip;
        this.interactive = interactive;
        this.rotation = rotation;
    }

    public CellObject() {
        this(0, false, false, 0);
    }

    public int getObjectID() {
        return objectID;
    }

    public boolean isFlip() {
        return flip;
    }

    public boolean isInteractive() {
        return interactive;
    }

    public int getRotation() {
        return rotation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.objectID;
        hash = 41 * hash + (this.flip ? 1 : 0);
        hash = 41 * hash + (this.interactive ? 1 : 0);
        hash = 41 * hash + this.rotation;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CellObject)) {
            return false;
        }
        final CellObject other = (CellObject) obj;
        if (this.objectID != other.getObjectID()) {
            return false;
        }
        if (this.flip != other.isFlip()) {
            return false;
        }
        if (this.interactive != other.isInteractive()) {
            return false;
        }
        if (this.rotation != other.getRotation()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CellObject{" + "objectID=" + objectID + ", flip=" + flip + ", interactive=" + interactive + ", rotation=" + rotation + '}';
    }
}
