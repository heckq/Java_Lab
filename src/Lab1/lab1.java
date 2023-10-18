package Lab1;

import java.util.*;

public class lab1 {
    public static void lab1_main() {
        System.out.println("Enter X: \n");
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        System.out.println("Enter Y: \n");
        double y = sc.nextDouble();
        System.out.println("Enter Z: \n");
        double z = sc.nextDouble();
        double ans = x;
        for (int i = 0; i < z; i++) {
            x = x + (x * (y / 100)) / 12;
        }
        ans = x - ans;
        System.out.println(ans);
    }
}
