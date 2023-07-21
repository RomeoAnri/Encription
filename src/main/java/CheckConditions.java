package main.java;

public class CheckConditions {
    public static boolean isSpecialCharacter(char c) {
        return (c == '.' || c == ',' || c == '"' || c == ':' || c == '-' || c == '!' || c == '?'|| c == ' ');
    }
    public static boolean isEnglishLetter(char ch) {

        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }
}
