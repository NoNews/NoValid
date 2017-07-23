package ru.alexbykov.simplevalidator;

import android.app.Application;
import android.text.Editable;
import android.util.Patterns;

import ru.alexbykov.simplevalidator.custom.AbstractFieldSettings;
import ru.alexbykov.simplevalidator.custom.FieldSettingsStore;
import ru.alexbykov.simplevalidator.utils.Gender;
import ru.alexbykov.simplevalidator.utils.StringUtils;


/**
 * Date: 23.07.2017
 * Time: 10:08
 * Project: Validator
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class Validator {

    private Application application;
    private Gender defaultGender;
    private FieldSettingsStore store;

    public Validator(Application application) {
        this.application = application;
        store = new FieldSettingsStore();
        defaultGender = Gender.MALE;
    }


    public Validator withDefaultGender(Gender defaultGender) {
        this.defaultGender = defaultGender;
        return this;
    }


    public boolean isValidField(String field) {
        return !StringUtils.isEmpty(field);
    }


    public boolean isValidField(Editable field) {
        return isValidField(field.toString());
    }


    @SuppressWarnings("unchecked")
    public <T> boolean isValidField(Class<? extends AbstractFieldSettings> clazz, T t) {
        AbstractFieldSettings fieldSettings = store.get(clazz);
        fieldSettings.setApplication(application);
        fieldSettings.setField(t);
        return fieldSettings.isValid();
    }

    @SuppressWarnings("unchecked")
    public <T> String getError(Class<? extends AbstractFieldSettings> clazz) {
        AbstractFieldSettings fieldSettings = store.get(clazz);

        if (fieldSettings.getField() == null) {
            throw new NoFieldException();
        }
        fieldSettings.setApplication(application);
        return fieldSettings.getError();
    }

    public boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isValidEmail(Editable email) {
        return isValidEmail(email.toString());
    }

    public String getValidField(String field, Gender gender) {
        return isValidField(field) ? getEmpty(gender) : field;
    }

    public String getValidField(String field) {
        return isValidField(field) ? getEmpty(defaultGender) : field;
    }


    private String getEmpty(Gender gender) {
        if (gender == Gender.MALE) {
            return application.getString(R.string.empty_field_male);
        } else if (gender == Gender.FEMALE) {
            return application.getString(R.string.empty_field_female);
        } else return application.getString(R.string.empty_field_middle);
    }

}
