package org.vonad.viewpagerupdatefortoolbar;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerUpdateForToolBarActivity extends AppCompatActivity implements NameFragment.OnFragmentResultListener {
    private ViewPager vpNameFragment;
    private TextView tvTitleToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vpNameFragment = (ViewPager) findViewById(R.id.vpFragment);
        tvTitleToolBar = (TextView) findViewById(R.id.tvTitleToolbar);
        // filldata.
        fillData();
    }

    private void fillData() {
        NamePageAdapter namePageAdapter = new NamePageAdapter(getSupportFragmentManager(), getListFragment());
        if (vpNameFragment != null) {
            vpNameFragment.setAdapter(namePageAdapter);
        }
    }

    private List<Fragment> getListFragment() {
        // init list fragment.
        List<Fragment> lstFragment = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataModel dataModel = new DataModel();
            dataModel.setNameFragment("This is page:" + i);
            dataModel.setNumberFragment(i);
            lstFragment.add(new NameFragment().instance(dataModel));
        }
        return lstFragment;
    }

    @Override
    public void onFragmentResultCreated(DataModel data) {
        if (data == null) {
            return;
        }
        System.out.println(">>>>> check data:"+data.getNameFragment());
        //call back from fragment.
        // result from fragment VISIBLE.
        if (tvTitleToolBar != null) {
            tvTitleToolBar.setText("Change success:" + data.getNameFragment());
        }
    }
}
