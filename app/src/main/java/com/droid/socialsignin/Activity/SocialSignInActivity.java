package com.droid.socialsignin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.droid.socialsignin.R;

public class SocialSignInActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_sign_in);
        findViewById(R.id.btn_google_sign_in).setOnClickListener(this);
        findViewById(R.id.btn_facebook_sign_in).setOnClickListener(this);
        findViewById(R.id.btn_twitter_sign_in).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_google_sign_in:
                startActivity(new Intent(SocialSignInActivity.this, GoogleSignInActivity.class));
                break;
            case R.id.btn_facebook_sign_in:
                startActivity(new Intent(SocialSignInActivity.this, FacebookSignInActivity.class));
                break;
            case R.id.btn_twitter_sign_in:
                startActivity(new Intent(SocialSignInActivity.this, TwitterSignInActivity.class));
                break;
        }
    }
}
