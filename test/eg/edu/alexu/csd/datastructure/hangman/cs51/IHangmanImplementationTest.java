package eg.edu.alexu.csd.datastructure.hangman.cs51;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IHangmanImplementationTest {
    @Test
    public void testcase1(){
        IHangmanImplementation x=new IHangmanImplementation();
        x.hiddenWord = "computer";
        x.Set();
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
    public void testcase2(){
        IHangmanImplementation x = new IHangmanImplementation();
        String result;
        x.hiddenWord = "book";
        x.Set();
        result= x.guess('b');
        assertEquals("b---",result);
        result=x.guess('o');
        assertEquals("boo-",result);
        result= x.guess('k');
        assertEquals("book",result);
        assertEquals(true,x.won);
    }

    @Test
    public void testcase3(){
        IHangmanImplementation x = new IHangmanImplementation();
        x.hiddenWord = "Pound";
        x.Set();
        x.guess('f');
        assertEquals(true,x.lost);
        assertThrows(RuntimeException.class,()->{x.guess('d');});
    }

    @Test
    public void testcase4(){
        IHangmanImplementation x = new IHangmanImplementation();
        x.hiddenWord = "world";
        x.Set();
        x.guess('f');
        assertEquals(true,x.lost);
        assertThrows(RuntimeException.class,()->{x.guess('d');});
    }

    @Test
    public void testcase5(){
        IHangmanImplementation x = new IHangmanImplementation();
        x.hiddenWord = "ruler";
        x.Set();
        x.setMaxWrongGuesses(3);
        x.guess('f');
        x.guess('b');
        x.guess('p');
        assertEquals(true,x.lost);
        assertThrows(RuntimeException.class,()->{x.guess('d');});
    }

    @Test
    public void testcase6(){
        String word = null;
        IHangmanImplementation x = new IHangmanImplementation();
        x.setDictionary(x.words);
        word = x.selectRandomSecretWord();
        assertTrue(!word.isEmpty());
    }
}
