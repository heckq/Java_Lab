import Lab1.*;
import Lab3.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("З якою лабораторною ви хочете взаємодіяти(введіть '1' чи '3'): \n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==1){
         lab1.lab1_main();
        }
        if(n==3){
            lab3.lab3_main();
        }
    }
}