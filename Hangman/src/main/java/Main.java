import java.util.Collections;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Hangman game = new Hangman();
        String guess;
        Scanner scan = new Scanner(System.in);
        boolean winner = false, playing = true, next = true;

        System.out.println("Welcome to Hangman! Let's play!\n\n");
        System.out.println(game.getAns());
        while(playing){
            if(next) {
                game.drawHangman();
                System.out.println("Missed letters:");
                System.out.println(game.getWrong().toString());
                System.out.println(game.getCorrect());
                System.out.println("Guess a letter");
            }

            guess = scan.next().toLowerCase();

            while (guess.length() != 1 || Character.isDigit(guess.charAt(0))) {
                System.out.println("Please enter single letters only.");
                guess = scan.next().toLowerCase();
            }

            if (game.checkUsed(guess.charAt(0))) {
                System.out.println("You already tried that letter!");
                System.out.println("Guess another letter");
                next = false;
            } else {
                winner = game.guessCheck(guess.charAt(0));
                next = true;
            }

            if(winner){
                System.out.println("You got the word!");
            }
            else if(game.getLives() == 0){
                game.drawHangman();
                System.out.println("You got hanged! The word was " + game.getAns());
            }
            if(winner || game.getLives() == 0){
                System.out.println("Would you like to play again? (yes to go again, anything else to quit)");
                guess = scan.next();
                if(!guess.toLowerCase().equals("yes"))
                    playing = false;
                else{
                    game.setUpGame();
                    winner = false;
                }
            }


        }
    }
}
