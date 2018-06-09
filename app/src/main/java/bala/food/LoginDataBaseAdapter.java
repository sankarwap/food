package bala.food;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

import static android.R.attr.password;

public class LoginDataBaseAdapter 
{
		static final String DATABASE_NAME = "login.db";
		static final int DATABASE_VERSION = 1;
		public static final int NAME_COLUMN = 1;
		//public static final int ID_COLUMN = 1;
		public static final int MOBILE_COLUMN = 1;
		//public static final int DEPARTMENT_COLUMN = 1;
		public static final int PASSWORD_COLUMN = 1;
		//public static final int YEAR_COLUMN = 1;
		// TODO: Create public field for each column in your table.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    , 
		// SQL Statement to create a new database.
		static final String DATABASE_CREATE = "create table "+"LOGIN"+
		                             "( " +"ID"+" integer primary key autoincrement,"+ "S_NAME  text, S_MOBILE text,S_PASSWORD text); ";
		// Variable to hold the database instance
		public SQLiteDatabase db;
		// Context of the application using the database.
		private final Context context;
		// Database open/upgrade helper
		private DataBaseHelper dbHelper;
		public  LoginDataBaseAdapter(Context _context)
		{
			context = _context;
			dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		public  LoginDataBaseAdapter open() throws SQLException
		{
			db = dbHelper.getWritableDatabase();
			return this;
		}
		public void close() 
		{
			db.close();
		}

		public SQLiteDatabase getDatabaseInstance()
		{
			return db;
		}

		//public void insertEntry(String name, String phone, String pass)
		//{
	      // ContentValues newValues = new ContentValues();
			// Assign values for each row.
			//newValues.put("S_NAME", name);
			//newValues.put("S_ID",id);
			//newValues.put("S_MOBILE",phone );
			//newValues.put("S_DEPT", dept);
			//newValues.put("S_YEAR",year);
			//newValues.put("S_PASSWORD", pass);
			
			
			// Insert the row into your table
			//db.insert("LOGIN", null, newValues);
			///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
		//}
		public int deleteEntry(String mobile)
		{
			//String id=String.valueOf(ID);
		    String where="S_NAME=?";
		    int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{mobile}) ;
	       // Toast.makeText(context, "Number for Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
	        return numberOFEntriesDeleted;
		}	
		public String getSinlgeEntry(String mobile)
		{
			Cursor cursor=db.query("LOGIN", null, " S_MOBILE=?", new String[]{mobile}, null, null, null);
	        if(cursor.getCount()<1) // UserName Not Exist
	        {
	        	cursor.close();
	        	return "NOT EXIST";
	        }
		    cursor.moveToFirst();
			String password= cursor.getString(cursor.getColumnIndex("S_PASSWORD"));
			
			cursor.close();
			return password;				
		}
		
		public String getSingleEntry1(String mobile){
			Cursor cursor=db.query("LOGIN", null, " S_MOBILE=?", new String[]{mobile}, null, null, null);
			cursor.moveToFirst();
			String name=cursor.getString(cursor.getColumnIndex("S_NAME"));
			cursor.close();
			return name;
		}
		
		//public String getSingleEntry2(String id){
		//	Cursor c=db.query("LOGIN", null, " S_ID=?", new String[]{id}, null, null, null);
		//	c.moveToFirst();
		//	String mobile=c.getString(c.getColumnIndex("S_MOBILE"));
		//	c.close();
		//	return mobile;
		//}
		//public String getSingleEntry3(String id){
		//	Cursor c=db.query("LOGIN", null, " S_ID=?", new String[]{id}, null, null, null);
		//	c.moveToFirst();
		//	String dept=c.getString(c.getColumnIndex("S_DEPT"));
		//	c.close();
		//	return dept;
		//}
		//public String getSingleEntry4(String id){
		//	Cursor c=db.query("LOGIN", null, " S_ID=?", new String[]{id}, null, null, null);
		//	c.moveToFirst();
		//	String year=c.getString(c.getColumnIndex("S_YEAR"));
		//	c.close();
		///	return year;
		//}

		
		
		public void  updateEntry(String name, String mobile, String password)
		{
			// Define the updated row content.
			ContentValues updatedValues = new ContentValues();
			// Assign values for each row.
			updatedValues.put("S_NAME", name);
			//updatedValues.put("S_ID",id);
			updatedValues.put("S_MOBILE",mobile);
			//updatedValues.put("S_DEPT", dept);
			//updatedValues.put("S_YEAR",year);
			updatedValues.put("S_PASSWORD", password);
			
			
	        String where="S_NAME = ?";
		    db.update("LOGIN",updatedValues, where, new String[]{name});
		}


	//public void inserEntry(String name, String phone, String pass) {
	//	ContentValues newValues = new ContentValues();
		// Assign values for each row.
	//	newValues.put("S_NAME", name);
	//	newValues.put("S_MOBILE",phone );
	//	newValues.put("S_PASSWORD", pass);


		// Insert the row into your table
	//	db.insert("LOGIN", null, newValues);
		///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
	//}

	public void insertEntry(String names, String phones,String passs) {
		ContentValues newValues = new ContentValues();
		// Assign values for each row.
		newValues.put("S_NAME", names);
		newValues.put("S_MOBILE",phones);
		newValues.put("S_PASSWORD", passs);


		// Insert the row into your table
		db.insert("LOGIN", null, newValues);
		///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
	}
}

