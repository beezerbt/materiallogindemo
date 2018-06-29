package com.sourcey.materiallogindemo;

import android.app.ProgressDialog;
import android.arch.lifecycle.LiveData;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.sourcey.materiallogindemo.response.BitBucketGETReposResponse;

import java.io.UnsupportedEncodingException;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpStatus;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private BitBucketGETReposResponse bitBucketGETReposResponse = null;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        Log.i("setResult", "resultIncoming:["+result+"]");
        this.result = result;
    }

    private volatile String result;

    public int getCallStatusCode() {
        return callStatusCode;
    }

    public void setCallStatusCode(int callStatusCode) {
        this.callStatusCode = callStatusCode;
    }

    private volatile int callStatusCode;

    public LiveData<BitBucketGETReposResponse> getLiveData() {
        return liveData;
    }

    public void setLiveData(LiveData<BitBucketGETReposResponse> liveData) {
        this.liveData = liveData;
    }

    LiveData<BitBucketGETReposResponse> liveData = null;

    @BindView(R.id.input_login)
    EditText _loginId;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.btn_login)
    Button _loginButton;
    @BindView(R.id.link_signup)
    TextView _signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    public void login() {
        Log.d(TAG, "============================>>Login()");
        setBitBucketGETReposResponse(null);
        //To be able to call the web service
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();
        String password = _passwordText.getText().toString();
        String loginId = _loginId.getText().toString();
        Log.i("Login", ">>>>>>>>>loginId = " + loginId + ">>>>>>>>>password =" + password);
        // ====================== TODO: Implement your own authentication logic here.

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://shahrik:Blog7402__@api.bitbucket.org/2.0/repositories/shahrik", new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                Log.i("AsyncHttpClient", "called before request is started");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                Log.i("AsyncHttpClient", "called when response HTTP status is 200 OK");
                String decodedDataUsingUTF8=null;
                if(statusCode == HttpStatus.SC_OK) {
                    try {
                        decodedDataUsingUTF8 = new String(response, "UTF-8");
                        setResult(decodedDataUsingUTF8);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        Log.e("onSuccess", "decodedDataUsingUTF8 failure");
                    }
                }
                setCallStatusCode(statusCode);
                Log.i("onSuccess", "responseL["+decodedDataUsingUTF8+"]");

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                Log.i("AsyncHttpClient", "called when response HTTP status is \"4XX\" (eg. 401, 403, 404)");
            }

            @Override
            public void onRetry(int retryNo) {
                Log.i("AsyncHttpClient", "called when request is retried");
            }
        });

        /*JSONObject jsonParams = new JSONObject();
        StringEntity entity = null;
        try {
            jsonParams.put("username", "lace.sam@gmail.com");
            jsonParams.put("password", "8Sapphire7");
            jsonParams.put("keepMeLogged", true);
            jsonParams.put("segment", "residential");
            entity = new StringEntity(jsonParams.toString());
            Log.i("Login", "Entity Payload:["+entity.toString()+"]");
        } catch (JSONException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(null,"https://www.engie-electrabel.be/nl/iam/v3/api/public/login", entity, "application/json", new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                Log.i("AsyncHttpClient", "called before request is started");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                Log.i("AsyncHttpClient", "called when response HTTP status is 200 OK");
                String decodedDataUsingUTF8=null;
                if(statusCode == HttpStatus.SC_OK) {
                    try {
                        decodedDataUsingUTF8 = new String(response, "UTF-8");
                        setResult(decodedDataUsingUTF8);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        Log.e("onSuccess", "decodedDataUsingUTF8 failure");
                    }
                }
                setCallStatusCode(statusCode);
                Log.i("onSuccess", "responseL["+decodedDataUsingUTF8+"]");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                Log.i("AsyncHttpClient", "called when response HTTP status is \"4XX\" (eg. 401, 403, 404)");
            }

            @Override
            public void onRetry(int retryNo) {
                Log.i("AsyncHttpClient", "called when request is retried");
            }
        });*/

        // ====================== TODO: Implement your own authentication logic here.
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        if(getCallStatusCode() == HttpStatus.SC_OK) {
                            onLoginSuccess();
                        } else {
                            onLoginFailed();
                        }
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);

        Intent intent = new Intent(this, SuccessfulLoginActivity.class);
        intent.putExtra("LoginResult", getResult());
        startActivity(intent);

        /*

        String prettyJSONResult;
        _loginButton.setEnabled(true);
        if (getResult() != null) {
            prettyJSONResult = getResult();
            Log.i("Response", "----->>Did it have shuffler:[" + prettyJSONResult.contains("shuffler") + "]");
        } else {
            prettyJSONResult = "Null";
        }
        final Toast tag = Toast.makeText(this, "Login succeeded!!.[" + prettyJSONResult + "]", Toast.LENGTH_LONG);
        tag.show();
        new CountDownTimer(9000, 1000) {
            public void onTick(long millisUntilFinished) {
                tag.show();
            }

            public void onFinish() {
                tag.show();
            }
        }.start();*/
        //finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

/*
        String email = _emailText.getText().toString();
*/
        String loginId = _loginId.getText().toString();
        String password = _passwordText.getText().toString();

       /* if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }*/

        if (loginId.isEmpty()) {
            _loginId.setError("enter a LOGIN");
            valid = false;
        } else {
            _loginId.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    public BitBucketGETReposResponse getBitBucketGETReposResponse() {
        return bitBucketGETReposResponse;
    }

    public void setBitBucketGETReposResponse(BitBucketGETReposResponse bitBucketGETReposResponse) {
        this.bitBucketGETReposResponse = bitBucketGETReposResponse;
    }
}
