package com.example.android.tourguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AttractionsAdapter extends ArrayAdapter <Attractions>{

    /**
     * This is the constructor for the context is to inflate the  layout file
     * abd tge list is the ata we want  to populate into the lists.
     *
     * @param context the current context. Used to Inflate the layout file
     * @param Attractions    A list of Attraction object to display on the list
     */


    public AttractionsAdapter(Activity context, ArrayList<Attractions> Attractions) {

        // This code initializes the ArrayAdapter's internal storage for the context and the list
        // The second argument is used when ArrayAdapter is populating a single TextView.
        //Because this is a custom adapter for two Text views and and ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, Attractions);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if the existing view is being reused, otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        Attractions currentAttraction = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView AttractionTextView = (TextView) listItemView.findViewById(R.id.attraction_name);
        // Get the version name from the current  attraction object and
        // set this text on the attraction_name TextView
        AttractionTextView.setText(((Attractions) currentAttraction).getmAttraction());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView PhoneTextView = (TextView) listItemView.findViewById(R.id.attraction_phone);
        // Get the version name from the current  attraction phone object and
        // set this text on the attraction_phone TextView
        PhoneTextView.setText(currentAttraction.getmphoneNumber());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.attraction_address);
        // Get the version number from the current attraction address and
        // set this text on the attraction_address TextView
        addressTextView.setText(currentAttraction.getmAttrationAdress());

        // Find the image view in the iist_item.xml layout with the ID Version number

        ImageView AttractionPictureImageView = listItemView.findViewById(R.id.Attraction_picture);
        //get the version number from the current image object and
        //set the image to the attraction_pictures text text view.
        AttractionPictureImageView.setImageResource(currentAttraction.getmAttractionArt());

        return listItemView;
    }
}

