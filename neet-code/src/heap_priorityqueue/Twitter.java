package heap_priorityqueue;

import util.CustomPair;

import java.util.*;

class Twitter {

    int counter;
    // count, tweetId
    Map<Integer, List<CustomPair<Integer, Integer>>> userIdToTweets;
    Map<Integer, Set<Integer>> userIdToFollowedUserMap;

    public Twitter() {
        counter = 0;
        userIdToTweets = new HashMap<>();
        userIdToFollowedUserMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userIdToTweets.computeIfAbsent(userId, key -> new ArrayList<>()).add(new CustomPair<>(counter++, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<CustomPair<Integer, Integer>> allTweets = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o2.getKey(), o1.getKey()));

        List<CustomPair<Integer, Integer>> userTweets = userIdToTweets.getOrDefault(userId, new ArrayList<>());
        allTweets.addAll(userTweets);
        Set<Integer> followee = userIdToFollowedUserMap.getOrDefault(userId, new HashSet<>());
        for (Integer followeeId : followee) {
            List<CustomPair<Integer, Integer>> followeeTweets = userIdToTweets.getOrDefault(followeeId, new ArrayList<>());
            allTweets.addAll(followeeTweets);
        }


        List<Integer> recentTweets = new ArrayList<>();
        int counter = 0;
        while (counter < 10 && !allTweets.isEmpty()) {
            CustomPair<Integer, Integer> tweet = allTweets.poll();
            recentTweets.add(tweet.getValue());
            counter++;
        }


        return recentTweets;
    }

    public void follow(int followerId, int followeeId) {
        userIdToFollowedUserMap.computeIfAbsent(followerId, key -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followeeIds = userIdToFollowedUserMap.get(followerId);
        followeeIds.remove(followeeId);
    }


    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
//        twitter.postTweet(1, 7);
//        twitter.postTweet(1, 8);
//        twitter.postTweet(1, 9);
//        twitter.postTweet(1, 10);
//        twitter.postTweet(1, 11);
//        twitter.postTweet(1, 12);
//        twitter.postTweet(1, 13);
//        twitter.postTweet(1, 14);
//        twitter.postTweet(1, 15);
//        twitter.postTweet(1, 16);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));

    }
}