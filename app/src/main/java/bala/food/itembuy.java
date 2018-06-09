package bala.food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sankar on 7/27/2017.
 */

public class itembuy extends Activity {
    //NumberPicker item;
    EditText name,num,add;
    TextView rupees,itemname,qunty;
    Button order;
    String names,phones,addresss;
    int value,rs1,rs,val;
     Spinner spn;
     String quantitys="1";
    String[] quantity={"1","2","3","4","5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itembuy);
      // item=(NumberPicker) findViewById(R.id.numberPicker3);
        spn=(Spinner)findViewById(R.id.spinner);
        name=(EditText)findViewById(R.id.name);
        num=(EditText)findViewById(R.id.phone);
        add=(EditText)findViewById(R.id.address);
        itemname=(TextView)findViewById(R.id.iname);
        rupees=(TextView)findViewById(R.id.rupees);
        qunty=(TextView)findViewById(R.id.qunty);
        order=(Button) findViewById(R.id.orderbtn);

        Intent i=getIntent();
        Bundle b=i.getExtras();
        final String iname=b.getString("namekey");
        final int rupee=b.getInt("rskey");


        //rupees set
        //final Integer fprice=value*rupee;
        //String rs=fprice.toString();
        // rupees.setText(rs);

        itemname.setText(iname);

        //item.setMinValue(1);
        //item.setMaxValue(10);
        //item.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
        //    @Override
          //  public void onValueChange(NumberPicker numberPicker, int i, int i1) {

    //         rs1=(i1*rupee);
  //              rupees.setText(""+rs1);
//            }
        //});

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,quantity);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);

spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        spn.setSelection(position);
        String selstate=(String)spn.getSelectedItem();
        val=Integer.parseInt(selstate);
        qunty.setText(""+val);
        rs=(val*rupee);
        rupees.setText(""+rs);
        quantitys=selstate;

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                names = name.getText().toString();
                phones = num.getText().toString();
                addresss = add.getText().toString();

                 if(names.equals("")){
                     name.setError("Enter Name");
                 }
                 else if(phones.equals("")){
                     num.setError("Enter Number");
                 }
                 else if(addresss.equals("")){
                     add.setError("Enter Address");
                 }
                 else if(names.equals("")||phones.equals("")){
                     name.setError("Enter Name");
                     num.setError("Enter Number");
                 }
                 else if(phones.equals("")||addresss.equals("")){
                     num.setError("Enter Number");
                     add.setError("Enter Address");
                 }
                 else if (addresss.equals("")||names.equals("")){
                     add.setError("Enter Address");
                     name.setError("Enter Name");
                 }
                 else if(names.equals("")||phones.equals("")||addresss.equals("")){
                     name.setError("Enter Name");
                     num.setError("Enter Number");
                     add.setError("Enter Address");
                 }
                 else {
                     SmsManager smsManager = SmsManager.getDefault();
                     smsManager.sendTextMessage(phones, null, "your food deliverd in 30mins" + "\n" + "Food Item:" + iname + "\n" + "food rupees:" + rs, null, null);
                     // smsManager.sendTextMessage("+919585251621", null, "your food deliverd in 30mins" + itemname +value +addresss +phones +names, null, null);


                     Toast.makeText(getApplicationContext(), "your order confirmed", Toast.LENGTH_SHORT).show();
                     Bundle  b=new Bundle();
                     b.putString("namekey",iname);
                     b.putInt("rskey",rs);
                     b.putString("quatitykey",quantitys);
                     b.putString("phonekey",phones);
                     b.putString("addkey",addresss);
                     Intent i = new Intent(getApplicationContext(), orderconform.class);
                     i.putExtras(b);
                     startActivity(i);
                 }
            }
        });
}
}
