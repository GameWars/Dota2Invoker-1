package com.yhzhang.dota2invokerskills;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

/*
 * The activity that shows the skill information and youtube demo video
 */
public class SkillInformation extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
	
	private static final int RECOVERY_DIALOG_REQUEST = 1;
	String vid = "";
	
	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.skillinfo);
        ImageView abiIcon = (ImageView) findViewById(R.id.abilityicon);
        TextView abiIntro = (TextView) findViewById(R.id.abilityintro);
        TextView manaCost = (TextView) findViewById(R.id.manacost);
        TextView coolDown = (TextView) findViewById(R.id.cooldown);
        
		YouTubePlayerView skill = (YouTubePlayerView) findViewById(R.id.youtube_view);;
		
		skill.initialize("AIzaSyChALWwz0-vpVetFvktjnCbgYfDwtpNl7s", this);
		String title = getIntent().getExtras().getString("Title");
		System.out.println(title);
		
		// Set which video to display based on item clicked
		if(title.equals("ColdSnap")){
			abiIcon.setImageResource(R.drawable.coldsnap);
			abiIntro.setText("Invoker draws the heat from an enemy, chilling them to their very core for a duration based on the level of Quas. The enemy will take damage and be briefly frozen. Further damage taken in this state will freeze the enemy again, dealing bonus damage. The enemy can only be frozen so often, but the freeze cooldown decreases based on the level of Quas.");
			manaCost.setText("Mana Cost: 100");
			coolDown.setText("Cool Down: 20");
			vid = "ZPita8hr8MQ";
		}
		if(title.equals("GhostWalk")){
			vid = "sjNjczESHgg";
			abiIcon.setImageResource(R.drawable.ghost);
			abiIntro.setText("Invoker manipulates the ice and electrical energies around him, rendering his body invisible. The elemental imbalance created as a consequence slows nearby enemies based on the level of Quas, and slows Invoker as well based on the level of Wex.");
			manaCost.setText("Mana Cost: 200");
			coolDown.setText("Cool Down: 35");
			
		}
		if(title.equals("IceWall")){
			abiIcon.setImageResource(R.drawable.icewall);
			abiIntro.setText("Generates a wall of solid ice directly in front of Invoker for a duration based on the level of Quas. The bitter cold emanating from it greatly slows nearby enemies based on the level of Quas and deals damage each second based on the level of Exort.");
			manaCost.setText("Mana Cost: 175");
			coolDown.setText("Cool Down: 25");
			vid = "cGVwehng5Zk";
		}
		if(title.equals("Tornado")){
			abiIcon.setImageResource(R.drawable.tornado);
			abiIntro.setText("Unleashes a fast moving tornado that picks up enemy units in its path, suspending them helplessly in the air shortly before allowing them to plummet to their doom. Travels further based on the level of Wex. Holds enemies in the air for a duration based on the level of Quas. Deals damage based on the levels of Quas and Wex.");
			manaCost.setText("Mana Cost: 150");
			coolDown.setText("Cool Down: 30");	
			vid = "U7B3JkLVS0I";
		}
		if(title.equals("DeafeningBlast")){
			abiIcon.setImageResource(R.drawable.blast);
			abiIntro.setText("Invoker unleashes a mighty sonic wave in front of him, dealing damage to any enemy unit it collides with based on the level of Exort. The sheer impact from the blast is enough to knock those enemy units back for a duration based on the level of Quas, then disarm their attacks for a duration based on the level of Wex.");
			manaCost.setText("Mana Cost: 200");
			coolDown.setText("Cool Down: 40");	
			
			vid = "cU2a6vILyyg";
		}
		if(title.equals("ForgeSpirit")){
			abiIcon.setImageResource(R.drawable.spirit);
			abiIntro.setText("Invoker forges a spirit embodying the strength of fire and fortitude of ice. Damage, health, and armor are based on the level of Exort while attack range, mana, and duration are based on the level of Quas. The elemental's scorching attack is capable of melting the armor of enemy heroes. If both Quas and Exort are level 4 or higher, Invoker will create two spirits instead of one.");
			manaCost.setText("Mana Cost: 75");
			coolDown.setText("Cool Down: 30");				
			
			vid = "xMBMz64Icf8";
		}
		if(title.equals("EMP")){
			abiIcon.setImageResource(R.drawable.emp);
			abiIntro.setText("Invoker builds up a charge of electromagnetic energy at a targeted location which automatically detonates after %delay% seconds. The detonation covers an area, draining mana based on the level of Wex. Deals damage for each point of mana drained.  If EMP drains mana from an enemy hero, Invoker gains 50% of the mana drained.");
			manaCost.setText("Mana Cost: 125");
			coolDown.setText("Cool Down: 30");	
			
			
			vid = "VF-cgzkXIMQ";
		}
		if(title.equals("Alacrity")){
			abiIcon.setImageResource(R.drawable.alacrity);
			abiIntro.setText("Invoker infuses an ally with an immense surge of energy, increasing their attack speed based on the level of Wex and their damage based on the level of Exort.");
			manaCost.setText("Mana Cost: 45");
			coolDown.setText("Cool Down: 15");				
			
			vid = "hu9VegLgza8";
		}
		if(title.equals("ChaosMeteor")){
			abiIcon.setImageResource(R.drawable.metetor);
			abiIntro.setText("Invoker pulls a flaming meteor from space onto the targeted location. Upon landing, the meteor rolls forward, constantly dealing damage based on the level of Exort, and rolling further based on the level of Wex. Units hit by the meteor will also be set on fire for a short time, receiving additional damage based on the level of Exort.");
			manaCost.setText("Mana Cost: 200");
			coolDown.setText("Cool Down: 55");			
			
			vid = "812PnlPitkE";
		}
		if(title.equals("SunStrike")){
			abiIcon.setImageResource(R.drawable.sunstrike);
			abiIntro.setText("Sends a catastrophic ray of fierce energy from the sun at any targeted location, incinerating all enemies standing beneath it once it reaches the earth. Deals damage based on the level of Exort, however this damage is spread evenly over all enemies hit.");
			manaCost.setText("Mana Cost: 175");
			coolDown.setText("Cool Down: 30");	
			vid = "5LZz3ZCHRW8";
		}
			
	}



	@Override
	public void onInitializationFailure(Provider arg0,
			YouTubeInitializationResult errorReason) {
	    if (errorReason.isUserRecoverableError()) {
	        errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
	      } else {
	        String errorMessage = String.format(getString(R.string.error_player), errorReason.toString());
	        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
	      }
		
	}

	@Override
	public void onInitializationSuccess(Provider provider, YouTubePlayer player,
			boolean wasRestored) {
		if (!wasRestored) {
		      player.cueVideo(vid);
		}
		
	}
	
	  protected YouTubePlayer.Provider getYouTubePlayerProvider() {
		    return (YouTubePlayerView) findViewById(R.id.youtube_view);
		  }
	
	
}
