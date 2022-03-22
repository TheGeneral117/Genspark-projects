import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //get random room
        Random rand = new Random();
        int room = rand.nextInt(2)+1;
        //create input object
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are in a land full of dragons. In front of you,");
        System.out.println("you see two caves. In one cave, the dragon is friendly");
        System.out.println("and will share his treasure with you.  The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2)");
        // user input
        int input = scanner.nextInt();
        //make sure user gives valid input
        while(input != 1 || input != 2){
            System.out.println("There is no other cave, please choose 1 or 2");
            input = scanner.nextInt();
        }

        //
        if(input==room){
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Gobbles you down in one bite!");
        }
        else{
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("says 'come share my treasure!'");
        }
        
    }
}
