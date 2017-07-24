package ru.alexbykov.novalid;

/**
 * Date: 23.07.2017
 * Time: 13:58
 * Project: Validator
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class NoFieldException extends RuntimeException {


    public NoFieldException() {
        super("First you can call method isCorrectField(YourSettings.class, yourField). Only after that you can get error message");
    }
}
