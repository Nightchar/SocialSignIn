package com.droid.socialsignin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.droid.socialsignin.R;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

/**
 * Created by nikhil1804 on 23-05-2017.
 */

public class TwitterSignInActivity extends AppCompatActivity {

    private TwitterLoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_twitter_signin);

        final TextView twitterInfo = (TextView) findViewById(R.id.twitter_info);
        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                TwitterSession twitterSession = result.data;
                twitterInfo.setText(
                        "Id : " + twitterSession.getId() + "\n\n"
                                + "User Id : " + twitterSession.getUserId() + "\n\n"
                                + "User Name : " + twitterSession.getUserName() + "\n\n"
                                + "AuthToken : " + twitterSession.getAuthToken().token + "\n\n"
                                + "AuthTokenSecret : " + twitterSession.getAuthToken().secret
                );

            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                twitterInfo.setText("Error - " + exception.getMessage());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}
