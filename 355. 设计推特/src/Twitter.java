import java.util.*;

class Twitter {

    Map<Integer,HashSet<Integer>> follows = new HashMap<>();
    LinkedList<Node> newsTweet = new LinkedList<>();

    /** Initialize your data structure here. */
    public Twitter() {}

    private class Node{
        int userId;
        int tweetId;

        Node(int userId, int tweetId){
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        newsTweet.addFirst(new Node(userId,tweetId));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> list = follows.getOrDefault(userId,new HashSet<>());
        list.add(userId);
        List<Integer> res = new ArrayList<>();
        for (Node node : newsTweet) {
            if (res.size() >=10 ) break;
            if (list.contains(node.userId))
                res.add(node.tweetId);
        }
        list.remove(userId);
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> follow = follows.getOrDefault(followerId, new HashSet<>());
        follow.add(followeeId);
        follows.put(followerId,follow);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> follow = follows.get(followerId);
        if (follow == null || follow.isEmpty()) return;
        follow.remove(followeeId);
        //System.out.println(followerId+" "+followeeId+follow);
        follows.put(followerId,follow);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

/*
class Twitter {
    class Tweet{
        int id;
        int time=0;
        Tweet next;
        public Tweet(int id, int time){
            this.id=id;
            this.time=time;
            next=null;
        }
    }

    HashMap<Integer, Tweet> map;
    HashMap<Integer, HashSet<Integer>> followees;
    int timeStamp;
    public Twitter() {
        map=new HashMap<Integer, Tweet>();
        followees=new HashMap<Integer, HashSet<Integer>>();
        timeStamp=0;
    }

    public void postTweet(int userId, int tweetId) {
        Tweet temp=new Tweet(tweetId, timeStamp++);
        Tweet head=map.get(userId);
        temp.next=head;
        head=temp;
        map.put(userId, head);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<Integer>();
        List<Tweet> tweets=new ArrayList<Tweet>();
        if(map.containsKey(userId)) tweets.add(map.get(userId));
        HashSet<Integer> followeeIds=followees.get(userId);
        if(followeeIds!=null){
            for(Integer followeeId: followeeIds){
                if(map.containsKey(followeeId))
                    tweets.add(map.get(followeeId));
            }
        }
        for(int i=0; i<10; i++){
            int max_index=-1;
            int max=Integer.MIN_VALUE;
            for(int j=0; j<tweets.size(); j++){
                Tweet temp=tweets.get(j);
                if(temp==null) continue;
                if(temp.time>max){
                    max=temp.time;
                    max_index=j;
                }
            }
            if(max_index>=0){
                res.add(tweets.get(max_index).id);
                tweets.set(max_index, tweets.get(max_index).next);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        HashSet<Integer> followeeIds=followees.get(followerId);
        if(followeeIds==null){
            followeeIds=new HashSet<Integer>();
            followees.put(followerId, followeeIds);
        }
        followeeIds.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followeeIds=followees.get(followerId);
        if(followeeIds==null) return;
        followeeIds.remove(followeeId);
    }
}
*/