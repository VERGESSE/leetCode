import java.util.List;

class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(),A,B,C);
    }

    public void move(int num, List<Integer> A,List<Integer> B, List<Integer> C){
        if(num == 1){
            C.add(A.remove(A.size()-1));
            return;
        }

        move(num-1,A,C,B);
        C.add(A.remove(A.size()-1));
        move(num-1,B,A,C);
    }
}
