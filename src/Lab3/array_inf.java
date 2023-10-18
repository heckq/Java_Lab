package Lab3;

import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class array_inf {

    static int getMax(int array[], int size) {
        int maxelem = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) maxelem = max(maxelem, array[i]);
        return maxelem;
    }

    static int getMin(int array[], int size) {
        int minelem = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) minelem = min(minelem, array[i]);
        return minelem;
    }

    static float getMid(int array[], int size) {
        float sum = getSum(array, size);
        sum /= size;
        return sum;
    }

    static int getSum(int array[], int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) sum += array[i];
        return sum;
    }

    static void getSort(int array[], int size) {
        int array1[] = array;
        Arrays.sort(array1);
        for (int i = 0; i < size; i++) System.out.print(array1[i] + " ");
        System.out.println();
        System.out.println("Reverse order:");
        for (int i = size - 1; i >= 0; i--) System.out.print(array1[i] + " ");
        System.out.println();
    }

    static void getEven(int array[], int size) {
        int n = 0;
        for (int i = 0; i < size; i++) if (array[i] % 2 == 0) n++;
        System.out.println("Number of even numbers: " + n);
        System.out.println("Even numbers: ");
        for (int i = 0; i < size; i++) if (array[i] % 2 == 0) System.out.print(array[i] + " ");
        System.out.println();
    }

    static void getOdd(int array[], int size) {
        int n = 0;
        for (int i = 0; i < size; i++) if (array[i] % 2 != 0) n++;
        System.out.println("Number of odd numbers: " + n);
        System.out.println("Odd numbers: ");
        for (int i = 0; i < size; i++) if (array[i] % 2 != 0) System.out.print(array[i] + " ");
        System.out.println();
    }
}
