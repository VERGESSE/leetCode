class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int student = 0;

        for(int i = 0; i < startTime.length; ++i){
            if(startTime[i] <= queryTime && endTime[i] >= queryTime){
                student++;
            }
        }
        return student;
    }
}
