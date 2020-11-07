
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

        System.out.println(word);
    }

}
