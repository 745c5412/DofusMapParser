package org.pvemu.dofusmapparser.data;

import org.pvemu.dofusmapparser.data.MutableDofusMap;
import org.pvemu.dofusmapparser.data.DofusMap;
import org.pvemu.dofusmapparser.data.ImmutableDofusMap;
import org.junit.Test;
import static org.junit.Assert.*;
import org.pvemu.dofusmapparser.data.ImmutableCell;
import org.pvemu.dofusmapparser.data.MutableCell;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class AbstractDofusMapTest {
    
    public AbstractDofusMapTest() {
    }

    /**
     * Test of size method, of class DofusMap.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        DofusMap instance = new ImmutableDofusMap(0, 4, 3, 0, 0, 0, true, 14, new ImmutableCell[]{});
        int expResult = 18;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class DofusMap.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        DofusMap i1 = new ImmutableDofusMap(0, 4, 3, 0, 0, 0, true, 14, new ImmutableCell[]{});
        DofusMap i2 = new MutableDofusMap(0, 4, 3, 0, 0, 0, true, 14, new MutableCell[]{});
        assertEquals(i1.hashCode(), i2.hashCode());
    }

    /**
     * Test of equals method, of class DofusMap.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        DofusMap i1 = new ImmutableDofusMap(0, 4, 3, 0, 0, 0, true, 14, new ImmutableCell[]{});
        DofusMap i2 = new MutableDofusMap(0, 4, 3, 0, 0, 0, true, 14, new MutableCell[]{});
        assertEquals(i1, i2);
        DofusMap i3 = new MutableDofusMap(9, 4, 3, 0, 0, 0, true, 14, new MutableCell[]{});
        assertFalse(i3.equals(i1));
    }
    
}
