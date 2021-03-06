import java.util.*;

class Node{
    int x;
    int y;
    public Node(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S==T)return 0;
        int m=routes.length;
        List<List<Integer>> arr=new ArrayList<>();
        for(int i=0;i<m;i++){
            Arrays.sort(routes[i]);
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<m-1;i++){
            for(int j=i+1;j<m;j++){
                if(find(routes[i],routes[j])){
                    arr.get(i).add(j);//i号车与直接能到的车j放在一起,间接能到的不能放
                    arr.get(j).add(i);
                }
            }
        }
        Set<Integer> seen=new HashSet<>();
        Set<Integer> target=new HashSet<>();
        Queue<Node> queue=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            if(Arrays.binarySearch(routes[i],S)>=0){
                seen.add(i);//存放始发站
                queue.offer(new Node(i,0));//存放第几辆车和转车次数
            }
            if(Arrays.binarySearch(routes[i],T)>=0){
                target.add(i);//存放终点站
            }
        }
        while(!queue.isEmpty()){
            Node info=queue.poll();
            int cur=info.x,depth=info.y;//x为第几辆车,y是转车的次数
            if(target.contains(cur))return depth+1;
            for(Integer nei:arr.get(cur)){//arr.get(cur)中存放的是与第cur辆车互通的车
                if(!seen.contains(nei)){//cur已经放过了(即该车不会经过到终点站),所以不能再放
                    seen.add(nei);
                    queue.offer(new Node(nei,depth+1));/*先遍历的是从始发站出发直达终点站的车,没有找到会继续遍历始发站出发直接能到达的车,如[1,2][2,3][3,4],给定S=1,T=4,先遍历[1,2],没找到就要遍历1可直接
到达的车,因为1能到2,2能到3,所以[1,2]该车可直接到达[2,3]该车,往下遍历即可;*/
                }
            }
        }
        return -1;
    }

    public boolean find(int[] a,int[] b){
        int i=0,j=0;
        while(i<a.length&&j<b.length){
            if(a[i]==b[j]){
                return true;
            }else if(a[i]<b[j]){
                i++;
            }else{
                j++;
            }
        }
        return false;
    }
}
