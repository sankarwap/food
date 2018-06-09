package bala.food;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sankar on 7/21/2017.
 */

public class signup extends Activity {
    Context context=this;
    ImageView img;
    LoginDataBaseAdapter LoginDataBaseAdapter;
    EditText name,phone,pass;
    Button reg;
    TextView login;
    String names,phones,passs,otpNumber;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        name=(EditText)findViewById(R.id.editText1);
        phone=(EditText)findViewById(R.id.editText2);
        pass=(EditText)findViewById(R.id.editText3);
        reg=(Button)findViewById(R.id.button1);
        login=(TextView)findViewById(R.id.textView);
        img=(ImageView)findViewById(R.id.imageView);
        img.setImageResource(R.drawable.user);
        sessionManager=new SessionManager(this);


        OTP a=new OTP();
        otpNumber=a.GenerateRandomNumber(6);
//        Toast.makeText(context, otpNumber, Toast.LENGTH_SHORT).show();

        LoginDataBaseAdapter=new LoginDataBaseAdapter(this);
        LoginDataBaseAdapter= LoginDataBaseAdapter.open();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              names=name.getText().toString();
                phones=phone.getText().toString();
                passs=pass.getText().toString();

                    Bundle b=new Bundle();
                    b.putString("otpkey",otpNumber);

                    try {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phones, null, otpNumber, null, null);


                        LayoutInflater li=LayoutInflater.from(context);
                        View promptsView=li.inflate(R.layout.alert,null);
                        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(context);
                        alertDialogBuilder.setView(promptsView);
                        final EditText userInput=(EditText)promptsView.findViewById(R.id.editTextDialogUserInput);
                        LoginDataBaseAdapter.insertEntry(names, phones, passs);
                        Toast.makeText(getApplicationContext(),"Register Success",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getBaseContext(),MainActivity.class);
                        startActivity(intent);


                        alertDialogBuilder.setCancelable(false).setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String otps=userInput.getText().toString();

                                if (names.equals("") || phone.equals("") || pass.equals("")) {
                                    Toast.makeText(getApplicationContext(), "Field all", Toast.LENGTH_LONG).show();
                                }

                               else if (!otpNumber.equals(otps)){

                                    //Toast.makeText(getApplicationContext(),"Enter correct Otp",Toast.LENGTH_SHORT).show();
                                    userInput.setError("enter correct otp");

                                }

                                else {
                                    sessionManager.storeSessionStringvalue("Login","phone",phones);
                                    LoginDataBaseAdapter.insertEntry(names, phones, passs);
                                    Toast.makeText(getApplicationContext(),"Register Success",Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getBaseContext(),MainActivity.class);
                                    startActivity(intent);
                                    finish();

                                }
                            }
                         });

                            AlertDialog alertDialog=alertDialogBuilder.create();
                              alertDialog.show();
                          }

                    catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "otp not sent", Toast.LENGTH_SHORT).show();
                       // Intent i=new Intent(getApplicationContext(),alert.class);
                        //startActivity(i);
                        //e.printStackTrace();
                    }

                }

        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        LoginDataBaseAdapter.close();
    }
}
