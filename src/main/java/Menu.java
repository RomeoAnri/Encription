package main.java;

import java.util.Scanner;

public class Menu {
    public void  showMenu() {

        System.out.println("Данні починають зчитуватися з таємного архіву:");
        ReaderAndWriter readerWriter = new ReaderAndWriter();
        System.out.println(readerWriter.reader());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Негайно введіть ключ-шифрувальник від 1 до 8 включно:");
        int key = scanner.nextInt();
        System.out.println("Щойно зашифрувалися наступні данні :");
        String codingMessage = EncryptingActions.encrypt(readerWriter.reader(), key);
        System.out.println(codingMessage);
        readerWriter.writer(codingMessage);
        System.out.println("Данні записані на флєш...");
        System.out.println("Якщо вам необхідно зламати зашифровані данні... \nНапишіть YES чи NO");
        Scanner scanner1 = new Scanner(System.in);
        String userInput = scanner1.nextLine();
        if (userInput.equalsIgnoreCase("YES")) {
            System.out.println("Розшифровка є :"+"\n");
            System.out.println(EncryptingActions.bruteForce(EncryptingActions.encrypt(readerWriter.reader(), key), readerWriter.reader()));
        } else if (userInput.equalsIgnoreCase("NO")) {
            System.out.println("Введіть чисельний ключ :");
            int newKey = scanner.nextInt();
            if(EncryptingActions.decrypt(EncryptingActions.encrypt(readerWriter.reader(), key), newKey).equalsIgnoreCase(readerWriter.reader())){
                System.out.println("Вітаю! Данні успішно разшифровані.");
                System.out.println("Розшифровка є :"+"\n");
                System.out.println(EncryptingActions.decrypt(EncryptingActions.encrypt(readerWriter.reader(), key), newKey));
                System.out.println("\n"+"😉👍👍👍👍👍👍👍👍👍👍👍👍👍👍😉");
            }
            else {
                System.out.println(EncryptingActions.decrypt(EncryptingActions.encrypt(readerWriter.reader(), key), newKey));
                System.out.println("Чисельний ключ не є коректним");
            }
        }
    }
}
