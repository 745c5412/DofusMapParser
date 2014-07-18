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
import org.pvemu.dofusmapparser.data.Layer;
import org.pvemu.dofusmapparser.data.MutableCell;
import org.pvemu.dofusmapparser.data.MutableCellObject;
import org.pvemu.dofusmapparser.data.MutableDofusMap;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class MutableDofusMapFactory extends AbstractDofusMapFactory<MutableDofusMap, MutableCell, MutableCellObject>{

    @Override
    protected MutableDofusMap createMap(int id, int width, int height, int background, int ambianceId, int musicId, boolean outdoor, int capabilities, MutableCell[] cells) {
        return new MutableDofusMap(id, width, height, background, ambianceId, musicId, outdoor, capabilities, cells);
    }

    @Override
    protected MutableCell getCell(boolean active, boolean lineOfSight, int movement, int groundSlope, int groundLevel, Map<Layer, MutableCellObject> objects) {
        return new MutableCell(active, lineOfSight, movement, groundSlope, groundLevel, objects);
    }

    @Override
    protected MutableCellObject getObject(int objectID, boolean flip, boolean interactive, int rotation) {
        return new MutableCellObject(objectID, flip, interactive, rotation);
    }
    
}
