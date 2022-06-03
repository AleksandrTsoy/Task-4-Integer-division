package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the integer number: ");
        int number = Integer.parseInt(in.nextLine());
        System.out.print("Input the divisor: ");
        int divisor = Integer.parseInt(in.nextLine());
        in.close();
        Facade facade = new Facade();
        StringBuilder result = facade.facade(number, divisor);
        System.out.println(result);
    }
}

