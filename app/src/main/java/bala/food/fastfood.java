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

public class fastfood extends Activity {
    GridView gv;
    String name,rupee;
    Bundle b;
    int rup;
    ImageView logout;
    SessionManager sessionManager;
    FastfoodAdapter adapter;
    String[] title = {"Panni Poori", "Chilli Chicken", "Cauliflower Chilli", "Mushroom Chilli","Veg Noodles","Egg Noodles"};
    String[] rs={"rs=20","rs=45","rs=30","rs=45","rs=45","rs=55"};
    Integer image[] = new Integer[]{
            R.drawable.panipuri3,
            R.drawable.chilli,
            R.drawable.cauliflower,
            R.drawable.mushroom,
            R.drawable.noodles,
            R.drawable.eggnoodles
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fastfood);
        int position = 0;
        sessionManager=new SessionManager(this);
        logout=(ImageView)findViewById(R.id.logout);
        //  view v=new view(this,image,item,rs);
        gv=(GridView) findViewById(R.id.gridview);
        FastfoodAdapter adapter=new FastfoodAdapter(this,title,rs,image);
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
                        name="Panni Poori";
                        rup= Integer.parseInt("20");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent panni = new Intent(getApplicationContext(), itembuy.class);
                        panni.putExtras(b);
                        startActivity(panni);
                        break;
                    case 1:
                        name="Chilli Chicken";
                        rup= Integer.parseInt("45");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent cchiken = new Intent(getApplicationContext(), itembuy.class);
                        cchiken.putExtras(b);
                        startActivity(cchiken);
                        break;
                    case 2:
                        name="Cauliflower Chilli";
                        rup=Integer.parseInt("30");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent cflower = new Intent(getApplicationContext(), itembuy.class);
                        cflower.putExtras(b);
                        startActivity(cflower);
                        break;
                    case 3:
                        name="Mushroom Chilli";
                        rup= Integer.parseInt("45");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent mchilli = new Intent(getApplicationContext(), itembuy.class);
                        mchilli.putExtras(b);
                        startActivity(mchilli);
                        break;
                    case 4:
                        name="Veg Noodles";
                        rup= Integer.parseInt("45");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent vnoodles = new Intent(getApplicationContext(), itembuy.class);
                        vnoodles.putExtras(b);
                        startActivity(vnoodles);
                        break;
                    case 5:
                        name="Egg Noodles";
                        rup= Integer.parseInt("55");
                        b=new Bundle();
                        b.putString("namekey",name);
                        b.putInt("rskey",rup);
                        Intent enoodles = new Intent(getApplicationContext(), itembuy.class);
                        enoodles.putExtras(b);
                        startActivity(enoodles);
                        break;

                }

            }
        });

    }
}
