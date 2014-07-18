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
public class MutableDofusMap extends DofusMap<MutableCell>{

    public MutableDofusMap(int id, int width, int height, int background, int ambianceId, int musicId, boolean outdoor, int capabilities, MutableCell[] cells) {
        super(id, width, height, background, ambianceId, musicId, outdoor, capabilities, cells);
    }

    @Override
    protected MutableCell createEmptyCell() {
        return new MutableCell(true, true, 4, 1, 7, new EnumMap<Layer, MutableCellObject>(Layer.class));
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWidth(int width) {
        this.width = width;
        checkMapCells();
    }

    public void setHeight(int height) {
        this.height = height;
        checkMapCells();
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public void setAmbianceId(int ambianceId) {
        this.ambianceId = ambianceId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public void setOutdoor(boolean outdoor) {
        this.outdoor = outdoor;
    }

    public void setCapabilities(int capabilities) {
        this.capabilities = capabilities;
    }

    public void setCell(int id, MutableCell cell) {
        if(id < 0 || id >= size())
            throw new IndexOutOfBoundsException("Cannot set the cell " + id + " : the map size is " + size());
                    
        cells[id] = cell;
    }
    
}
