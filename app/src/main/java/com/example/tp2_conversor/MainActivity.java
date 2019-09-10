package com.example.tp2_conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnConvertir;
    private EditText edtDolares;
    private EditText edtCambio;
    private EditText edtEuros;
    private RadioButton rdbDolares;
    private RadioButton rdbEuros;
    private TextView euroValor;
    double dolar = 0.91;
    double euro = 1.10;
    double convertido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtDolares=findViewById(R.id.editDolares);
        edtEuros=findViewById(R.id.editEuros);
        edtCambio=findViewById(R.id.editCambio);
        rdbDolares=findViewById(R.id.radioDolar);
        rdbEuros=findViewById(R.id.radioEuros);
        btnConvertir=findViewById(R.id.buttonConvertir);
        edtDolares.setEnabled(false);
        edtEuros.setEnabled(false);

        rdbDolares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtEuros.setEnabled(true);
                edtDolares.setEnabled(false);
            }
        });
        rdbEuros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtEuros.setEnabled(false);
                edtDolares.setEnabled(true);
            }
        });

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rdbDolares.isChecked()){
                    if(!edtEuros.getText().toString().equals("")){
                        double valorE=Double.parseDouble(edtEuros.getText().toString());
                        convertido=valorE*euro;
                        String valor= String.valueOf(convertido);
                        edtCambio.setText(valor);
                    }else{
                        Toast.makeText(getApplicationContext(),"ingrese un valor para convertir", Toast.LENGTH_LONG).show();
                    }
                }
                if(rdbEuros.isChecked()){
                    if(!edtDolares.getText().toString().equals("")) {
                        double valorD=Double.parseDouble(edtDolares.getText().toString());
                        convertido=valorD*dolar;
                        String valor= String.valueOf(convertido);
                        edtCambio.setText(valor);
                    }else{
                        Toast.makeText(getApplicationContext(),"ingrese un valor para convertir", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
