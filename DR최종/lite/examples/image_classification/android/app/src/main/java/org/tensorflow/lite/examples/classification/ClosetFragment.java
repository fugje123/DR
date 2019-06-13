package org.tensorflow.lite.examples.classification;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class ClosetFragment extends Fragment {

    ImageButton chat;

    public ClosetFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_closet, container, false);
        {
            chat = (ImageButton)view.findViewById(R.id.chat);
        }

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), StartActivity.class);
                in.putExtra("some", "some data");
                startActivity(in);
            }
        });
        return view;
    }
}
