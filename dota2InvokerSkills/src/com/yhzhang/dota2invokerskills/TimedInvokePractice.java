package com.yhzhang.dota2invokerskills;


import java.util.ArrayList;
import java.util.Random;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
/**
 * The skill invoking quiz
 * @author yuhaozhang
 *
 */
public class TimedInvokePractice extends Activity implements ViewFactory{

	
	
		private ImageButton bing;
		private ImageButton huo;
		private ImageButton lei;
		private ImageButton invoke;
		private ImageView c1;
		private ImageView c2;
		private ImageView c3;
		private ImageView c4;
		private TextSwitcher t1;
		private TextView timeLeft;
		private TextView numRight;
		private String theSkill = "unset";
		private String trueSkill; 
		private ArrayList<Integer> elements;
		private int rightCount = 0;
		private int timeRemain = 60000;
		private boolean displayResult = true;
		

		
	    String[] skillArray = new String[] {
	            "Cold Snap",
	            "Ghost Walk",
	            "Ice Wall",
	            "Tornado",
	            "Deafening Blast",
	            "Forge Spirit",
	            "EMP",
	            "Alacrity",
	            "Chaos Meteor",
	            "Sun Strike"
	        };
	
		private final int ice = 1;
		private final int fire = 2;
		private final int thunder = 3;
		
		
		public void onBackPressed() {
			finish();
			Intent i = new Intent("com.yhzhang.dota2invokerskills.Chooser");
			startActivity(i);
			displayResult = false;
		}

	
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.timedinvoke);
			initial();
			gameRun();
			timeLeft.setText("Time Left: " + String.valueOf(timeRemain));
			timeLeft.setTextSize(20);
			timeLeft.setTextColor(Color.GRAY);
			
			// Up date the countdown shown in the activity
			CountDownTimer t = new CountDownTimer(60000,1000) {
				
				@Override
				public void onTick(long arg0) {
					timeRemain -= 1000;
					timeLeft.setText("Time Left: " + String.valueOf(timeRemain / 1000));
					
				}
				
				@Override
				public void onFinish() {
					
				}
			};
			t.start();
			
			// The activity stops after the 60 seconds
			Thread timer = new Thread(){
				public void run(){
					try{
						sleep(60000);
						
					}
					catch (InterruptedException e){
						e.printStackTrace();
					}finally{
						finish();
						if (displayResult) {
							// After the quiz ends, start the result activity
							Intent openMainActivity = new Intent(
									"com.yhzhang.dota2invokerskills.Score");
							openMainActivity.putExtra("score", rightCount);
							startActivity(openMainActivity);
						}
					}
				}
			};
			timer.start();	
			
		}	
		
		
		
		private void gameRun(){
			int number = new Random().nextInt(10);
			t1.setText(String.valueOf(skillArray[number]));
			trueSkill = skillArray[number];
		}
		
		/*
		 * Initialize the references and onclick listeners
		 */
		private void initial(){
			
			bing = (ImageButton) findViewById(R.id.imageButton1);
	        lei = (ImageButton) findViewById(R.id.imageButton2);
	        huo = (ImageButton) findViewById(R.id.imageButton3);
	        invoke = (ImageButton) findViewById(R.id.imageButton4);
	        c1 = (ImageView) findViewById(R.id.ImageView1);
	        c2 = (ImageView) findViewById(R.id.ImageView2);
	        c3 = (ImageView) findViewById(R.id.ImageView3);
	        c4 = (ImageView) findViewById(R.id.ImageView4);
	        t1 = (TextSwitcher) findViewById(R.id.right); 
	        numRight = (TextView) findViewById(R.id.totalRight);
	        timeLeft = (TextView) findViewById(R.id.timeLeft);
	        t1.setFactory(this);  
	        t1.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));  
	        t1.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
	        c1.setImageResource(R.drawable.blackbackground);
			c2.setImageResource(R.drawable.blackbackground);
			c3.setImageResource(R.drawable.blackbackground);
			c4.setImageResource(R.drawable.blackbackground);
			elements = new ArrayList<Integer>();
	
	        
	
	        bing.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					upDateArray(ice);
					upDateInput();
				}
			});
	        
	        
	        huo.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					upDateArray(fire);
					upDateInput();
				}
			});
	        
	        
	        lei.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					upDateArray(thunder);
					upDateInput();
				}
			});
	        
	        
	        invoke.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
						upDateImage();								
				}
			});   
			
		}
		
		private void upDateImage(){
			int sum = 0;
			for(int num : elements){
				sum += num;
			}
			if(sum == 3 && elements.size() == 3){
				c4.setImageResource(R.drawable.coldsnap);
				theSkill = "Cold Snap";			
			}
			if(sum == 6 && elements.contains(ice) && elements.size() == 3){
				c4.setImageResource(R.drawable.blast);
				theSkill = "Deafening Blast";
	
			}
			if(sum == 6 && !elements.contains(ice) && elements.size() == 3){
				c4.setImageResource(R.drawable.sunstrike);	
				theSkill = "Sun Strike";
			}
			
			if(sum == 5 && elements.contains(thunder) && elements.size() == 3){
				c4.setImageResource(R.drawable.ghost);
				theSkill = "Ghost Walk";
			}
			if(sum == 5 && !elements.contains(thunder) && elements.size() == 3){
				c4.setImageResource(R.drawable.spirit);
				theSkill = "Forge Spirit";
			}
			if(sum == 4 && elements.size() == 3){
				c4.setImageResource(R.drawable.icewall);
				theSkill = "Ice Wall";
			}
			if(sum == 7 && elements.contains(ice) && elements.size() == 3){
				c4.setImageResource(R.drawable.tornado);
				theSkill = "Tornado";
			}
			if(sum == 7 && !elements.contains(ice) && elements.size() == 3){
				c4.setImageResource(R.drawable.metetor);
				theSkill = "Chaos Meteor";
			}		
			if(sum == 9 && elements.size() == 3){
				c4.setImageResource(R.drawable.emp);
				theSkill = "EMP";
			}
			if(sum == 8 && elements.size() == 3){
				c4.setImageResource(R.drawable.alacrity);
				theSkill = "Alacrity";
			}
			
			// Display whether the answer is correct or not
			if(!theSkill.equals("unset") && theSkill.equals(trueSkill)){
			    Handler handler = new Handler();
			    t1.setText(String.valueOf("Ccorrect!"));
	            handler.postDelayed(new Runnable() {
	                @Override
	                public void run() {
	                	 gameRun();
	                }
	            }, 500);
               
				rightCount += 1;
				numRight.setText("Correct: " + String.valueOf(rightCount));
				numRight.setTextSize(20);
				numRight.setTextColor(Color.GRAY);
				
			}
			else if(!theSkill.equals("unset") && !theSkill.equals(trueSkill)){
			    Handler handler = new Handler();
			    t1.setText(String.valueOf("Incorrect"));
	            handler.postDelayed(new Runnable() {
	                @Override
	                public void run() {
	                    t1.setText(String.valueOf(trueSkill));
	                }
	            }, 500);
  
				
			}
			
			
		}
		
		private void upDateArray(int toAdd){
			if(elements.size() < 3){
				elements.add(toAdd);
			}
			else{
				elements.remove(0);
				elements.add(toAdd);
			}
			
		}
		
		private void upDateInput(){
				for(int i = 0; i < elements.size(); i++){
					if(i == 0){
						upDateHelper(i, c2);
					}
					if(i == 1){
						upDateHelper(i, c1);
					}
					if(i == 2){
						upDateHelper(i, c3);
					}
				}
		}
		
		private void upDateHelper(int index, ImageView hisBall){
			if(elements.get(index) == 1){
				hisBall.setImageResource(R.drawable.quas);
			}
			if(elements.get(index) == 2){
				hisBall.setImageResource(R.drawable.exort);
			}
			if(elements.get(index) == 3){
				hisBall.setImageResource(R.drawable.wex);
			}
			
		}



		@Override
		public View makeView() {
			 TextView t = new TextView(this);  
			 t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);  
			 t.setTextSize(28); 
			 t.setTextColor(Color.GRAY);
			 return t; 
		}
	


	
	
}
	
