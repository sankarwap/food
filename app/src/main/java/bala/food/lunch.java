package bala.food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Sankar on 7/25/2017.
 */

public class lunch extends Activity {
    GridView gv;
    String name,rupee;
    Bundle b;
    ImageView logout;
    SessionManager sessionManager;
    int rup;
    LunchviewAdapter adapter;
    String[] title = {"Mutton Biriyani", "Chicken Biriyani", "Full Meals", "Mutton","Manchuri","Veg Biriyani"};
    String[] rs={"rs=150","rs=100","rs=100","rs=150","rs=80","rs=60"};
    Integer image[] = {
            R.drawable.mbiriyani,
            R.drawable.cbiriyani,
            R.drawable.meals,
            R.drawable.mutton,
            R.drawable.manchurian,
            R.drawable.vegbiriyani

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunch);
        int position = 0;
        sessionManager=new SessionManager(this);
        logout=(ImageView)findViewById(R.id.logout);
        //  view v=new view(this,image,item,rs);
        gv=(GridView) findViewById(R.id.gridview);
        LunchviewAdapter adapter=new LunchviewAdapter(this,title,rs,image);
        gv.setAdapter(adapter);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.callLogout();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

        // view v = new view(this, image, item);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String ss = (String) gv.getItemAtPosition(position);
                // Toast.makeText(getApplicationContext(),""+ss,Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        name="Mutton Biriyani";
                        rup= Integer.parseInt("150");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent mbri = new Intent(getApplicationContext(), itembuy.class);
                        mbri.putExtras(b);
                        startActivity(mbri);
                        break;
                    case 1:
                        name="Chicken Biriyani";
                        rup= Integer.parseInt("100");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent cbri = new Intent(getApplicationContext(), itembuy.class);
                        cbri.putExtras(b);
                        startActivity(cbri);
                        break;
                    case 2:
                        name="Full meals";
                        rup=Integer.parseInt("100");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent meals = new Intent(getApplicationContext(), itembuy.class);
                        meals.putExtras(b);
                        startActivity(meals);
                        break;
                    case 3:
                        name="Mutton";
                        rup= Integer.parseInt("150");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent mutton = new Intent(getApplicationContext(), itembuy.class);
                        mutton.putExtras(b);
                        startActivity(mutton);
                        break;
                    case 4:
                        name="Manchuri";
                        rup= Integer.parseInt("80");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent manchuri = new Intent(getApplicationContext(), itembuy.class);
                        manchuri.putExtras(b);
                        startActivity(manchuri);
                        break;
                    case 5:
                        name="Veg Biriyani";
                        rup= Integer.parseInt("25");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent vbri = new Intent(getApplicationContext(), itembuy.class);
                        vbri.putExtras(b);
                        startActivity(vbri);
                        break;
                }

            }
        });

    }
}
