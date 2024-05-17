package com.uts.quiz2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rgPhones = findViewById(R.id.rg_phones);
        RadioGroup rgExtras = findViewById(R.id.rg_extras);
        EditText etDays = findViewById(R.id.et_days);
        Button btnOrder = findViewById(R.id.btn_order);

        btnOrder.setOnClickListener(v -> {
            int selectedPhoneId = rgPhones.getCheckedRadioButtonId();
            int selectedExtraId = rgExtras.getCheckedRadioButtonId();
            String daysText = etDays.getText().toString();
            long totalPrice = 0;
            int days = 0;
            String selectedPhone = "";
            String selectedExtra = "";

            // Cek apakah input hari kosong atau tidak
            if (daysText.isEmpty()) {
                Toast.makeText(MainActivity.this, "Masukkan jumlah hari rental", Toast.LENGTH_SHORT).show();
                return;
            } else {
                days = Integer.parseInt(daysText);
            }

            if (selectedPhoneId == R.id.rb_iphone15ProMax) {
                totalPrice += 300000;
                selectedPhone = "iPhone 15 Pro Max";
            } else if (selectedPhoneId == R.id.rb_iphone15Pro) {
                totalPrice += 280000;
                selectedPhone = "iPhone 15 Pro";
            } else if (selectedPhoneId == R.id.rb_iphone14ProMax) {
                totalPrice += 250000;
                selectedPhone = "iPhone 14 Pro Max";
            } else if (selectedPhoneId == R.id.rb_iphone14Pro) {
                totalPrice += 200000;
                selectedPhone = "iPhone 14 Pro";
            } else if (selectedPhoneId == R.id.rb_iphone13ProMax) {
                totalPrice += 100000;
                selectedPhone = "iPhone 13 Pro Max";
            }

            if (selectedExtraId == R.id.rb_airPods) {
                totalPrice += 20000;
                selectedExtra = "Air Pods";
            } else if (selectedExtraId == R.id.rb_casing) {
                totalPrice += 10000;
                selectedExtra = "Casing";
            }

            // Mengalikan total harga dengan jumlah hari rental
            totalPrice *= days;

            Intent intent = new Intent(MainActivity.this, InvoiceActivity.class);
            intent.putExtra("selectedPhone", selectedPhone);
            intent.putExtra("selectedExtra", selectedExtra);
            intent.putExtra("days", days);
            intent.putExtra("totalPrice", totalPrice);
            startActivity(intent);
        });
    }
}
