package two;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String input = in.nextLine();
        int n = input.length();

        List<BigInteger> res = new ArrayList<>();
        int l = 0, r = -1;
        while (++r < n){
            char cur = input.charAt(r);
            if (cur >= '0' && cur <= '9'){

            } else {
                if (r > l){
                    res.add(toInt(input.substring(l, r)));
                }
                l = r + 1;
            }
        }
        if (r > l){
            res.add(toInt(input.substring(l, r)));
        }
        Collections.sort(res);
        for (BigInteger integer : res) {
            System.out.println(integer);
        }
    }
    private static BigInteger toInt(String s){
        int l = 0, r = s.length();
        while (l < r && s.charAt(l) == '0'){
            l++;
        }
        if (l == r){
            return BigInteger.ZERO;
        }
        return new BigInteger(s.substring(l, r));
    }
}
