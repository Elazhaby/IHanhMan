package eg.edu.alexu.csd.datastructure.hangman.cs51;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IHangmanImplementationTest {
    @Test
    public void test1(){
        IHangmanImplementation x=new IHangmanImplementation();
        x.hiddenWord="computer";
        x.intialize();
        x.guess('c');
        x.guess('o');
        x.guess('m');
        x.guess('p');
        x.guess('u');
        x.guess('t');
        x.guess('e');
        x.guess('r');
        assertEquals(true,x.won);
    }
    @Test
    public void test2(){
        IHangmanImplementation x = new IHangmanImplementation();
        String result;
        x.hiddenWord = "book";
        x.intialize();
        result= x.guess('b');
        assertEquals("b---",result);
        result=x.guess('o');
        assertEquals("boo-",result);
        result= x.guess('k');
        assertEquals("book",result);
        assertEquals(true,x.won);
    }

    @Test
    public void test3(){
        IHangmanImplementation x = new IHangmanImplementation();
        x.hiddenWord = "Pound";
        x.intialize();
        x.guess('f');
        assertEquals(true,x.lost);
        assertThrows(RuntimeException.class,()->{x.guess('d');});
    }

    @Test
    public void test4(){
        IHangmanImplementation x = new IHangmanImplementation();
        x.hiddenWord = "world";
        x.intialize();
        x.guess('f');
        assertEquals(true,x.lost);
        assertThrows(RuntimeException.class,()->{x.guess('d');});
    }

    @Test
    public void test5(){
        IHangmanImplementation x = new IHangmanImplementation();
        x.hiddenWord = "ruler";
        x.intialize();
        x.setMaxWrongGuesses(3);
        x.guess('f');
        x.guess('b');
        x.guess('p');
        assertEquals(true,x.lost);
        assertThrows(RuntimeException.class,()->{x.guess('d');});
    }

    @Test
    public void test6(){
        String word=null;
        IHangmanImplementation x = new IHangmanImplementation();
        x.setDictionary(x.words);
        word= x.selectRandomSecretWord();
        assertTrue(!word.isEmpty());
    }
}
