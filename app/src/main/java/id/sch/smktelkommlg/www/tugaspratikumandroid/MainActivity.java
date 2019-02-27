package id.sch.smktelkommlg.www.tugaspratikumandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnok;
    EditText editnama, editpinjam, editkembali, editalamat;
    TextView txthasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnok = findViewById(R.id.btnok);
        editnama = findViewById(R.id.editnama);
        editalamat = findViewById(R.id.editalamat);
        editpinjam = findViewById(R.id.editpinjam);
        editkembali = findViewById(R.id.editkembali);
        txthasil = findViewById(R.id.txthasil);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
            }

            private void doProcess() {
                if (isValid()) {
                    String nama = editnama.getText().toString();
                    String pinjam = editpinjam.getText().toString();
                    String kembali = editkembali.getText().toString();
                    String alamat = editalamat.getText().toString();
                    txthasil.setText("Nama Anda " + nama + "\n" + "Pinjam Buku pada Tanggal " + pinjam + "\n" + "Buku Kembali pada Tanggal  " + kembali + "\n" + "Alamat " + alamat);
                }
            }

            private boolean isValid() {
                boolean valid = true;
                String nama = editnama.getText().toString();
                String pinjam = editpinjam.getText().toString();
                String kembali = editkembali.getText().toString();
                String alamat = editalamat.getText().toString();
                if (nama.isEmpty()) {
                    editnama.setError("Nama Belum Diisi");
                    valid = false;
                } else if (nama.length() < 3) {
                    editnama.setError("Karakter Nama kurang dari 3 karakter");
                    valid = false;
                } else {
                    editnama.setError(null);
                }
                if (pinjam.isEmpty()) {
                    editpinjam.setError("Tanggal Pinjam Belum Diisi");
                    valid = false;
                } else if (pinjam.length() < 4) {
                    editpinjam.setError("Format tanggal pinjam xx/yy/zzzz");
                    valid = false;
                } else {
                    editpinjam.setError(null);
                }
                if (kembali.isEmpty()) {
                    editkembali.setError("Tanggal Kembali Belum Diisi");
                    valid = false;
                } else if (kembali.length() < 4) {
                    editkembali.setError("Format tanggal kembali xx/yy/zzzz");
                    valid = false;
                } else {
                    editkembali.setError(null);
                }
                if (alamat.isEmpty()) {
                    editalamat.setError("Alamat Belum Diisi");
                    valid = false;
                } else if (alamat.length() < 4) {
                    editalamat.setError("Karakter kurang dari 4");
                    valid = false;
                } else {
                    editalamat.setError(null);
                }
                return valid;
            }
        });
    }
}