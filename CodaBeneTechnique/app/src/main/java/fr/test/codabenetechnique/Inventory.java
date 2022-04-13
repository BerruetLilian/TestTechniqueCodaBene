package fr.test.codabenetechnique;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Inventory {

    private final Map<Integer, LocalDate> products;

    public Inventory(){
        products = new HashMap<>();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addProduct(String id, String date) throws NumberFormatException,InvalidDateException, DateTimeParseException {
        int idProd = Integer.parseInt(id);
        if(idProd < 0 ){
            throw new NumberFormatException();
        }
        LocalDate expiryDate = LocalDate.parse(date) ;
        if(LocalDate.now().isAfter(expiryDate)){
            throw new InvalidDateException("Date is before now.");
        }
        products.merge(idProd,expiryDate, (oldValue, newValue) -> oldValue.isBefore(newValue) ? oldValue : newValue);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String display() {
        if(products.isEmpty()){
            return "Aucun produits saisis";
        }
        StringJoiner stringJoiner = new StringJoiner("\n");
        products.entrySet().forEach(e -> stringJoiner.add(e.getKey().toString() + " : " + e.getValue().toString()));
        return stringJoiner.toString();
    }

}
