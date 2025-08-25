package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ViagemActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_viagem);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btVoltarViagem = findViewById(R.id.btVoltarViagem);
        btVoltarViagem.setOnClickListener(this);

        Button btCalcularViagem = findViewById(R.id.btCalcularViagem);
        btCalcularViagem.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btVoltarViagem) {
            finish();
        } else if (view.getId() == R.id.btCalcularViagem) {
            calcular();
        }
    }

    private void calcular() {
        EditText etDistancia = findViewById(R.id.etDistancia);
        EditText etMediaKMPorLitro = findViewById(R.id.etMediaKMPorL);
        EditText etValorCombustivel = findViewById(R.id.etValorCombustivel);

        float distancia = Float.parseFloat(etDistancia.getText().toString());
        float kmPorL = Float.parseFloat(etMediaKMPorLitro.getText().toString());
        float valorCombustivel = Float.parseFloat(etValorCombustivel.getText().toString());

        float total = distancia / kmPorL * valorCombustivel;
        String totalStr = String.format("%.2f", total);

        Toast.makeText(
                ViagemActivity.this,
                "O valor total da viagem é de R$".concat(totalStr),
                Toast.LENGTH_LONG
        ).show();
    }
}