package com.invillia.incubadora.exception;

/**
 * @author s2it_pandrade
 * @version : $<br/>
 * : $
 * @since 24/10/19 16:56
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(final String message) {
        super("Invalid user Id:" + message);
    }


}
