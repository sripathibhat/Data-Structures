class Twitter {

    Map<Integer, List<Tweet>> tweets;
    Map<Integer, Set<Integer>> followees;
    int time;
    
    /** Initialize your data structure here. */

    // 2 maps - Map<UserId, List of tweets done by userId>
    // Map<UserId, Set of users whom this userId is following>
    // Newsfeed generation is at runtime, get all tweets done by the user and tweets of his followees, put them to a minHeap of size K (10) sorted by tweet time
    // when size > k, remove a tweet which will always remove the least recently posted tweet
    public Twitter() {
        tweets = new HashMap<>();
        followees = new HashMap<>();
        time = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(time++, tweetId);
        if(!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(tweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> topTweets = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        if(tweets.containsKey(userId)) {
            for(Tweet tweet: tweets.get(userId)) {
                pq.add(tweet);
                if(pq.size() > 10) {
                    pq.poll();
                }
            }
        }
        
        if(followees.containsKey(userId)) {
            for(Integer followee: followees.get(userId)) {
                if(tweets.containsKey(followee)) {
                    for(Tweet tweet: tweets.get(followee)) {
                        pq.add(tweet);
                        if(pq.size() > 10) {
                            pq.poll();
                        }
                    }
                }
            }
        }
        while(pq.size() > 0) {
            topTweets.add(pq.poll().id);
        }
        Collections.reverse(topTweets);
        return topTweets;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followees.containsKey(followerId)) {
            followees.put(followerId, new HashSet<>());
        }
        followees.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followees.containsKey(followerId)) {
            followees.get(followerId).remove(followeeId);
        }
    }
    
    class Tweet {
        int time;
        int id;
        
        Tweet(int time, int id) {
            this.time = time;
            this.id = id;
        }
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