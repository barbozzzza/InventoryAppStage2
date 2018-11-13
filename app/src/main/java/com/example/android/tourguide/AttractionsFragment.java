package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends Fragment {




    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attractions> attractions = new ArrayList<>();
        attractions.add(new Attractions("Johson Space Center","713-270-2603","101 Main St, Houston, TX 77587",R.drawable.johnsonspacecenter));
        attractions.add(new Attractions("The Hobby Center","713-568-4595","300 Caroline St, Houston, TX 77587",R.drawable.hobbycenter));
        attractions.add(new Attractions("Buffalo Bayou Cistern","713-698-7254","4456 Allen Park Way, Houston, TX 77587",R.drawable.cistern));
        attractions.add(new Attractions("Rhotko","713-512-6767","569 Menil St, Houston, TX 77587",R.drawable.rhotko));
        attractions.add(new Attractions("Discovery Green","713-997-3547","1400 Americas Blvd, Houston, TX 77587",R.drawable.discovergreen));

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
