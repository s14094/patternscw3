package s14094.patterns.cw003;

import java.util.Random;

/**
 * @author Paweł Łakomiec
 **/
public class Service {

    public static final int USED_COMPLEXITY = 1;
    public static final int ARRAY_LENGTH_O1 = 100;
    public static final int ARRAY_LENGTH_On = 10000;
    public static final int ARRAY_LENGTH_On2 = 10000;

    public int[] generateArray(int complex) {

        int length;
        if (complex == 1) {
            length = ARRAY_LENGTH_O1;
        } else if (complex == 2) {
            length = ARRAY_LENGTH_On;
        } else {
            length = ARRAY_LENGTH_On2;
        }

        Random rd = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
        return arr;
    }


}
