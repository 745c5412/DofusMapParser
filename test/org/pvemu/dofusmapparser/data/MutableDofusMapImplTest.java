/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.pvemu.dofusmapparser.data;

import org.pvemu.dofusmapparser.data.MutableDofusMap;
import org.junit.Test;
import static org.junit.Assert.*;
import org.pvemu.dofusmapparser.data.MutableCell;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class MutableDofusMapImplTest {
    
    public MutableDofusMapImplTest() {
    }

    /**
     * Test of setWidth method, of class MutableDofusMap.
     */
    @Test
    public void testSetWidth() {
        System.out.println("setWidth");
        MutableDofusMap instance = getInstance();
        instance.setWidth(3);
        assertEquals(13, instance.size());
    }
    
    private MutableDofusMap getInstance(){
        return new MutableDofusMap(0, 4, 3, 0, 0, 0, true, 14, new MutableCell[]{});
    }

    /**
     * Test of setHeight method, of class MutableDofusMap.
     */
    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        MutableDofusMap instance = getInstance();
        instance.setHeight(4);
        assertEquals(25, instance.size());
    }
    
}
