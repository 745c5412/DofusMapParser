package org.pvemu.dofusmapparser.factory;

import org.pvemu.dofusmapparser.data.DofusMap;
import org.pvemu.dofusmapparser.factory.exception.BadMapDataException;
import org.pvemu.dofusmapparser.factory.exception.BadMapSizeException;
import org.pvemu.dofusmapparser.model.MapModel;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public interface DofusMapFactory<M extends DofusMap>{
    public M buildMap(int id, int width, int height, int background, int ambianceId, int musicId, boolean outdoor, int capabilities, String mapData) throws BadMapDataException, BadMapSizeException;
    public M buildMap(MapModel model) throws BadMapDataException, BadMapSizeException;
}
