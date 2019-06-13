package org.tensorflow.lite.examples.classification;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class LangActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txt_lang;
    private Button btn_en, btn_ko, btn_jp;
    private Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang);
        txt_lang = (TextView)findViewById(R.id.langsetting);
        btn_ko = (Button) findViewById(R.id.button_Kor);
        btn_en = (Button) findViewById(R.id.button_USA);
        btn_jp = (Button) findViewById(R.id.button_Jp);

        btn_ko.setOnClickListener(this);
        btn_en.setOnClickListener(this);
        btn_jp.setOnClickListener(this);

        loadLocale();
    }
    public void loadLocale()
    {
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        String language = prefs.getString(langPref, "");
        changeLang(language);
    }
    public void saveLocale(String lang)
    {
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, lang);
        editor.commit();
    }
    public void changeLang(String lang)
    {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);
        saveLocale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        updateTexts();
    }
    private void updateTexts()
    {
        txt_lang.setText(R.string.langsetting);
        btn_ko.setText(R.string.button_Kor);
        btn_en.setText(R.string.button_USA);
        btn_jp.setText(R.string.button_Japan);
    }
    @Override
    public void onClick(View v) {
        String lang = "ko";
        switch (v.getId()) {
            case R.id.button_Kor:
                lang = "ko";
                break;
            case R.id.button_USA:
                lang = "en";
                break;
            case R.id.button_Jp:
                lang = "ja";
                break;
            default:
                break;
        }
        changeLang(lang);
    }
    @Override
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (myLocale != null){
            newConfig.locale = myLocale;
            Locale.setDefault(myLocale);
            getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
        }
    }
}