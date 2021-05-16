class Solution {
    public int[] findClosedNumbers(int num) {
        int [] re={-1,-1};
        int flag1=0;
        int flag2=0;
        int temp=num;
        int cur;
        for(int i=0;i<31&&(flag1<2 || flag2<2);i++){
            cur=temp&1;
            temp=temp>>1;
            if(flag1==0&&cur==0){
                flag1=1;
            }else if(flag1==1 && cur==1){
                flag1=2;
                re[1]=(int)(num-Math.pow(2,i)+Math.pow(2,i-1));
                int temp1=re[1]&(((int)Math.pow(2,i-1))-1);
                re[1]=re[1]>>(i-1);
                for(int j=0;j<i-1;j++){
                    re[1]=((re[1]<<1)|(temp1&1));
                    temp1=temp1>>1;
                }
            }
            if(flag2==0&&cur==1){
                flag2=1;
            }else if(flag2==1 && cur==0){
                flag2=2;
                re[0]=(int)(num-Math.pow(2,i-1)+Math.pow(2,i));
                int temp1=re[0]&(((int)Math.pow(2,i-1))-1);
                re[0]=re[0]>>(i-1);
                for(int j=0;j<i-1;j++){
                    re[0]=((re[0]<<1)|(temp1&1));
                    temp1=temp1>>1;
                }
            }
        }
        return re;
    }
}
