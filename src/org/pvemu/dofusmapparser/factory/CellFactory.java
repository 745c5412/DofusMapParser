package org.pvemu.dofusmapparser.factory;

import org.pvemu.dofusmapparser.data.ImmutableCell;
import org.pvemu.dofusmapparser.factory.exception.BadMapDataException;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public interface CellFactory<C extends ImmutableCell>{
    public C makeCell(String data) throws BadMapDataException;
    public C[] createCellArray(int size);
}
