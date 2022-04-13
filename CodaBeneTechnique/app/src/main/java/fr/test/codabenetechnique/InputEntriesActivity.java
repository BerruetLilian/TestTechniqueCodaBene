package fr.test.codabenetechnique;

import static fr.test.codabenetechnique.MainActivity.inventory;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.time.format.DateTimeParseException;

public class InputEntriesActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "fr.test.codabenetechnique.VALIDATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_entries);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void validationButton(View view) {
        Intent intent = new Intent(this, ValidationActivity.class);
        EditText editText = (EditText) findViewById(R.id.idInputEntries);
        String idProd = editText.getText().toString();
        editText = (EditText) findViewById(R.id.dateInputEntries);
        String dateProd = editText.getText().toString();
        String validationMessage = "";
        try {
            inventory.addProduct(idProd,dateProd);
            validationMessage = "L'entrée a été pris en compte.";
        } catch (InvalidDateException e) {
            validationMessage = "La date d'expiration n'est pas valide.";
        } catch(NumberFormatException e) {
            validationMessage = "Nombre invalide.";
        } catch(DateTimeParseException e){
            validationMessage = "Le format de la date d'expiration n'est pas valide.";
        }
        finally {
            intent.putExtra(EXTRA_MESSAGE, validationMessage);
            startActivity(intent);
        }
    }

}