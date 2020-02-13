package com.example.e_softwarica;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_softwarica.Createchannel.CreateChannel;
import com.example.e_softwarica.model.RegisterReceiveParams;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;

    private Button btnlogin,btnregister;
    EditText etusername,etpassword;
    private TextView txtlink;
    DbHelper dbHelper;
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;
    SQLiteDatabase mydatabase;
    List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initCreateAccountTextView();
        initViews();
        dbHelper = new DbHelper(this);
        //for notification
        notificationManagerCompat= NotificationManagerCompat.from(this);
        CreateChannel channel=new CreateChannel(this);
        channel.createChannel();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {

                    //Get values from EditText fields
                    String Email = etusername.getText().toString();
                    String Password = etpassword.getText().toString();

                    mydatabase = openOrCreateDatabase("test",MODE_PRIVATE,null);
                    //Authenticate user

                    Cursor resultSet = mydatabase.rawQuery("Select * from users",null);
                    if(resultSet.moveToFirst()){
                        do{
                            /*list.add(resultSet.getString(resultSet.getColumnIndex("id")));
                            list.add(resultSet.getString(resultSet.getColumnIndex("name")));
                            list.add(resultSet.getString(resultSet.getColumnIndex("email")));
                            list.add(resultSet.getString(resultSet.getColumnIndex("password")));*/
                            String email = resultSet.getString(2);
                            String password = resultSet.getString(3);
                            if(email.equalsIgnoreCase(Email) && password.equalsIgnoreCase(Password)){
                                Toast.makeText(getApplicationContext(),"Login successfully",Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                 startActivity(intent);
                                 finish();
                            } else{
                                Toast.makeText(getApplicationContext(),"Failed to log in , please try again",Toast.LENGTH_LONG).show();
                            }
                           // Toast.makeText(getApplicationContext(),email,Toast.LENGTH_SHORT).show();

                        } while (resultSet.moveToNext());
                    }

                    DisplayNotification();


                  //  RegisterReceiveParams currentUser = dbHelper.Authenticate(new RegisterReceiveParams(null, null, Email, Password));

                    //Check Authentication is successful or not
                   /* if (currentUser != null) {
                        Toast.makeText(getApplicationContext(),"Login successfully",Toast.LENGTH_LONG).show();

                        //User Logged in Successfully Launch You home screen activity
                       // Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                       // startActivity(intent);
                       // finish();
                    } else {

                        //User Logged in Failed
                        Toast.makeText(getApplicationContext(),"Failed to log in , please try again",Toast.LENGTH_LONG).show();
                       // Snackbar.make(buttonLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();

                    }*/
                   //Testing

                    Logins();
                }
            }
        });


    }

    private void Logins() {
        float first=Float.parseFloat(etusername.getText().toString());
        float second=Float.parseFloat(etpassword.getText().toString());
        testing arithmetic=new testing();
        String result=arithmetic.login("first", "second");

        Intent intent=new Intent(LoginActivity.this, Dashboard_fragment.class);
        intent.putExtra("result",result);
        startActivity(intent);
    }


    //testing

    private void DisplayNotification() {
        Notification notification= new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.notices)
                .setContentTitle("Welcome to softwarica")
                .setContentText("Login Successfully!!")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

        notificationManagerCompat.notify(1, notification);


    }

    private void initCreateAccountTextView() {
        txtlink =(TextView) findViewById(R.id.txtlink);
        txtlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    //this method is used to connect XML views to its Objects
    private void initViews() {
        etusername = (EditText) findViewById(R.id.input_email1);
        etpassword = (EditText) findViewById(R.id.input_password1);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        btnlogin =(Button) findViewById(R.id.btnlogin);

    }


    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String Email = etusername.getText().toString();
        String Password = etpassword.getText().toString();

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
