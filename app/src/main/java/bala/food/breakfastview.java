package bala.food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Sankar on 7/24/2017.
 */

public class breakfastview extends Activity  {
    GridView gv;
    ImageView logout;
    SessionManager sessionManager;
    String name,rupee;
    Bundle b;
    int rup;
    GridViewCustomAdapter adapter;
    String[] title = {"IDLI", "PONGAL","Poori", "DHOSAI", "Veg Biriyani","Uthappam","Uppuma","VADAI"};
    String[] rs={"rs=30","rs=30","rs=40","rs=20","rs=60","rs=25","rs=20","rs=10"};
    Integer image[] = {
            R.drawable.idli,
            R.drawable.pongal,
            R.drawable.poori,
            R.drawable.dhosai,
            R.drawable.vegbiriyani,
            R.drawable.appam,
            R.drawable.uppuma,
            R.drawable.vadai
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breakfast);
        sessionManager=new SessionManager(this);
        logout=(ImageView)findViewById(R.id.logout);
        int position = 0;
      //  view v=new view(this,image,item,rs);
        gv=(GridView) findViewById(R.id.gridview);
        GridViewCustomAdapter adapter=new GridViewCustomAdapter(this,title,rs,image);
        gv.setAdapter(adapter);

        // view v = new view(this, image, item);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.callLogout();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String ss = (String) gv.getItemAtPosition(position);
                // Toast.makeText(getApplicationContext(),""+ss,Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        name="Idli";
                       rup= Integer.parseInt("30");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent idli = new Intent(getApplicationContext(), itembuy.class);
                        idli.putExtras(b);
                        startActivity(idli);
                        break;
                    case 1:
                        name="Ponal";
                        rup= Integer.parseInt("30");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent pongal = new Intent(getApplicationContext(), itembuy.class);
                        pongal.putExtras(b);
                        startActivity(pongal);
                        break;
                    case 2:
                        name="Poori";
                        rup=Integer.parseInt("40");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent poori = new Intent(getApplicationContext(), itembuy.class);
                        poori.putExtras(b);
                        startActivity(poori);
                        break;
                    case 3:
                        name="Dhosai";
                        rup= Integer.parseInt("20");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent dhosai = new Intent(getApplicationContext(), itembuy.class);
                        dhosai.putExtras(b);
                        startActivity(dhosai);
                        break;
                    case 4:
                        name="vegbiri";
                        rup= Integer.parseInt("60");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent vegbiri = new Intent(getApplicationContext(), itembuy.class);
                        vegbiri.putExtras(b);
                        startActivity(vegbiri);
                        break;
                    case 5:
                        name="uthappam";
                        rup= Integer.parseInt("25");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent uthapam = new Intent(getApplicationContext(), itembuy.class);
                        uthapam.putExtras(b);
                        startActivity(uthapam);
                        break;
                    case 6:
                        name="uppuma";
                        rup= Integer.parseInt("20");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent uppuma = new Intent(getApplicationContext(), itembuy.class);
                        uppuma.putExtras(b);
                        startActivity(uppuma);
                        break;
                    case 7:
                        name="Vadai";
                        rup= Integer.parseInt("10");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent vadai = new Intent(getApplicationContext(), itembuy.class);
                        vadai.putExtras(b);
                        startActivity(vadai);
                        break;

                }

            }
        });

    }

}