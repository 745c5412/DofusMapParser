package update;

import org.pvemu.dofusmapparser.DofusMapParser;
import org.pvemu.dofusmapparser.data.Layer;
import org.pvemu.dofusmapparser.data.MutableDofusMap;
import org.pvemu.dofusmapparser.factory.MutableDofusMapFactory;
import org.pvemu.dofusmapparser.factory.exception.BadMapDataException;
import org.pvemu.dofusmapparser.factory.exception.BadMapSizeException;
import org.pvemu.dofusmapparser.model.MapModel;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class UpdateMapData {
    public static void main(String[] args) throws BadMapDataException, BadMapSizeException {
        
        //get a map model
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
        
        MutableDofusMapFactory factory = DofusMapParser.getMutableDofusMapFactory(); //get the mutable factory (to modify the map)
        MutableDofusMap map = factory.buildMap(model); //build the map
        
        //changes values
        map.getCell(150).getObject(Layer.GROUND).setRotation(10);
        map.getCell(25).getObject(Layer.LAYER2).setInteractive(true);
        map.getCell(75).getObject(Layer.LAYER1).setObjectID(25);
        map.setHeight(18);
        map.setWidth(14);
        
        //compress and generate a new MapModel
        MapModel modified = DofusMapParser.getCompressor().generateMapModel(map);
        
        
        //compare...
        int length = modified.getMapData().length() > model.getMapData().length() ? modified.getMapData().length() : model.getMapData().length();
        
        for(int i = 0; i < length; ++i){
            char c1 = 0;
            char c2 = 0;
            
            if(i < model.getMapData().length())
                c1 = model.getMapData().charAt(i);
            
            if(i < modified.getMapData().length())
                c2 = modified.getMapData().charAt(i);
            
            if(c1 != c2)
                System.out.println(i + " : " + c1 + " => " + c2);
        }
    }
}
