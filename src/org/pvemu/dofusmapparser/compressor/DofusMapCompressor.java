package org.pvemu.dofusmapparser.compressor;

import org.pvemu.dofusmapparser.data.DofusMap;
import org.pvemu.dofusmapparser.model.MapModel;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public interface DofusMapCompressor {
    public MapModel generateMapModel(DofusMap map);
    public String generateMapData(DofusMap map);
}
