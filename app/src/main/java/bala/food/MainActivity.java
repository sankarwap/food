package bala.food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public static final String EXTRA_ID="com.sankar.Design.ID";
    ImageView img;
    EditText phn,pass;
    Button sub;
    String phone2,pass2,storedpassword;
    LoginDataBaseAdapter LoginDataBaseAdapter;
    TextView signup;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView)findViewById(R.id.imageView);
        phn=(EditText)findViewById(R.id.editText1);
        pass=(EditText)findViewById(R.id.editText2);
        sub=(Button)findViewById(R.id.button1);
        signup=(TextView)findViewById(R.id.textView);
        img.setImageResource(R.drawable.user);
        sessionManager=new SessionManager(this);

        if(!sessionManager.getSessionStringValue("Login","phone").equals("0")){
            Intent i=new Intent(getApplicationContext(),itemlist.class);
            i.putExtra(EXTRA_ID,sessionManager.getSessionStringValue("Login","phone"));
            startActivity(i);
            finish();
        }



        LoginDataBaseAdapter =new LoginDataBaseAdapter(this);
        LoginDataBaseAdapter=LoginDataBaseAdapter.open();

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone2=phn.getText().toString();
                pass2=pass.getText().toString();
                storedpassword=LoginDataBaseAdapter.getSinlgeEntry(phone2);
                if (pass2.equals(storedpassword)){
                    sessionManager.storeSessionStringvalue("Login","phone",phone2);
                    Toast.makeText(getApplicationContext(),"signin success",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getApplicationContext(),itemlist.class);
                    i.putExtra(EXTRA_ID,phone2);
                    startActivity(i);
                    finish();
                }
                else {
                    phn.setError("number wrong");
                    pass.setError("password Wrong");
                    Toast.makeText(getApplicationContext(),"id or password error",Toast.LENGTH_SHORT).show();
                }
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),signup.class);
                startActivity(i);

            }
        });
    }
}
