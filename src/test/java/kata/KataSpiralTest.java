package kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class KataSpiralTest {

    @Test
    public void entryString(){
        assertTrue(KataSpiral.createSpiral("j").length ==0);
    }
    @Test
    public void entryEqualsToZero(){
        assertTrue(KataSpiral.createSpiral("0").length ==0);
    }

    @Test
    public void entryNegative(){
        assertTrue(KataSpiral.createSpiral("-1").length ==0);
    }

    @Test
    public void entryEqualsToOne(){
        assertTrue(KataSpiral.createSpiral("1").length ==1);
        assertTrue(KataSpiral.createSpiral("1")[0][0] ==1);
    }

    @Test
    public void entryEqualsToTwo(){
        assertTrue(KataSpiral.createSpiral("2").length ==2);
        assertTrue(KataSpiral.createSpiral("2")[0][0] == 1);
        assertTrue(KataSpiral.createSpiral("2")[0][1] == 2);
        assertTrue(KataSpiral.createSpiral("2")[1][0] == 4);
        assertTrue(KataSpiral.createSpiral("2")[1][1] == 3);
    }

    @Test
    public void entryEqualsToThree(){
        assertTrue(KataSpiral.createSpiral("3").length ==3);
        assertTrue(KataSpiral.createSpiral("3")[0][0] == 1);
        assertTrue(KataSpiral.createSpiral("3")[0][1] == 2);
        assertTrue(KataSpiral.createSpiral("3")[0][2] == 3);
        assertTrue(KataSpiral.createSpiral("3")[1][0] == 8);
        assertTrue(KataSpiral.createSpiral("3")[1][1] == 9);
        assertTrue(KataSpiral.createSpiral("3")[1][2] == 4);
        assertTrue(KataSpiral.createSpiral("3")[2][0] == 7);
        assertTrue(KataSpiral.createSpiral("3")[2][1] == 6);
        assertTrue(KataSpiral.createSpiral("3")[2][2] == 5);
    }

    @Test
    public void entryEqualsToFor(){
        assertTrue(KataSpiral.createSpiral("4").length ==4);
        assertTrue(KataSpiral.createSpiral("4")[0][0] ==1);
        assertTrue(KataSpiral.createSpiral("4")[0][1] ==2);
        assertTrue(KataSpiral.createSpiral("4")[0][2] ==3);
        assertTrue(KataSpiral.createSpiral("4")[0][3] ==4);

        assertTrue(KataSpiral.createSpiral("4")[1][3] ==5);
        assertTrue(KataSpiral.createSpiral("4")[2][3] ==6);
        assertTrue(KataSpiral.createSpiral("4")[3][3] ==7);

        assertTrue(KataSpiral.createSpiral("4")[3][2] ==8);
        assertTrue(KataSpiral.createSpiral("4")[3][1] ==9);
        assertTrue(KataSpiral.createSpiral("4")[3][0] ==10);

        assertTrue(KataSpiral.createSpiral("4")[2][0] ==11);
        assertTrue(KataSpiral.createSpiral("4")[1][0] ==12);

        assertTrue(KataSpiral.createSpiral("4")[1][1] ==13);
        assertTrue(KataSpiral.createSpiral("4")[1][2] ==14);

        assertTrue(KataSpiral.createSpiral("4")[2][2] ==15);

        assertTrue(KataSpiral.createSpiral("4")[2][1] ==16);
    }
}