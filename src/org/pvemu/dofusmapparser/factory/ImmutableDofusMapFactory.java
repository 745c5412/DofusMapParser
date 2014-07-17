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
