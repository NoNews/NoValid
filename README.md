# No valid

Android validation library


### Gradle

    compile 'ru.alexbykov:novalid:1.0.1'





### Custom Validation

```
public class PasswordSettings extends AbstractFieldSettings<String> {
    private static final int PASSWORD_ERROR = R.string.error_password;
    private static final int MIN_PASSWORD_LENGTH = 6;

    @Override
    public boolean isValid() {
        return field.length() >= MIN_PASSWORD_LENGTH;
    }

    @Override
    public String getError() {
        return context.getString(PASSWORD_ERROR);
      }
    }
   ```

#### Check it
```
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