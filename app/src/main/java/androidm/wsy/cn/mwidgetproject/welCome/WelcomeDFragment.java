package androidm.wsy.cn.mwidgetproject.welCome;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidm.wsy.cn.mwidgetproject.R;
import androidm.wsy.cn.mwidgetproject.activitys.WebActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeDFragment extends Fragment {

    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_welcome_d, container, false);
        button = (Button) view.findViewById(R.id.welcome_start);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("url","http://app.xiaomi.com/details?id=cn.wsy.travel&ref=search");
                startActivity(intent);
//                getActivity().finish();
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
