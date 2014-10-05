package com.yhzhang.dota2invokerskills;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/*
 * The starting menu of the app
 */
public class StartMenu extends Activity{
	
	Button Browse;
	Button Prac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulayout);
        Browse = (Button) findViewById(R.id.button1);
        Prac = (Button) findViewById(R.id.button2);
        Browse.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent("com.yhzhang.dota2invokerskills.Browser");
				startActivity(i);				
			}
		});
        
        
        Prac.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent("com.yhzhang.dota2invokerskills.Chooser");
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