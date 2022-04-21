import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hangman {
    private String ans;
    private ArrayList<Character> answer = new ArrayList<>();
    private ArrayList<Character> wrong = new ArrayList<>();
    private ArrayList<Character> used = new ArrayList<>();
    private char[] correct;
    private Random rand = new Random();
    private Scanner scan;
    private ArrayList<String> list;
    int lives;

    public Hangman() throws FileNotFoundException {
        try {
            list = new ArrayList<String> (Files.readAllLines(Path.of("src/main/resources/hangmanWords.txt")).stream()
                    .collect(Collectors.toList()));
            setUpGame();
        }
        catch (IOException e){
            System.out.println("File failed to load in class");
        }
    }

    public void setUpGame(){
        wrong.clear();
        used.clear();
        lives = 6;
        setAnswer();
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

    public ArrayList<Character> getUsed(){
        return used;
    }

    public boolean checkUsed(Character guess){
        if(used.contains(guess))
            return true;
        return false;
    }

    public void setAnswer(String input){
        ans = input;
        answer.clear();
        extracted();
    }

    private void extracted() {
        correct = new char[ans.length()];
        Arrays.fill(correct, '_');
        answer = new ArrayList<Character>(ans.chars().mapToObj(c -> (char)c).collect(Collectors.toList()));
    }

    public void setAnswer(){
        int random = rand.nextInt(list.size());
        ans = list.get(random);
        answer.clear();
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
        if(!used.contains(guess))
            used.add(guess);
        return false;
    }

    public boolean keepPlaying(){
        return false;
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
                        +"\t|    O\n"
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
                        +"\t|    O\n"
                        +"\t|   \\|\n"
                        +"\t|\n"
                        +"\t|\n"
                        +"\t*************");
                break;
            case 2:
                System.out.println(""
                        +"\t|----------\n"
                        +"\t|    O\n"
                        +"\t|   \\|/\n"
                        +"\t|\n"
                        +"\t|\n"
                        +"\t*************");
                break;
            case 1:
                System.out.println(""
                        +"\t|----------\n"
                        +"\t|    O\n"
                        +"\t|   \\|/\n"
                        +"\t|   /\n"
                        +"\t|\n"
                        +"\t*************");
                break;
            default:
                System.out.println(""
                        +"\t|----------\n"
                        +"\t|    O\n"
                        +"\t|   \\|/\n"
                        +"\t|   / \\\n"
                        +"\t|\n"
                        +"\t*************");
        }
    }

}
