
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

        //call method
        hangman(word, scan);

    }
    public static void hangman(String secretWord , Scanner scan)
    {
        //guessedLetters['p'-'a'] = true;
        //guessedLetters['P'-'A' + 26] = true;

        boolean[] guessedLetters = new boolean[52];
        String guess = scan.nextLine();
        // TODO: Input validation!
        if(guess.length() == 1)
        {
            /*
                TODO:
                  - check if the letter has already been guessed >
                  - if so, add a strike
                  - if letter hasn't been guessed >
                  - mark it as guessed


             */
        }
        else {
            /*
            TODO: If whole word is guessed
                - check if guessed = actual word
                -if so, guesser wins game
             */
        }

        boolean wordCorrect = true;
        for (int i = 0; i < secretWord.length(); i++) {
             char temp = secretWord.charAt(i);
             if(Character.isUpperCase(temp)){
                 if(guessedLetters[temp- 'A' + 26])
                     System.out.print(temp);
                 else{
                     System.out.print("_");
                     wordCorrect = false;
                 }

             }
            else if(Character.isLowerCase(temp)){
                if(guessedLetters[temp- 'a'])
                    System.out.print(temp);
                else {
                    System.out.print("_");
                    wordCorrect = false;
                }
            }
            else if((int)(temp) == 32)
            {
                System.out.print(" ");
            }


        }
    }

}
