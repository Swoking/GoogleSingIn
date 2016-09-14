package app.swoking.fr.googlesingin.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import app.swoking.fr.googlesingin.Utils.App;
import app.swoking.fr.googlesingin.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button   buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup;

    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if(App.isLoged()){
            // profile activity
        }

        buttonSignIn    = (Button)   findViewById(R.id.buttonSignin);
        editTextEmail     = (EditText) findViewById(R.id.editeTextEmail);
        editTextPassword  = (EditText) findViewById(R.id.editeTextPassword);
        textViewSignup    = (TextView) findViewById(R.id.textViewSingup);

        progressDialog = new ProgressDialog(this);

        buttonSignIn.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
    }

    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            //stopping the function
            return;
        }

        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            //stopping the function
            return;
        }
        //if validation are OK

        //we will first show a progressbar
        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            //start the profile activity
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view == buttonSignIn) {
            userLogin();
        }
        if(view == textViewSignup) {
            finish();
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }
}
