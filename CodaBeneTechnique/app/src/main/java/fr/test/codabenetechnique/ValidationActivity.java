package fr.test.codabenetechnique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ValidationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);

        Intent intent = getIntent();
        String message = intent.getStringExtra(InputEntriesActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.validationText);
        textView.setText(message);
    }
}