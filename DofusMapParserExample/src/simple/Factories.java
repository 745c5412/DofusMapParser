package simple;

import org.pvemu.dofusmapparser.DofusMapParser;
import org.pvemu.dofusmapparser.data.DofusMap;
import org.pvemu.dofusmapparser.factory.DofusMapFactory;
import org.pvemu.dofusmapparser.factory.exception.BadMapDataException;
import org.pvemu.dofusmapparser.factory.exception.BadMapSizeException;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class Factories {
    public static void main(String[] args) throws BadMapDataException, BadMapSizeException {
        System.out.println("Factories");
        int id = 10000;
        int width = 15;
        int height = 17;
        int background = 341;
        int ambianceId = 0;
        int musicId = 128;
        boolean outdoor = true;
        int capabilities = 98;
        String mapData = "HhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhfDeaaa0LHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaGhf_eaaa1nGhgbeaaa1wHhGaeaaaaaHhGaeaaaaaHhqaeqgaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaa0JHhaaeaaaaaHhGaeaaaaaGhaaeaaa1iGhaaeaaa1tHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaGhaaeaaa1nHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGae0yiaaGhaaeaaa0MGhgaeaaa1sHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaGhaaeaaa1vHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaGhf-eaaa1kHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDe0FaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1kHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaae0ia1vHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaGhf9eaaa1jHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhaae0ziaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1kHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaa1bHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaa0DHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDe0EaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhaaeaaa0DHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhqaeaaaqgHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaa0LHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaa02HhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGae1aiaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaaaaGhaaeaaa0nHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaae0haaaHhaaeaaaaaGhaaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaa02HhGaeaaaaaGhaaeaaaaaHhaaeaaaaaGhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDe0GaaaHhfDeaaaaaHhfDe0FaaaHhfDeaaaaaHhfDeaaa0JHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa0rHhaae0haaaGhaaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1wGhaaeaaaaaHhaaeaaaaaGhaaeaaa1vHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaae0wiaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaaaaGhaaeaaaaaGhaaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaaaaGhaaeaaaaaHhaaeaaaaaGhaaeaaa1kHhGaeaaaaaHhaae0uaaaHhaaeaaaaaHhaae0vaaaHhaae0uaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhgbeaaa1tGhaaeaaaaaGhfyeaaa0oGhaae0haaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1jGhaaeaaaaaGhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa0OGhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaa0DHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0iaaaGhaaeaaa1vHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaa0DHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhqaeqgaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1mGhaaeaaa1uHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1iHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGae0iaaaGhaaeaaa1pHhGaeaaaaaHhGaeaaa1bHhGaeaaaaaGhaaeaaa0MHhqae0haqgHhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaa02HhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhaae0iaaaGhaaeaaa1tHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaa";
        
        //there is 3 factories
        DofusMapFactory f1 = DofusMapParser.getMutableDofusMapFactory(); //mutable factory : build a read/write map
        DofusMapFactory f2 = DofusMapParser.getImmutableDofusMapFactory(); //immutable factory : build a read only map
        DofusMapFactory f3 = DofusMapParser.getCachedDofusMapFactory(); //cached factory : build a read only map, with using a cache system.
        //it use less memory to load a lot of maps, but more if you load only one map
        
        DofusMap m1 = f1.buildMap(id, width, height, background, ambianceId, musicId, outdoor, capabilities, mapData);
        DofusMap m2 = f2.buildMap(id, width, height, background, ambianceId, musicId, outdoor, capabilities, mapData);
        DofusMap m3 = f3.buildMap(id, width, height, background, ambianceId, musicId, outdoor, capabilities, mapData);
        
        //the generated maps are equals with the 3 factories
        assert m1.equals(m2);
        assert m2.equals(m3);
        assert m1.equals(m3);
    }
}
