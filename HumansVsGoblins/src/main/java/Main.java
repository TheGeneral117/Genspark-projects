import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Land map = new Land();
        int size = map.getDimensions();
        //ArrayList<Goblin> goblins = new ArrayList<>();
        Goblin goblin = new Goblin(size);
        Human human = new Human(size);
        boolean keepPlaying = true, next = true, combat = false;
        String move;
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the game. You may control your movement with n/s/e/w just like a compass!");
        System.out.println("Your only goal is to last as long as you can against the goblins!");
        System.out.print("You are represented with the symbol: " + human.toString());
        System.out.println("\nGoblins are represented with the symbol: " + goblin.toString());


        while (keepPlaying) {
            while (true) {
                //System.out.println(map.toString(human, goblins));
                if(next) {
                    System.out.println(map.toString(human, goblin));

                    move = " ";
                    System.out.println("Where would you like to move?");
                    move = String.valueOf(scan.next().charAt(0));

                    switch (move) {
                        case "n":
                            map.move(human, 0, -1);
                            break;
                        case "s":
                            map.move(human, 0, 1);
                            break;
                        case "e":
                            map.move(human, 1, 0);
                            break;
                        case "w":
                            map.move(human, -1, 0);
                            break;
                        default:
                            System.out.println("That is not a valid move, your options are n/s/e/w");
                            break;
                    }
                }
                combat = map.checkCombat(human.getPos(), goblin);
                if (combat) {
                    if(next)
                        System.out.println("You have encountered a goblin, let the fight commence!");
                    else
                        System.out.println("Continuing combat");
                    System.out.println("Rock, paper, or scissors?");
                    move = scan.next().toLowerCase();
                    if(move.equals("rock"))
                        map.combat(1, goblin, human);
                    else if(move.equals("paper"))
                        map.combat(2, goblin, human);
                    else if(move.equals("scissors"))
                        map.combat(3, goblin, human);
                    else
                        map.combat(4, goblin, human);
                }

                if (!human.Alive())
                    break;
                else if(goblin.Alive() && combat)
                    next=false;
                else if(!goblin.Alive() && combat){
                    next = true;
                    combat = false;
                    goblin = new Goblin(size);
                }

            }
            System.out.printf("You have died after killing %d goblins! Would you like to play again? (y/n)\n");
            move = String.valueOf(scan.next().toLowerCase().charAt(0));
            if (move != "y") {
                System.out.println("Thank you for playing!");
                keepPlaying=false;
            }
        }
    }


}
