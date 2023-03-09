package Customer;

import java.util.regex.Pattern;

public class ValidatePhone {
    private static final String CLASS_REGEX = "^0[987326][\\d]{8,9}$";

    public ValidatePhone(){}

    public boolean validate(String regex){
        return Pattern.matches(CLASS_REGEX,regex);
    }
}
