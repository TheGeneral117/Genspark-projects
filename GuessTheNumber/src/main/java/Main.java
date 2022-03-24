import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //variable declaration
        Scanner scan = new Scanner(System.in);
        String name, input, keepPlaying="y";
        Random rand = new Random();
        int answer;
        int guessNum =-1, count=0;
        Object guess;

        //game and player introduction
        System.out.println("Hello! What is your name?");
        input = scan.nextLine();
        name = setString(input);
        System.out.printf("Well, %s, ",name);


        //reset point
        while(keepPlaying.equals("y")){
            //game reset
            guessNum = 0;
            answer = rand.nextInt(20)+1;
            count=0;
            System.out.println("I am thinking of a number between 1 and 20.");
            //game loop
            while(guessNum !=answer && count < 6){

                //make sure user gives valid input
                System.out.println("Take a guess.");
                while (true) {
                    input = scan.nextLine();
                    guess = setInt(input);
                    if(guess instanceof Integer) {
                        guessNum = Integer.parseInt(guess.toString());
                        count++;
                        break;
                    }

                    System.out.println("I need a real, whole number.\n");
                }
                if(guessNum ==answer)
                    break;
                else if (guessNum < answer)
                    System.out.println("Your guess is too low.");
                else if (guessNum > answer)
                    System.out.println("Your guess is too high.");
            }
            //check if player guessed too much or won
            if(answer == guessNum)
                System.out.printf("Good job, %s! You guessed my number in %d guesses!\n",name,count);
            else
                System.out.printf("I'm sorry, %s! You guessed wrong 6 times!\n",name,count);

            //input check
            do {
                System.out.println("Would you like to play again? (y or n)");
                input=scan.nextLine().toLowerCase();
                keepPlaying = setString(input);
            }while(!(keepPlaying.equals("y") || keepPlaying.equals("n")));
        }
    }

    //      METHODS
    public static String setString(String input){
        try{
            return input;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "You should not have hit this";
    }

    public static Object setInt(String input){
        int num=0;
        try {
            num = Integer.valueOf(input);
            return num;
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
