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

import java.util.EnumMap;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class ImmutableDofusMap extends DofusMap<Cell>{
    final static private ImmutableCell EMPTY_CELL = new ImmutableCell(true, true, 4, 1, 7, new EnumMap<Layer, ImmutableCellObject>(Layer.class));

    public ImmutableDofusMap(int id, int width, int height, int background, int ambianceId, int musicId, boolean outdoor, int capabilities, ImmutableCell[] cells) {
        super(id, width, height, background, ambianceId, musicId, outdoor, capabilities, cells);
    }

    @Override
    protected ImmutableCell createEmptyCell() {
        return EMPTY_CELL;
    }
    
}
