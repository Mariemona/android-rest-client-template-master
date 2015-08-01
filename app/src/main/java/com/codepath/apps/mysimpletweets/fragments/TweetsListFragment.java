package com.codepath.apps.mysimpletweets.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TweetsArrayAdapter;
import com.codepath.apps.mysimpletweets.models.Tweet;

import java.util.ArrayList;
import java.util.List;

public class TweetsListFragment extends Fragment{
    private ArrayList<Tweet> tweets;
    private TweetsArrayAdapter aTweets;
    private ListView lvTweets;


    // inflation logic
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
      View v = inflater.inflate(R.layout.fragment_tweets_list, parent, false);
        // Find the listview
        lvTweets = (ListView) v.findViewById(R.id.lvTweets);
        // Connect adapter to list view
        lvTweets.setAdapter(aTweets);
        return v;
    }

    // creation lifecycle event
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create the arraylist (data source)
        tweets = new ArrayList<>();
        // Construct the adapter from data source
        aTweets = new TweetsArrayAdapter(getActivity(), tweets);
    }
    public void addAll(List<Tweet> tweets){
     aTweets.addAll(tweets);
    }
}
