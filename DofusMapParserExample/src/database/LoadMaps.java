package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class LoadMaps {

    public static void main(String[] args) throws SQLException {
        Connexion connexion = new Connexion();

        //execute the query
        ResultSet RS = connexion.query("SELECT * FROM maps");

        List<MapModel> models = new ArrayList<>();

        //and load models
        while (RS.next()) {
            final int id = RS.getInt("id");
            final int width = RS.getInt("width");
            final int height = RS.getInt("heigth");
            final int background = 0;
            final int ambianceId = 0;
            final int musicId = 0;
            final boolean outdoor = true;
            final int capabilities = RS.getInt("capabilities");
            final String mapData = RS.getString("mapData");

            models.add(new MapModel() {

                @Override
                public int getId() {
                    return id;
                }

                @Override
                public int getWidth() {
                    return width;
                }

                @Override
                public int getHeight() {
                    return height;
                }

                @Override
                public int getBackground() {
                    return background;
                }

                @Override
                public int getAmbianceId() {
                    return ambianceId;
                }

                @Override
                public int getMusicId() {
                    return musicId;
                }

                @Override
                public boolean isOutdoor() {
                    return outdoor;
                }

                @Override
                public int getCapabilities() {
                    return capabilities;
                }

                @Override
                public String getMapData() {
                    return mapData;
                }
            });
        }

        //and finally build maps
        DofusMapFactory factory = DofusMapParser.getImmutableDofusMapFactory();
        
        List<DofusMap> maps = new ArrayList<DofusMap>(models.size());

        for(MapModel model : models) {
            try{
                maps.add(factory.buildMap(model));
            }catch(Exception e){
                System.err.println("invalid map");
            }
        }
    }
}
