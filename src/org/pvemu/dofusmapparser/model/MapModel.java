package org.pvemu.dofusmapparser.model;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public interface MapModel {
    public int getId();
    public int getWidth();
    public int getHeight();
    public int getBackground();
    public int getAmbianceId();
    public int getMusicId();
    public boolean isOutdoor();
    public int getCapabilities();
    public String getMapData();
}
