package ehwaz.problem_solving.util;

/**
 * Created by Sangwook on 2016-04-08.
 */
public class printing {
    public static void printArray(int[] ar) {
        StringBuilder output = new StringBuilder();
        for(int n: ar){
            output.append(n + " ");
        }
        System.out.println(output.toString().trim());
    }

    public static void printArray(long[] ar) {
        StringBuilder output = new StringBuilder();
        for(long n: ar){
            output.append(n + " ");
        }
        System.out.println(output.toString().trim());
    }
}
