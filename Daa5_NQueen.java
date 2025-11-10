import java.util.Scanner;

public class Daa5_NQueen {
    static int N;
    static int[][] board;
    static boolean[] cols;   // columns used
    static boolean[] diag1;  // major diagonals
    static boolean[] diag2;  // minor diagonals
    static int firstRow, firstCol;
    static int solutionCount = 0;

    // Print board configuration
    static void printBoard() {
        System.out.println("Solution #" + (++solutionCount) + ":");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    // Recursive backtracking function
    static void solve(int row) {
        if (row == N) {
            printBoard();
            return;
        }

        // Skip the row with the fixed queen
        if (row == firstRow) {
            solve(row + 1);
            return;
        }

        for (int c = 0; c < N; c++) {
            int d1Index = row - c + (N - 1);
            int d2Index = row + c;
            if (!cols[c] && !diag1[d1Index] && !diag2[d2Index]) {
                // Place queen
                board[row][c] = 1;
                cols[c] = diag1[d1Index] = diag2[d2Index] = true;

                // Recurse for next row
                solve(row + 1);

                // Backtrack
                board[row][c] = 0;
                cols[c] = diag1[d1Index] = diag2[d2Index] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter board size (N): ");
        N = sc.nextInt();

        board = new int[N][N];
        cols = new boolean[N];
        diag1 = new boolean[2 * N - 1];
        diag2 = new boolean[2 * N - 1];

        System.out.print("Enter first queen position (row col) 0-based: ");
        firstRow = sc.nextInt();
        firstCol = sc.nextInt();

        // Validate input
        if (firstRow < 0 || firstRow >= N || firstCol < 0 || firstCol >= N) {
            System.out.println("Invalid first queen position!");
            sc.close();
            return;
        }

        // Place the first queen
        board[firstRow][firstCol] = 1;
        cols[firstCol] = true;
        diag1[firstRow - firstCol + (N - 1)] = true;
        diag2[firstRow + firstCol] = true;

        System.out.println("\nSolving " + N + "-Queens with first queen fixed at (" + firstRow + ", " + firstCol + ")...\n");

        solve(0);

        System.out.println("✅ Total number of valid solutions: " + solutionCount);
        sc.close();
    }
}
