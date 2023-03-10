package edu.iest.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bnCanal = findViewById(R.id.boton);
        EditText etCanal = findViewById(R.id.etCanal);
        TextView tvCanal = findViewById(R.id.tvCanal);
        TextView tvCambioCanal = findViewById(R.id.tvCambioCanal);
        Spinner spProgramas = findViewById(R.id.programa);
        ivContinuara = findViewById(R.id.ivContinuara);

        spProgramas.setOnItemSelectedListener(this);

        bnCanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aqui la logica que hacer al dar clic
                //obtendremos el valor del edittext y lo asignaremos al textview inferior

                String texto = etCanal.getText().toString();
                Toast.makeText(MainActivity.this,"El canal es  "+texto, Toast.LENGTH_LONG).show();
                tvCambioCanal.setText(texto);
            }
        });
        ivContinuara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spProgramas = findViewById(R.id.programa);
                EditText etCanal = findViewById(R.id.etCanal);
                Intent i = new Intent(MainActivity.this,DatosActivity.class);
                i.putExtra("canal", etCanal.getText().toString());
                i.putExtra("programa",spProgramas.getSelectedItem().toString());
                startActivity(i);
            }
        });
    }
    private ImageView ivContinuara;


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int posicion, long l) {
        String programa = adapterView.getItemAtPosition(posicion).toString();
        Snackbar.make(adapterView,"Programa seleccionado "+programa,Snackbar.LENGTH_LONG).show();

        if(posicion == 0){
            ivContinuara.setImageResource(R.drawable.tobecontinued_onepiece);
        }else if (posicion == 1){
            ivContinuara.setImageResource(R.drawable.tobecontinued_jojos);
        }else {
            ivContinuara.setImageResource(R.drawable.tobecontinued_looneytunes);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}