package org.tensorflow.lite.examples.classification;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;

import android.widget.ImageView;
import android.widget.TextView;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.InputType;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import org.tensorflow.lite.examples.classification.API.API;
import org.tensorflow.lite.examples.classification.API.APIService.WeatherServices;
import org.tensorflow.lite.examples.classification.activities.WeatherDetails;
import org.tensorflow.lite.examples.classification.adapters.CityWeatherAdapter;
import org.tensorflow.lite.examples.classification.interfaces.onSwipeListener;
import org.tensorflow.lite.examples.classification.models.CityWeather;
import org.tensorflow.lite.examples.classification.utils.ItemTouchHelperCallback;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

public class MainActivity extends AppCompatActivity {
    private static final  String TAG = "MainActivity";
    Random r;
    //한국
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    //영국
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    //일본
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;


private List<CityWeather> cities;
    @BindView(R.id.recyclerViewWeatherCards) RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @BindView(R.id.swipeRefresh) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.fabAddCity) FloatingActionButton fabAddCity ;
    private WeatherServices weatherServices;
    private MaterialTapTargetPrompt mFabPrompt;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);




        cities = getCities();


        weatherServices = API.getApi().create(WeatherServices.class);

        layoutManager = new LinearLayoutManager(this);
        adapter = new CityWeatherAdapter(cities, R.layout.weather_card, this, new CityWeatherAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CityWeather cityWeather, int position, View clickView) {
                Intent intent = new Intent(MainActivity.this, WeatherDetails.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        MainActivity.this,clickView,
                        "weatherCardTransition");

                intent.putExtra("city",  cityWeather);
                startActivity(intent,options.toBundle());
            }
        });



        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy >0) {
                    // Scroll Down
                    if (fabAddCity.isShown()) {
                        fabAddCity.hide();
                    }
                }
                else if (dy <0) {
                    // Scroll Up
                    if (!fabAddCity.isShown()) {
                        fabAddCity.show();
                    }
                }
            }
        });

        fabAddCity.setOnClickListener(view -> {
            showAlertAddCity("Add city","Type the city you want to add");
        });

        swipeRefreshLayout.setColorSchemeResources(R.color.google_blue, R.color.google_green, R.color.google_red, R.color.google_yellow);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            refreshData();
        });
        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback((onSwipeListener) adapter);
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }



    public void recyclerScrollTo(int pos){
        recyclerView.scrollToPosition(pos);
    }


    private void refreshData() {
        for (int i = 0; i < cities.size(); i++) {
            updateCity(cities.get(i).getCity().getName(), i);
            System.out.println("CIUDAD #"+i);
        }
        System.out.println("TERMINE EL REFREHS!!!!");
        swipeRefreshLayout.setRefreshing(false);
    }

    private String cityToAdd ="";
    public void showAlertAddCity(String title, String message){
        AlertDialog.Builder mbuilder = new AlertDialog.Builder(this);
        if(title!=null) mbuilder.setTitle(title);
        if(message!=null) mbuilder.setMessage(message);
        final View view = LayoutInflater.from(this).inflate(R.layout.dialog_add_city,null);
        mbuilder.setView(view);
        final TextView editTextAddCityName = view.findViewById(R.id.editTextAddCityName);
        Bundle intent = getIntent().getExtras();
        editTextAddCityName.setText(intent.getString("address"));
        final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

        mbuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                cityToAdd = editTextAddCityName.getText().toString();
                addCity(cityToAdd);
                imm.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS,0);
            }
        });
        mbuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.cancel();
                imm.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS,0);
                Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_LONG).show();
            }
        });
        final AlertDialog dialog= mbuilder.create();
        dialog.show();
    }
    public void updateCity(String cityName, int index){
        Call<CityWeather> cityWeather = weatherServices.getWeatherCity(cityName, API.KEY, "metric",6);
        cityWeather.enqueue(new Callback<CityWeather>() {
            @Override
            public void onResponse(Call<CityWeather> call, Response<CityWeather> response) {
                if(response.code()==200){
                    CityWeather cityWeather = response.body();
                    cities.remove(index);
                    cities.add(index,cityWeather);
                    adapter.notifyItemChanged(index);
                }
            }

            @Override
            public void onFailure(Call<CityWeather> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Sorry, can't refresh right now.",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void addCity(String cityName){
        //한국 봄 옷
        List<String> urlImage = new ArrayList<String>();
        urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2FCardigan.PNG?alt=media&token=7971b062-a7e5-403e-ab53-f32686867b78");
        urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EA%B0%80%EC%A3%BD%EC%9E%90%EC%BC%93.PNG?alt=media&token=721f4ca6-61dc-45ae-ba29-51498cb4f2c5");
        urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EA%B2%80%EC%A0%95%EC%83%89%20%EA%B0%80%EB%94%94%EA%B1%B41.PNG?alt=media&token=e45b9a96-8d5e-4af4-aaed-123f3323b959");
        urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EA%B2%80%EC%A0%95%EC%83%89%ED%8B%B0%20%EB%B2%A0%EC%9D%B4%EC%A7%80%EB%B0%94%EC%A7%801.PNG?alt=media&token=788524b9-164a-4494-a5b3-ee38b34b1ad5");
        urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EA%B2%80%EC%A0%95%EC%9E%90%EC%BC%931.PNG?alt=media&token=cfa33c06-2e8f-4430-82f6-67548f8c400c");
        urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EA%B2%80%EC%A0%95%EC%9E%90%EC%BC%931.PNG?alt=media&token=cfa33c06-2e8f-4430-82f6-67548f8c400c");
        urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%84%A4%EC%9D%B4%EB%B9%84%20%ED%8A%B8%EB%A0%8C%EC%B9%98%EC%BD%94%ED%8A%B81.PNG?alt=media&token=f39e0def-24f5-4659-bb00-7ec9517abc04");
        urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%85%B9%EC%83%89%EB%A7%A8%ED%88%AC%EB%A7%A81.PNG?alt=media&token=7d049315-bfc4-4d63-b903-c932646499de");
        urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%8B%88%ED%8A%B8%EC%A1%B0%EB%81%BC.PNG?alt=media&token=4146442c-b22b-4d26-a668-796fc07884e4");
        urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%8D%B0%EC%9D%BC%EB%A6%AC%20%EC%9E%90%EC%BC%93.PNG?alt=media&token=8f94bdac-8c36-4b93-9a24-2eecbb9295ce");
        List<String> urlImage1 = new ArrayList<String>();
        urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%A1%B1%EA%B0%80%EB%94%94%EA%B1%B4.PNG?alt=media&amp;token=63d6dfa6-ee9c-43cd-8a18-41b93d4ad27f");
        urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%A1%B1%EA%B0%80%EB%94%94%EA%B1%B41.PNG?alt=media&amp;token=4ec2c413-479e-447c-9752-6782d37a3a21");
        urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%A3%A8%EC%A6%88%ED%95%8F%20%EB%A7%A8%ED%88%AC%EB%A7%A8.PNG?alt=media&amp;token=2990c995-10e9-49ae-915b-9f688e29401f");
        urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%A7%A8%ED%88%AC%EB%A7%A8.PNG?alt=media&amp;token=5fcee143-a80e-44ff-abb7-55d72d301dae");
        urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%A7%A8%ED%88%AC%EB%A7%A81.PNG?alt=media&amp;token=7235c886-6429-45a2-9f84-269379830698");
        urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%B8%8C%EC%9D%B4%EB%84%A5%20%EB%8B%88%ED%8A%B8.PNG?alt=media&amp;token=bb97136a-487d-45f6-9210-6db72f19fec6");
        urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%B8%8C%EC%9D%B4%EB%84%A5%20%EB%A7%A8%ED%88%AC%EB%A7%A8.PNG?alt=media&amp;token=775d4add-887a-43c0-8a98-b20c88c0ee25");
        urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EC%8A%A4%ED%94%84%EB%9D%BC%EC%9D%B4%ED%8A%B8%20%EB%8B%88%ED%8A%B8.PNG?alt=media&amp;token=1bf32775-a15a-4b1b-8a7a-7c74846ba9e5");
        urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EC%96%91%ED%84%B8%EC%9E%90%EC%BC%931.PNG?alt=media&amp;token=d1a4d538-e9e8-4ec5-9051-616748c2f4ec");
        urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EC%9E%90%EC%BC%93.PNG?alt=media&amp;token=0170c1cd-ab71-4088-8578-3e861d60b523");
        List<String> urlImage2 = new ArrayList<String>();
        urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EC%9E%90%EC%BC%931.PNG?alt=media&amp;token=e05edd01-8957-4598-9d5f-38d1b404b165");
        urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EC%B2%AD%EC%9E%90%EC%BC%93%20%ED%9B%84%EB%93%9C1.PNG?alt=media&amp;token=3b471ebf-4ab0-4b1d-bc0e-fdb7f4304437");
        urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EC%B2%AD%EC%B2%AD%20%ED%8C%8C%EC%88%80.PNG?alt=media&amp;token=48cabc99-7727-4b90-80c4-a4f095f09bc1");
        urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EC%B2%B4%ED%81%AC%EB%82%A8%EB%B0%A91.PNG?alt=media&amp;token=44262985-e14b-4558-b950-8edec8cff30f");
        urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%ED%8A%B8%EB%A0%8C%EC%B9%98%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=d4a78863-5379-42c4-80ec-b4f84afc8f99");
        urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%ED%8A%B8%EB%A0%8C%EC%B9%98%EC%BD%94%ED%8A%B81.PNG?alt=media&amp;token=2eee56a4-8927-4427-a377-70bade85f268");
        urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%ED%8C%A8%EB%94%A9%EC%A1%B0%EB%81%BC1.PNG?alt=media&amp;token=b9f50334-8a25-4faa-aab2-69751e70929a");
        urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%ED%95%AD%EA%B3%B5%EC%A0%90%ED%8D%BC.PNG?alt=media&amp;token=f703bc18-de27-469a-91fa-e50414e9f2f3");
        urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%ED%9B%84%EB%91%90%ED%8B%B0.PNG?alt=media&amp;token=324b95aa-14e5-4149-ad8b-313847146386");
        urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%ED%9B%84%EB%93%9C%ED%8B%B01.PNG?alt=media&amp;token=61d4ab1c-ca78-4c37-9571-61276761b6a2");
        //영국 봄 옷
        List<String> urlImage3 = new ArrayList<String>();
        urlImage3.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EA%B0%80%EC%A3%BD%EC%9E%90%EC%BC%93.PNG?alt=media&amp;token=c3f85231-b64d-442d-a4f8-f616a1b00e9c");
        urlImage3.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EA%B0%88%EC%83%89%20%ED%8C%A8%EB%94%A9%EC%A1%B0%EB%81%BC.PNG?alt=media&amp;token=ddcb4b2c-3998-4b5c-998a-0b0f38d51364");
        urlImage3.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EA%B2%80%EC%A0%95%20%ED%8F%B4%EB%9D%BC%ED%8B%B0.PNG?alt=media&amp;token=f4e91977-43ea-43d7-ac96-0018a5add674");
        urlImage3.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EA%B2%80%EC%A0%95%EC%BD%94%ED%8A%B8%20%EB%8B%88%ED%8A%B8.PNG?alt=media&amp;token=4052a052-6eab-45be-87aa-0b1826d2410f");
        urlImage3.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EA%B7%B8%EB%A0%88%EC%9D%B4%20%EB%8B%88%ED%8A%B8.PNG?alt=media&amp;token=2e35e6a8-2b44-47f5-afea-7f52c868be1f");
        urlImage3.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EB%84%A4%EC%9D%B4%EB%B9%84%20%EA%B0%80%EB%94%94%EA%B1%B4.PNG?alt=media&amp;token=1450d427-c6a1-41df-8881-e9382c745523");
        urlImage3.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EB%84%A4%EC%9D%B4%EB%B9%84%20%EC%9E%90%EC%BC%93.PNG?alt=media&amp;token=64befed7-2cd6-45c9-a8fe-ec0b69612f3c");
        urlImage3.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EB%84%A4%EC%9D%B4%EB%B9%84%20%EC%A0%95%EC%9E%A5.PNG?alt=media&amp;token=03e4f829-d0c0-459e-a9ff-0b401918fb68");
        urlImage3.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EB%84%A4%EC%9D%B4%EB%B9%84%20%EC%A1%B0%EB%81%BC.PNG?alt=media&amp;token=d9218d86-52e1-4982-87f7-778ea9e74f0f");
        urlImage3.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EB%84%A4%EC%9D%B4%EB%B9%84%20%ED%8A%B8%EB%A0%8C%EC%B9%98%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=afb531cc-ad55-4ee6-bcec-56249b148b3c");
        List<String> urlImage4 = new ArrayList<String>();
        urlImage4.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EB%9D%BC%EC%9D%B4%EB%8D%94%EC%9E%90%EC%BC%93.PNG?alt=media&amp;token=9a450190-eb22-47d9-8552-b15ece984e95");
        urlImage4.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EB%A7%A8%ED%88%AC%EB%A7%A8.PNG?alt=media&amp;token=5ceec216-9478-4447-a210-e309122564c1");
        urlImage4.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EB%B2%A0%EC%9D%B4%EC%A7%80%20%EC%9E%90%EC%BC%93.PNG?alt=media&amp;token=35146cb8-99bc-4e80-9871-b351ded30ced");
        urlImage4.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EB%B2%A0%EC%9D%B4%EC%A7%80%20%EC%B2%B4%ED%81%AC%EB%82%A8%EB%B0%A9.PNG?alt=media&amp;token=e8959b18-8d95-4ea0-ba51-055dda58a969");
        urlImage4.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EB%B2%A0%EC%9D%B4%EC%A7%80%20%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=992df777-4be5-48ec-8555-73600e6c8e42");
        urlImage4.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EB%B8%8C%EB%A6%AD%EC%BB%AC%EB%9F%AC%20%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=a61eeacf-91a1-4840-b38c-7dd82fb4f158");
        urlImage4.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EC%82%AC%ED%8C%8C%EB%A6%AC%20%EC%A0%90%ED%8D%BC.PNG?alt=media&amp;token=0966a325-a118-4ddd-9c13-62df6e8d9ee2");
        urlImage4.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EC%85%94%EC%B8%A0%20%EB%84%A4%EC%9D%B4%EB%B9%84%20%EC%8A%AC%EB%9E%99%EC%8A%A4.PNG?alt=media&amp;token=879178b3-a8ee-4cdf-a018-c3769e07ffdb");
        urlImage4.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EC%8A%A4%EC%9B%A8%ED%84%B0.PNG?alt=media&amp;token=598c6256-5ae6-404f-abe5-adb566343533");
        urlImage4.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EC%95%BC%EC%83%81.PNG?alt=media&amp;token=5349f919-ac26-439c-a084-528aab3ea8a9");
        List<String> urlImage5 = new ArrayList<String>();
        urlImage5.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EC%A4%84%EB%AC%B4%EB%8A%AC%20%EA%B0%80%EB%94%94%EA%B1%B4.PNG?alt=media&amp;token=4c388df3-76ee-4699-9a32-3f656a2c1122");
        urlImage5.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EC%B2%AD%EC%B2%AD%ED%8C%8C%EC%88%80.PNG?alt=media&amp;token=e6f06596-00fa-40a5-9be0-7a5370892712");
        urlImage5.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EC%B2%B4%ED%81%AC%20%EC%A0%95%EC%9E%A5.PNG?alt=media&amp;token=ab2c0702-ef1e-4bb6-8960-17aaf17adcbe");
        urlImage5.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%EC%B2%B4%ED%81%AC%20%EC%A1%B0%EB%81%BC.PNG?alt=media&amp;token=d99204d5-fb7e-4b98-bc15-6aac4501b62c");
        urlImage5.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%ED%8A%B8%EB%A0%8C%EC%B9%98%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=59820785-80bb-41bb-9e07-5369212a4432");
        urlImage5.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%ED%95%98%EB%8A%98%20%EA%B0%80%EB%94%94%EA%B1%B4.PNG?alt=media&amp;token=24fca748-0354-4b8f-aca9-cd62c5f6f22d");
        urlImage5.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%ED%95%98%EB%8A%98%20%EB%A7%A8%ED%88%AC%EB%A7%A8.PNG?alt=media&amp;token=1be8a78f-c7e5-4549-9bbc-3fc308b79a1e");
        urlImage5.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%ED%9A%8C%EC%83%89%20%EC%9E%90%EC%BC%93.PNG?alt=media&amp;token=091133e4-dcca-4ba9-bb00-2b4fc4c1c4ca");
        urlImage5.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%ED%9B%84%EB%93%9C%EC%9E%90%EC%BC%93.PNG?alt=media&amp;token=4b878296-0669-4cbb-9f1d-c36fede0296e");
        urlImage5.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2Fspring%2F%ED%9D%B0%EC%85%94%EC%B8%A0.PNG?alt=media&amp;token=48f0d7b6-5b05-47b2-8d48-a598af08a752");
        //일본 봄 옷
        List<String> urlImage6 = new ArrayList<String>();
        urlImage6.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F1.JPG?alt=media&amp;token=8a0e9a8c-c4dc-4068-835f-ccd5bccd0c92");
        urlImage6.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F10.JPG?alt=media&amp;token=8a8429d4-2599-4e57-9611-005897cbebcf");
        urlImage6.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F11.JPG?alt=media&amp;token=54ded1be-7a01-4074-a5c5-85046ad23793");
        urlImage6.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F12.JPG?alt=media&amp;token=74348af8-f6f8-46dd-8f90-3e83dda454d4");
        urlImage6.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F13.JPG?alt=media&amp;token=061e9e4d-66e6-47f6-80ec-c3a27b023cf5");
        urlImage6.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F14.JPG?alt=media&amp;token=8ba2949c-3090-4810-866c-871eb9dc29b3");
        urlImage6.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F15.JPG?alt=media&amp;token=a0563791-3b59-4a2a-b77d-462b7627c5c4");
        urlImage6.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F16.JPG?alt=media&amp;token=d2d6fab9-d000-463b-ae74-a35949fb67a6");
        urlImage6.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F17.JPG?alt=media&amp;token=01593a50-0053-4898-93c3-b46a938a5b76");
        urlImage6.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F18.JPG?alt=media&amp;token=0fae5318-0dee-4933-a83a-148fd25ad8a5");
        List<String> urlImage7 = new ArrayList<String>();
        urlImage7.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F19.JPG?alt=media&amp;token=328350b3-dcc7-4faf-ad07-4b40e25a278a");
        urlImage7.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F2.JPG?alt=media&amp;token=fdf16925-7488-41f3-838e-6395a244108e");
        urlImage7.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F20.JPG?alt=media&amp;token=318a391c-1748-454a-b102-adf44c410d25");
        urlImage7.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F21.JPG?alt=media&amp;token=fc62054a-22c3-4a6e-b9db-d46ba3100f18");
        urlImage7.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F22.JPG?alt=media&amp;token=b122f047-c726-4fc6-9aaa-83121c2bd8be");
        urlImage7.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F23.JPG?alt=media&amp;token=0f660865-ed5a-4ba4-91b7-f4f2d3976aa6");
        urlImage7.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F24.JPG?alt=media&amp;token=7b639197-fa41-4d98-b075-0a09939b3ddd");
        urlImage7.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F25.JPG?alt=media&amp;token=da60c09f-0886-4e5b-9941-7f3cca121ced");
        urlImage7.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F26.JPG?alt=media&amp;token=9a86457c-5866-4458-a69f-d97bcd49be8b");
        urlImage7.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F27.JPG?alt=media&amp;token=0a8c0cca-ff52-4ae0-8a7f-827d918792e0");
        List<String> urlImage8 = new ArrayList<String>();
        urlImage8.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F28.JPG?alt=media&amp;token=b77258ca-2fa1-4fff-967f-ef3086a2dcc2");
        urlImage8.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F29.JPG?alt=media&amp;token=ac8393db-4b45-4b30-a238-29cad56ce519");
        urlImage8.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F3.JPG?alt=media&amp;token=914d0369-040e-4a9c-95d6-3de61da10150");
        urlImage8.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F30.JPG?alt=media&amp;token=a7718c37-6803-4e22-95db-94a715b7d118");
        urlImage8.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F4.JPG?alt=media&amp;token=d50a3bfb-1780-4aee-b253-1e945fe7ee67");
        urlImage8.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F5.JPG?alt=media&amp;token=1fa8406e-b9e0-4137-b896-4f62a3808025");
        urlImage8.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F6.JPG?alt=media&amp;token=5e140934-22e9-4be0-87dd-b44d4a8cd1a1");
        urlImage8.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F7.JPG?alt=media&amp;token=d683bf47-c288-4495-89ef-73cdda383c8f");
        urlImage8.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F8.JPG?alt=media&amp;token=aff68269-291f-418b-9c09-9f4df918d5ba");
        urlImage8.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2Fspring%2F9.JPG?alt=media&amp;token=79782f2d-006c-4bd0-8744-f06b5dee4d94");
        //한국 여름 옷
        List<String> urlImage9 = new ArrayList<String>();
        urlImage9.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EA%B2%80%EC%A0%95%20%EB%B0%98%EB%B0%94%EC%A7%80%20%EC%A4%84%EB%AC%B4%EB%8A%AC%20%EB%B0%98%ED%8C%94.PNG?alt=media&token=547da3ae-517a-427d-b383-f6661ef55063\\n");
        urlImage9.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EA%B2%80%EC%A0%95%EC%83%89%20%EC%8A%AC%EB%9E%99%EC%8A%A4%20%ED%9D%B0%ED%8B%B0.PNG?alt=media&token=e5f3a71f-e2d3-4fe7-8139-5c8b46323d8d");
        urlImage9.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EA%B2%80%EC%A0%95%EC%83%89%ED%8B%B0%20%EB%B2%A0%EC%9D%B4%EC%A7%80%EB%B0%94%EC%A7%80.PNG?alt=media&token=ae96a923-a798-4e16-bd2e-e47c89cfc67d");
        urlImage9.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EA%B9%85%EC%97%84%EC%B2%B4%ED%81%AC%EC%85%94%EC%B8%A0%20.PNG?alt=media&token=5406c41c-eff2-4fc1-a7b9-db1ff31bd4f8");
        urlImage9.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EB%8B%A8%EC%B9%B4%EB%9D%BC%EB%B0%98%ED%8C%94%20.PNG?alt=media&token=be8a3135-f8cb-4dbd-87b9-d89360abec8a");
        List<String> urlImage10 = new ArrayList<String>();
        urlImage10.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EB%8B%A8%EC%B9%B4%EB%9D%BC%EB%B0%98%ED%8C%94%20.PNG?alt=media&token=be8a3135-f8cb-4dbd-87b9-d89360abec8a");
        urlImage10.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EC%8A%A4%ED%94%84%EB%9D%BC%EC%9D%B4%ED%8A%B8%EC%8A%AC%EB%9E%99%EC%8A%A4%20.PNG?alt=media&token=2b4a314c-96fe-4144-894e-032fc15b0c64");
        urlImage10.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EC%8A%AC%EB%9E%99%EC%8A%A4%20%EC%85%94%EC%B8%A0%20.PNG?alt=media&token=efbcaabe-308a-470a-82ca-99a5558e3f15");
        urlImage10.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EC%8A%AC%EB%9E%99%EC%8A%A4%20%EC%A4%84%EB%AC%B4%EB%8A%AC%20%EB%B0%98%ED%8C%94.PNG?alt=media&token=e8257067-b828-4a8a-8b0e-5e9346c4cbc3");
        urlImage10.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EC%97%B0%EC%B2%AD%EB%B0%94%EC%A7%80.PNG?alt=media&token=bba69705-f7b5-4d86-9f68-434544e59267");
        List<String> urlImage11 = new ArrayList<String>();
        urlImage11.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EC%B2%AD%EB%B0%94%EC%A7%80%20%EB%B0%98%ED%8C%94%EC%85%94%EC%B8%A0.PNG?alt=media&token=44611280-5622-409b-8469-0abbac1a224d");
        urlImage11.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%EC%B2%AD%EB%B0%98%EB%B0%94%EC%A7%80.PNG?alt=media&token=ed7fd2cf-f31f-41fc-b474-3c40fcf09d5b");
        urlImage11.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%ED%8C%8C%EC%9E%90%EB%A7%88%EC%85%94%EC%B8%A0%20%ED%9A%8C%EC%83%89%20%EC%8A%AC%EB%9E%99%EC%8A%A4.PNG?alt=media&token=68a89166-44bb-4ce0-b508-c704a514238a");
        urlImage11.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%ED%9A%8C%EC%83%89%20%EC%8A%AC%EB%9E%99%EC%8A%A4%20%EA%B2%80%EC%A0%95%ED%8B%B0.PNG?alt=media&token=429de564-bbcc-4d56-a50a-24d88eecfc7a");
        urlImage11.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FSummer%2F%ED%9D%B0%EC%83%89%20%EB%B0%B4%EB%94%A9%20%EB%B0%94%EC%A7%80%20(2).PNG?alt=media&token=0858d06d-6521-4929-87ad-7e99774f0cb7");
        //영국 여름 옷
        List<String> urlImage12 = new ArrayList<String>();
        urlImage12.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F7%EB%B6%80%20%EC%B2%AD%EB%B0%98%EB%B0%94%EC%A7%80.PNG?alt=media&token=8fb3181f-14ca-479f-8869-d10f2b6f7b1e");
        urlImage12.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EA%B2%80%EC%A0%95%20%EC%B9%B4%EB%9D%BC%ED%8B%B0.PNG?alt=media&token=74a66dfb-d319-4c1a-9958-3e1da2e0c08d");
        urlImage12.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EA%B2%80%EC%A0%95%ED%8B%B0.PNG?alt=media&token=d6f08f1c-ac0b-4dd1-93cd-3c820b366b87");
        urlImage12.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EB%84%A4%EC%9D%B4%EB%B9%84%20%EC%85%94%EC%B8%A0.PNG?alt=media&token=1b2d389f-698a-4990-93e7-17588712511c");
        urlImage12.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EB%AA%A8%EB%82%98%EB%AF%B8.PNG?alt=media&token=8e8b7c85-463a-4445-9771-8847c9ddc3a4");
        List<String> urlImage13 = new ArrayList<String>();
        urlImage13.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EB%B0%98%EB%B0%94%EC%A7%80%20%EC%B2%AD%EC%9E%90%EC%BC%93.PNG?alt=media&token=702bbd7e-9e0a-4509-9ac8-1ae59f6bc5fd");
        urlImage13.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EB%B6%84%ED%99%8D%EB%B0%94%EC%A7%80.PNG?alt=media&token=3afa21a0-cd34-45fb-a46b-e9bb9ed1a5cd");
        urlImage13.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EC%8A%A4%ED%94%84%EB%9D%BC%EC%9D%B4%ED%8A%B8%20%EC%85%94%EC%B8%A0.PNG?alt=media&token=cf6964d3-e797-43bf-a330-c0ad34d09585");
        urlImage13.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EC%97%B0%EC%B0%A2%EC%B2%AD.PNG?alt=media&token=69252f07-6808-42e3-83ae-fe81775253c3");
        urlImage13.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EC%A0%95%EC%9E%A5%20%EB%B0%98%EB%B0%94%EC%A7%80.PNG?alt=media&token=58f98c80-3178-4907-9036-0e8f96baafc9");
        List<String> urlImage14 = new ArrayList<String>();
        urlImage14.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EC%B2%AD%EC%B2%AD%ED%8C%8C%EC%85%98.PNG?alt=media&token=f0ac1e26-faa3-40b9-b9ae-b21e47a418db");
        urlImage14.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EC%B9%B4%ED%82%A4%EB%B0%94%EC%A7%80%EC%85%94%EC%B8%A0.PNG?alt=media&token=2bfabda4-cd1a-4e69-a94f-39b368ad805a");
        urlImage14.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%ED%95%98%EB%8A%98%20%EC%85%94%EC%B8%A0%20%EB%84%A4%EC%9D%B4%EB%B9%84%20%EB%B0%94%EC%A7%80.PNG?alt=media&token=f9502d26-3edd-4913-9eba-8eb18a5477c7");
        urlImage14.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%ED%9D%B0%EB%B0%98%EB%B0%94%EC%A7%80%20%EC%85%94%EC%B8%A0.PNG?alt=media&token=136b8f0c-f32c-4a89-adfd-3e137d078b9c");
        urlImage14.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FSummer%2F%EC%8A%A4%ED%94%84%EB%9D%BC%EC%9D%B4%ED%8A%B8%20%EB%B0%98%ED%8C%94.PNG?alt=media&token=906cf10f-1985-46b4-b3ae-b1f97580721d");
        //일본 여름 옷
        List<String> urlImage15 = new ArrayList<String>();
        urlImage15.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F1.JPG?alt=media&token=17192769-236b-421a-b527-4e4778b96028");
        urlImage15.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F10.JPG?alt=media&token=848ac346-5d45-46a3-9b63-834c8b667d73");
        urlImage15.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F11.JPG?alt=media&token=3061021f-731d-418b-8445-cdd613c599ef");
        urlImage15.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F12.JPG?alt=media&token=88e3b9fc-0a21-4f27-b604-ecd226158adc");
        urlImage15.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F13.JPG?alt=media&token=37ae5040-37af-485e-91df-88eeb209ce7f");
        List<String> urlImage16 = new ArrayList<String>();
        urlImage16.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F14.JPG?alt=media&token=da95cb1d-d22d-420d-8a08-a2df8e374276");
        urlImage16.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F15.JPG?alt=media&token=6d1e478f-b5ad-4a27-a182-590aa557da0a");
        urlImage16.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F2.JPG?alt=media&token=704f9af9-e81f-4c92-b9a5-ebea7fb06f9b");
        urlImage16.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F3.JPG?alt=media&token=98227cbe-3369-4fae-a722-d83a745f1231");
        urlImage16.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F4.JPG?alt=media&token=fe57ddc8-b09c-4f1c-9ec7-510626415774");
        List<String> urlImage17 = new ArrayList<String>();
        urlImage17.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F5.JPG?alt=media&token=5de6ccb6-b579-4433-9594-0a40702867d7");
        urlImage17.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F6.JPG?alt=media&token=f8e3097c-6976-43bf-8281-b4a34e81461d");
        urlImage17.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F7.JPG?alt=media&token=dece3e1d-fdd4-47c4-93e3-c1c416404291");
        urlImage17.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F8.JPG?alt=media&token=a3706562-04da-4a4c-a62b-62f4b602c677");
        urlImage17.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FSummer%2F9.JPG?alt=media&token=3cb99f77-af08-49cb-aacd-ef4ef6be8a33");
       //한국 겨울 옷
        List<String> urlImage18 = new ArrayList<String>();
        urlImage18.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%EA%B2%80%EC%A0%95%20%EB%A1%B1%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=b3542de9-c1cc-4543-a811-51626b1ac79c");
        urlImage18.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%EA%B3%A4%EC%83%89%20%EB%A1%B1%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=7cce1ab4-6cfb-41fa-a176-ccf7a5abb9ce");
        urlImage18.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%EA%BD%88%EB%B0%B0%EA%B8%B0%20%EB%8B%88%ED%8A%B8.PNG?alt=media&amp;token=5a3512c1-aebf-4e82-9ba7-6848e129b515");
        urlImage18.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%EB%8B%88%ED%8A%B8.PNG?alt=media&amp;token=f4afd437-0f3d-42e2-b8c8-38c52352e982");
        urlImage18.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%EB%A1%B1%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=61720a6a-ac12-4b9f-9c28-d9282df9a2a2");
        List<String> urlImage19 = new ArrayList<String>();
        urlImage19.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%EB%A1%B1%ED%8C%A8%EB%94%A9.PNG?alt=media&amp;token=52f81df5-0906-41b7-99aa-33bd8367322");
        urlImage19.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%EB%A1%B1%ED%9B%84%EB%93%9C%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=9a699490-848e-4231-ad09-852d446460d6");
        urlImage19.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%EB%AA%A8%EC%A7%81%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=c8d3a527-b4c9-48d4-b374-717b63aae1c6");
        urlImage19.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%EB%B8%8C%EB%9D%BC%EC%9A%B4%20%EB%A1%B1%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=73dc9b2b-bfa2-4283-aa6f-37c81ec57f83");
        urlImage19.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%EC%96%91%ED%84%B8%20%EB%A1%B1%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=cb8a46e4-a873-45d5-8619-9a153b9afd14");
        List<String> urlImage20 = new ArrayList<String>();
        urlImage20.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%EC%96%91%ED%84%B8%20%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=a613792e-2661-47c3-904f-8f9ea41f872d");
        urlImage20.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%EC%96%91%ED%84%B8%EC%95%BC%EC%83%81.PNG?alt=media&amp;token=08215e23-f4fa-438f-9ea7-8d11df1ef5c5");
        urlImage20.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%EC%9A%B8%20%EC%8B%B1%EA%B8%80%20%EC%98%A4%EB%B2%84%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=dcff6b56-0c92-4dc3-9ffd-4207bd17c37a");
        urlImage20.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%ED%95%98%EB%8A%98%EC%83%89%20%EB%8B%88%ED%8A%B8.PNG?alt=media&amp;token=46a69462-8cc7-418a-acfa-a70780352209");
        urlImage20.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2FWinter%2F%ED%95%98%EC%9D%B4%EB%84%A5%20%EC%96%91%ED%84%B8%20%EC%88%8F%EB%AC%B4%EC%8A%A4%ED%83%95.PNG?alt=media&amp;token=17b22e4d-1383-4fe6-8c4d-e3e620fec215");
        //영국 겨울 옷
        List<String> urlImage21 = new ArrayList<String>();
        urlImage21.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%EA%B2%80%EC%A0%95%20%EB%A1%B1%EC%BD%94%ED%8A%B8%20%ED%9D%B0%EB%AA%A9%ED%8F%B4%EB%9D%BC.PNG?alt=media&amp;token=da293680-3f2a-4532-8d49-d5fb760a37e3");
        urlImage21.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%EA%B2%80%EC%A0%95%20%EB%A1%B1%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=06831e9c-d00b-414a-a75d-d2379ab362c6");
        urlImage21.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%EB%84%A4%EC%9D%B4%EB%B9%84%20%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=76177283-385e-4673-abf2-2f9a7855aac9");
        urlImage21.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%EB%84%A4%EC%9D%B4%EB%B9%84%20%ED%84%B8%ED%8C%A8%EB%94%A9.PNG?alt=media&amp;token=5d9abeb6-ff58-487c-be25-ea3b1f113a8c");
        urlImage21.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%EB%AA%A8%EC%A7%81%20%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=617f1aee-447d-44af-b9e0-bd3c6bedf12e");
        List<String> urlImage22 = new ArrayList<String>();
        urlImage22.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%EB%AC%B4%EC%8A%A4%ED%83%95.PNG?alt=media&amp;token=c650592c-e0b9-4259-b1ef-69f8b0f86cb7");
        urlImage22.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%EB%B2%A0%EC%9D%B4%EC%A7%80%20%EB%AA%A8%EC%A7%81%20%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=a9304b54-e327-499a-bee9-5b02a8f61a73");
        urlImage22.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%EC%8A%AC%EB%A6%BC%20%EB%A1%B1%20%EC%A0%95%EC%9E%A5.PNG?alt=media&amp;token=9ee0bb16-693b-4054-a14d-0c96c3017623");
        urlImage22.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%EC%95%BC%EC%83%81.PNG?alt=media&amp;token=051a0971-7cab-4dff-81f5-e9d4373d88cb");
        urlImage22.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%ED%84%B8%20%ED%8C%A8%EB%94%A9.PNG?alt=media&amp;token=38b615bd-8965-4f68-874c-ace4d93d63e6");
        List<String> urlImage23 = new ArrayList<String>();
        urlImage23.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%ED%8C%A8%EB%94%A9.PNG?alt=media&amp;token=dd79d5a6-7b73-4106-9fe7-a7fb53e44e37");
        urlImage23.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%ED%9A%8C%EC%83%89%20%EB%A1%B1%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=adf8e6e7-6798-4589-9879-fc8d1d639fb6");
        urlImage23.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%ED%9A%8C%EC%83%89%20%EB%AA%A8%EC%A7%81%20%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=47686562-a95a-481b-90e9-fd4fe1014917");
        urlImage23.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%ED%9A%8C%EC%83%89%20%EC%B2%B4%ED%81%AC%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=75da1724-6269-4b08-b0a3-bdfdfa399bd4");
        urlImage23.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FUnited%20Kingdom%2FWinter%2F%ED%9A%8C%EC%83%89%20%ED%84%B8%ED%8C%A8%EB%94%A9.PNG?alt=media&amp;token=d6692b09-872f-46b9-8d24-85bf84e81749");
        //일본 겨울 옷
        List<String> urlImage24 = new ArrayList<String>();
        urlImage24.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F1.JPG?alt=media&amp;token=26b57d6e-4237-4468-a612-cda3b0e5e446");
        urlImage24.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F10.JPG?alt=media&amp;token=f32c81d2-d982-48a7-8489-fe55e5c21667");
        urlImage24.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F11.JPG?alt=media&amp;token=2b2372b5-503d-4172-bde6-516ca4275f7d");
        urlImage24.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F12.JPG?alt=media&amp;token=eb3a7ea2-447a-429f-8b75-332f9e800f71");
        urlImage24.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F13.JPG?alt=media&amp;token=21824a16-5f0e-4a0a-8cf1-60aa4e13a63d");
        List<String> urlImage25 = new ArrayList<String>();
        urlImage25.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F14.JPG?alt=media&amp;token=581faa3b-6bec-4fb1-b8e2-3ce110966c94");
        urlImage25.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F15.JPG?alt=media&amp;token=ac11dfae-9d4f-4278-9784-8135bf72b3da");
        urlImage25.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F2.JPG?alt=media&amp;token=7ae88afd-6061-4d51-8b43-c3e67c38cf90");
        urlImage25.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F3.JPG?alt=media&amp;token=103308d5-1e2d-4590-ace4-41ca1a378ce5");
        urlImage25.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F4.JPG?alt=media&amp;token=1c5ef7f6-02a0-4b7e-a62a-1445fd1dd3cf");
        List<String> urlImage26 = new ArrayList<String>();
        urlImage26.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F5.JPG?alt=media&amp;token=47d97e8d-6599-4fbe-9501-5a2270ae2925");
        urlImage26.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F6.JPG?alt=media&amp;token=6e61e0e0-a409-478d-9e94-c8a0051c615a");
        urlImage26.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F7.JPG?alt=media&amp;token=baadc7e4-c6e6-470d-90a4-f42482115f43");
        urlImage26.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F8.JPG?alt=media&amp;token=82fcf8a4-0146-4822-b638-0241ea151231");
        urlImage26.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FJapan%2FWinter%2F9.JPG?alt=media&amp;token=0eb93482-f560-4e01-a513-cfc09e0e2fc1");
        //한국 3장
        imageView=(ImageView)findViewById(R.id.imageView_01);
        imageView1=(ImageView)findViewById(R.id.imageView_02);
        imageView2=(ImageView)findViewById(R.id.imageView_03);
        //영국 3장
        imageView3=(ImageView)findViewById(R.id.imageView_04);
        imageView4=(ImageView)findViewById(R.id.imageView_05);
        imageView5=(ImageView)findViewById(R.id.imageView_06);
        //일본 3장
        imageView6=(ImageView)findViewById(R.id.imageView_07);
        imageView7=(ImageView)findViewById(R.id.imageView_08);
        imageView8=(ImageView)findViewById(R.id.imageView_09);
        r = new Random();
        Call<CityWeather> cityWeather = weatherServices.getWeatherCity(cityName, API.KEY, "metric",6);
        cityWeather.enqueue(new Callback<CityWeather>() {
            @Override
            public void onResponse(Call<CityWeather> call, Response<CityWeather> response) {
                if(response.code()==200){
                    CityWeather cityWeather = response.body();
                    cities.add(cityWeather);
                    adapter.notifyItemInserted(cities.size()-1);
                    recyclerView.scrollToPosition(cities.size()-1);
                    Toast.makeText(MainActivity.this,"Add new weather and slide to check",Toast.LENGTH_LONG).show();
                    if((int)cityWeather.getWeeklyWeather().get(0).getTemp().getDay()>=11&&(int)cityWeather.getWeeklyWeather().get(0).getTemp().getDay()<=24){
                        String randomImage = urlImage.get(r.nextInt(urlImage.size()));
                        String randomImage1 = urlImage1.get(r.nextInt(urlImage1.size()));
                        String randomImage2 = urlImage2.get(r.nextInt(urlImage2.size()));

                        String randomImage3 = urlImage3.get(r.nextInt(urlImage3.size()));
                        String randomImage4 = urlImage4.get(r.nextInt(urlImage4.size()));
                        String randomImage5 = urlImage5.get(r.nextInt(urlImage6.size()));

                        String randomImage6 = urlImage6.get(r.nextInt(urlImage6.size()));
                        String randomImage7 = urlImage7.get(r.nextInt(urlImage7.size()));
                        String randomImage8 = urlImage8.get(r.nextInt(urlImage8.size()));
                        //한국 봄
                        Picasso.get().load(randomImage).into(imageView);
                        Picasso.get().load(randomImage1).into(imageView1);
                        Picasso.get().load(randomImage2).into(imageView2);
                        //영국 봄
                        Picasso.get().load(randomImage3).into(imageView3);
                        Picasso.get().load(randomImage4).into(imageView4);
                        Picasso.get().load(randomImage5).into(imageView5);
                        //일본 봄
                        Picasso.get().load(randomImage6).into(imageView6);
                        Picasso.get().load(randomImage7).into(imageView7);
                        Picasso.get().load(randomImage8).into(imageView8);
                    }
                    if((int)cityWeather.getWeeklyWeather().get(0).getTemp().getDay()>=25){
                        String randomImage =  urlImage9.get(r.nextInt(urlImage9.size()));
                        String randomImage1 = urlImage10.get(r.nextInt(urlImage10.size()));
                        String randomImage2 = urlImage11.get(r.nextInt(urlImage11.size()));

                        String randomImage3 = urlImage12.get(r.nextInt(urlImage12.size()));
                        String randomImage4 = urlImage13.get(r.nextInt(urlImage13.size()));
                        String randomImage5 = urlImage14.get(r.nextInt(urlImage14.size()));

                        String randomImage6 = urlImage15.get(r.nextInt(urlImage15.size()));
                        String randomImage7=  urlImage16.get(r.nextInt(urlImage16.size()));
                        String randomImage8 = urlImage17.get(r.nextInt(urlImage17.size()));
                        //한국 여름
                        Picasso.get().load(randomImage).into(imageView);
                        Picasso.get().load(randomImage1).into(imageView1);
                        Picasso.get().load(randomImage2).into(imageView2);
                        //영국 여름
                        Picasso.get().load(randomImage3).into(imageView3);
                        Picasso.get().load(randomImage4).into(imageView4);
                        Picasso.get().load(randomImage5).into(imageView5);
                        //일본 여름
                        Picasso.get().load(randomImage6).into(imageView6);
                        Picasso.get().load(randomImage7).into(imageView7);
                        Picasso.get().load(randomImage8).into(imageView8);
                    }
                    if((int)cityWeather.getWeeklyWeather().get(0).getTemp().getDay()<=10){
                        String randomImage =  urlImage18.get(r.nextInt(urlImage18.size()));
                        String randomImage1 = urlImage19.get(r.nextInt(urlImage19.size()));
                        String randomImage2 = urlImage20.get(r.nextInt(urlImage20.size()));

                        String randomImage3 = urlImage21.get(r.nextInt(urlImage21.size()));
                        String randomImage4 = urlImage22.get(r.nextInt(urlImage22.size()));
                        String randomImage5 = urlImage23.get(r.nextInt(urlImage23.size()));

                        String randomImage6 = urlImage24.get(r.nextInt(urlImage24.size()));
                        String randomImage7=  urlImage25.get(r.nextInt(urlImage25.size()));
                        String randomImage8 = urlImage26.get(r.nextInt(urlImage26.size()));
                        //한국 여름
                        Picasso.get().load(randomImage).into(imageView);
                        Picasso.get().load(randomImage1).into(imageView1);
                        Picasso.get().load(randomImage2).into(imageView2);
                        //영국 여름
                        Picasso.get().load(randomImage3).into(imageView3);
                        Picasso.get().load(randomImage4).into(imageView4);
                        Picasso.get().load(randomImage5).into(imageView5);
                        //일본 여름
                        Picasso.get().load(randomImage6).into(imageView6);
                        Picasso.get().load(randomImage7).into(imageView7);
                        Picasso.get().load(randomImage8).into(imageView8);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"Sorry, city not found",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<CityWeather> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Sorry, weather services are currently unavailable",Toast.LENGTH_LONG).show();
            }
        });
    }
    private List<CityWeather> getCities() {
        return new ArrayList<CityWeather>(){
            {
            }
        };
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;


                    switch (item.getItemId()){
                        case R.id.navigation_home:

                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.navigation_closet:
                            selectedFragment = new ClosetFragment();
                            break;
                        case R.id.navigation_category:
                            selectedFragment = new CategoryFragment();
                            break;
                        case R.id.navigation_setting:
                            selectedFragment = new SettingFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}
