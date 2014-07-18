package org.pvemu.dofusmapparser.common;

import org.pvemu.dofusmapparser.factory.exception.BadMapDataException;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
final public class DofusMapUtils {
    final static private char[] HASH = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
        't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
        'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'
    };
    
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
    
    static public char getBase64Char(byte v){
        return HASH[v];
    }
    
    static public int getMapSize(int width, int height){
        return width * (height - 1) * 2 + (width - height + 1);
    }
    
}
