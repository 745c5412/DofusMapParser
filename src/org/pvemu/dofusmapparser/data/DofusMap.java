package org.pvemu.dofusmapparser.data;

import java.lang.reflect.Array;
import org.pvemu.dofusmapparser.common.DofusMapUtils;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
abstract public class DofusMap<C extends Cell>{
    protected int id;
    protected int width;
    protected int height;
    protected int background;
    protected int ambianceId;
    protected int musicId;
    protected boolean outdoor;
    protected int capabilities;
    protected C[] cells; //arrays are more effecient than ArrayList

    public DofusMap(int id, int width, int height, int background, int ambianceId, int musicId, boolean outdoor, int capabilities, C[] cells) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.background = background;
        this.ambianceId = ambianceId;
        this.musicId = musicId;
        this.outdoor = outdoor;
        this.capabilities = capabilities;
        this.cells = cells;
        checkMapCells();
    }
    
    final protected void checkMapCells(){
        int size = DofusMapUtils.getMapSize(width, height);
        
        if(size != cells.length){ //change map size
            C[] nCells = (C[])Array.newInstance(createEmptyCell().getClass(), size);
            int length = cells.length;

            if(length > size)
                length = size;

            System.arraycopy(cells, 0, nCells, 0, length);
            cells = nCells;
        }
        
        //check null cells
        for(int i = 0; i < size; ++i){
            if(cells[i] == null)
                cells[i] = createEmptyCell();
        }
    }
    
    abstract protected C createEmptyCell();

    public int getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getBackground() {
        return background;
    }

    public int getAmbianceId() {
        return ambianceId;
    }

    public int getMusicId() {
        return musicId;
    }

    public boolean isOutdoor() {
        return outdoor;
    }

    public int getCapabilities() {
        return capabilities;
    }    

    public C getCell(int num) {
        if(num < 0 || num > size())
            throw new IndexOutOfBoundsException("Try to access a cell " + num + " but the map size is " + size());
        
        return cells[num];
    }

    public int size() {
        return cells.length;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
        hash = 89 * hash + this.width;
        hash = 89 * hash + this.height;
        hash = 89 * hash + this.background;
        hash = 89 * hash + this.ambianceId;
        hash = 89 * hash + this.musicId;
        hash = 89 * hash + (this.outdoor ? 1 : 0);
        hash = 89 * hash + this.capabilities;
        int aHash = 1;
        
        for(Cell cell : cells){
            aHash = aHash * 31 + cell.hashCode();
        }
        
        hash = hash * 89 + aHash;
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DofusMap)) {
            return false;
        }
        final DofusMap<?> other = (DofusMap<?>) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.width != other.width) {
            return false;
        }
        if (this.height != other.height) {
            return false;
        }
        if (this.background != other.background) {
            return false;
        }
        if (this.ambianceId != other.ambianceId) {
            return false;
        }
        if (this.musicId != other.musicId) {
            return false;
        }
        if (this.outdoor != other.outdoor) {
            return false;
        }
        if (this.capabilities != other.capabilities) {
            return false;
        }
        if(cells.length != other.cells.length)
            return false;
        for(int i = 0; i < cells.length; ++i){
            if(!cells[i].equals(other.cells[i]))
                return false;
        }
        return true;
    }
    
}
