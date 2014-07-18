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
package org.pvemu.dofusmapparser.factory;

import java.util.Map;
import org.pvemu.dofusmapparser.data.ImmutableCell;
import org.pvemu.dofusmapparser.data.ImmutableCellObject;
import org.pvemu.dofusmapparser.data.ImmutableDofusMap;
import org.pvemu.dofusmapparser.data.Layer;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class ImmutableDofusMapFactory extends AbstractDofusMapFactory<ImmutableDofusMap, ImmutableCell, ImmutableCellObject>{

    @Override
    protected ImmutableDofusMap createMap(int id, int width, int height, int background, int ambianceId, int musicId, boolean outdoor, int capabilities, ImmutableCell[] cells) {
        return new ImmutableDofusMap(id, width, height, background, ambianceId, musicId, outdoor, capabilities, cells);
    }

    @Override
    protected ImmutableCell getCell(boolean active, boolean lineOfSight, int movement, int groundSlope, int groundLevel, Map<Layer, ImmutableCellObject> objects) {
        return new ImmutableCell(active, lineOfSight, movement, groundSlope, groundLevel, objects);
    }

    @Override
    protected ImmutableCellObject getObject(int objectID, boolean flip, boolean interactive, int rotation) {
        return new ImmutableCellObject(objectID, flip, interactive, rotation);
    }
    
}
