package com.example.android.tourguide;

public class Attractions {

    /** takes attraction name */

    private String attraction;


    /** takes  phone number */

    private  String phoneNumber;

    /** takes attraction address */

    private  String attractionAddress;

    /** takes attraction picture*/

    private int attractionArt;




    /** constructor that takes the three inputs */

    public Attractions(String attractionName, String attractionPhoneNumber, String attractionAddressNumber, int attractionPictures){




        attraction = attractionName;
        phoneNumber = attractionPhoneNumber;
        attractionAddress = attractionAddressNumber;
        attractionArt = attractionPictures;

    }

    /**get attraction name*/
    public String getmAttraction() {
        return attraction;
    }

    /**get phone name*/

    public String getmphoneNumber() {
        return phoneNumber;
    }

    /**get address */

    public String getmAttrationAdress() {return attractionAddress;}

    /** get attraction art*/

    public int getmAttractionArt() {return  attractionArt;}


}
