package Coach;

import java.util.regex.Pattern;

public class ValidateLicensePlate {
    private static final String CLASS_REGEX = "^([\\d]{2}[A-Z])\\-([\\d]{3}\\.[\\d]{2})$";

    public ValidateLicensePlate(){}

    public boolean validate(String regex){
        return Pattern.matches(CLASS_REGEX ,regex);

    }

}
