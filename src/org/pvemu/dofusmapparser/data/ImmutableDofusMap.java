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
