package com.droid.socialsignin.application;

import android.app.Application;
import android.util.Log;

import com.droid.socialsignin.R;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;

/**
 * Created by nikhil1804 on 25-05-2017.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig(getString(R.string.twitter_consumer_key),
                        getString(R.string.twitter_consumer_secret)))
                .debug(true)
                .build();
        Twitter.initialize(config);
    }
}
