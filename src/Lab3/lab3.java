package Lab3;

import java.util.Scanner;

public class lab3 {
    public static void lab3_main() {
        System.out.println("Enter array size(must be more than 0): \n");
        Scanner sc = new Scanner(System.in);
        int size=0;
        try{
             size = sc.nextInt();
        }
        catch (Exception e){
            System.out.println("щось пішло не так");
        }


        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter array elem №: " + (i + 1));
            int elem = sc.nextInt();
            array[i] = elem;
        }
        System.out.println("Enter your query:");
        while (true) {
            System.out.println("Type '0' for menu ");
            int st = sc.nextInt();
            if (st == 0) System.out.println(
                    """
                            Type '-1' to exit\s
                            Type '1' for max elem of array\s
                            Type '2' for min elem of array\s
                            Type '3' for Arithmetical mean of array\s
                            Type '4' for sum of array\s
                            Type '5' to sort array\s
                            Type '6' for all even elem of array\s
                            Type '7' for all odd elem of array\s
                            """);
            if (st == 1) System.out.println("Max elem of array: " + array_inf.getMax(array, size));
            if (st == 2) System.out.println("Min elem of array: " + array_inf.getMin(array, size));
            if (st == 3) System.out.println("Arithmetical mean of array: " + array_inf.getMid(array, size));
            if (st == 4) System.out.println("Sum of array: " + array_inf.getSum(array, size));
            if (st == 5) {
                System.out.println("Sorted array: ");
                array_inf.getSort(array, size);
            }
            if (st == 6) array_inf.getEven(array, size);
            if (st == 7) array_inf.getOdd(array, size);
            if (st == -1) break;
            if (st > 7 || st < -1) System.out.println("Wrong query");
        }
    }

}
