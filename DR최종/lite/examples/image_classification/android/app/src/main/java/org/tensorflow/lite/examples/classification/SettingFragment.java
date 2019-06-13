package org.tensorflow.lite.examples.classification;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SettingFragment extends Fragment {
    TextView langsetting, mysetting;


    public SettingFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        langsetting = (TextView) view.findViewById(R.id.langsetting);
        mysetting = (TextView) view.findViewById(R.id.mysetting);

        langsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), LangActivity.class);
                in.putExtra("some", "some data");
                startActivity(in);
            }
        });
        mysetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), AccountActivity.class);
                in.putExtra("some", "some data");
                startActivity(in);
            }
        });
        return view;
    }
}