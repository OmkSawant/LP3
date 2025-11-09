import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// A node in the Huffman tree
class HuffmanNode {
    int data;
    char c;
    HuffmanNode left, right;
}

// Comparator for sorting nodes by frequency
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data; // ascending order of frequency
    }
}

public class Daa2_Huffman {

    // Recursive function to print the Huffman codes
    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + " : " + s);
            return;
        }
        if (root.left != null)
            printCode(root.left, s + "0");
        if (root.right != null)
            printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] charArray = new char[n];
        int[] charFreq = new int[n];

        System.out.println("Enter characters and their frequencies:");
        for (int i = 0; i < n; i++) {
            System.out.print("Character " + (i + 1) + ": ");
            charArray[i] = sc.next().charAt(0);
            System.out.print("Frequency of " + charArray[i] + ": ");
            charFreq[i] = sc.nextInt();
        }

        // Create a priority queue to store nodes based on frequency
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new MyComparator());

        // Create a leaf node for each character
        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charFreq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }

        // Build the Huffman Tree
        HuffmanNode root = null;
        while (q.size() > 1) {
            HuffmanNode x = q.poll(); // smallest frequency
            HuffmanNode y = q.poll(); // second smallest

            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;

            root = f;
            q.add(f);
        }

        // Print Huffman Codes
        System.out.println("\nHuffman Codes for the given characters:");
        printCode(root, "");

        sc.close();
    }
}
