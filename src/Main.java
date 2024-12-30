import java.util.Random;
import java.util.Scanner;

public class Main {
     static final int ID_LENGTH = 9;
     static final int LENGTH_WORDS=5 ;
     static final int MAX_GUESSES= 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //תרגיל 1
        //חלק ראשון בדיקת תקינות ת.ז וזימון הפונקצייה הייעודית
        int[] personalId = new int[ID_LENGTH];

        System.out.println("Enter your 9-digit ID:");
        String input = scanner.nextLine();
        while (input.length() < ID_LENGTH) {
            input = "0" + input;
        }

        for (int i = 0; i < ID_LENGTH; i++) {
            personalId[i] = input.charAt(i) - '0';
        }

        correctId(personalId);

        // חלק שני: מציאת ספרת הביקורת בעזרת פונקציה ייעודית במידה והמשתמש הכניס 8 ספרות
//        int[] personalId = new int[8];
//
//        System.out.println("Enter your 8-digit ID, one digit at a time:");
//        for (int i = 0; i < personalId.length; i++) {
//            personalId[i] = scanner.nextInt();
//        }
//
//        int checkDigit = calculateCheckDigit(personalId);
//
//        System.out.println("The check digit is: " + checkDigit);

        //תרגיל 2
//        String[] words = {"apple", "table", "chair", "house", "light",
//                "stone", "water", "bread", "plant", "smile"};
//
//        wordleGame(words);

    }

    //תרגיל 1

    public static void correctId(int[] personalId)
        {
        int[] constantArr = {1, 2, 1, 2, 1, 2, 1, 2, 1};
        int[] newArr = new int[personalId.length];

        for (int i = 0; i < personalId.length; i++) {
            newArr[i] = personalId[i] * constantArr[i];
        }

        System.out.print("New array: ");
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] > 9) {
                int ones = newArr[i] % 10;
                int tens = newArr[i] / 10 % 10;
                newArr[i] = ones + tens;
            }
            System.out.print(newArr[i] + " ");
        }
        System.out.println();

        int sum = 0;
        for (int i = 0; i < newArr.length; i++) {
            sum += newArr[i];
        }

        if (sum % 10 == 0) {
            System.out.println("Your ID is correct");
        } else {
            System.out.println("Your ID is incorrect");
        }
    }

//    public static int calculateCheckDigit(int[] personalId) {
//        int[] constantArr = {1, 2, 1, 2, 1, 2, 1, 2};
//        int[] newArr = new int[personalId.length];
//
//        for (int i = 0; i < personalId.length; i++) {
//            newArr[i] = personalId[i] * constantArr[i];
//        }
//
//        for (int i = 0; i < newArr.length; i++) {
//            if (newArr[i] > 9) {
//                int ones = newArr[i] % 10;
//                int tens = newArr[i] / 10;
//                newArr[i] = ones + tens;
//            }
//        }
//
//        int sum = 0;
//        for (int i = 0; i < newArr.length; i++) {
//            sum += newArr[i];
//        }
//
//        int checkDigit = (10 - (sum % 10)) % 10;
//
//        return checkDigit;
//    }


    //תרגיל 2
//    public static void wordleGame(String[] words) {
//        // בחירת מילה סודית
//        String secretWord = getRandomWord(words).toLowerCase();
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Welcome to Wordle! Try to guess the 5-letter word.");
//
//        for (int i = 1; i <= MAX_GUESSES; i++) {
//            System.out.print("Attempt " + i + "/" + MAX_GUESSES + ": ");
//            String guess = scanner.nextLine().toLowerCase();
//
//            // בדיקת תקינות הניחוש
//            if (!isValidGuess(guess)) {
//                System.out.println("Invalid guess. Make sure it's a 5-letter word containing only letters.");
//                i--;
//                continue;
//            }
//
//            // משוב על הניחוש
//            String feedback = getFeedback(guess, secretWord);
//            System.out.println("Feedback: " + feedback);
//
//            // בדיקת ניצחון
//            if (guess.equals(secretWord)) {
//                System.out.println("Congratulations! You've guessed the word!");
//                return;
//            }
//        }
//        // אם נגמרו הניסיונות
//        System.out.println("Game over! The word was: " + secretWord);
//    }
//
//    public static String getRandomWord(String[] words) {
//        Random rand = new Random();
//        int index = rand.nextInt(words.length);
//        return words[index];
//    }
//
//    public static boolean isValidGuess(String guess) {
//        if (guess.length() != LENGTH_WORDS) {
//            return false;
//        }
//        for (int i = 0; i < guess.length(); i++) {
//            char c = guess.charAt(i);
//            if (!Character.isLetter(c)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static String getFeedback(String guess, String secretWord) {
//        String feedback = "";
//        boolean[] used = new boolean[LENGTH_WORDS];
//
//        // בדיקת אותיות במיקום נכון
//        for (int i = 0; i < LENGTH_WORDS; i++) {
//            if (guess.charAt(i) == secretWord.charAt(i)) {
//                feedback += "G"; // אות במיקום נכון
//                used[i] = true;
//            } else {
//                feedback += "_";
//            }
//        }
//
//        // בדיקת אותיות נכונות במיקום שגוי
//        for (int i = 0; i < LENGTH_WORDS; i++) {
//            if (feedback.charAt(i) == 'G') continue;
//
//            for (int j = 0; j < LENGTH_WORDS; j++) {
//                if (!used[j] && guess.charAt(i) == secretWord.charAt(j)) {
//                    char[] feedbackArray = feedback.toCharArray();
//                    feedbackArray[i] = 'Y'; // אות נכונה במיקום שגוי
//                    feedback = new String(feedbackArray);
//                    used[j] = true;
//                    break;
//                }
//            }
//        }
//
//        return feedback;
//    }
}

