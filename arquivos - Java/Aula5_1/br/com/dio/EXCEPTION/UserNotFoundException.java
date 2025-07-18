package br.com.dio.EXCEPTION;

public class UserNotFoundException  extends RuntimeException{

    public UserNotFoundException(final String message){
        super(message);
    }
}
