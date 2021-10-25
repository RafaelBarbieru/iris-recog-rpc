public class IDValidator {

    private static final char FIVE = '5';
    private static final char ZERO = '0';

    /**
     * Validates an ID passed by parameter
     * @param id
     * @return
     */
    public static boolean validateID(String id) {

        // If the last character is 5 or 0, return false
        if (getLastCharacter(id) != FIVE && getLastCharacter(id) != ZERO) {
            return false;
        }

        // Adding all the ASCII character codes up
        int sum = 0;
        for (int i = 0; i < id.length(); i++)
            sum += id.charAt(i);

        // If the sum of all the ASCII character codes of the ID is divisible by 3, it's valid
        return sum % 3 == 0;

    }

    /**
     * Gets the last character of a string
     *
     * @param string
     */
    private static char getLastCharacter(String string) {
        return string.charAt(string.length() - 1);
    }
}