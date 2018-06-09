package bala.food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Sankar on 7/26/2017.
 */

public class dinners extends Activity {
    GridView gv;
    String name,rupee;
    Bundle b;
    int rup;
    ImageView logout;
    SessionManager sessionManager;
    dinnersAdapter adapter;
    String[] title = {"IDLI", "Masal Dhosa","Egg Dhosa","Semmiya","Poori", "Parota","Gravy","Noodles"};
    String[] rs={"rs=30","rs=40","rs=35","rs=25","rs=30","rs=40","rs=35","rs=45"};
    Integer image[] = {
            R.drawable.idilivadasambar,
            R.drawable.masala,
            R.drawable.eggdhosai,
            R.drawable.semmiya,
            R.drawable.poori,
            R.drawable.parata,
            R.drawable.gravy,
            R.drawable.noodles
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinner);
        int position = 0;
        sessionManager=new SessionManager(this);
        logout=(ImageView)findViewById(R.id.logout);
        //  view v=new view(this,image,item,rs);
        gv=(GridView) findViewById(R.id.gridview);
        dinnersAdapter adapter=new dinnersAdapter(this,title,rs,image);
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
                        name="Masala Dhosa";
                        rup= Integer.parseInt("40");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent mdhosa = new Intent(getApplicationContext(), itembuy.class);
                        mdhosa.putExtras(b);
                        startActivity(mdhosa);
                        break;
                    case 2:
                        name="Egg Dhosa";
                        rup=Integer.parseInt("35");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent eDhosa = new Intent(getApplicationContext(), itembuy.class);
                        eDhosa.putExtras(b);
                        startActivity(eDhosa);
                        break;
                    case 3:
                        name="Semmiya";
                        rup= Integer.parseInt("25");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent semmiya = new Intent(getApplicationContext(), itembuy.class);
                        semmiya.putExtras(b);
                        startActivity(semmiya);
                        break;
                    case 4:
                        name="Poori";
                        rup= Integer.parseInt("30");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent poori = new Intent(getApplicationContext(), itembuy.class);
                        poori.putExtras(b);
                        startActivity(poori);
                        break;
                    case 5:
                        name="Parota";
                        rup= Integer.parseInt("40");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent parota = new Intent(getApplicationContext(), itembuy.class);
                        parota.putExtras(b);
                        startActivity(parota);
                        break;
                    case 6:
                        name="Gravy";
                        rup= Integer.parseInt("35");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent gravy = new Intent(getApplicationContext(), itembuy.class);
                        gravy.putExtras(b);
                        startActivity(gravy);
                        break;
                    case 7:
                        name="Noodles";
                        rup= Integer.parseInt("45");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent noodles = new Intent(getApplicationContext(), itembuy.class);
                        noodles.putExtras(b);
                        startActivity(noodles);
                        break;
                }

            }
        });

    } }
