package org.pvemu.dofusmapparser.factory.exception;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class BadMapSizeException extends Exception{
    final private int expected;
    final private int current;

    public BadMapSizeException(int expected, int current) {
        this.expected = expected;
        this.current = current;
    }

    @Override
    public String getMessage() {
        return "The expected size is " + expected + " but has " + current;
    }
    
    
}
