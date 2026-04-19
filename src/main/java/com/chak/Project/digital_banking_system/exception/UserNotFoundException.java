package com.chak.Project.digital_banking_system.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException (String message)
    {
         super(message);
    }
}
