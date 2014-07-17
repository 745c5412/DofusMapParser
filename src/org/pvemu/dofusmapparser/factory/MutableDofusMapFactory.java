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
