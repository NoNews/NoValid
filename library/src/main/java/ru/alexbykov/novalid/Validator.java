package ru.alexbykov.novalid;

import android.app.Application;
import android.content.Context;
import android.text.Editable;
import android.util.Patterns;

import ru.alexbykov.novalid.custom.AbstractFieldSettings;
import ru.alexbykov.novalid.custom.FieldSettingsStore;
import ru.alexbykov.novalid.utils.Gender;
import ru.alexbykov.novalid.utils.StringUtils;


/**
 * Date: 23.07.2017
 * Time: 10:08
 * Project: Validator
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class Validator {

    private Context context;
    private Gender defaultGender;
    private FieldSettingsStore store;

    public Validator(Application application) {
        this.context = application;
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
        fieldSettings.setContext(context);
        fieldSettings.setField(t);
        return fieldSettings.isValid();
    }

    @SuppressWarnings("unchecked")
    public <T> String getError(Class<? extends AbstractFieldSettings> clazz) {
        AbstractFieldSettings fieldSettings = store.get(clazz);

        if (fieldSettings.getField() == null) {
            throw new NoFieldException();
        }
        fieldSettings.setContext(context);
        return fieldSettings.getError();
    }

    public boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isValidEmail(Editable email) {
        return isValidEmail(email.toString());
    }

    public String getValidField(String field, Gender gender) {
        return isValidField(field) ? getEmptyDefaultField(gender) : field;
    }

    public String getValidField(String field) {
        return isValidField(field) ? getEmptyDefaultField(defaultGender) : field;
    }

    public String getValidChooseField(String field) {
        return isValidField(field) ? field : getString(R.string.empty_field_choose);
    }

    public String getValidInsertField(String field) {
        return isValidField(field) ? field : getString(R.string.empty_field_insert);
    }


    private String getString(int idRes) {
        return context.getString(idRes);
    }

    private String getEmptyDefaultField(Gender gender) {
        if (gender == Gender.MALE) {
            return getString(R.string.empty_field_male);
        } else if (gender == Gender.FEMALE) {
            return getString(R.string.empty_field_female);
        } else return getString(R.string.empty_field_middle);
    }

}
