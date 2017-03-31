package org.vonad.viewpagerupdatefortoolbar;

import java.io.Serializable;

/**
 * Created by vonad on 3/31/2017.
 */

public class DataModel implements Serializable {
    private String nameFragment;
    private int numberFragment;

    public String getNameFragment() {
        return nameFragment;
    }

    public void setNameFragment(String nameFragment) {
        this.nameFragment = nameFragment;
    }

    public int getNumberFragment() {
        return numberFragment;
    }

    public void setNumberFragment(int numberFragment) {
        this.numberFragment = numberFragment;
    }
}
