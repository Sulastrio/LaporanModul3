package com.example.laporanmodul3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputNama;
    private CheckBox statusMenikah;
    private RadioGroup golonganGroup;
    private RadioButton golongan1, golongan2;
    private TextView gajiPokok, tunjangan, totalGaji;
    private Button btnHitungGaji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen
        inputNama = findViewById(R.id.inputNama);
        statusMenikah = findViewById(R.id.statusMenikah);
        golonganGroup = findViewById(R.id.golonganGroup);
        golongan1 = findViewById(R.id.golongan1);
        golongan2 = findViewById(R.id.golongan2);
        gajiPokok = findViewById(R.id.gajiPokok);
        tunjangan = findViewById(R.id.tunjangan);
        totalGaji = findViewById(R.id.totalGaji);
        btnHitungGaji = findViewById(R.id.btnHitungGaji);

        btnHitungGaji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungGaji();
            }
        });
    }

    private void hitungGaji() {
        String nama = inputNama.getText().toString().trim();

        if (nama.isEmpty()) {
            Toast.makeText(this, "Nama harus diisi!", Toast.LENGTH_SHORT).show();
            return;
        }

        int gaji = 0;
        int tunjanganMenikah = 0;

        if (golongan1.isChecked()) {
            gaji = 5000000;
        } else if (golongan2.isChecked()) {
            gaji = 7000000;
        } else {
            Toast.makeText(this, "Pilih golongan terlebih dahulu!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (statusMenikah.isChecked()) {
            tunjanganMenikah = 2000000;
        }

        int total = gaji + tunjanganMenikah;

        // Set hasil ke TextView
        gajiPokok.setText("Gaji Pokok : Rp " + gaji);
        tunjangan.setText("Tunjangan : Rp " + tunjanganMenikah);
        totalGaji.setText("Total Gaji : Rp " + total);
    }
}
