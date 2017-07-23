package ru.alexbykov.simplevalidator.custom;

import java.util.HashMap;

/**
 * Date: 23.07.2017
 * Time: 12:10
 * Project: Validator
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class FieldSettingsStore {

    private final HashMap<String, AbstractFieldSettings> validators = new HashMap<>();


    public void put(String key, AbstractFieldSettings fieldValidator) {
        AbstractFieldSettings validator = validators.get(key);
        if (validator != null) {
            validators.remove(key);
        }
        validators.put(key, fieldValidator);
    }


    public AbstractFieldSettings get(Class<? extends AbstractFieldSettings> clazz) {
        AbstractFieldSettings validator = validators.get(clazz.getCanonicalName());
        if (validator == null) {
            validator = FieldSettingsFactory.create(clazz);
            put(validator.getClass().getCanonicalName(), validator);
        }
        return validator;
    }
}
