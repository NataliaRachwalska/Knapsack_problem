package org.example;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = 1;
        int upperBound = 10;

        System.out.printf("Enter number of items:");
        int num = scanner.nextInt();

        System.out.printf("Enter seed:");
        int seed = scanner.nextInt();

        System.out.printf("Enter knapsack capacity:");
        int capacity = scanner.nextInt();

        System.out.printf("Generated sorted items:\n");

        Problem problem = new Problem(num, seed, lowerBound, upperBound);
        problem = problem.GenerateProblem();

        problem.Sort();
        System.out.println(problem);

        Result result = problem.Solve(capacity);
        System.out.println(result);
    }
}