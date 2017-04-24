package com.component.independent.appremaining;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Switch welcome_home,room_based,daylight_saving,no_movement;
    int welcome_home_flag,room_based_flag,daylight_saving_flag,no_movement_flag;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        editor = sharedPreferences.edit();

        welcome_home = (Switch) findViewById(R.id.welcome_home);
        room_based = (Switch) findViewById(R.id.room_based);
        daylight_saving = (Switch) findViewById(R.id.daylight_saving);
        no_movement = (Switch) findViewById(R.id.no_movement);

        welcome_home_flag = sharedPreferences.getInt("welcome_home_val",0);
        room_based_flag = sharedPreferences.getInt("room_based_val",0);
        daylight_saving_flag = sharedPreferences.getInt("daylight_saving_val",0);
        no_movement_flag = sharedPreferences.getInt("no_movement_val",0);




        if(welcome_home_flag==1){
            Toast.makeText(this, "welcome flag checked", Toast.LENGTH_SHORT).show();
            welcome_home.setChecked(true);
        }
        else{
            welcome_home.setChecked(false);
        }
        if(room_based_flag==1){
            room_based.setChecked(true);
        } else{
            room_based.setChecked(false);
        }
        if(daylight_saving_flag==1){
            daylight_saving.setChecked(true);
        } else{
            daylight_saving.setChecked(false);
        }
        if(no_movement_flag==1){
            no_movement.setChecked(true);
        } else{
            no_movement.setChecked(false);
        }

       welcome_home.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (welcome_home.isChecked()) {
                   welcome_home.setChecked(false);
                   AlertDialog adb = new AlertDialog.Builder(MainActivity.this)
                           .setTitle("Welcome Home")
                           .setMessage("Turns out certain lights when you ETA is less than two minutes")
                           .setIcon(android.R.drawable.ic_dialog_alert)
                           .setPositiveButton("Turn ON", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int which) {
                                   welcome_home.setChecked(true);
                                   welcome_home_flag = 1;
                                   editor.putInt("welcome_home_val",welcome_home_flag);
                                   editor.commit();
                                   Toast.makeText(MainActivity.this, "Welcome Home Active", Toast.LENGTH_SHORT).show();

                               }
                           })
                           .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int which) {
                                   welcome_home_flag = 0;
                                   editor.putInt("welcome_home_val",welcome_home_flag);
                                   editor.commit();
                                   Toast.makeText(MainActivity.this, "Lights will not turn on when you reach home",
                                           Toast.LENGTH_SHORT).show();
                               }
                           })
                           .create();
                   adb.show();
               }else{
                   welcome_home_flag = 0;
                   editor.putInt("welcome_home_val",welcome_home_flag);
                   editor.commit();
               }

           }
       });



        room_based.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (room_based.isChecked())
                {
                    room_based.setChecked(false);
                    AlertDialog adb = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Room Based")
                            .setMessage("The app will automatically detect your rooms")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton("Turn ON", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    room_based.setChecked(true);
                                    room_based_flag = 1;
                                    editor.putInt("room_based_val",room_based_flag);
                                    editor.commit();
                                    Toast.makeText(MainActivity.this, "Welcome Home Active", Toast.LENGTH_SHORT).show();

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    room_based_flag = 0;
                                    editor.putInt("room_based_val",room_based_flag);
                                    editor.commit();
                                    Toast.makeText(MainActivity.this, "Lights will not turn on when you reach home",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .create();
                    adb.show();
                }
                else{
                    room_based_flag = 0;
                    editor.putInt("room_based_val",room_based_flag);
                    editor.commit();

                }

            }
        });

        daylight_saving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(daylight_saving.isChecked())
                {
                    no_movement.setChecked(false);
                    daylight_saving.setChecked(false);
                    AlertDialog adb = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Daylight Saving")
                            .setMessage("Turns off lights during the daytime")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton("Turn ON", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    daylight_saving.setChecked(true);
                                    daylight_saving_flag = 1;
                                    editor.putInt("daylight_saving_val",daylight_saving_flag);
                                    editor.commit();
                                    Toast.makeText(MainActivity.this, "Welcome Home Active", Toast.LENGTH_SHORT).show();

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    daylight_saving_flag = 0;
                                    editor.putInt("daylight_saving_val",daylight_saving_flag);
                                    editor.commit();
                                    Toast.makeText(MainActivity.this, "Lights will not turn on when you reach home",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .create();
                    adb.show();
                }else{
                    daylight_saving_flag = 0;
                    editor.putInt("daylight_saving_val",daylight_saving_flag);
                    editor.commit();
                }
            }
        });

        no_movement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (no_movement.isChecked()) {
                    AlertDialog adb = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("No Movement")
                            .setMessage("System will sound the alarm during the no movement phase")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton("Turn ON", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    no_movement.setChecked(true);
                                    no_movement_flag = 1;
                                    editor.putInt("no_movement_val", no_movement_flag);
                                    editor.commit();
                                    Toast.makeText(MainActivity.this, "Welcome Home Active", Toast.LENGTH_SHORT).show();

                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    no_movement_flag = 0;
                                    editor.putInt("no_movement_val", no_movement_flag);
                                    editor.commit();
                                    Toast.makeText(MainActivity.this, "Lights will not turn on when you reach home",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .create();
                    adb.show();
                }else{
                    no_movement_flag = 0;
                    editor.putInt("no_movement_val", no_movement_flag);
                    editor.commit();

                }
            }
        });

    }
}
