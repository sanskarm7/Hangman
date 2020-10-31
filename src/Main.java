import java.sql.SQLOutput;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        boolean check = false;
        Scanner scan = new Scanner(System.in);
        while(!check)
        {
        System.out.print("Type in the hangman word >>> ");
        String word = scan.nextLine();

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


    }

}
