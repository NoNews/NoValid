package ru.alexbykov.simplevalidator.custom;

/**
 * Date: 23.07.2017
 * Time: 12:03
 * Project: Validator
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class FieldSettingsFactory {

    private FieldSettingsFactory() {
    }

    public static AbstractFieldSettings create(Class<? extends AbstractFieldSettings> clazz) {
        //noinspection TryWithIdenticalCatches
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Cannot create an instance of " + clazz, e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + clazz, e);
        }
    }

}
