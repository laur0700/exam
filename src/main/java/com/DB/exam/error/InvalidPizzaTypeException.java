package com.DB.exam.error;

public class InvalidPizzaTypeException extends Exception{
    public InvalidPizzaTypeException(){
    }

    public InvalidPizzaTypeException(String message){
        super(message);
    }
}
