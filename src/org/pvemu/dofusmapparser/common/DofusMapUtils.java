package org.pvemu.dofusmapparser.common;

import org.pvemu.dofusmapparser.factory.exception.BadMapDataException;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
final public class DofusMapUtils {

    public static byte getHashIndex(char c) throws BadMapDataException{
        if(c >= 'a' && c <= 'z'){
            return (byte)(c - 'a');
        }
        if(c >= 'A' && c <= 'Z'){
            return (byte)(c - 'A' + 26);
        }
        if(c >= '0' && c <= '9'){
            return (byte)(c - '0' + 52);
        }
        if(c == '-'){
            return 62;
        }
        if(c == '_'){
            return 63;
        }

        throw new BadMapDataException("invalid base64 char : " + c);
    }
    
    static public int getMapSize(int width, int height){
        return width * (height - 1) * 2 + (width - height + 1);
    }
    
}
