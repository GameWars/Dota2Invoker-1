package com.yhzhang.dota2invokerskills;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/*
 * Shows the score records
 */
public class TimedResult extends Activity{
	
	DBAdapter myDb;
	private int point;
	private ListView allResult;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> records = new ArrayList<String>();
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.score);
		 openDB();
		 point = getIntent().getExtras().getInt("score");
		 TextView score = (TextView) findViewById(R.id.resultPoint);
		 AddRecord();
		 allResult = (ListView) findViewById(R.id.ScoreList);
		 score.setText("Time's up, you got: " + point + " correct");
		 score.setTextSize(24);
		 score.setTextColor(Color.GRAY);
		 DisplayRecords();
		
	}
	
	/*
	 * Get the current date
	 */
	private String getDate(){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		String formattedDate = df.format(c.getTime());
		return formattedDate;
	}
	
	public void AddRecord() {
		
		long newId = myDb.insertRow("1", point, getDate());
		
	}
	
	
	
	
	private void openDB() {
		myDb = new DBAdapter(this);
		myDb.open();
	}
	
	
	private void closeDB() {
		myDb.close();
	}
	
	protected void onDestroy() {
		super.onDestroy();	
		closeDB();
	}
	
	
	/*
	 * Display the record in the database
	 */
	private void displayRecordSet(Cursor cursor) {
		String message = "";

		if (cursor.moveToFirst()) {
			int rankNum = 1;
			do {

				int id = cursor.getInt(DBAdapter.COL_ROWID);
				int numScore = cursor.getInt(DBAdapter.COL_SCORE);
				String theDate = cursor.getString(DBAdapter.COL_DATE);
				
				message = 
						   "rank: " + rankNum
						   +", #" + numScore
						   +", Date: " + theDate
						   +"\n";
				rankNum += 1;
				records.add(message);
			} while(cursor.moveToNext());
			adapter = new ArrayAdapter<String>(this,
	                 android.R.layout.simple_list_item_1, android.R.id.text1, records);
			allResult.setAdapter(adapter);
		}
		
		cursor.close();
	}
	
	public void DisplayRecords() {
		
		Cursor cursor = myDb.getAllRows();
		displayRecordSet(cursor);
	}
	
	
	
}
