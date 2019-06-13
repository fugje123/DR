package org.tensorflow.lite.examples.classification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CategoryFragment extends Fragment {

    ImageButton imageButton, upload;


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        imageButton = (ImageButton) view.findViewById(R.id.spbutton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SpringActivity.class);
                startActivity(intent);
            }
        });


        imageButton = (ImageButton)view.findViewById(R.id.sumbutton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(),SummerActivity.class);
                startActivity(intent2);
            }
        });


        imageButton = (ImageButton)view.findViewById(R.id.falbutton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(),FallActivity.class);
                startActivity(intent3);
            }
        });


        imageButton = (ImageButton)view.findViewById(R.id.winbutton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getActivity(),WinterActivity.class);
                startActivity(intent4);
            }
        });
        return  view;
    }
}
