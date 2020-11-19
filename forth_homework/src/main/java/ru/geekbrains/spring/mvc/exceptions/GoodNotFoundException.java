package ru.geekbrains.spring.mvc.exceptions;

public class GoodNotFoundException extends RuntimeException{
    public GoodNotFoundException(String message) {super(message);}
}
