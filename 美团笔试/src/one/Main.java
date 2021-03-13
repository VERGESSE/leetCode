package one;

import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] source = new int[n][m];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                source[j][i] = in.nextInt();
            }
        }
        for (int[] row : source) {
            for (int cur : row) {
                System.out.print(cur + " ");
            }
            System.out.println();
        }
    }
}
