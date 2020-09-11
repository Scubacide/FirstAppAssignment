package com.example.a8point0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);



        this.logStuff(getVersion("ss")); // I'm not sure why it wanted a " " in the ( )s


//        if (osVersion <= 8.0) {
//            Toast.makeText(this, "Update at Settings>System>System update.", Toast.LENGTH_LONG).show();
//            setContentView(R.layout.outdated);
//        }
          // Was using these to check the OS in float form, 8.1.0 was breaking this.
//        else if (osVersion >= 9.0) {
//            for (int i=0; i<2; i++) { // Lengthens the Toast message.
//                Toast.makeText(this, "Your OS is up to date! Thank you!", Toast.LENGTH_SHORT).show();
//            }
//        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.landscapelayout);
            //SystemClock.sleep(5000); // was skipping frames and making the OS Toasts not display.
            //Toast.makeText(this, "Set to landscape mode.", Toast.LENGTH_SHORT);
        }
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            //SystemClock.sleep(5000); // was skipping frames and making the OS Toasts not display.
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                Toast.makeText(this, "Your OS is up to date! Thank you!", Toast.LENGTH_SHORT).show();
            } // Put OS checks in here because they're annoying in landscape.
            else {
                Toast.makeText(this, "You're running and old OS. Update at Settings>System>System update.", Toast.LENGTH_SHORT).show();
            }
            //Toast.makeText(this, "Set to portrait mode.", Toast.LENGTH_SHORT);
        }
    }

    private void logStuff(String details) {
        System.out.println(details);
    }
    public String getVersion(String version) {
        String osVersion = "************** Version of Android is: " + Build.VERSION.RELEASE + " **************";
        return osVersion;
    }


}