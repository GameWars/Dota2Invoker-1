package com.yhzhang.dota2invokerskills;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
 
public class InvokerSkillBrowser extends Activity {
	private String chosenSkill;
 
    // Array of strings storing skill names
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
    
    // Array of strings to identify different youtube videos
    String[] webArray = new String[]{
            "ColdSnap",
            "GhostWalk",
            "IceWall",
            "Tornado",
            "DeafeningBlast",
            "ForgeSpirit",
            "EMP",
            "Alacrity",
            "ChaosMeteor",
            "SunStrike"
    };
 
    /*
     * Array of image 
     */
    int[] imagesArray = new int[]{
        R.drawable.coldsnap,
        R.drawable.ghost,
        R.drawable.icewall,
        R.drawable.tornado,
        R.drawable.blast,
        R.drawable.spirit,
        R.drawable.emp,
        R.drawable.alacrity,
        R.drawable.metetor,
        R.drawable.sunstrike
    };
    
    
    /*
     * Combination of elements to be shown on the listview
     */
    String[] comboArray = new String[]{
        "Quas Quas Quas",
        "Quas Quas Wes",
        "Quas Quas Exort",
        "Wex Wex Quas",
        "Quas Wex Exort",
        "Exort Exort Quas",
        "Wex Wex Wex",
        "Wex Wex Exort",
        "Exort Exort Wex",
        "Exort Exort Exort"
    };
    
   
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // List of hashmaps containing information for each listview element
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
 
        for(int i=0;i<10;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("skill", "Skill : " + skillArray[i]);
            hm.put("combo","Elements : " + comboArray[i]);
            hm.put("image", Integer.toString(imagesArray[i]) );
            aList.add(hm);
        }
 
        String[] from = { "image","skill","combo" };
 
        int[] to = { R.id.image,R.id.skill,R.id.combo};
        
        // Create an adapter for the listview
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.list_row, from, to);
 
        ListView listView = ( ListView ) findViewById(R.id.listview);
 
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				chosenSkill = webArray[arg2];
				// Send information indicating which element clicked to next activity
				Intent i = new Intent("com.yhzhang.dota2invokerskills.Cold");
				i.putExtra("Title", chosenSkill);
				startActivity(i);	
			}
		});
    }
}
