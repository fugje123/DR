package org.tensorflow.lite.examples.classification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {
TextView Skip;
Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        login = (Button)findViewById(R.id.startlogin);
        register = (Button)findViewById(R.id.startregister);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(IntroActivity.this, loginActivity.class);
                IntroActivity.this.startActivity(loginIntent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(IntroActivity.this, SignUpActivity.class);
                IntroActivity.this.startActivity(registerIntent);
            }
        });
    }
}
