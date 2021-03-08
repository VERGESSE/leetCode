package one;

import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int N = in.nextInt();
        while (N-- > 0){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] cards = new int[n];
            for(int i = 0; i < n; i++){
                cards[i] = in.nextInt();
            }
            int start = cards[0];
            for(int i = 1; i < n; i++){
                int next = cards[i];
                int sub = next - start - 1;
                if(k - sub <= 0){
                    break;
                } else {
                    k -= sub;
                }
                start = next;
            }
            System.out.println(start + k);
        }
    }
}
