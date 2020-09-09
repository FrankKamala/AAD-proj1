package com.kamala.aadproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }
}