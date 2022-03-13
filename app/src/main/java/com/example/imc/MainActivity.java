package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtMassa, edtAltura;
    Button btnCalcularImc;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregaComponentes();

    }


    protected void carregaComponentes() {
        edtMassa = findViewById(R.id.edtMassa);
        edtAltura = findViewById(R.id.edtAltura);
        btnCalcularImc = findViewById(R.id.btnCalcularImc);
        txtResultado = findViewById(R.id.txtResultado);
    }

    public void realizaCalculo(View view) {
        double massa = Double.parseDouble(edtMassa.getText().toString());
        double altura = Double.parseDouble(edtAltura.getText().toString());

        double imc = massa / (altura * altura);

        String imcClassificado = classificaImc(imc);

        txtResultado.setText("Seu IMC é: " + imc +"\n" + imcClassificado);

    }

    public String classificaImc(double imc) {

        if(imc < 16){
            return "Magreza grave";
        } else if (16 <= imc && imc < 17 ) {
            return "Magreza moderada";
        } else if (17 <= imc && imc < 18.5){
            return "Magreza leve";
        } else if(18.5 <= imc && imc < 25){
            return "Saudavel";
        } else if(25 <= imc && imc < 30){
            return "Sobrepeso";
        } else if(30 <= imc && imc < 35){
            return "Obesidade grau I";
        } else if(35 <= imc && imc < 40){
            return "Obesidade grau II";
        } else if (imc >= 40){
            return "Obesidade grau III (Mórbida)";
        } else {
            return "";
        }

    }

}

