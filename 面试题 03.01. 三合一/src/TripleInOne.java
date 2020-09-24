class TripleInOne {

    private int[] stack;
    private int p1, p2, p3;
    private int stackSize;

    public TripleInOne(int stackSize) {
        this.stack = new int[stackSize * 3];
        this.stackSize = stackSize;
        this.p1 = 0;
        this.p2 = this.p1 + stackSize;
        this.p3 = this.p2 + stackSize;
    }

    public void push(int stackNum, int value) {
        int p = getStackNum(stackNum);
        if(p < (stackNum + 1) * stackSize){
            stack[p] = value;
            addPoint(stackNum);
        }
    }

    public int pop(int stackNum) {
        int p = getStackNum(stackNum);
        if(p > stackNum * stackSize){
            decPoint(stackNum);
            return stack[--p];
        }
        return -1;
    }

    public int peek(int stackNum) {
        int p = getStackNum(stackNum);
        if(p > stackNum * stackSize){
            return stack[--p];
        }
        return -1;
    }

    public boolean isEmpty(int stackNum) {
        return getStackNum(stackNum) == stackNum * stackSize;
    }

    private int getStackNum(int stackNum){
        return stackNum == 0 ? p1 : stackNum == 1 ? p2 : p3;
    }

    private void addPoint(int stackNum){
        if(stackNum == 0)
            p1 ++;
        else if(stackNum == 1)
            p2 ++;
        else
            p3 ++;
    }

    private void decPoint(int stackNum){
        if(stackNum == 0)
            p1 --;
        else if(stackNum == 1)
            p2 --;
        else
            p3 --;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
