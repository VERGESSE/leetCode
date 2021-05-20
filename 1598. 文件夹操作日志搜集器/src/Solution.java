class Solution {
    public int minOperations(String[] logs) {

        Deep deep = new Deep();

        for(String log : logs){
            if("../".equals(log)){
                deep.dec();
            } else if(!"./".equals(log)){
                deep.add();
            }
        }

        return deep.deep();
    }

    static class Deep{
        private int deep = 0;

        void add(){
            deep++;
        }

        void dec(){
            if(deep > 0){
                deep--;
            }
        }

        int deep(){
            return deep;
        }
    }
}
