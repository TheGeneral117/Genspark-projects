import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Hangman {
    private String ans, name;
    Map<String, String> winners = new HashMap<String, String>();
    private ArrayList<Character> answer = new ArrayList<>();
    private ArrayList<Character> wrong = new ArrayList<>();
    private ArrayList<Character> used = new ArrayList<>();
    private char[] correct;
    private Random rand = new Random();
    private Scanner scan;
    private ArrayList<String> list, hangmen;
    private int lives, wins = -1;

    public Hangman() throws FileNotFoundException {
        try {
            list = new ArrayList<String> (Files.readAllLines(Path.of("src/main/resources/hangmanWords.txt")).stream()
                    .collect(Collectors.toList()));
            hangmen = new ArrayList<String> (Files.readAllLines(Path.of("src/main/resources/hangmanFigures.txt")).stream()
                    .collect(Collectors.toList()));
            fix(0);
            setUpGame();
        }
        catch (IOException e){
            System.out.println("File failed to load in class");
        }
    }

    public void setName(String name){
        this.name = name;
    }

    private void fix(int i){
        String hold = hangmen.get(i);
        hold = hold.replace("\\\\n", "\n").replace("\\\\t", "\t");
        hangmen.set(i, hold);
        if(++i != hangmen.size())
            fix(i);
    }

    public void setUpGame(){
        wrong.clear();
        used.clear();
        lives = 6;
        wins++;
        setAnswer();
    }

    public int getWins(){
        return wins;
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
        // correct guess
        if(answer.contains(guess)) {
            char finalGuess = guess;

            // fill in matching letters
            addLetters(0, finalGuess);

            // if all letters guessed
            if(!new String(correct).contains("_"))
                return true;
        }
        // wrong guess
        else {
            lives--;
            if(!wrong.contains(guess))
                wrong.add(guess);
        }

        // if letter not used
        if(!used.contains(guess))
            used.add(guess);
        return false;
    }

    private void addLetters(int i, char guess){
        if(answer.get(i).equals(guess))
            correct[i] = guess;
        if(++i != correct.length)
            addLetters(i, guess);
    }

    public boolean keepPlaying(){
        return false;
    }

    public void writeWinners(String name){

    }

    public void readWinners(){

        BufferedReader br = null;

        try {

            // create file object
            File file = new File("src/main/resources/hangmanWords.txt");

            // create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));

            // read file line by line
            readLine(br);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            // Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
    }

    private void readLine(BufferedReader br) throws IOException {
        String line;
        line = br.readLine();

        // split the line by :
        String[] parts = line.split(":");

        // first part is name, second is number
        String name = parts[0].trim();
        String number = parts[1].trim();

        // put name, number in HashMap if they are
        // not empty
        if (!name.equals("") && !number.equals(""))
            winners.put(name, number);

        if(br.readLine() != null)
            readLine(br);
    }

    public void drawHangman() {
        switch (lives){
            case 6:
                System.out.println(hangmen.get(0));
                break;
            case 5:
                System.out.println(hangmen.get(1));
                break;
            case 4:
                System.out.println(hangmen.get(2));
                break;
            case 3:
                System.out.println(hangmen.get(3));
                break;
            case 2:
                System.out.println(hangmen.get(4));
                break;
            case 1:
                System.out.println(hangmen.get(5));
                break;
            default:
                System.out.println(hangmen.get(6));
                break;
        }
    }

}
