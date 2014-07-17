package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.pvemu.dofusmapparser.DofusMapParser;
import org.pvemu.dofusmapparser.data.DofusMap;
import org.pvemu.dofusmapparser.factory.DofusMapFactory;
import org.pvemu.dofusmapparser.model.MapModel;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class Benchmarks {
    final private static List<MapModel> models = new ArrayList<>();

    static abstract private class Test{
        final private List<DofusMap> maps = new ArrayList<>(models.size());

        public void test(){   
            System.gc();
            DofusMapFactory factory = factory();
            long startTime = System.currentTimeMillis();
            long startRam = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            
            for(MapModel model : models){
                try{
                    maps.add(factory.buildMap(model));
                }catch(Exception e){}
            }
            
            long ram = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - startRam) / 8192L;
            System.out.println(getClass().getName() + " : time=" + (System.currentTimeMillis() - startTime) + "ms" + ", ram=" + ram + "ko");
        }
        
        abstract public DofusMapFactory factory();
    }
    
    static private class MutableFactoryTest extends Test{

        @Override
        public DofusMapFactory factory() {
            return DofusMapParser.getMutableDofusMapFactory();
        }

    }
    
    static private class ImmutableFactoryTest extends Test{

        @Override
        public DofusMapFactory factory() {
            return DofusMapParser.getImmutableDofusMapFactory();
        }
        
    }
    
    static private class CachedFactoryTest extends Test{

        @Override
        public DofusMapFactory factory() {
            return DofusMapParser.getCachedDofusMapFactory();
        }
        
    }
    
    public static void main(String[] args) throws SQLException {
        System.out.println("Benchmarks");
        Connexion connexion = new Connexion();

        //execute the query
        ResultSet RS = connexion.query("SELECT * FROM maps");

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
        
        new ImmutableFactoryTest().test(); //database.Benchmarks$ImmutableFactoryTest : time=731ms, ram=66530ko
        new MutableFactoryTest().test(); //database.Benchmarks$MutableFactoryTest : time=772ms, ram=64153ko
        new CachedFactoryTest().test(); //database.Benchmarks$CachedFactoryTest : time=1105ms, ram=24743ko
    }
}
