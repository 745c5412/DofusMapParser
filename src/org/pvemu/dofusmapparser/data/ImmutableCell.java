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
