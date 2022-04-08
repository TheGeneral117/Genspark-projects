import java.util.Collections;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Hangman game = new Hangman();
        String guess;
        Scanner scan = new Scanner(System.in);
        boolean winner = false;

        System.out.println("Welcome to Hangman! Let's play!\n\n");
        while(true){
            game.drawHangman();
            System.out.println("Missed letters:");
            System.out.println(game.getWrong().toString());
            System.out.println("Guess a letter");

            guess = scan.next().toLowerCase();

            while (guess.length() != 1 || Character.isDigit(guess.charAt(0))) {
                System.out.println("Please enter single letters only.");
                guess = scan.next().toLowerCase();
            }
            if(game.getWrong().contains(guess))
                System.out.println("You already tried that letter!");
            else{
                winner = game.guessCheck(guess.charAt(0));
            }

            if(winner){
                System.out.println("You got the word!");
            }
            else if(game.getLives() == 0){
                System.out.println("You got hanged!");
            }


        }
    }
}
