package org.pvemu.dofusmapparser;

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
    
    
}
