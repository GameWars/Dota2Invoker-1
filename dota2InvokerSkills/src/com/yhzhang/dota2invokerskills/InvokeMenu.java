package com.yhzhang.dota2invokerskills;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


/**
 * Choose a practice or a quiz
 * @author yuhaozhang
 *
 */
public class InvokeMenu extends Activity {
	
	Button timed;
	Button untimed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invokemenu);
        timed = (Button) findViewById(R.id.button3);
        untimed = (Button) findViewById(R.id.button4);
        timed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent("com.yhzhang.dota2invokerskills.TimedPrac");
				finish();
				startActivity(i);
			}
		});
        
        
        untimed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent("com.yhzhang.dota2invokerskills.Prac");
				finish();
				startActivity(i);			
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}


