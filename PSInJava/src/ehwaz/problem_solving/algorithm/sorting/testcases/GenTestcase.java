package ehwaz.problem_solving.algorithm.sorting.testcases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Sangwook on 2016-04-08.
 */
public class GenTestcase {
    // Ref: http://www.javapractices.com/topic/TopicAction.do?Id=62
    static long generate(long start, long end) {
        Random randomGenerator = new Random();

        long range = end - start + 1;
        long fraction = (long)(range * randomGenerator.nextDouble());

        return start + fraction;
    }

    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("From? : ");
        long start = sc.nextLong();

        System.out.println("To? : ");
        long end = sc.nextLong();

        System.out.println("How many? : ");
        long numberOfValues = sc.nextLong();

        if (start >= end) {
            throw new IllegalArgumentException("Wrong range input");
        }

        String path = System.getProperty("user.dir");
        String fileName = "len" + Long.toString(numberOfValues) + "_less" +
                            Long.toString(end) + "_bigger" + Long.toString(start) + "_input.txt";

        try {
            FileWriter writer = new FileWriter(path + "/" + fileName);

            writer.write(Long.toString(numberOfValues) + "\n");
            for (long cnt = 0; cnt < numberOfValues; cnt++) {
                long randomNum = generate(start, end);
                writer.write(Long.toString(randomNum));
                if (cnt != numberOfValues-1) {
                    writer.write(" ");
                }
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
