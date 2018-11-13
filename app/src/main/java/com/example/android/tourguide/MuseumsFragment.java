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
public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attractions> attractions = new ArrayList<>();
        attractions.add(new Attractions("MFHA","713-289-5603","151 Main St, Houston, TX 77587",R.drawable.mfha));
        attractions.add(new Attractions("The Menil","713-570-4603","171 Menil St, Houston, TX 77587",R.drawable.menil));
        attractions.add(new Attractions("Holocaust Museum","713-578-2673","5645 Houston St, Houston, TX 77587",R.drawable.holocaust));
        attractions.add(new Attractions("Buffalo Soldier's Museum","713-260-2600","6977 AlmedaSt, Houston, TX 77587",R.drawable.buffalosoldiers));
        attractions.add(new Attractions("The Orange Show","713-247-2705","5697 Scott St, Houston, TX 77587",R.drawable.orangeshow));

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
