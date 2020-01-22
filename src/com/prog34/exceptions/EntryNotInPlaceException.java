package com.prog34.exceptions;

public class EntryNotInPlaceException extends Exception{
    @Override
    public String getMessage() {
        return "Current place doesn't contains specified entry";
    }
}
