import java.util.Random;
import java.util.Scanner;

public class Main {
    // Methods
    public static Object setInt(String input){
        int num=0;
        try {
            num = Integer.valueOf(input);
            return num;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        //variable declaration
        int choice=0;
        Random rand = new Random();
        boolean inputAccepted = false;

        //get random room
        int room = rand.nextInt(2)+1;
        //create input object
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are in a land full of dragons. In front of you,");
        System.out.println("you see two caves. In one cave, the dragon is friendly");
        System.out.println("and will share his treasure with you.  The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight.");

        //make sure user gives valid input
        while (true) {
            try {
                System.out.println("Which cave will you go into? (1 or 2)");
                choice = Integer.valueOf(scanner.nextLine());
                if(choice == 1 || choice == 2)
                    break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input" + choice);
            }
        }


        //result of choice
        if(choice==room){
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
