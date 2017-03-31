package org.vonad.viewpagerupdatefortoolbar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by vonad on 3/31/2017.
 */

public class NameFragment extends Fragment {
    private static String KEY_DATA_MODEL = "nameModel";
    private DataModel mDataOfDetailForActivity = new DataModel();
    private OnFragmentResultListener mFragmentListener;
    private TextView tvName;

    // constructor.
    public NameFragment instance(DataModel dataModel) {
        final NameFragment fragment = new NameFragment();
        final Bundle data = new Bundle();
        if (dataModel != null) {
            data.putSerializable(KEY_DATA_MODEL, dataModel);
        }
        // Attach data with fragment.
        fragment.setArguments(data);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name,
                container,
                false);
        tvName = (TextView) view.findViewById(R.id.tvNameFragment);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // update data.
        if (getArguments() != null && getArguments().getSerializable(KEY_DATA_MODEL) != null) {
            DataModel dataModel = (DataModel) getArguments().getSerializable(KEY_DATA_MODEL);
            updateDataFromActivity(dataModel);
        }

    }

    public void updateDataFromActivity(DataModel dataModel) {
        if (dataModel == null) {
            return;
        }
        //set data to textView.
        if (tvName != null) {
            tvName.setText(dataModel.getNameFragment() + "__" + dataModel.getNumberFragment());
        }
        //set model.
        mDataOfDetailForActivity = dataModel;
        // remember check visible user add data callback.
        if (getUserVisibleHint()) {
            // set data to send activity.
            mFragmentListener.onFragmentResultCreated(dataModel);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (isResumed() && isAdded()) {
                // for the first page.
                if (mFragmentListener != null) {
                    // set data to send activity.
                    mFragmentListener.onFragmentResultCreated(mDataOfDetailForActivity);
                }
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mFragmentListener = (OnFragmentResultListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnFragmentResultListener");
        }
    }

    public interface OnFragmentResultListener {
        public void onFragmentResultCreated(DataModel data);
    }
}
