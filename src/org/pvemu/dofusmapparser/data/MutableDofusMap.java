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
