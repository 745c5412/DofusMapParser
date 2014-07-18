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

import java.util.Map;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
abstract public class Cell<O extends CellObject>{
    protected boolean active;
    protected boolean lineOfSight;
    protected int movement;
    protected int groundSlope;
    protected int groundLevel;
    final protected Map<Layer, O> objects;

    public Cell(boolean active, boolean lineOfSight, int movement, int groundSlope, int groundLevel, Map<Layer, O> objects) {
        this.active = active;
        this.lineOfSight = lineOfSight;
        this.movement = movement;
        this.groundSlope = groundSlope;
        this.groundLevel = groundLevel;
        this.objects = objects;
    }
    
    protected abstract O getDefaultObject();

    public boolean isActive() {
        return active;
    }

    public boolean isLineOfSight() {
        return lineOfSight;
    }

    public int getMovement() {
        return movement;
    }

    public int getGroundSlope() {
        return groundSlope;
    }

    public int getGroundLevel() {
        return groundLevel;
    }

    public O getObject(Layer layer) {
        if(!objects.containsKey(layer))
            objects.put(layer, getDefaultObject());
        
        return objects.get(layer);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.active ? 1 : 0);
        hash = 59 * hash + (this.lineOfSight ? 1 : 0);
        hash = 59 * hash + this.movement;
        hash = 59 * hash + this.groundSlope;
        hash = 59 * hash + this.groundLevel;
        
        int mHash = 1;
        for(Layer layer : Layer.values()){
            mHash = 15 * mHash + getObject(layer).hashCode();
        }
        
        hash = 59 * hash + mHash;
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Cell)) {
            return false;
        }
        final Cell<?> other = (Cell<?>) obj;
        if (this.active != other.isActive()) {
            return false;
        }
        if (this.lineOfSight != other.isLineOfSight()) {
            return false;
        }
        if (this.movement != other.getMovement()) {
            return false;
        }
        if (this.groundSlope != other.getGroundSlope()) {
            return false;
        }
        if (this.groundLevel != other.getGroundLevel()) {
            return false;
        }
        for(Layer layer : Layer.values()){
            if(!getObject(layer).equals(other.getObject(layer)))
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String objs = "[ ";
        
        for(Layer layer : Layer.values()){
            objs += layer.name() + " => " + getObject(layer) + ", ";
        }
        
        objs += "]";
        
        return "Cell{" + "active=" + active + ", lineOfSight=" + lineOfSight + ", movement=" + movement + ", groundSlope=" + groundSlope + ", groundLevel=" + groundLevel + ", objects=" + objs + '}';
    }
}
