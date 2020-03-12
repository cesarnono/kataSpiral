package kata;

import java.util.HashMap;
import java.util.Map;

public class KataSpiral {
    private static final int CERO=0;
    private static final int UNO=1;
    private static final String RIGHT = "RIGHT";
    private static final String DOWN = "DOWN";
    private static final String LEFT = "LEFT";
    private static final String UP = "UP";
    private static final String[] MOVEMENTS = {RIGHT,DOWN,LEFT,UP};
    public static final String LAST_VALUE_SPIRAL = "lastValueSpiral";
    public static final String VALUE_CONSECUTIVE_SPIRAL = "valueConsecutiveSpiral";
    public static final String J = "j";
    public static final String I = "i";

    public static void main(String[] args) {
        Integer[][] spiral = createSpiral("10");
        for (int i = 0; i <spiral.length ; i++) {
            for (int j = 0; j < spiral[i].length ; j++) {
                System.out.print(spiral[i][j]+"-");
            }
            System.out.println();
        }
    }

    public static Integer[][] createSpiral(String value) {
        Integer[][] spirals = null;
        try {
            Integer entryValue = Integer.parseInt(value);
            spirals = new Integer[entryValue][entryValue];
            int valueConsecutiveSpiral = 1;
            int i = 0;
            int j= -1;
            boolean continueMovement = true;
            int lastValueSpiral =0;
            int maxValueSpiral = (entryValue*entryValue);
            Map moveMade = null;
            while (continueMovement){
                for (String movement: MOVEMENTS) {
                    switch (movement){
                        case RIGHT:
                            moveMade = moveRight(j,i,entryValue,valueConsecutiveSpiral,spirals);
                            j = (Integer)moveMade.get(J);
                            break;
                        case DOWN:
                            moveMade = moveDown(i,j,entryValue,valueConsecutiveSpiral,spirals);
                            i= (Integer)moveMade.get(I);
                            break;
                        case LEFT:
                            moveMade = moveLeft(j,i,valueConsecutiveSpiral,spirals);
                            j = (Integer)moveMade.get(J);
                            break;
                        case UP:
                            moveMade = moveUp(i,j,valueConsecutiveSpiral,spirals);
                            i = (Integer)moveMade.get(I);
                            break;
                    }
                    lastValueSpiral = (Integer) moveMade.get(LAST_VALUE_SPIRAL);
                    valueConsecutiveSpiral = (Integer)moveMade.get(VALUE_CONSECUTIVE_SPIRAL);
                    if(lastValueSpiral == maxValueSpiral) {
                        continueMovement= false;
                        break;
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e);
            spirals = new Integer[CERO][CERO];
        }
        return spirals;
    }

    public static Map<String,Integer> moveRight(int indexIncremental, int indexFixed,int maxValueMovement, int valueConsecutiveSpiral, Integer[][] spirals) {
        int j = indexIncremental;
        int i = indexFixed;
        int  lastValueSpiral = valueConsecutiveSpiral;
        for (j=j+1; j < maxValueMovement ; j++) {
            Integer valueFetchFromSpiral = spirals[i][j];
            if(valueFetchFromSpiral != null) {
                --j; break;
            }
            spirals[i][j] = valueConsecutiveSpiral++;
            lastValueSpiral =spirals[i][j];
        }
        if(j == maxValueMovement){
            --j;
        }
        Map data = new HashMap();
        data.put(J,j);
        data.put(LAST_VALUE_SPIRAL,lastValueSpiral);
        data.put(VALUE_CONSECUTIVE_SPIRAL,valueConsecutiveSpiral);
        return data;
    }

    public static Map<String,Integer> moveDown(int indexIncremental, int indexFixed,int maxValueMovement, int valueConsecutiveSpiral, Integer[][] spirals) {
        int i = indexIncremental;
        int j = indexFixed;
        int  lastValueSpiral = valueConsecutiveSpiral;
        for (i =i+1; i< maxValueMovement; i++){
            Integer valueFetchFromSpiral = spirals[i][j];
            if(valueFetchFromSpiral != null) {
                --i; break;
            }
            spirals[i][j] = valueConsecutiveSpiral++;
            lastValueSpiral =spirals[i][j];
        }
        if(i == maxValueMovement){
            --i;
        }
        Map data = new HashMap();
        data.put(I,i);
        data.put(LAST_VALUE_SPIRAL,lastValueSpiral);
        data.put(VALUE_CONSECUTIVE_SPIRAL,valueConsecutiveSpiral);
        return data;
    }

    public static Map<String,Integer> moveLeft(int indexDecremental, int indexFixed, int valueConsecutiveSpiral, Integer[][] spirals) {
        int j = indexDecremental;
        int i = indexFixed;
        int  lastValueSpiral = valueConsecutiveSpiral;
        for (j =j-1; j >= 0 ; j--) {
            Integer valueFetchFromSpiral = spirals[i][j];
            if(valueFetchFromSpiral != null) {
                ++j; break;
            }
            spirals[i][j] = valueConsecutiveSpiral++;
            lastValueSpiral =spirals[i][j];
        }
        if(j<0){
            j++;
        }
        Map data = new HashMap();
        data.put(J,j);
        data.put(LAST_VALUE_SPIRAL,lastValueSpiral);
        data.put(VALUE_CONSECUTIVE_SPIRAL,valueConsecutiveSpiral);
        return data;
    }

    public static Map<String,Integer> moveUp(int indexDecremental, int indexFixed, int valueConsecutiveSpiral, Integer[][] spirals) {
        int i = indexDecremental;
        int j = indexFixed;
        int  lastValueSpiral = valueConsecutiveSpiral;
        for (i=i-1; i >= 0 ; i--) {
            Integer valueFetchFromSpiral = spirals[i][j];
            if(valueFetchFromSpiral != null){
                i++; break;
            }
            spirals[i][j] = valueConsecutiveSpiral++;
            lastValueSpiral =spirals[i][j];
        }
        if(i<0){
            i++;
        }
        Map data = new HashMap();
        data.put(I,i);
        data.put(LAST_VALUE_SPIRAL,lastValueSpiral);
        data.put(VALUE_CONSECUTIVE_SPIRAL,valueConsecutiveSpiral);
        return data;
    }
}
