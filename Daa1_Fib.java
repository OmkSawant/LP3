import java.util.Scanner;

public class Daa1_Fib {

    // Step counters for both methods
    static int recursiveSteps = 0;
    static int iterativeSteps = 0;

    // Recursive Fibonacci 
    static int fibonacciRecursive(int n) {
        recursiveSteps++; // count each call
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci 
    static int fibonacciIterative(int n) {
        if (n <= 1) {
            iterativeSteps++;
            return n;
        }
        int a = 0, b = 1, c = 0;
        iterativeSteps += 2; // for initial assignments
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
            iterativeSteps++; // count each loop iteration
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int n = sc.nextInt();

        // Recursive
        recursiveSteps = 0;
        System.out.println("\nFibonacci Series using Recursive method:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.println("\nTotal Recursive Steps: " + recursiveSteps);

        // Iterative
        iterativeSteps = 0;
        System.out.println("\nFibonacci Series using Iterative method:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciIterative(i) + " ");
        }
        System.out.println("\nTotal Iterative Steps: " + iterativeSteps);

        sc.close();
    }
}
