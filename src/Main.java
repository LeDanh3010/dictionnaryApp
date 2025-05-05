import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;



public class Main {
    private static Scanner input = new Scanner(System.in);
    private static HashMap<String,String> words = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("Dictionary English Vietnamese");

        while(true){
            System.out.println("add: to add a new word");
            System.out.println("find: to find word");
            System.out.println("edit: to edit word");
            System.out.println("remove: to remove word");
            System.out.println("list: to list words have in the dictionary");
            System.out.println("exit: to to exit the dictionary\n");
            System.out.println("Please enter your option you want to choose:");

            String action = input.nextLine().trim().toLowerCase();
            switch (action){
                case "add":
                    addWord();
                    break;
                case "find":
                    findWord();
                    break;
                case "list":
                    listWord();
                    break;
                case "edit":
                    editWord();
                    break;
                case "remove":
                    removeWord();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid your choose is not available\n");
            }
        }

    }
    public static void addWord() {
        String englishWord;
        do {
            System.out.print("Enter your word: ");
            englishWord = input.nextLine().trim();
        } while (englishWord.isEmpty());

        boolean check = words.containsKey(englishWord);
        if (check) {
            System.out.println("Your word already was available\n");
        } else {
            String meaning;
            do {
                System.out.print("Enter meaning:");
                meaning = input.nextLine().trim();
            } while (meaning.isEmpty());
            words.put(englishWord, meaning);
            System.out.println("One word was added successfully\n");
        }
    }
    public static void findWord(){
        System.out.print("Enter your word you want to find: ");
        String yourWord = input.nextLine().trim();
        boolean check = words.containsKey(yourWord);
        if(check){
            String result = words.get(yourWord);
            System.out.println("Meaning: " + result);
        }else{
            System.out.println("Your word is not available in the dictionary\n");
        }
    }
    public static void listWord(){
        System.out.println("List all the word:");
        for (Map.Entry<String,String> entry: words.entrySet()){
            System.out.println(entry.getKey().toUpperCase() + " : " + entry.getValue());
        }
        System.out.println();
    }
    public static void removeWord(){
        System.out.print("Enter your word that you want to remove: ");
        String yourWord = input.nextLine().trim();
        boolean check = words.containsKey(yourWord);
        if(!check){
            System.out.println("Your word is not available in the dictionary\n");
        }else{
            words.remove(yourWord);
            System.out.println("Your word is removed successfully\n");
        }
    }
    public static void editWord(){
        System.out.println("Enter you word that you want to edit meaning: ");
        String yourWord = input.nextLine().trim();
        System.out.println("Enter your meaning: ");
        String yourMeaning = input.nextLine().trim();
        boolean check = words.containsKey(yourWord);
        if(!check){
            System.out.println("Your word is not available in the dictionary\n");
        }else{
            words.replace(yourWord,yourMeaning);
            System.out.println("Your word is edited successfully\n");
        }
        
    }

}
