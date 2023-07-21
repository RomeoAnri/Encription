package main.java;

public class EncryptingActions {
    public static String encrypt(String message, int shift) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if (CheckConditions.isEnglishLetter(currentChar) || CheckConditions.isSpecialCharacter(currentChar)) {
                chars[i] = shiftChar(currentChar, shift);
            }
        }
        return new String(chars);
    }
    public static String decrypt(String message, int shift) {
    return encrypt(message, -shift);
    }

    private static char shiftChar(char c, int shift) {
        if (Character.isUpperCase(c)) {
            return (char) (((c - 'A' + shift) + 26) % 26 + 'A');
        } else if (Character.isLowerCase(c)) {
            return (char) (((c - 'a' + shift) + 26) % 26 + 'a');
        } else if (CheckConditions.isSpecialCharacter(c)) {
            char[] specialChars = {'.', ',', '"', ':', '-', '!', '?', ' '};
            int specialCharsCount = specialChars.length;
            int index = -1;
            for (int counter = 0; counter < specialChars.length; counter++) {
                if (c == specialChars[counter]) {
                    index = counter;
                    break;
                }
            }
            if (index != -1) {
                return specialChars[(index + shift + specialCharsCount) % specialCharsCount];
            }
        }
        return c;
    }

    public static String bruteForce(String imputeText, String reference) {
        StringBuilder constructNewPhrase = new StringBuilder();
        int hackerKey = 0;
        while (!decrypt(imputeText, hackerKey).equalsIgnoreCase(reference)) {
            hackerKey++;
            constructNewPhrase = new StringBuilder(decrypt(imputeText, hackerKey));
        }
        return constructNewPhrase.toString();
    }
}
