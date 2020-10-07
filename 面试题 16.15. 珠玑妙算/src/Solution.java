import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] masterMind(String solution, String guess) {

        int[] solution0 = new int[4];
        char[] solutionC = solution.toCharArray();
        char[] guessC = guess.toCharArray();
        List<Character> noGuess = new ArrayList<>();
        int guessNum = 0;
        int reGuessNum = 0;
        for(int i = 0; i < solutionC.length; i++){
            int index = getIndex(solutionC[i]);
            solution0[index] ++;
            if(solutionC[i] == guessC[i]){
                solution0[index] --;
                guessNum++;
            } else {
                noGuess.add(guessC[i]);
            }
        }
        for(char c : noGuess){
            int index = getIndex(c);
            if(solution0[index] > 0){
                solution0[index] --;
                reGuessNum++;
            }
        }
        return new int[]{guessNum, reGuessNum};
    }

    private int getIndex(char c){
        if(c == 'R')
            return 0;
        else if(c == 'Y')
            return 1;
        else if(c == 'G')
            return 2;
        else
            return 3;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] mind = solution.masterMind("BGBG", "RGBR");
        System.out.println(mind[0] + " " + mind[1]);
    }
}
