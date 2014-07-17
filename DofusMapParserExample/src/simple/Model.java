package simple;

import org.pvemu.dofusmapparser.DofusMapParser;
import org.pvemu.dofusmapparser.data.DofusMap;
import org.pvemu.dofusmapparser.factory.DofusMapFactory;
import org.pvemu.dofusmapparser.factory.exception.BadMapDataException;
import org.pvemu.dofusmapparser.factory.exception.BadMapSizeException;
import org.pvemu.dofusmapparser.model.MapModel;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class Model {
    public static void main(String[] args) throws BadMapDataException, BadMapSizeException {
        System.out.println("Model");
        
        //you can use a model to load maps
        MapModel model = new MapModel() {

            @Override
            public int getId() {
                return 10000;
            }

            @Override
            public int getWidth() {
                return 15;
            }

            @Override
            public int getHeight() {
                return 17;
            }

            @Override
            public int getBackground() {
                return 341;
            }

            @Override
            public int getAmbianceId() {
                return 0;
            }

            @Override
            public int getMusicId() {
                return 128;
            }

            @Override
            public boolean isOutdoor() {
                return true;
            }

            @Override
            public int getCapabilities() {
                return 98;
            }

            @Override
            public String getMapData() {
                return "HhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhfDeaaa0LHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaGhf_eaaa1nGhgbeaaa1wHhGaeaaaaaHhGaeaaaaaHhqaeqgaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaa0JHhaaeaaaaaHhGaeaaaaaGhaaeaaa1iGhaaeaaa1tHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaGhaaeaaa1nHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGae0yiaaGhaaeaaa0MGhgaeaaa1sHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaGhaaeaaa1vHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaGhf-eaaa1kHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDe0FaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1kHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaae0ia1vHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaGhf9eaaa1jHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhaae0ziaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1kHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaa1bHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaa0DHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDe0EaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhaaeaaa0DHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhqaeaaaqgHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaa0LHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaa02HhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGae1aiaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaaaaGhaaeaaa0nHhGaeaaaaaHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaae0haaaHhaaeaaaaaGhaaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaa02HhGaeaaaaaGhaaeaaaaaHhaaeaaaaaGhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhfDe0GaaaHhfDeaaaaaHhfDe0FaaaHhfDeaaaaaHhfDeaaa0JHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa0rHhaae0haaaGhaaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1wGhaaeaaaaaHhaaeaaaaaGhaaeaaa1vHhGaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaae0wiaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaaaaGhaaeaaaaaGhaaeaaaaaHhGaeaaaaaHhaaeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhfDeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaaaaGhaaeaaaaaHhaaeaaaaaGhaaeaaa1kHhGaeaaaaaHhaae0uaaaHhaaeaaaaaHhaae0vaaaHhaae0uaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhgbeaaa1tGhaaeaaaaaGhfyeaaa0oGhaae0haaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1jGhaaeaaaaaGhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa0OGhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaa0DHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0iaaaGhaaeaaa1vHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaa0DHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhqaeqgaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1mGhaaeaaa1uHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaGhaaeaaa1iHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhGaeaaaaaHhGae0iaaaGhaaeaaa1pHhGaeaaaaaHhGaeaaa1bHhGaeaaaaaGhaaeaaa0MHhqae0haqgHhGaeaaaaaHhGae0haaaHhGaeaaaaaHhGaeaaa02HhGaeaaaaaHhGaeaaaaaHhaaeaaaaaHhaae0iaaaGhaaeaaa1tHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaaHhaaeaaaaa";
            }
        };
        
        DofusMapFactory factory = DofusMapParser.getImmutableDofusMapFactory();
        DofusMap map = factory.buildMap(model);
    }
}
