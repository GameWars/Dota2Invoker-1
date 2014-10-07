package com.yhzhang.dota2invokerskills;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Practice invoking the skills with no time limit
 * @author yuhaozhang
 *
 */
public class InvokePractice extends Activity{
	
	private ImageButton quas;
	private ImageButton exsort;
	private ImageButton wex;
	private ImageButton invoke;
	private ImageView c1;
	private ImageView c2;
	private ImageView c3;
	private ImageView c4;
	private ArrayList<Integer> elements;
	
	private final int aQuas = 1;
	private final int aExsort = 2;
	private final int aWex = 3;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.invokeprac);
		initial();
	}
	
	public void onBackPressed() {
		finish();
		Intent i = new Intent("com.yhzhang.dota2invokerskills.Chooser");
		startActivity(i);
	}
	
	
	/*
	 * Initialize the references 
	 */
	private void initial(){
		
		quas = (ImageButton) findViewById(R.id.imageButton1);
        wex = (ImageButton) findViewById(R.id.imageButton2);
        exsort = (ImageButton) findViewById(R.id.imageButton3);
        invoke = (ImageButton) findViewById(R.id.imageButton4);
        c1 = (ImageView) findViewById(R.id.ImageView1);
        c2 = (ImageView) findViewById(R.id.ImageView2);
        c3 = (ImageView) findViewById(R.id.ImageView3);
        c4 = (ImageView) findViewById(R.id.ImageView4);
        c1.setImageResource(R.drawable.blackbackground);
		c2.setImageResource(R.drawable.blackbackground);
		c3.setImageResource(R.drawable.blackbackground);
		c4.setImageResource(R.drawable.blackbackground);
		elements = new ArrayList<Integer>();

        

        quas.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				upDateArray(aQuas);
				upDateInput();
			}
		});
        
        
        exsort.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				upDateArray(aExsort);
				upDateInput();
			}
		});
        
        
        wex.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				upDateArray(aWex);
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
	
	/*
	 * Show the skill image in the center based on the elements set
	 */
	private void upDateImage(){
		int sum = 0;
		for(int num : elements){
			sum += num;
		}
		if(sum == 3 && elements.size() == 3){
			c4.setImageResource(R.drawable.coldsnap);
			
		}
		if(sum == 6 && elements.contains(aQuas) && elements.size() == 3){
			c4.setImageResource(R.drawable.blast);
		}
		if(sum == 6 && !elements.contains(aQuas) && elements.size() == 3){
			c4.setImageResource(R.drawable.sunstrike);			
		}
		
		if(sum == 5 && elements.contains(aWex) && elements.size() == 3){
			c4.setImageResource(R.drawable.ghost);
		}
		if(sum == 5 && !elements.contains(aWex) && elements.size() == 3){
			c4.setImageResource(R.drawable.spirit);
		}
		if(sum == 4 && elements.size() == 3){
			c4.setImageResource(R.drawable.icewall);
		}
		if(sum == 7 && elements.contains(aQuas) && elements.size() == 3){
			c4.setImageResource(R.drawable.tornado);
		}
		if(sum == 7 && !elements.contains(aQuas) && elements.size() == 3){
			c4.setImageResource(R.drawable.metetor);
		}		
		if(sum == 9 && elements.size() == 3){
			c4.setImageResource(R.drawable.emp);
		}
		if(sum == 8 && elements.size() == 3){
			c4.setImageResource(R.drawable.alacrity);
		}
		
		
		
		
	}
	
	/*
	 * Update the skill array 
	 */
	private void upDateArray(int toAdd){
		if(elements.size() < 3){
			elements.add(toAdd);
		}
		else{
			elements.remove(0);
			elements.add(toAdd);
		}
		
	}
	
	
	/*
	 * Update the element image based on the button pressed
	 */
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
	
	/*
	 * Set the element image on the screen
	 */
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
}
				
	
	

