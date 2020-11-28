
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        boolean check = false;
        Scanner scan = new Scanner(System.in);
        String word = null;

        while(!check)

        {
        System.out.print("Type in the hangman word >>> ");
        word = scan.nextLine(); //gets word
        word = word.trim(); //removes spaces from ends of word
        String[] wordPieces = word.split(" ");// splits words into "pieces"
        word = "";
            for (String wordPiece : wordPieces) { //iterates through pieces of array
                if(!wordPiece.equals(""))
                {
                    word+= wordPiece + " "; //filters out unimportant spaces
                }
            }
            word = word.trim();
        for (int i = 0; i < word.length(); i++) {
            if ((int) (word.charAt(i)) <= 90 && (int) (word.charAt(i)) >= 65)
            {
                check = true;
            }
            else if ((int) (word.charAt(i)) <= 122 && (int) (word.charAt(i)) >= 97)
            {
               check =  true;
            }
            else if ((int) (word.charAt(i)) == 32)
            {
                check = true;
            }
            else
            {
                check = false;
                System.out.println("Please enter one or more valid words.");
                break;
            }
        }

        }

        System.out.print("Your word is " + word);
        try
        {
            Thread.sleep(3000);
            System.out.println("\r                                                                                                                                                                                                                     ");
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }


        //call method
        hangman(word, scan, 10);

    }
    public static void hangman(String secretWord , Scanner scan, int numberOfStrikes)
    {
        //guessedLetters['p'-'a'] = true;
        //guessedLetters['P'-'A' + 26] = true;

        boolean[] guessedLetters = new boolean[52];
        int strike = 0;
        boolean wordCorrect = false;

        while(!wordCorrect && strike < numberOfStrikes) {

            System.out.print("Guess a letter or word >>> ");
            String guess = scan.nextLine();
            while (!validateGuess(guess)) {
                System.out.print("Error! Please enter a valid guess! >>>");
                guess = scan.nextLine();
            }

            if (guess.length() == 1) {

                if (guessedLetters[Character.toLowerCase(guess.charAt(0)) - 'a'] || guessedLetters[Character.toUpperCase(guess.charAt(0)) - 'A' + 26]) {
                    strike++;
                    System.out.println("You've already guessed this letter! You have " + strike + " strikes!");

                } else {
                    guessedLetters[Character.toLowerCase(guess.charAt(0)) - 'a'] = true;
                    guessedLetters[Character.toUpperCase(guess.charAt(0)) - 'A' + 26] = true;
                    boolean ifletterguessed = false;
                    for (int i = 0; i < secretWord.length(); i++) {
                        if (Character.toUpperCase(guess.charAt(0)) == Character.toUpperCase(secretWord.charAt(i)))
                            ifletterguessed = true;
                    }
                    if (!ifletterguessed) {
                        strike++;
                        System.out.println("Wrong letter! You have " + strike + " strikes!");
                    }
                }
            } else {

                if (guess.equalsIgnoreCase(secretWord)) {
                    wordCorrect = true;
                    break;
                } else {
                    strike++;
                    System.out.println("Wrong word! You have " + strike + " strikes!");
                }
            }

            wordCorrect = true;
            for (int i = 0; i < secretWord.length(); i++) {
                char temp = secretWord.charAt(i);
                if (Character.isUpperCase(temp)) {
                    if (guessedLetters[temp - 'A' + 26])
                        System.out.print(temp + " ");
                    else {
                        System.out.print("_ ");
                        wordCorrect = false;
                    }

                } else if (Character.isLowerCase(temp)) {
                    if (guessedLetters[temp - 'a'])
                        System.out.print(temp + " ");
                    else {
                        System.out.print("_ ");
                        wordCorrect = false;
                    }
                } else if ((int) (temp) == 32) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        if(wordCorrect)
        {
            System.out.println("CONGRATULATIONS! YOU WON WITH " + strike + " STRIKES!");
        }
        else
        {
            System.out.println("YOU LOST! IMAGINE WINNING, COULDN'T BE YOU! THE WORD WAS " + secretWord);
        }
    }
    public static boolean validateGuess(String guess)
    {
        guess = guess.trim();
        boolean checkLetter = guess.length() > 0;
        for (int i = 0; i < guess.length() && checkLetter; i++) {
            if(Character.isLetter(guess.charAt(i))) {

            }
            else if (Character.isWhitespace(guess.charAt(i))){

            }
            else
            {
                checkLetter = false;
            }

        }
        return checkLetter;
    }

}
