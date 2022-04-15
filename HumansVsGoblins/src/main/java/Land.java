import java.util.ArrayList;
import java.util.Arrays;

public class Land {
    int[][] dimensions = new int[7][7];;
    char symbol = '◙';

    public String toString(Human human, ArrayList<Goblin> goblins){
        String map="";
        for (int i = 0; i < dimensions.length; i++) {
            for (int j = 0; j < dimensions[0].length; j++) {
                int[] coord = new int[]{i, j};
                if(Arrays.equals(human.getPos(), coord))
                    map+=human.toString();
                for (Goblin goblin : goblins) {
                    if(Arrays.equals(goblin.getPos(), coord))
                        map+=goblin.toString();
                }
                map+=symbol;
            }
            map+="\n";
        }
        return map;
    }


    public String toString(Human human, Goblin goblin){
        String map="";
        for (int i = 0; i < dimensions.length; i++) {
            for (int j = 0; j < dimensions[0].length; j++) {
                int[] coord = new int[]{i, j};
                if(Arrays.equals(human.getPos(), coord))
                    map+=human.toString();
                else if(Arrays.equals(goblin.getPos(), coord))
                    map+=goblin.toString();
                else
                    map+=symbol;
            }
            map+="\n";
        }
        return map;
    }

    public int getDimensions(){
        return dimensions.length;
    }

    public void move(Human human, int moveX, int moveY){
        human.setPos(moveX,moveY, dimensions.length);
    }

    public boolean checkCombat(int[] pos, ArrayList<Goblin> goblins){
        for (Goblin goblin : goblins) {
            if(Arrays.equals(goblin.getPos(), pos))
                return true;
        }
        return false;
    }

    public boolean checkCombat(int[] pos, Goblin goblin){
        if(Arrays.equals(goblin.getPos(), pos))
            return true;
        return false;
    }

    public void combat(int pChoice, Goblin goblin, Human human){
        if(pChoice == 4)
            System.out.println("That is not a valid choice, the goblin gets the first swing!");
        int gChoice = goblin.combatChoice();
        int goblinDmg = (int)(goblin.getStrength() * Math.random());
        int humanDmg = (int)(human.getStrength() * Math.random());

        if((pChoice == 1 && gChoice == 2) || (pChoice == 2 && gChoice == 3) || (pChoice == 3 && gChoice == 1))
        {
            System.out.println("You were faster and got the first swing.");
            if(humanDmg == 0)
                System.out.println("You missed your swing");
            else
                goblin.setHealth(goblin.getHealth() - humanDmg);
            if(human.Alive()) {
                if (goblinDmg == 0)
                    System.out.println("The goblin missed their swing");
                else
                    human.setHealth(human.getHealth() - goblinDmg);
            }
            return;
        }
        else if((pChoice == 1 && gChoice == 3) || (pChoice == 3 && gChoice == 2) || (pChoice == 2 && gChoice == 1))
        {
            System.out.println("You were slower and got hit first.");
            if (goblinDmg == 0)
                System.out.println("The goblin missed their swing");
            else
                human.setHealth(human.getHealth() - goblinDmg);

            if(goblin.Alive()) {
                if(humanDmg == 0)
                    System.out.println("You missed your swing");
                else
                    goblin.setHealth(goblin.getHealth() - humanDmg);
            }
            return;
        }
        else
            System.out.println("You both hit each other at the same time");

        if (goblinDmg == 0)
            System.out.println("The goblin missed their swing");
        else
            human.setHealth(human.getHealth() - goblinDmg);
        if(goblin.Alive()) {
            if(humanDmg == 0)
                System.out.println("You missed your swing");
            else
                goblin.setHealth(goblin.getHealth() - humanDmg);
        }
    }



}
