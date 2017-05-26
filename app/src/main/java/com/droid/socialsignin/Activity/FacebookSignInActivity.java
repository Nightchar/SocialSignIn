package com.droid.socialsignin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.droid.socialsignin.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by nikhil1804 on 23-05-2017.
 */

public class FacebookSignInActivity extends AppCompatActivity {

    CallbackManager callbackManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_facebook_signin);
        final TextView info = (TextView) findViewById(R.id.info);
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        if (loginButton != null) {

            loginButton.setReadPermissions("email");

            callbackManager = CallbackManager.Factory.create();
            // Callback registration
            LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    // App code
                    info.setText(
                            "User ID: "
                                    + loginResult.getAccessToken().getUserId()
                                    + "\n" +
                                    "Auth Token: "
                                    + loginResult.getAccessToken().getToken()
                                    + "\n" +
                                    "Applicatin Id Token: "
                                    + loginResult.getAccessToken().getApplicationId()
                    );

                }

                @Override
                public void onCancel() {
                    // App code
                    info.setText("Login attempt canceled.");
                }

                @Override
                public void onError(FacebookException exception) {
                    // App code
                    info.setText("Login attempt failed.");
                }
            });
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
