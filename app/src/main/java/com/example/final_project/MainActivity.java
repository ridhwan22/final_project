package com.example.final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating a dropdown list that matches the id **/
        Spinner days = (Spinner) findViewById(R.id.weekDays);
        //Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> dropDownAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.weekDays));
        //Making dropDownAdapter as a drop down list**/
        dropDownAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Set the spinner days to the adaptor dropDownAdaptor**/
        days.setAdapter(dropDownAdapter);

        // Making a responsible drop down when each item is selected
        days.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**.
             * responsible drop down list
             * @param parent
             * @param view
             * @param position position of each drop down list item
             * @param id
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
