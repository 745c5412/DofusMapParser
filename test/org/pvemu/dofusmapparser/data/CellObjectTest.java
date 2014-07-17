package org.pvemu.dofusmapparser.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class CellObjectTest {
    
    public CellObjectTest() {
    }

    /**
     * Test of getObjectID method, of class CellObject.
     */
    @Test
    public void testGetObjectID() {
        System.out.println("getObjectID");
        CellObject instance = new CellObjectImpl();
        int expResult = 0;
        int result = instance.getObjectID();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFlip method, of class CellObject.
     */
    @Test
    public void testIsFlip() {
        System.out.println("isFlip");
        CellObject instance = new CellObjectImpl();
        boolean expResult = false;
        boolean result = instance.isFlip();
        assertEquals(expResult, result);
    }

    /**
     * Test of isInteractive method, of class CellObject.
     */
    @Test
    public void testIsInteractive() {
        System.out.println("isInteractive");
        CellObject instance = new CellObjectImpl();
        boolean expResult = false;
        boolean result = instance.isInteractive();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRotation method, of class CellObject.
     */
    @Test
    public void testGetRotation() {
        System.out.println("getRotation");
        CellObject instance = new CellObjectImpl();
        int expResult = 0;
        int result = instance.getRotation();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class CellObject.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");        
        CellObject i1 = new CellObjectImpl();
        CellObject i2 = new MutableCellObject();
        CellObject i3 = new ImmutableCellObject(9, true, true, 90);
        assertEquals(i1, i2);
        assertNotSame(i1, i2);
        assertFalse(i1.equals(i3));
    }
    
    @Test
    public void testHashCode(){
        System.out.println("hashCode");
        Object obj = new MutableCellObject();
        CellObject instance = new ImmutableCellObject();
        assertEquals(instance.hashCode(), obj.hashCode());
    }
    
    private class CellObjectImpl extends CellObject{

        public CellObjectImpl(int objectID, boolean flip, boolean interactive, int rotation) {
            super(objectID, flip, interactive, rotation);
        }

        public CellObjectImpl() {
        }
        
    }
}
