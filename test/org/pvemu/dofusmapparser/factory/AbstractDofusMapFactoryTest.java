package org.pvemu.dofusmapparser.factory;

import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import org.pvemu.dofusmapparser.data.Cell;
import org.pvemu.dofusmapparser.data.CellObject;
import org.pvemu.dofusmapparser.data.DofusMap;
import org.pvemu.dofusmapparser.data.Layer;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class AbstractDofusMapFactoryTest {
    
    public AbstractDofusMapFactoryTest() {
    }

    /**
     * Test of buildMap method, of class AbstractDofusMapFactory.
     */
    @Test
    public void testBuildMap() throws Exception {
        System.out.println("buildMap");
        int id = 10000;
        int width = 15;
        int height = 17;
        int background = 341;
        int ambianceId = 0;
        int musicId = 128;
        boolean outdoor = true;
        int capabilities = 98;
        String mapData = "HhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhfDeaaa0LHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaGhf_eaaa1nGhgbeaaa1wHhGaeaaaaaHhGaeaaaaaHhqaeqgaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaa0JHhaaeaaaaaHhGaeaaaaaGhaaeaaa1iGhaaeaaa1tHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaGhaaeaaa1nHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGae0yiaaGhaaeaaa0MGhgaeaaa1sHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaGhaaeaaa1vHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaGhf-eaaa1kHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDe0FaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1kHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaae0ia1vHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaGhf9eaaa1jHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhaae0ziaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1kHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaa1bHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaa0DHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDe0EaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhaaeaaa0DHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhqaeaaaqgHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaa0LHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaa02HhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGae1aiaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaaaaGhaaeaaa0nHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaae0haaaHhaaeaaaaaGhaaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaa02HhGaeaaaaaGhaaeaaaaaHhaaeaaaaaGhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDe0GaaaHhfDeaaaaaHhfDe0FaaaHhfDeaaaaaHhfDeaaa0JHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa0rHhaae0haaaGhaaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1wGhaaeaaaaaHhaaeaaaaaGhaaeaaa1vHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaae0wiaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaaaaGhaaeaaaaaGhaaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaaaaGhaaeaaaaaHhaaeaaaaaGhaaeaaa1kHhGaeaaaaaHhaae0uaaaHhaaeaaaaaHhaae0vaaaHhaae0uaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhgbeaaa1tGhaaeaaaaaGhfyeaaa0oGhaae0haaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1jGhaaeaaaaaGhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa0OGhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaa0DHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0iaaaGhaaeaaa1vHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaa0DHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhqaeqgaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1mGhaaeaaa1uHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1iHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGae0iaaaGhaaeaaa1pHhGaeaaaaaHhGaeaaa1bHhGaeaaaaaGhaaeaaa0MHhqae0haqgHhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaa02HhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhaae0iaaaGhaaeaaa1tHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaa";
        
        
        AbstractDofusMapFactory i1 = new ImmutableDofusMapFactory();
        AbstractDofusMapFactory i2 = new MutableDofusMapFactory();
        AbstractDofusMapFactory i3 = new CachedDofusMapFactory();
        
        DofusMap m1 = i1.buildMap(id, width, height, background, ambianceId, musicId, outdoor, capabilities, mapData);
        DofusMap m2 = i2.buildMap(id, width, height, background, ambianceId, musicId, outdoor, capabilities, mapData);
        DofusMap m3 = i3.buildMap(id, width, height, background, ambianceId, musicId, outdoor, capabilities, mapData);
        
        try{
            assertEquals(m1, m2);
            assertEquals(m2, m3);
            assertEquals(m1, m3);
        }catch(Exception e){
            fail(e.toString());
        }
    }

    /**
     * Test of makeCell method, of class AbstractDofusMapFactory.
     */
    @Test
    public void testMakeCell() {
        System.out.println("makeCell");
        String cellData = "HhfDeaaaaa";
        AbstractDofusMapFactory i1 = new ImmutableDofusMapFactory();
        AbstractDofusMapFactory i2 = new MutableDofusMapFactory();
        AbstractDofusMapFactory i3 = new CachedDofusMapFactory();
        
        try{
            assertEquals(i1.makeCell(cellData), i2.makeCell(cellData));
            assertEquals(i2.makeCell(cellData), i3.makeCell(cellData));
            assertEquals(i1.makeCell(cellData), i3.makeCell(cellData));
        }catch(Exception e){
            fail(e.toString());
        }
    }
    
}
