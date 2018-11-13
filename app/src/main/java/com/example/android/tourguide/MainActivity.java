package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        //get intent from Fragments to pass on to another Activity
        Intent intent = getIntent();

        String CurrentAttraction = intent.getStringExtra("ATTRACTION_NAME");
        String CurrentAttractionPhoneNumber = intent.getStringExtra("ATTRACTION_PHONE_NUMBER");
        String CurrentAttractionAddress = intent.getStringExtra("ATTRACTION_ADDRESS");
        int CurrentAttractionPicture = intent.getIntExtra("ATTRACTION_PICTURES",0);


    TextView currentaAttractionName = (TextView) findViewById(R.id.AttracttionName);

        assert currentaAttractionName != null;
        currentaAttractionName.setText(CurrentAttraction);

    TextView currentAttractionNumber = (TextView) findViewById(R.id.AttractionPhoneNumber);

        assert currentAttractionNumber != null;
        currentAttractionNumber.setText(CurrentAttractionPhoneNumber);

    TextView currentAttractionAddressInfo = (TextView) findViewById(R.id.AttractionAddres);

        assert currentAttractionAddressInfo != null;
        currentAttractionAddressInfo.setText(CurrentAttractionAddress);

    ImageView currentAttractionImage = (ImageView) findViewById(R.id.AttractionImage);
        if (currentAttractionImage != null) {
            currentAttractionImage.setImageResource(CurrentAttractionPicture);
        }


        // Sets tab_menu as the layout file
        ImageView menu = (ImageView) findViewById(R.id.home_button);

        // creates button/ sets on click listener for Main Activity View

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(MainActivity.this, TabActivity.class);
                startActivity(menuIntent);
            }
        });


}}