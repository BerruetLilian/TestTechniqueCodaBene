package fr.test.codabenetechnique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_products);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_DISPLAY);

        TextView textView = findViewById(R.id.displayText);
        textView.setText(message);
    }

}