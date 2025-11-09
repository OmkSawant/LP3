import java.util.Scanner;

public class Daa4_01Knap {

    // Function to solve 0-1 Knapsack using Dynamic Programming
    public static int knapsack(int W, int wt[], int val[], int n) {
        int[][] K = new int[n + 1][W + 1];

        // Build table K[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W]; // Maximum value
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] val = new int[n];
        int[] wt = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and value of item " + (i + 1) + ": ");
            wt[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }

        System.out.print("Enter capacity of knapsack: ");
        int W = sc.nextInt();

        int maxVal = knapsack(W, wt, val, n);
        System.out.println("\nMaximum value in Knapsack = " + maxVal);

        sc.close();
    }
}
