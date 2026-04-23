package com.example.helloworld;

import android.content.res.Resources;
import android.os.Bundle;
import android.content.res.Configuration;
import java.util.Locale;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;

import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources res = getResources();
        Configuration config = res.getConfiguration();
        config.setLocale(new Locale("en"));
        res.updateConfiguration(config, res.getDisplayMetrics());
        setContentView(R.layout.activity_main);


        TextView text = findViewById(R.id.textview_main);

        Button btn = findViewById(R.id.button);
        final boolean[] isHello = {true};

        btn.setOnClickListener(clic -> {
            if (isHello[0]) {
                text.setText(getString(R.string.enjoy_str));
            } else {
                text.setText(getString(R.string.hello_str));
            }
            isHello[0] = !isHello[0];

                }
                );

        Button btn2 = findViewById(R.id.button_lang);
        final boolean[] isEnglish = {true};

        btn2.setOnClickListener(clic_lang -> {

            if (isEnglish[0]) {
                config.setLocale(new Locale("fr"));
            } else {
                config.setLocale(new Locale("en"));
            }
            isEnglish[0] = !isEnglish[0];



            res.updateConfiguration(config, res.getDisplayMetrics());
            if (isHello[0]) {
                text.setText(getString(R.string.hello_str));
            } else {
                text.setText(getString(R.string.enjoy_str));
            }


        });


    }
}
