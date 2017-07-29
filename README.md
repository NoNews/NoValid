# No valid

Android validation library


### Gradle

    compile 'ru.alexbykov:novalid:1.0.2'


### Install

```java
Validator validator = new Validator(context);
```




### Methods


|Method        |Input Type|   Answer type| Description
| :-------------: |:-----:|:-------------:|:-------------:|
| isValidEmail|String or Editable |  boolean   |  Check  for valid emai |
| isValidField|String or Editable |  boolean   | Check  for null/empty/only spaces|
| isValidField|Class<? extends AbstractFieldSettings> clazz, T t)  | boolean   | Check custom validation settings|
| getError|Class<? extends AbstractFieldSettings> clazz, T t)  |  String   | Get error from custom validation settings (will check last field)|
| getValidField|String  or String, Gender  |String| Will return value or placeholder with the corresponding gender|
| getValidInsertField|String| String   | Will return value or placeholder for insert field|
| getValidChooseField|String |  String   | Will return value or placeholder for choose field|
| withDefaultGender|Gender.MASCULINE  or Gender.FEMININE or Gender.NEUTER |  String   | Set default gender for  method getValidField (default = MASCULINE)|



### Custom Validation example
```java
public class PasswordSettings extends AbstractFieldSettings<String> {
    private static final int PASSWORD_ERROR = R.string.error_password;
    private static final int MIN_PASSWORD_LENGTH = 6;

    @Override
    public boolean isValid() {
        return field.length() >= MIN_PASSWORD_LENGTH;
    }

    @Override
    public String getError() {
        return getString(PASSWORD_ERROR);
      }
    }
   ```

And check it

```java
    private void checkPassword(String password) {

        if (validator.isValidField(PasswordSettings.class, password){
             //do what you want
        }
        else {
             showError(validator.getError(PasswordSettings.class));
        }
    }
  ```


#### License
```
Copyright 2017 Alex Bykov

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.