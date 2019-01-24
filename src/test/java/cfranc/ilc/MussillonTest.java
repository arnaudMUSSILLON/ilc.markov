/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfranc.ilc;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arnaudmussillon
 */
public class MussillonTest {
    
    String[] when2SimpleWords = new String[] {"parapluie", "parachute"};
    
    @Test
    public void getSimilarity_2SimpleWords_26() {
        MarkovWord m = new MarkovWord();
        double expected = 0.33;
        double actual = m.getSimilarity(when2SimpleWords[0],when2SimpleWords[1], 2);
        assertEquals(expected, actual,0.01);		
    }

    @Test
    public void getSimilarity_SameWord_100() {
        MarkovWord m = new MarkovWord();
        double expected = 1.0;
        double actual = m.getSimilarity(when2SimpleWords[0],when2SimpleWords[0], 4);
        assertEquals(expected, actual,0.000000001);		
    }


    @Test
    public void common_SameWord_1() {
        MarkovWord m = new MarkovWord();
        MarkovData m1 = new MarkovData("chien", 2);
        MarkovData m2 = new MarkovData("chat", 2);
        MarkovData m3 = new MarkovData("chien", 2);
        MarkovData m4 = new MarkovData("serpent", 2);
        List<MarkovData> liste1 = new ArrayList<MarkovData>();
        List<MarkovData> liste2 = new ArrayList<MarkovData>();
        liste1.add(m1);
        liste1.add(m2);
        liste2.add(m3);
        liste2.add(m4);
        int expected = 1;
        int actual = m.common(liste1, liste2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void common_DifferentWords_0() {
        MarkovWord m = new MarkovWord();
        MarkovData m1 = new MarkovData("cochon", 2);
        MarkovData m2 = new MarkovData("chat", 2);
        MarkovData m3 = new MarkovData("chien", 2);
        MarkovData m4 = new MarkovData("serpent", 2);
        List<MarkovData> liste1 = new ArrayList<MarkovData>();
        List<MarkovData> liste2 = new ArrayList<MarkovData>();
        liste1.add(m1);
        liste1.add(m2);
        liste2.add(m3);
        liste2.add(m4);
        int expected = 0;
        int actual = m.common(liste1, liste2);
        assertEquals(expected, actual);
    }
    
    
    @Test
    public void common_SameWordUpperCase_1() {
        MarkovWord m = new MarkovWord();
        MarkovData m1 = new MarkovData("chien", 2);
        MarkovData m2 = new MarkovData("chat", 2);
        MarkovData m3 = new MarkovData("CHIEN", 2);
        MarkovData m4 = new MarkovData("serpent", 2);
        List<MarkovData> liste1 = new ArrayList<MarkovData>();
        List<MarkovData> liste2 = new ArrayList<MarkovData>();
        liste1.add(m1);
        liste1.add(m2);
        liste2.add(m3);
        liste2.add(m4);
        int expected = 1;
        int actual = m.common(liste1, liste2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void union_2SimilarWords_4(){
        MarkovWord m = new MarkovWord();
        MarkovData m1 = new MarkovData("chien", 2);
        MarkovData m2 = new MarkovData("chat", 2);
        MarkovData m3 = new MarkovData("mandrill", 2);
        MarkovData m4 = new MarkovData("chien", 2);
        MarkovData m5 = new MarkovData("serpent", 2);
        MarkovData m6 = new MarkovData("chien", 2);
        List<MarkovData> liste1 = new ArrayList<MarkovData>();
        List<MarkovData> liste2 = new ArrayList<MarkovData>();
        liste1.add(m1);
        liste1.add(m2);
        liste1.add(m3);
        liste2.add(m4);
        liste2.add(m5);
        liste2.add(m6);
        int expected = 4;
        int actual = m.union(liste1, liste2);
        assertEquals(expected, actual);   
    }

    @Test
    public void union_NoSimilarWords_5(){
        MarkovWord m = new MarkovWord();
        MarkovData m1 = new MarkovData("chien", 2);
        MarkovData m2 = new MarkovData("chat", 2);
        MarkovData m3 = new MarkovData("mandrill", 2);
        MarkovData m4 = new MarkovData("baleine", 2);
        MarkovData m5 = new MarkovData("serpent", 2);
        List<MarkovData> liste1 = new ArrayList<MarkovData>();
        List<MarkovData> liste2 = new ArrayList<MarkovData>();
        liste1.add(m1);
        liste1.add(m2);
        liste2.add(m3);
        liste2.add(m4);
        liste2.add(m5);
        int expected = 5;
        int actual = m.union(liste1, liste2);
        assertEquals(expected, actual);   
    }
    
    
    @Test 
    public void processString_SameList_1() {
        MarkovWord m = new MarkovWord();
        List<MarkovData> expected = new ArrayList<MarkovData>();
        expected.add(new MarkovData("%i",1));
        expected.add(new MarkovData("il",1));
        expected.add(new MarkovData("l%",1));
        List<MarkovData> actual = m.processString("il", 2);
        assertEquals(expected, actual);
    }
    
    
    @Test
    public void contains_SimilarWords_1() {
        MarkovWord m = new MarkovWord("baleine", 2);
        int expected = 1;
        int actual = m.contains("ba");
        assertEquals(expected, actual);
    }
    
    @Test
    public void contains_DifferentWords_0() {
        MarkovWord m = new MarkovWord("baleine",2);
        int expected = 0;
        int actual = m.contains("balais");
        assertEquals(expected, actual);
    }
}
