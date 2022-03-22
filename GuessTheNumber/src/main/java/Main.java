import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //variable declaration
        Scanner scan = new Scanner(System.in);
        boolean inputAccepted = false;
        String name, input="y";
        Random rand = new Random();
        int answer = rand.nextInt(20)+1;
        int guess=-1, count=0;

        //game and player introduction
        System.out.println("Hello! What is your name?");
        name = scan.nextLine();
        System.out.printf(String.format("Well, %s, I am thinking of a number between 1 and 20.\nTake a guess.",name));


        //reset point
        while(input.equals("y")){
            //game loop
            while(guess!=answer){

                //make sure user gives valid input
                inputAccepted=false;
                while (!inputAccepted) {
                    try {
                        guess = Integer.valueOf(scan.nextLine());
                        inputAccepted=true;
                    } catch (NumberFormatException e) {
                        System.out.println("I need a real, whole number");
                    }
                }
                if(guess==answer)
                    break;
                else if (guess < answer)
                    System.out.println("Your guess is too low.\nTake a guess.");
                else if (guess > answer)
                    System.out.println("Your guess is too high.\nTake a guess.");
            }
            //player guessed right
            System.out.println(String.format("Good job, %s! You guessed my number in %i guesses!",name,count));
            System.out.println("Would you like to play again? (y or n)");

            //input check
            do {
                input=scan.nextLine();
                input.toLowerCase();
            }while(!(input.equals("y") || input.equals("n")));
        }
    }
}
