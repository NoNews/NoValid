package ru.alexbykov.novalid.custom;

import android.app.Application;

/**
 * Date: 23.07.2017
 * Time: 10:09
 * Project: Validator
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public abstract class AbstractFieldSettings<T> {


    protected T field;

    protected Application application;

    public abstract boolean isValid();

    public abstract String getError();


    public void setApplication(Application application) {
        this.application = application;
    }

    public void setField(T field) {
        this.field = field;
    }

    public T getField() {

        return field;
    }
}
