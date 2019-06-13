package org.tensorflow.lite.examples.classification;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.tensorflow.lite.examples.classification.R;
import org.tensorflow.lite.examples.classification.SearchActivity;

public class HomeFragment extends Fragment {

    ImageButton search;
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;


    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
            {

                search = (ImageButton) view.findViewById(R.id.search_button);

                //한국 기본
                imageView =(ImageView) view.findViewById(R.id.imageView_01);
                String url = "https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2FCardigan.PNG?alt=media&token=7971b062-a7e5-403e-ab53-f32686867b78";
                Picasso.get().load(url).into(imageView);
                imageView1=(ImageView) view.findViewById(R.id.imageView_02);
                String url1 = "https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EA%B0%80%EC%A3%BD%EC%9E%90%EC%BC%93.PNG?alt=media&token=721f4ca6-61dc-45ae-ba29-51498cb4f2c5";
                Picasso.get().load(url1).into(imageView1);
                imageView2 =(ImageView) view.findViewById(R.id.imageView_03);
                String url2 = "https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EA%B2%80%EC%A0%95%EC%83%89%20%EA%B0%80%EB%94%94%EA%B1%B41.PNG?alt=media&token=e45b9a96-8d5e-4af4-aaed-123f3323b959";
                Picasso.get().load(url2).into(imageView2);

                //영국 기본
                imageView3 =(ImageView) view.findViewById(R.id.imageView_04);
                String url3 = "https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EA%B0%80%EC%A3%BD%EC%9E%90%EC%BC%93.PNG?alt=media&amp;token=c3f85231-b64d-442d-a4f8-f616a1b00e9c";
                Picasso.get().load(url3).into(imageView3);
                imageView4 =(ImageView) view.findViewById(R.id.imageView_05);
                String url4 = "https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EA%B0%88%EC%83%89%20%ED%8C%A8%EB%94%A9%EC%A1%B0%EB%81%BC.PNG?alt=media&amp;token=ddcb4b2c-3998-4b5c-998a-0b0f38d51364";
                Picasso.get().load(url4).into(imageView4);
                imageView5 =(ImageView) view.findViewById(R.id.imageView_06);
                String url5 = "https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EA%B2%80%EC%A0%95%20%ED%8F%B4%EB%9D%BC%ED%8B%B0.PNG?alt=media&amp;token=f4e91977-43ea-43d7-ac96-0018a5add674";
                Picasso.get().load(url5).into(imageView5);

                //일본 기본
                imageView6 =(ImageView) view.findViewById(R.id.imageView_07);
                String url6 = "https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F1.JPG?alt=media&amp;token=8a0e9a8c-c4dc-4068-835f-ccd5bccd0c92";
                Picasso.get().load(url6).into(imageView6);
                imageView7 =(ImageView) view.findViewById(R.id.imageView_08);
                String url7 = "https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F10.JPG?alt=media&amp;token=8a8429d4-2599-4e57-9611-005897cbebcf";
                Picasso.get().load(url7).into(imageView7);
                imageView8 =(ImageView) view.findViewById(R.id.imageView_09);
                String url8 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F11.JPG?alt=media&amp;token=54ded1be-7a01-4074-a5c5-85046ad23793";
                Picasso.get().load(url8).into(imageView8);


            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(getActivity(), SearchActivity.class);
                    in.putExtra("some", "some data");
                    startActivity(in);
                }

            });

            return view;
        }
    }
}
