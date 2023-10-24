package com.develhope.esSpringBoot.controller;
//SI DEVE CREARE UN PACKAGE A PARTE PER LE ECCEZIONI?
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message){
        super(message);
    }
}
