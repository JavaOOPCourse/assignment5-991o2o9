import java.sql.Array;
import java.util.*;

public class Assignment5_StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GRADED ASSIGNMENT 5: STRING MANIPULATION ===");
            System.out.println("Выберите задание (1-8) или 0 для выхода:");
            System.out.println("1 — Count Vowels");
            System.out.println("2 — Reverse a String");
            System.out.println("3 — Check Palindrome");
            System.out.println("4 — Count Words in a Sentence");
            System.out.println("5 — Remove All Spaces");
            System.out.println("6 — Capitalize First Letter of Each Word");
            System.out.println("7 — Find the Most Frequent Character");
            System.out.println("8 — Check Anagrams");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число!");
                continue;
            }

            switch (choice) {
                case 1 -> task1(scanner);
                case 2 -> task2(scanner);
                case 3 -> task3(scanner);
                case 4 -> task4(scanner);
                case 5 -> task5(scanner);
                case 6 -> task6(scanner);
                case 7 -> task7(scanner);
                case 8 -> task8(scanner);
                case 0 -> {
                    System.out.println("До свидания! Удачи со сдачей задания :)");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // ===================== TASK 1 =====================
    private static void task1(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Подсчитать количество гласных (a, e, i, o, u)

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int count = 0;

        for (char c : input.toCharArray()){
            if (vowels.contains(c)){
                count++;
            }
        }

        System.out.println("Number of vowels: " + count);
    }

    // ===================== TASK 2 =====================
    private static void task2(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Вывести строку в обратном порядке
        Deque<Character> reverser = new ArrayDeque<>();
        String reversed = "";

        for (char ch : input.toCharArray()){
            reverser.push(ch);
        }

        while (!reverser.isEmpty()){
            reversed += reverser.pop();
        }

        System.out.println(reversed);
    }

    // ===================== TASK 3 =====================
    private static void task3(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().toLowerCase();

        // TODO: Проверить, является ли строка палиндромом (игнорировать регистр)
        boolean isPalindrome = false;
        Deque<Character> reverser = new ArrayDeque<>();
        String reversed = "";

        for (char ch : input.toCharArray()) {
            reverser.push(ch);
        }

        while (!reverser.isEmpty()) {
            reversed += reverser.pop();
        }

        if(reversed.equals(input)) isPalindrome = true;

        System.out.println(isPalindrome ? "Yes" : "No");
    }

    // ===================== TASK 4 =====================
    private static void task4(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine().trim();

        // TODO: Подсчитать количество слов в предложении
        int wordCount = 0;
        boolean isWord = false;
        String forbidden = " ,.!@#$%^&*()_+-=";

        for (char ch: sentence.toCharArray()){
            if(forbidden.indexOf(ch) == -1){
                if(!isWord){
                    wordCount++;
                    isWord = true;
                }
            }else{
                isWord = false;
            }
        }

        System.out.println("Number of words: " + wordCount);
    }

    // ===================== TASK 5 =====================
    private static void task5(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Удалить все пробелы из строки
        String noSpaces = "";
        ArrayList<Character> output = new ArrayList<>();
        for (char ch: input.toCharArray()){
            if(ch != ' '){
                output.add(ch);
            }
        }

        for (char ch : output){
            noSpaces += ch;
        }

        System.out.println(noSpaces);
    }

    // ===================== TASK 6 =====================
    private static void task6(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // TODO: Преобразовать первую букву каждого слова в заглавную
        String result = "";
        boolean isWord = false;

        for (char ch: sentence.toCharArray()){
            if(ch != ' '){
                if(!isWord){
                    result += Character.toUpperCase(ch);
                    isWord = true;
                }
                else {
                    result += ch;
                }
            }
            else{
                result += ch;
                isWord = false;
            }
        }

        System.out.println(result);
    }

    // ===================== TASK 7 =====================
    private static void task7(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Найти символ, который встречается чаще всего
        char mostFrequent = ' ';
        int maxCount = 0;

        Set<Character> uniqueChar = new HashSet<>();

        for (char ch : input.toCharArray()){
            if (ch != ' '){
                uniqueChar.add(ch);
            }
        }

        for (char u: uniqueChar){
            int currentCount = 0;

            for (char ch : input.toCharArray()){
                if (ch == u){
                    currentCount++;
                }
            }
            if (currentCount > maxCount){
                maxCount = currentCount;
                mostFrequent = u;
            }
        }

        System.out.println("The most frequent character is: " + mostFrequent + " (" + maxCount + "-times" + ")");
    }

    // ===================== TASK 8 =====================
    private static void task8(Scanner scanner) {
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine().trim().toLowerCase();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine().trim().toLowerCase();

        // TODO: Проверить, являются ли две строки анаграммами (игнорировать пробелы и регистр)
        boolean areAnagrams = false;

        if (str1.length()!=str2.length()){
            System.out.println("Not anagrams");
            return;
        }

        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);

        areAnagrams = Arrays.equals(array1,array2);

        System.out.println(areAnagrams ? "Yes" : "No");
    }
}