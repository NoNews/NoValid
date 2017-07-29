package ru.alexbykov.novalid.custom;

import android.content.Context;

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

    protected Context context;

    public abstract boolean isValid();

    public abstract String getError();


    public void setContext(Context context) {
        this.context = context;
    }

    public void setField(T field) {
        this.field = field;
    }

    public T getField() {
        return field;
    }

    protected String getString(int resId) {
        return context.getString(resId);
    }
}
