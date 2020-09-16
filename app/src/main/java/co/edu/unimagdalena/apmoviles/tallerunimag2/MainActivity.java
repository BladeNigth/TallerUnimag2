package co.edu.unimagdalena.apmoviles.tallerunimag2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
        pendiente.setOnClickListener(this);
        pmedio.setOnClickListener(this);
        cuadrante.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {

        if(TextUtils.isEmpty(x1.getText().toString()) || TextUtils.isEmpty(x2.getText().toString()) ||  TextUtils.isEmpty(y1.getText().toString()) ||
                TextUtils.isEmpty(y2.getText().toString())){
            Toast.makeText(getApplicationContext(), "Datos invalidos", Toast.LENGTH_LONG).show();
            }else {
                double dx1 = Double.parseDouble(x1.getText().toString());
                double dx2 = Double.parseDouble(x2.getText().toString());
                double dy1 = Double.parseDouble(y1.getText().toString());
                double dy2 = Double.parseDouble(y2.getText().toString());
                double pmy,pmx,m;
                switch (view.getId()) {
                    case R.id.btnpm:

                        pmx = (dx2+dx1)/2;
                        pmy = (dy2+dy1)/2;
                        Toast.makeText(getApplicationContext(),"El punto medio es: ("+pmx+" , "+pmy+")",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.btnpendiente:

                        m =(dy2-dy1)/(dx2-dx1);
                        Toast.makeText(getApplicationContext(),"La Pendiente es: "+m,Toast.LENGTH_LONG).show();
                        break;

                    case R.id.btncuad:

                        pmx = (dx2+dx1)/2;
                        pmy = (dy2+dy1)/2;
                        if(pmx>0 && pmy >0){
                            Toast.makeText(getApplicationContext(),"Esta ubicado en el cuadrante  1",Toast.LENGTH_LONG).show();
                        }else if(pmx < 0 && pmy > 0){
                            Toast.makeText(getApplicationContext(),"Esta ubicado en el cuadrante  2",Toast.LENGTH_LONG).show();
                        }else if(pmx < 0 && pmy < 0){
                            Toast.makeText(getApplicationContext(),"Esta ubicado en el cuadrante  3",Toast.LENGTH_LONG).show();
                        }else if(pmx > 0 && pmy < 0){
                            Toast.makeText(getApplicationContext(),"Esta ubicado en el cuadrante  4",Toast.LENGTH_LONG).show();
                        }

                        break;
            }

        }

    }
}