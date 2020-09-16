package co.edu.unimagdalena.apmoviles.tallerunimag2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText x1,x2,y1,y2;
    Button pmedio,pendiente,cuadrante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x1 = findViewById(R.id.edtx1);
        x2 = findViewById(R.id.edtx2);
        y1 = findViewById(R.id.edty1);
        y2 = findViewById(R.id.edty2);
        pmedio = findViewById(R.id.btnpm);
        pendiente = findViewById(R.id.btnpendiente);
        cuadrante = findViewById(R.id.btncuad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.m1:
                Toast.makeText(this, "Distance", Toast.LENGTH_SHORT).show();
                break;

            case R.id.m2:

                x1.setText(aleatorio());
                x2.setText(aleatorio());
                y1.setText(aleatorio());
                y2.setText(aleatorio());
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public String aleatorio(){
        int max = 50, min = -50;
        Random r = new Random();
        int alea = r.nextInt((max-min)+1)+min;
        String al =""+alea;
        return al;
    }
}