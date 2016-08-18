package androidm.wsy.cn.mwidgetproject.welCome;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidm.wsy.cn.mwidgetproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeBFragment extends Fragment {


    public WelcomeBFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome_b, container, false);
    }

}
