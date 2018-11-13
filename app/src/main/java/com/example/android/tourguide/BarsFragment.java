package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarsFragment extends Fragment {


    public BarsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attractions> attractions = new ArrayList<>();
        attractions.add(new Attractions("Okra Charity Bar","713-230-2603","101 Chase St, Houston, TX 77587",R.drawable.okra));
        attractions.add(new Attractions("Poison Girl","713-270-2503","101 Buffalo St, Houston, TX 77587",R.drawable.poisongirl));
        attractions.add(new Attractions("Vallhalla","713-260-2633","101 Smith St, Houston, TX 77587",R.drawable.vallhalla));
        attractions.add(new Attractions("The Heymerchant","713-210-4603","101 Heights St, Houston, TX 77587",R.drawable.heymerchant));
        attractions.add(new Attractions("Dan Electro Guitar Lounge","713-270-2434","101 Kirby St, Houston, TX 77587",R.drawable.danselectro));

        //Set attraction adapter to retrive information from the attractions array.
        final AttractionsAdapter adapter = new AttractionsAdapter(getActivity(), attractions);

        //Find list vies and set current item to it
        ListView listView = rootView.findViewById(R.id.list);


        listView.setAdapter(adapter);




        // When listView item is clicked, item data is sent to new activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Attractions item = adapter.getItem(position);
                Intent intent = new Intent(getActivity().getApplicationContext(),MainActivity.class);
                intent.putExtra("ATTRACTION_NAME",item.getmAttraction());
                intent.putExtra("ATTRACTION_PHONE_NUMBER",item.getmphoneNumber());
                intent.putExtra("ATTRACTION_ADDRESS",item.getmAttrationAdress());
                intent.putExtra("ATTRACTION_PICTURES",item.getmAttractionArt());
                startActivity(intent);
            }
        });





        return rootView;
    }

}
