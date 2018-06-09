package bala.food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by Sankar on 7/21/2017.
 */

public class itemlist extends Activity {
    ListView lv;
    String[] item={"BREAK FAST","LUNCH","FAST FOOD","DINNER"};
    Integer image[]={
            R.drawable.mrg,
            R.drawable.aft,
            R.drawable.panipuri3,
            R.drawable.nyt
    };
    ImageView logout;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        int position=0;
        view v=new view(this,image,item);
        lv=(ListView)findViewById(R.id.ListView);
        sessionManager=new SessionManager(this);
        logout=(ImageView)findViewById(R.id.logout);
        lv.setAdapter(v);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.callLogout();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String ss=(String)lv.getItemAtPosition(position);
               // Toast.makeText(getApplicationContext(),""+ss,Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        Intent newActivity = new Intent(getApplicationContext(), breakfastview.class);
                        startActivity(newActivity);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(getApplicationContext(), lunch.class);
                        startActivity(newActivity1);
                        break;
                    case 2:
                        Intent newActivity2 = new Intent(getApplicationContext(), fastfood.class);
                        startActivity(newActivity2);
                        break;
                    case 3:
                        Intent newActivity3=new Intent(getApplicationContext(),dinners.class);
                        startActivity(newActivity3);
                        break;
                }

            }
        });

    }
}
