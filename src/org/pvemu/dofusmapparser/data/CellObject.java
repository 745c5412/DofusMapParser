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
