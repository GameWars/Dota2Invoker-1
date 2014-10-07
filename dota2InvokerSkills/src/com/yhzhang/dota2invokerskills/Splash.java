package com.yhzhang.dota2invokerskills;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * The splash screen when the app starts
 * @author yuhaozhang
 */
public class Splash extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(1000);
					
				}
				catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMainActivity = new Intent("com.yhzhang.dota2invokerskills.MenuAction");
					startActivity(openMainActivity);
				}
			}
		};
		timer.start();	
	}

	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}
	
	
	

}