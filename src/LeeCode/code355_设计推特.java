package LeeCode;

import java.util.*;

public class code355_设计推特 {
    public static void main(String[] args) {
        //设计一个简化版的推特(Twitter)，
        //   可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近 10 条推文。
        //
        //实现 Twitter 类：
        //
        //Twitter() 初始化简易版推特对象
        //postTweet(int userId, int tweetId):       根据给定的 tweetId 和 userId 创建一条新推文。每次调用此函数都会使用一个不同的 tweetId 。
        //getNewsFeed(int userId):                  检索当前用户新闻推送中最近  10 条推文的 ID 。新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。
        //follow(int followerId, int followeeId):   ID 为 followerId 的用户开始关注 ID 为 followeeId 的用户。
        //unfollow(int followerId, int followeeId): ID 为 followerId 的用户不再关注 ID 为 followeeId 的用户。
        Twitter twitter=new Twitter();
        twitter.postTweet(1,5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1,2);
        twitter.postTweet(2,6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1,2);
        System.out.println(twitter.getNewsFeed(1));
    }
    //这个题目有点折磨的,有种强迫症的想要去建立用户,推文类
    //不过又不是做系统,做个题目嘛,没必要
    private static class Twitter {
        List<Integer> all_tweets;//所有推文,用索引记录时间
        Map<Integer,List<Integer>> tweets;//用户对应推文
        Map<Integer,Set<Integer>> follows;//用户对应关注

        public Twitter() {
            all_tweets=new ArrayList<>();
            tweets=new HashMap<>();
            follows=new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            all_tweets.add(tweetId);//维护所有推文
            //维护用户推文关系
            if (tweets.containsKey(userId)){
                tweets.get(userId).add(tweetId);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(tweetId);
                tweets.put(userId,list);
            }
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> feed=new ArrayList<>(10);//结果集
            int num=10;
            Set<Integer> follow=new HashSet<>();//该用户关注的用户
            if (follows.containsKey(userId)) follow=follows.get(userId);
            follow.add(userId);//关注自己
            Set<Integer> tweet=new HashSet<>();//获取所有关注用户的推文
            for (Integer followId : follow) {
                if (tweets.containsKey(followId)){
                    tweet.addAll(tweets.get(followId));
                }
            }
            //倒序遍历所有推文,满足时间要求和数量要求
            for (int i = all_tweets.size()-1; i>=0&&num>0; i--) {
                if (tweet.contains(all_tweets.get(i))){//如果是关注用户的推文才feed
                    feed.add(all_tweets.get(i));
                    num--;
                }
            }
            return feed;
        }

        public void follow(int followerId, int followeeId) {
            //维护用户关注关系
            if (follows.containsKey(followerId)){
                follows.get(followerId).add(followeeId);
            }else {
                Set<Integer> set=new HashSet<>();
                set.add(followeeId);
                follows.put(followerId,set);
            }
        }

        public void unfollow(int followerId, int followeeId) {
            //删除用户关注关系
            if (!follows.containsKey(followerId)) return;
            Set<Integer> set = follows.get(followerId);
            set.remove(followeeId);
        }
    }
}
