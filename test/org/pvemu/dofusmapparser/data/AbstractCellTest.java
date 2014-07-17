package org.pvemu.dofusmapparser.data;

import java.util.EnumMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class AbstractCellTest {
    
    public AbstractCellTest() {
    }

    /**
     * Test of getDefaultObject method, of class Cell.
     */
    @Test
    public void testGetDefaultObject() {
        System.out.println("getDefaultObject");
        Cell instance = new ImmutableCell(true, true, 4, 1, 7, new EnumMap<Layer, ImmutableCellObject>(Layer.class));
        Object expResult = new ImmutableCellObject();
        
        Object result = instance.getDefaultObject();
        assertEquals(result, expResult);
    }

    /**
     * Test of getObject method, of class Cell.
     */
    @Test
    public void testGetObject() {
        System.out.println("getObject");
        Layer layer = Layer.GROUND;
        Map<Layer, ImmutableCellObject> objects = new EnumMap<>(Layer.class);
        ImmutableCellObject obj = new ImmutableCellObject(5, true, false, 90);
        objects.put(Layer.LAYER1, obj);
        Cell instance = new ImmutableCell(true, true, 0, 0, 0, objects);
        Object expResult = instance.getDefaultObject();
        Object result = instance.getObject(layer);
        assertEquals(expResult, result);
        assertEquals(instance.getObject(Layer.LAYER1), obj);
    }

    /**
     * Test of hashCode method, of class Cell.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        boolean active = true;
        boolean lineOfSight = true;
        int movement = 4;
        int groundSlope = 1;
        int groundLevel = 7;
        
        
        Map<Layer, ImmutableCellObject> objects1 = new EnumMap<>(Layer.class);
        ImmutableCellObject cellObj1 = new ImmutableCellObject(5, true, false, 90);
        objects1.put(Layer.LAYER1, cellObj1);
        Cell obj1 = new ImmutableCell(active, lineOfSight, movement, groundSlope, groundLevel, objects1);
        
        Map<Layer, MutableCellObject> objects2 = new EnumMap<>(Layer.class);
        MutableCellObject cellObj2 = new MutableCellObject(5, true, false, 90);
        objects2.put(Layer.LAYER1, cellObj2);
        Cell obj2 = new MutableCell(active, lineOfSight, movement, groundSlope, groundLevel, objects2);
        
        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

    /**
     * Test of equals method, of class Cell.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        final boolean active = true;
        final boolean lineOfSight = true;
        final int movement = 4;
        final int groundSlope = 1;
        final int groundLevel = 7;
        
        final Cell instance1 = new ImmutableCell(active, lineOfSight, movement, groundSlope, groundLevel, new EnumMap<Layer, ImmutableCellObject>(Layer.class));
        final Cell instance2 = new MutableCell(active, lineOfSight, movement, groundSlope, groundLevel, new EnumMap<Layer, MutableCellObject>(Layer.class));
        assertEquals(instance1, instance2);
        assertNotSame(instance1, instance2);
      
        Map<Layer, MutableCellObject> objects = new EnumMap<>(Layer.class);
        objects.put(Layer.GROUND, new MutableCellObject(8, true, false, 180));
        final Cell instance3 = new MutableCell(active, lineOfSight, movement, groundSlope, groundLevel, objects);
        assertFalse(instance1.equals(instance3));
    }
}
