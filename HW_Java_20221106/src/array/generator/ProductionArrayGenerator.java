package array.generator;

import java.util.Scanner;

public class ProductionArrayGenerator implements ArrayGenerator{
    @Override
    public int[] generateArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ENTER ARRAY LENGTH: ");
        int size = scanner.nextInt();

        System.out.print("ENTER " + size + " NUMBERS: ");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        return arr;
    }
}
