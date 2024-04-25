package fr.esgi.jeux_erwan.helpers;

public class ValidationHelper
{
    public static boolean hasUppercase(String input)
    {
        return !input.equals(input.toLowerCase());
    }

    public static boolean isValidEmailAddress(String email)
    {
        String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher m = p.matcher(email);

        return m.matches();
    }
}
