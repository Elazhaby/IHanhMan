package eg.edu.alexu.csd.datastructure.hangman.cs51;

import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public interface IHangman {

    void setDictionary(String[] words);

    String selectRandomSecretWord();

    String guess(Character c) throws Exception;

    void setMaxWrongGuesses(Integer max);
}

class IHangmanImplementation implements IHangman {
    public String[] words = new String[854];
    public String hiddenWord;
    public String Expected;
    public boolean won = false;
    public boolean lost = false;
    private char[] wordCharacters = new char[300];
    private int j = 0;
    private int trials = 1;
    
    
    public void setDictionary(String [] words) {
        try{
            Scanner read1 = new Scanner(new FileReader("hangman.txt"));
            for(int i=0;i<words.length;i++){
                words[i]=read1.next();
            }
        }
        catch (Exception e){
            System.out.println("Unable to access The File");
        }
    }

    public String selectRandomSecretWord() {
        int rand = new Random().nextInt(words.length);
        hiddenWord = words[rand];
        Expected = hiddenWord.replaceAll("\\S","-");
        hiddenWord = hiddenWord.toLowerCase();
        return hiddenWord;
    }

    public void Set(){
        hiddenWord = hiddenWord.toLowerCase();
        Expected = hiddenWord.replaceAll("\\S","-");
    }

    public String get_Expected(){
        return this.Expected;
    }
    public String guess(Character c) {
        if(!lost) {
            boolean a = false;
            if (hiddenWord.equals(Expected))    System.out.println("you have won");          
            else {
                if (trials > 0) {
                    for (int i = 0; i < wordCharacters.length; i++) {
                        if (wordCharacters[i] == c)    x = true;                        
                    }
                    if (!a) {
                        wordCharacters[j] = c;
                        j++;
                        boolean b = false;
                        for (int i = 0; i < hiddenWord.length(); i++) {
                            if (hiddenWord.charAt(i) == c) {
                                Expected = Expected.substring(0, i) + c + Expected.substring(i + 1);
                                b = true;
                            }
                        }
                        if (hiddenWord.equals(Expected))    won = true;                       
                        if (!b)   trials--;                      
                        System.out.println(Expected);
                        }
                     else {
                        System.out.println("This character have been chosen before");
                        System.out.println(Expected);
                         }
                      }
                else {
                    System.out.println("Game Over You have lost");
                    System.out.println("The secret word is " + hiddenWord);
                }
            }
            System.out.println("Remaining Trials " + trials);
            if (trials == 0)     lost = true;
        }
        else{
        throw new RuntimeException("maximum number of chances");
        }
        return Expected;
    }
    public void setMaxWrongGuesses(Integer max) {
        trials = max;
        wordCharacters = new char[max+ hiddenWord.length()];
    }
}
