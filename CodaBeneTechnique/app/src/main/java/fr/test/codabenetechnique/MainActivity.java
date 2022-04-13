package fr.test.codabenetechnique;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_DISPLAY = "fr.test.codabenetechnique.DISPLAY";
    public static final Inventory inventory = new Inventory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToInputActivity(View view) {
        Intent intent = new Intent(this, InputEntriesActivity.class);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void goToDisplayActivity(View view) {
        Intent intent = new Intent(this, DisplayProductsActivity.class);
        intent.putExtra(EXTRA_DISPLAY, inventory.display());
        startActivity(intent);
    }

}