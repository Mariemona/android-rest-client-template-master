package com.codepath.apps.mysimpletweets.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Monaika on 7/24/2015.
 */
public class Tweet {
    // list out the attributes
    private String body;
    private long uid; // unique id for the tweet
    private User user; // store embedded user object
    private String createdAt;

    public String getBody() {
        return body;
    }

    public long getUid() {
        return uid;
    }

    public User getUser() {
        return user;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    // Deserialize the  and build Tweet object
    // Tweet.fromJSON("{ ...}") => <Tweet>
    public static Tweet fromJSON(JSONObject jsonobject) {
        Tweet tweet = new Tweet();
        // Extract the values from the json, store them
        try {
            tweet.body = jsonobject.getString("text");
            tweet.uid = jsonobject.getLong("id");
            tweet.createdAt = jsonobject.getString("created_at");
            tweet.user = User.fromJSON(jsonobject.getJSONObject("user"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Return the tweet object
        return tweet;
    }
    public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray){
        ArrayList<Tweet> tweets = new ArrayList<>();
        // Iterate the json array and create tweets
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject tweetJson = jsonArray.getJSONObject(i);
                    Tweet tweet = Tweet.fromJSON(tweetJson);
                    if (tweet!= null) {
                        tweets.add(tweet);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    continue;
                }
            }
            //Return the finished list
            return  tweets;
        }


}

