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
package org.pvemu.dofusmapparser;

import org.pvemu.dofusmapparser.compressor.DofusMapCompressor;
import org.pvemu.dofusmapparser.compressor.DofusMapCompressorImpl;
import org.pvemu.dofusmapparser.factory.CachedDofusMapFactory;
import org.pvemu.dofusmapparser.factory.ImmutableDofusMapFactory;
import org.pvemu.dofusmapparser.factory.MutableDofusMapFactory;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
final public class DofusMapParser {
    static private CachedDofusMapFactory cachedDofusMapFactory = null;
    static private ImmutableDofusMapFactory immutableDofusMapFactory = null;
    static private MutableDofusMapFactory mutableDofusMapFactory = null;
    static private DofusMapCompressor compressor = null;

    public static CachedDofusMapFactory getCachedDofusMapFactory() {
        if(cachedDofusMapFactory == null)
            cachedDofusMapFactory = new CachedDofusMapFactory();
        
        return cachedDofusMapFactory;
    }

    public static ImmutableDofusMapFactory getImmutableDofusMapFactory() {
        if(immutableDofusMapFactory == null)
            immutableDofusMapFactory = new ImmutableDofusMapFactory();
        
        return immutableDofusMapFactory;
    }

    public static MutableDofusMapFactory getMutableDofusMapFactory() {
        if(mutableDofusMapFactory == null)
            mutableDofusMapFactory = new MutableDofusMapFactory();
        
        return mutableDofusMapFactory;
    }

    public static DofusMapCompressor getCompressor() {
        if(compressor == null)
            compressor = new DofusMapCompressorImpl();
        
        return compressor;
    }
}
