import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Hangman {
    private String ans;
    private ArrayList<Character> answer = new ArrayList<>();
    private ArrayList<Character> wrong = new ArrayList<>();
    private char[] correct;
    private Random rand = new Random();
    private Scanner scan;
    private ArrayList<String> list = new ArrayList<>();
    int lives;

    public Hangman() throws FileNotFoundException {
        try {
            scan = new Scanner(new File("src/main/resources/hangmanWords.txt"));
            while (scan.hasNext()) {
                list.add(scan.nextLine());
            }
            setUpGame();
        }
        catch (FileNotFoundException e){
            System.out.println("File failed to load in class");
        }
    }

    public void setUpGame(){
        setAnswer();
        answer.clear();
        wrong.clear();
        lives = 6;
    }

    public String getAns(){
        return ans;
    }

    public char[] getCorrect(){
        return correct;
    }

    public int getLives(){
        return lives;
    }

    public ArrayList<Character> getWrong(){
        return wrong;
    }

    public void setAnswer(String input){
        ans = input;
        extracted();
    }

    private void extracted() {
        correct = new char[ans.length()];
        for (int i = 0; i < ans.length(); i++) {
            correct[i]='_';
            answer.add(ans.charAt(i));
        }
    }

    public void setAnswer(){
        int random = rand.nextInt(list.size());
        ans = list.get(random);
        extracted();
    }

    public boolean guessCheck(char guess){
        guess = Character.toLowerCase(guess);
        if(answer.contains(guess)) {
            for (int i = 0; i < answer.size(); i++) {
                if(answer.get(i) == guess)
                    correct[i] = guess;
            }
            if(!new String(correct).contains("_"))
                return true;
        }
        else {
            lives--;
            if(!wrong.contains(guess))
                wrong.add(guess);
        }
        return false;
    }

    public boolean keepPlaying(){

    }

    public void drawHangman() {
        switch (lives){
            case 6:
                System.out.println(""
                        +"\t|----------\n"
                        +"\t|\n"
                        +"\t|\n"
                        +"\t|\n"
                        +"\t|\n"
                        +"\t*************");
                break;
            case 5:
                System.out.println(""
                        +"\t|----------\n"
                        +"\t|     O\n"
                        +"\t|\n"
                        +"\t|\n"
                        +"\t|\n"
                        +"\t*************");
                break;
            case 4:
                System.out.println(""
                        +"\t|----------\n"
                        +"\t|     O\n"
                        +"\t|     |\n"
                        +"\t|\n"
                        +"\t|\n"
                        +"\t*************");
                break;
            case 3:
                System.out.println(""
                        +"\t|----------\n"
                        +"\t|     O\n"
                        +"\t|   \\|\n"
                        +"\t|\n"
                        +"\t|\n"
                        +"\t*************");
                break;
            case 2:
                System.out.println(""
                        +"\t|----------\n"
                        +"\t|     O\n"
                        +"\t|   \\|/\n"
                        +"\t|\n"
                        +"\t|\n"
                        +"\t*************");
                break;
            case 1:
                System.out.println(""
                        +"\t|----------\n"
                        +"\t|     O\n"
                        +"\t|   \\|/\n"
                        +"\t|    /\n"
                        +"\t|\n"
                        +"\t*************");
                break;
            default:
                System.out.println(""
                        +"\t|----------\n"
                        +"\t|     O\n"
                        +"\t|   \\|/\n"
                        +"\t|    / \\\n"
                        +"\t|\n"
                        +"\t*************");
        }
    }

}
