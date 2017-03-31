package org.vonad.viewpagerupdatefortoolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by vonad on 3/31/2017.
 */

public class NamePageAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragment;

    public NamePageAdapter(final FragmentManager fm,
                           List<Fragment> fragments) {
        super(fm);
        mFragment = fragments;
    }

    @Override
    public Fragment getItem(final int position) {
        if (mFragment != null) {
            return this.mFragment.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if (mFragment != null) {
            return this.mFragment.size();
        }
        return 0;
    }

    /*
    * update from activity to fragment if you like.
     *  */
    public void updateDataResulModel(DataModel dataModel) {
        if (mFragment == null || dataModel == null) {
            return;
        }
        for (int i = 0; i < mFragment.size(); i++) {
            if (mFragment.get(i)
                    .getClass()
                    .getName()
                    .equals(NameFragment.class.getName())) {
                ((NameFragment) mFragment.get(i)).updateDataFromActivity(dataModel);

            }
        }
    }
}
