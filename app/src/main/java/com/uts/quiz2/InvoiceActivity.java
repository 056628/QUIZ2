package com.uts.quiz2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class InvoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        long totalPrice = getIntent().getLongExtra("totalPrice", 0);
        String selectedPhone = getIntent().getStringExtra("selectedPhone");
        String selectedExtra = getIntent().getStringExtra("selectedExtra");
        int days = getIntent().getIntExtra("days", 0);

        TextView tvInvoice = findViewById(R.id.tv_invoice);
        tvInvoice.setText("Barang yang dipilih: " + selectedPhone + "\n" +
                "Tambahan: " + (selectedExtra.isEmpty() ? "Tidak ada" : selectedExtra) + "\n" +
                "Jumlah hari: " + days + "\n" +
                "Total Harga: " + totalPrice);
    }
}
