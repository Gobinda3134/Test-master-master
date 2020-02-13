package com.example.e_softwarica;

import android.content.Intent;
import android.nfc.tech.NfcA;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.example.e_softwarica.model.RegisterReceiveParams;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    TextView link_login;
    Button btnregister;
    TextInputLayout textInputLayoutName;
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;
    List<RegisterReceiveParams> photo_list = new ArrayList<>();
    List<RegisterReceiveParams> userResultBeanList = new ArrayList<>();
    EditText name,email,password;
    DbHelper dbHelper;
    Editable strname,stremail,strpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DbHelper(this);
        initViews();
        initTextViewLogin();


        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    String Name = name.getText().toString();
                    String Email = email.getText().toString();
                    String Password = password.getText().toString();

                    //Check in the database is there any user associated with  this email
                    if (!dbHelper.isEmailExists(Email)) {

                        //Email does not exist now add new user to database
                        dbHelper.addUser(new RegisterReceiveParams(null, Name, Email, Password));
                        Toast.makeText(getApplicationContext(),"User Registered Successfully",Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        }, Snackbar.LENGTH_LONG);
                    }else {

                        //Email exists with email input provided so show error user already exist
                        Toast.makeText(getApplicationContext(),"User already exists with same email",Toast.LENGTH_LONG).show();
                       // Snackbar.make(btnregister, " ", Snackbar.LENGTH_LONG).show();
                    }


                }
            }
    });

    }

    private void initTextViewLogin() {
        link_login =(TextView) findViewById(R.id.link_login);
        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }

    private void initViews() {
        name = findViewById(R.id.input_name);
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutName = (TextInputLayout) findViewById(R.id.textInputLayoutName);

        btnregister = (Button) findViewById(R.id.btnregister);

    }

    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String UserName = name.getText().toString();
        String Email = email.getText().toString();
        String Password = password.getText().toString();

        //Handling validation for UserName field
        if (UserName.isEmpty()) {
            valid = false;
            textInputLayoutName.setError("Please enter valid username!");
        } else {
            if (UserName.length() > 5) {
                valid = true;
                textInputLayoutName.setError(null);
            } else {
                valid = false;
                textInputLayoutName.setError("Username is to short!");
            }
        }

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            textInputLayoutEmail.setError("Please enter valid email!");
        } else {
            valid = true;
            textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 5) {
                valid = true;
                textInputLayoutPassword.setError(null);
            } else {
                valid = false;
                textInputLayoutPassword.setError("Password is to short!");
            }
        }


        return valid;
    }

    }
