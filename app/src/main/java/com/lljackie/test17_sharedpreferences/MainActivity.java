package com.lljackie.test17_sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String SharedPreferencesFileName="config";

    private final static String Key_StudentName ="StudentName";
    private final static String Key_StudentAge ="StudentAge";
    private final static String Key_StudentNumber ="StudentNumber";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences=getSharedPreferences(SharedPreferencesFileName, MODE_PRIVATE);
        editor=preferences.edit();

        Button btnWrite=(Button)findViewById(R.id.bt_write);
        Button btnRead=(Button)findViewById(R.id.bt_read);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString(Key_StudentName, "Jack");
                editor.putInt(Key_StudentAge, 20);
                editor.putString(Key_StudentNumber, "2014010129");

                editor.apply();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strStudentName = preferences.getString(Key_StudentName, null);
                String strStudentNumber = preferences.getString(Key_StudentNumber, null);
                int nStudentAge=preferences.getInt(Key_StudentAge,20);
                if (strStudentName != null && strStudentNumber != null)
                    Toast.makeText(MainActivity.this, "Name: " + strStudentName + " Number: " +
                            strStudentNumber+" Age: "+nStudentAge, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "null", Toast.LENGTH_LONG).show();
            }
        });
    }

}
