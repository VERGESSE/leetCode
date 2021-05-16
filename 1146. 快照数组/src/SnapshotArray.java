import java.util.*;

class SnapshotArray {

    private List<SnapInt>[] snapshotArray;
    private HashSet<Integer> snapCheck;
    private int snap = 0;

    public SnapshotArray(int length) {
        snapshotArray = new List[length];
        snapCheck = new HashSet<>();
        for(int i = 0; i < length; i++){
            snapshotArray[i] = new ArrayList<>();
            snapshotArray[i].add(new SnapInt(snap, 0));
        }
    }

    public void set(int index, int val) {
        List<SnapInt> cur = snapshotArray[index];
        if(!snapCheck.contains(index)){
            cur.add(new SnapInt(snap, val));
            snapCheck.add(index);
        } else {
            cur.get(cur.size() - 1).num = val;
        }
    }

    public int snap() {
        snapCheck.clear();
        return snap++;
    }

    public int get(int index, int snap_id) {
        List<SnapInt> cur = snapshotArray[index];
        int maxSnap = cur.get(cur.size() - 1).snap;
        int end = cur.size() - 1;
        if(maxSnap != snap && maxSnap <= snap_id){
            return cur.get(cur.size() - 1).num;
        }
        if(maxSnap == snap){
            end --;
        }
        return get(cur, snap_id, 0, end);
    }

    private int get(List<SnapInt> list, int snap_id, int start, int end){
        int mid = start + (end - start) / 2;
        int maxSnap = list.get(end).snap;

        if(maxSnap <= snap_id){
            return list.get(end).num;
        }
        if(start + 1 >= end || list.get(mid).snap == snap_id){
            return list.get(mid).num;
        } else if(list.get(mid).snap > snap_id){
            return get(list, snap_id, start, mid);
        } else {
            return get(list, snap_id, mid, end);
        }
    }

    static class SnapInt{
        int snap;
        int num;
        SnapInt(int snap, int num){
            this.snap = snap;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(1, 3);
        snapshotArray.set(1, 8);
        snapshotArray.snap();
        snapshotArray.get(1, 0);
        snapshotArray.set(2, 5);
        snapshotArray.get(2, 0);
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.set(0, 6);
        snapshotArray.get(0, 12);
        snapshotArray.get(0, 1);
        snapshotArray.snap();
        snapshotArray.set(2, 18);
        snapshotArray.set(2, 20);
        snapshotArray.set(0, 1);
        snapshotArray.get(2, 1);
        snapshotArray.snap();
        System.out.println(snapshotArray.get(2, 2));
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */

/* 35ms
class SnapshotArray {

    // Copy on write
    //private int[] base;
    private List<Map<Integer, Integer>> snapshots;

    public SnapshotArray(int length) {
        snapshots = new ArrayList<>();
        snapshots.add(new HashMap<>());
    }

    public void set(int index, int val) {
        Map<Integer, Integer> snapshot = snapshots.get(snapshots.size() - 1);
        snapshot.put(index, val);
    }

    public int snap() {
        snapshots.add(new HashMap<>());
        return snapshots.size() - 2;
    }

    public int get(int index, int snap_id) {
        for (int i = snap_id; i >= 0; --i) {
            if (snapshots.get(i).containsKey(index)) {
                return snapshots.get(i).get(index);
            }
        }
        return 0;
    }
}
 */
