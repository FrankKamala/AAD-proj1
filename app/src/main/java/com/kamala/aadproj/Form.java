package com.kamala.aadproj;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Form extends AppCompatActivity {
    @BindView(R.id.secondName)
    EditText mSName;
    @BindView(R.id.firstName)
    EditText mFName;
    @BindView(R.id.subEmail)
    EditText mMail;
    @BindView(R.id.subLink)
    EditText mLink;
    @BindView(R.id.subButton)
    Button mButton;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);
    }
}