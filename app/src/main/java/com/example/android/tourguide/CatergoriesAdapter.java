package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CatergoriesAdapter  extends FragmentPagerAdapter{

    /**
     * {@link CatergoriesAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
     * each list item based on a data source which is a list of {@link Attractions} objects.
     */


        /** Context of the app */
        private Context mContext;

        /**
         * Create a new {@link CatergoriesAdapter} object.
         *
         * @param context is the context of the app
         * @param fm is the fragment manager that will keep each fragment's state in the adapter
         *           across swipes.
         */
        public CatergoriesAdapter(Context context, FragmentManager fm) {
            super(fm);
            mContext = context;
        }

        /**
         * Return the {@link Fragment} that should be displayed for the given page number.
         */
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new AttractionsFragment();
            } else if (position == 1) {
                return new ResturantFragment();
            } else if (position == 2) {
                return new MuseumsFragment();
            } else {
                return new BarsFragment();
            }
        }

        /**
         * Return the total number of pages.
         */
        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return mContext.getString(R.string.Attractions_Category);
            } else if (position == 1) {
                return mContext.getString(R.string.Restaurant_Category);
            } else if (position == 2) {
                return mContext.getString(R.string.Museums_Category);
            } else {
                return mContext.getString(R.string.Bars_Category);
            }
        }
    }




