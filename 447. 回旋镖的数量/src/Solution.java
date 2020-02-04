import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {

        int ret = 0;

        Map<Integer,Integer> record = new HashMap<>();
        for (int i = 0; i < points.length; i++){

            for(int j = 0; j < points.length; j++){
                if(i != j){
                    Integer distance = dis(points[i], points[j]);
                    if(!record.containsKey(distance))
                        record.put(distance,1);
                    else {
                        Integer count = record.get(distance);
                        record.put(distance,count + 1);
                        ret += 2 * count;
                    }
                }
            }
            record.clear();
        }

        return ret;
    }

    private Integer dis(int[] p1,int[] p2){

        return (p1[1] - p2[1]) * (p1[1] - p2[1]) +
                (p1[0] - p2[0]) * (p1[0] - p2[0]);
    }
}