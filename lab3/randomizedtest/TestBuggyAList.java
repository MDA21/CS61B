package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> list = new BuggyAList<Integer>();
        AListNoResizing<Integer> list1 = new AListNoResizing<Integer>();
        for (int i =4; i <= 6;i++){
            list.addLast(i);
            list1.addLast(i);
        }
        assertEquals(list.size(), list1.size());
        assertEquals(list.removeLast(), list1.removeLast());
        assertEquals(list.removeLast(), list1.removeLast());
        assertEquals(list.removeLast(), list1.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<Integer>();
        BuggyAList<Integer> list = new BuggyAList<Integer>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                list.addLast(randVal);
                assertEquals(L.size(), list.size());
            } else if (operationNumber == 1) {
                // size
                if(L.size() == 0){
                    continue;
                }
                int RemoveLastA = L.removeLast();
                int RemoveLastB = list.removeLast();
                assertEquals(RemoveLastA, RemoveLastB);
            }else if (operationNumber == 2) {
                if(L.size() == 0){
                    continue;
                }
                int LastA = L.getLast();
                int LastB = list.getLast();
                assertEquals(LastA, LastB);
            }
        }
    }

}