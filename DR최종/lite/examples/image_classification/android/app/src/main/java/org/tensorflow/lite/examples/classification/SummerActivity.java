package org.tensorflow.lite.examples.classification;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class SummerActivity extends AccountActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer);


        //한국
        ImageView imageView = findViewById(R.id.sumimage);
        String url = "https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EA%B2%80%EC%A0%95%20%EB%B0%98%EB%B0%94%EC%A7%80%20%EC%A4%84%EB%AC%B4%EB%8A%AC%20%EB%B0%98%ED%8C%94.PNG?alt=media&token=547da3ae-517a-427d-b383-f6661ef55063\n";
        Picasso.get().load(url).into(imageView);

        ImageView imageView1 = findViewById(R.id.sumimage1);
        String url1 = "https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EA%B2%80%EC%A0%95%EC%83%89%20%EC%8A%AC%EB%9E%99%EC%8A%A4%20%ED%9D%B0%ED%8B%B0.PNG?alt=media&token=e5f3a71f-e2d3-4fe7-8139-5c8b46323d8d";
        Picasso.get().load(url1).into(imageView1);

        ImageView imageView2 = findViewById(R.id.sumimage2);
        String url2 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EA%B2%80%EC%A0%95%EC%83%89%ED%8B%B0%20%EB%B2%A0%EC%9D%B4%EC%A7%80%EB%B0%94%EC%A7%80.PNG?alt=media&token=ae96a923-a798-4e16-bd2e-e47c89cfc67d";
        Picasso.get().load(url2).into(imageView2);

        ImageView imageView3 = findViewById(R.id.sumimage3);
        String url3 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EA%B9%85%EC%97%84%EC%B2%B4%ED%81%AC%EC%85%94%EC%B8%A0%20.PNG?alt=media&token=5406c41c-eff2-4fc1-a7b9-db1ff31bd4f8";
        Picasso.get().load(url3).into(imageView3);

        ImageView imageView4 = findViewById(R.id.sumimage4);
        String url4 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EB%8B%A8%EC%B9%B4%EB%9D%BC%EB%B0%98%ED%8C%94%20.PNG?alt=media&token=be8a3135-f8cb-4dbd-87b9-d89360abec8a";
        Picasso.get().load(url4).into(imageView4);

        ImageView imageView5 = findViewById(R.id.sumimage5);
        String url5 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EB%8B%A8%EC%B9%B4%EB%9D%BC%EB%B0%98%ED%8C%94%20.PNG?alt=media&token=be8a3135-f8cb-4dbd-87b9-d89360abec8a";
        Picasso.get().load(url5).into(imageView5);

        ImageView imageView6 = findViewById(R.id.sumimage6);
        String url6 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EC%8A%A4%ED%94%84%EB%9D%BC%EC%9D%B4%ED%8A%B8%EC%8A%AC%EB%9E%99%EC%8A%A4%20.PNG?alt=media&token=2b4a314c-96fe-4144-894e-032fc15b0c64";
        Picasso.get().load(url6).into(imageView6);

        ImageView imageView7 = findViewById(R.id.sumimage7);
        String url7 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EC%8A%AC%EB%9E%99%EC%8A%A4%20%EC%85%94%EC%B8%A0%20.PNG?alt=media&token=efbcaabe-308a-470a-82ca-99a5558e3f15";
        Picasso.get().load(url7).into(imageView7);

        ImageView imageView8 = findViewById(R.id.sumimage8);
        String url8 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EC%8A%AC%EB%9E%99%EC%8A%A4%20%EC%A4%84%EB%AC%B4%EB%8A%AC%20%EB%B0%98%ED%8C%94.PNG?alt=media&token=e8257067-b828-4a8a-8b0e-5e9346c4cbc3";
        Picasso.get().load(url8).into(imageView8);

        ImageView imageView9 = findViewById(R.id.sumimage9);
        String url9 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EC%97%B0%EC%B2%AD%EB%B0%94%EC%A7%80.PNG?alt=media&token=bba69705-f7b5-4d86-9f68-434544e59267";
        Picasso.get().load(url9).into(imageView9);

        ImageView imageView10 = findViewById(R.id.sumimage10);
        String url10 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EC%B2%AD%EB%B0%94%EC%A7%80%20%EB%B0%98%ED%8C%94%EC%85%94%EC%B8%A0.PNG?alt=media&token=44611280-5622-409b-8469-0abbac1a224d";
        Picasso.get().load(url10).into(imageView10);

        ImageView imageView11 = findViewById(R.id.sumimage11);
        String url11 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EC%B2%AD%EB%B0%98%EB%B0%94%EC%A7%80.PNG?alt=media&token=ed7fd2cf-f31f-41fc-b474-3c40fcf09d5b";
        Picasso.get().load(url11).into(imageView11);

        ImageView imageView12 = findViewById(R.id.sumimage12);
        String url12 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%ED%8C%8C%EC%9E%90%EB%A7%88%EC%85%94%EC%B8%A0%20%ED%9A%8C%EC%83%89%20%EC%8A%AC%EB%9E%99%EC%8A%A4.PNG?alt=media&token=68a89166-44bb-4ce0-b508-c704a514238a";
        Picasso.get().load(url12).into(imageView12);

        ImageView imageView13 = findViewById(R.id.sumimage13);
        String url13 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%ED%9A%8C%EC%83%89%20%EC%8A%AC%EB%9E%99%EC%8A%A4%20%EA%B2%80%EC%A0%95%ED%8B%B0.PNG?alt=media&token=429de564-bbcc-4d56-a50a-24d88eecfc7a";
        Picasso.get().load(url13).into(imageView13);

        ImageView imageView14 = findViewById(R.id.sumimage14);
        String url14 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%ED%9D%B0%EC%83%89%20%EB%B0%B4%EB%94%A9%20%EB%B0%94%EC%A7%80%20(2).PNG?alt=media&token=0858d06d-6521-4929-87ad-7e99774f0cb7";
        Picasso.get().load(url14).into(imageView14);

        // 일본
        ImageView imageView15 = findViewById(R.id.sumimage15);
        String url15 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F1.JPG?alt=media&token=17192769-236b-421a-b527-4e4778b96028";
        Picasso.get().load(url15).into(imageView15);

        ImageView imageView16 = findViewById(R.id.sumimage16);
        String url16 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F10.JPG?alt=media&token=848ac346-5d45-46a3-9b63-834c8b667d73";
        Picasso.get().load(url16).into(imageView16);

        ImageView imageView17 = findViewById(R.id.sumimage17);
        String url17 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F11.JPG?alt=media&token=3061021f-731d-418b-8445-cdd613c599ef";
        Picasso.get().load(url17).into(imageView17);

        ImageView imageView18 = findViewById(R.id.sumimage18);
        String url18 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F12.JPG?alt=media&token=88e3b9fc-0a21-4f27-b604-ecd226158adc";
        Picasso.get().load(url18).into(imageView18);

        ImageView imageView19 = findViewById(R.id.sumimage19);
        String url19 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F13.JPG?alt=media&token=37ae5040-37af-485e-91df-88eeb209ce7f";
        Picasso.get().load(url19).into(imageView19);

        ImageView imageView20 = findViewById(R.id.sumimage20);
        String url20 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F14.JPG?alt=media&token=da95cb1d-d22d-420d-8a08-a2df8e374276";
        Picasso.get().load(url20).into(imageView20);

        ImageView imageView21 = findViewById(R.id.sumimage21);
        String url21 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F15.JPG?alt=media&token=6d1e478f-b5ad-4a27-a182-590aa557da0a";
        Picasso.get().load(url21).into(imageView21);

        ImageView imageView22 = findViewById(R.id.sumimage22);
        String url22 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F2.JPG?alt=media&token=704f9af9-e81f-4c92-b9a5-ebea7fb06f9b";
        Picasso.get().load(url22).into(imageView22);

        ImageView imageView23 = findViewById(R.id.sumimage23);
        String url23 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F3.JPG?alt=media&token=98227cbe-3369-4fae-a722-d83a745f1231";
        Picasso.get().load(url23).into(imageView23);

        ImageView imageView24 = findViewById(R.id.sumimage24);
        String url24 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F4.JPG?alt=media&token=fe57ddc8-b09c-4f1c-9ec7-510626415774";
        Picasso.get().load(url24).into(imageView24);

        ImageView imageView25 = findViewById(R.id.sumimage25);
        String url25 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F5.JPG?alt=media&token=5de6ccb6-b579-4433-9594-0a40702867d7";
        Picasso.get().load(url25).into(imageView25);

        ImageView imageView26 = findViewById(R.id.sumimage26);
        String url26 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F6.JPG?alt=media&token=f8e3097c-6976-43bf-8281-b4a34e81461d";
        Picasso.get().load(url26).into(imageView26);

        ImageView imageView27 = findViewById(R.id.sumimage27);
        String url27 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F7.JPG?alt=media&token=dece3e1d-fdd4-47c4-93e3-c1c416404291";
        Picasso.get().load(url27).into(imageView27);

        ImageView imageView28 = findViewById(R.id.sumimage28);
        String url28 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F8.JPG?alt=media&token=a3706562-04da-4a4c-a62b-62f4b602c677";
        Picasso.get().load(url28).into(imageView28);


        ImageView imageView29 = findViewById(R.id.sumimage29);
        String url29 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F9.JPG?alt=media&token=3cb99f77-af08-49cb-aacd-ef4ef6be8a33";
        Picasso.get().load(url29).into(imageView29);

        //영국
        ImageView imageView30 = findViewById(R.id.sumimage30);
        String url30 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F7%EB%B6%80%20%EC%B2%AD%EB%B0%98%EB%B0%94%EC%A7%80.PNG?alt=media&token=8fb3181f-14ca-479f-8869-d10f2b6f7b1e";
        Picasso.get().load(url30).into(imageView30);

        ImageView imageView31 = findViewById(R.id.sumimage31);
        String url31 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EA%B2%80%EC%A0%95%20%EC%B9%B4%EB%9D%BC%ED%8B%B0.PNG?alt=media&token=74a66dfb-d319-4c1a-9958-3e1da2e0c08d";
        Picasso.get().load(url31).into(imageView31);

        ImageView imageView32 = findViewById(R.id.sumimage32);
        String url32 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EA%B2%80%EC%A0%95%ED%8B%B0.PNG?alt=media&token=d6f08f1c-ac0b-4dd1-93cd-3c820b366b87";
        Picasso.get().load(url32).into(imageView32);

        ImageView imageView33 = findViewById(R.id.sumimage33);
        String url33 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EB%84%A4%EC%9D%B4%EB%B9%84%20%EC%85%94%EC%B8%A0.PNG?alt=media&token=1b2d389f-698a-4990-93e7-17588712511c";
        Picasso.get().load(url33).into(imageView33);

        ImageView imageView34 = findViewById(R.id.sumimage34);
        String url34 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EB%AA%A8%EB%82%98%EB%AF%B8.PNG?alt=media&token=8e8b7c85-463a-4445-9771-8847c9ddc3a4";
        Picasso.get().load(url34).into(imageView34);

        ImageView imageView35 = findViewById(R.id.sumimage35);
        String url35 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EB%B0%98%EB%B0%94%EC%A7%80%20%EC%B2%AD%EC%9E%90%EC%BC%93.PNG?alt=media&token=702bbd7e-9e0a-4509-9ac8-1ae59f6bc5fd";
        Picasso.get().load(url35).into(imageView35);

        ImageView imageView36 = findViewById(R.id.sumimage36);
        String url36 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EB%B6%84%ED%99%8D%EB%B0%94%EC%A7%80.PNG?alt=media&token=3afa21a0-cd34-45fb-a46b-e9bb9ed1a5cd";
        Picasso.get().load(url36).into(imageView36);

        ImageView imageView37 = findViewById(R.id.sumimage37);
        String url37 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EC%8A%A4%ED%94%84%EB%9D%BC%EC%9D%B4%ED%8A%B8%20%EC%85%94%EC%B8%A0.PNG?alt=media&token=cf6964d3-e797-43bf-a330-c0ad34d09585";
        Picasso.get().load(url37).into(imageView37);

        ImageView imageView38 = findViewById(R.id.sumimage38);
        String url38 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EC%97%B0%EC%B0%A2%EC%B2%AD.PNG?alt=media&token=69252f07-6808-42e3-83ae-fe81775253c3";
        Picasso.get().load(url38).into(imageView38);

        ImageView imageView39 = findViewById(R.id.sumimage39);
        String url39 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EC%A0%95%EC%9E%A5%20%EB%B0%98%EB%B0%94%EC%A7%80.PNG?alt=media&token=58f98c80-3178-4907-9036-0e8f96baafc9";
        Picasso.get().load(url39).into(imageView39);

        ImageView imageView40 = findViewById(R.id.sumimage40);
        String url40 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EC%B2%AD%EC%B2%AD%ED%8C%8C%EC%85%98.PNG?alt=media&token=f0ac1e26-faa3-40b9-b9ae-b21e47a418db";
        Picasso.get().load(url40).into(imageView40);

        ImageView imageView41 = findViewById(R.id.sumimage41);
        String url41 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EC%B9%B4%ED%82%A4%EB%B0%94%EC%A7%80%EC%85%94%EC%B8%A0.PNG?alt=media&token=2bfabda4-cd1a-4e69-a94f-39b368ad805a";
        Picasso.get().load(url41).into(imageView41);

        ImageView imageView42 = findViewById(R.id.sumimage42);
        String url42 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%ED%95%98%EB%8A%98%20%EC%85%94%EC%B8%A0%20%EB%84%A4%EC%9D%B4%EB%B9%84%20%EB%B0%94%EC%A7%80.PNG?alt=media&token=f9502d26-3edd-4913-9eba-8eb18a5477c7";
        Picasso.get().load(url42).into(imageView42);

        ImageView imageView43 = findViewById(R.id.sumimage43);
        String url43 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%ED%9D%B0%EB%B0%98%EB%B0%94%EC%A7%80%20%EC%85%94%EC%B8%A0.PNG?alt=media&token=136b8f0c-f32c-4a89-adfd-3e137d078b9c";
        Picasso.get().load(url43).into(imageView43);

        ImageView imageView44 = findViewById(R.id.sumimage44);
        String url44 ="https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EC%8A%A4%ED%94%84%EB%9D%BC%EC%9D%B4%ED%8A%B8%20%EB%B0%98%ED%8C%94.PNG?alt=media&token=906cf10f-1985-46b4-b3ae-b1f97580721d";
        Picasso.get().load(url44).into(imageView44);



    }
}

