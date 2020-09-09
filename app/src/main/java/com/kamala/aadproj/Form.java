package com.kamala.aadproj;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.kamala.aadproj.constants.Constants;

import java.util.HashMap;
import java.util.Map;

public class Form extends AppCompatActivity implements View.OnClickListener {
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
    RequestQueue queue;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);
        mButton.setOnClickListener(this);

        queue = Volley.newRequestQueue(getApplicationContext());

    }

    @Override
    public void onClick(View view) {
        if(view==mButton){
            verifyPost();
        }


    }

    private void verifyPost() {
        if (mFName.getText().toString().trim().length() > 0 && mSName.getText().toString().trim().length() > 0&&mMail.getText().toString().trim().length()>0&&mLink.getText().toString().trim().length()>0)
        {
            postData(mFName.getText().toString().trim(), mSName.getText().toString().trim(),mMail.getText().toString().trim(),mLink.getText().toString().trim());
        } else {
            Snackbar.make(mButton, "Required Fields Missing", Snackbar.LENGTH_LONG).show();
        }
    }

    private void postData(String mail, String seName, String frName, String link) {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                Constants.FORM_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", "Response: " + response);
                        if (response.length() > 0) {
                            Snackbar.make( mButton,"Successfully Posted", Snackbar.LENGTH_LONG).show();
                            mFName.setText(null);
                            mSName.setText(null);
                            mMail.setText(null);
                            mLink.setText(null);
                        } else {
                            Snackbar.make(mButton, "Try Again", Snackbar.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
              //  progressDialog.dismiss();
                Snackbar.make(mButton, "Error while Posting Data", Snackbar.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                params.put(Constants.fName, frName);
                params.put(Constants.lName, seName);
                params.put(Constants.email, mail);
                params.put(Constants.linkPro, link);
                return params;
            }
    };
        request.setRetryPolicy(new DefaultRetryPolicy(
                50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }
    }
