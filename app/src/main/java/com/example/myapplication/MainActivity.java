package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ajustar padding según las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Lógica adicional para la calculadora
        EditText number1EditText = findViewById(R.id.number1EditText);
        EditText number2EditText = findViewById(R.id.number2EditText);
        TextView resultTextView = findViewById(R.id.resultTextView);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(view -> {
            try {
                double num1 = Double.parseDouble(number1EditText.getText().toString());
                double num2 = Double.parseDouble(number2EditText.getText().toString());
                double result = num1 + num2;
                resultTextView.setText("Resultado: " + result);
            } catch (NumberFormatException e) {
                resultTextView.setText("Por favor ingrese números válidos.");
            }
        });
    }
}
