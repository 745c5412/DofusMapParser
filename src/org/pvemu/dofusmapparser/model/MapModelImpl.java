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
package org.pvemu.dofusmapparser.model;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class MapModelImpl implements MapModel{
    final private int id;
    final private int width;
    final private int height;
    final private int background;
    final private int ambianceId;
    final private int musicId;
    final private boolean outdoor;
    final private int capabilities;
    final private String mapData;

    public MapModelImpl(int id, int width, int height, int background, int ambianceId, int musicId, boolean outdoor, int capabilities, String mapData) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.background = background;
        this.ambianceId = ambianceId;
        this.musicId = musicId;
        this.outdoor = outdoor;
        this.capabilities = capabilities;
        this.mapData = mapData;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getBackground() {
        return background;
    }

    @Override
    public int getAmbianceId() {
        return ambianceId;
    }

    @Override
    public int getMusicId() {
        return musicId;
    }

    @Override
    public boolean isOutdoor() {
        return outdoor;
    }

    @Override
    public int getCapabilities() {
        return capabilities;
    }

    @Override
    public String getMapData() {
        return mapData;
    }
    
}
