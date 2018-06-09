package bala.food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

/**
 * Created by Sankar on 8/1/2017.
 */

public class orderconform extends Activity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderconform);
        btn=(Button)findViewById(R.id.button);

        Intent i=getIntent();
        Bundle b=i.getExtras();
        String iname=b.getString("namekey");
        int rupee=b.getInt("rskey");
        String quantity=b.getString("quatitykey");
        String cusnum=b.getString("phonekey");
        String address=b.getString("addkey");

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+919585251621", null, "New order" + "\n" + "Food Name:" + iname + "\n" + "food rupees:" +rupee + "\n" + "Quantity:" +quantity +"\n"+"Customer Number"+cusnum +"\n"+"Customer Address"+address, null, null);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),itemlist.class);
                startActivity(i);
            }
        });
    }
}
