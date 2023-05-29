package com.example.alcarde_multicalc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

class CalculatorActivity extends AppCompatActivity {
    private EditText operand1, operand2;
    private TextView resultText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        operand1 = findViewById(R.id.editTextOperand1);
        operand2 = findViewById(R.id.editTextOperand2);
        resultText = findViewById(R.id.textViewResult);

        Button addButton = findViewById(R.id.buttonAdd);
        Button subtractButton = findViewById(R.id.buttonSubtract);
        Button multiplyButton = findViewById(R.id.buttonMultiply);
        Button divideButton = findViewById(R.id.buttonDivide);

        addButton.setOnClickListener(v -> performOperation('+'));

        subtractButton.setOnClickListener(v -> performOperation('-'));

        multiplyButton.setOnClickListener(v -> performOperation('*'));

        divideButton.setOnClickListener(v -> performOperation('/'));
    }

    @SuppressLint("SetTextI18n")
    private void performOperation(char operator) {
        double num1 = Double.parseDouble(operand1.getText().toString());
        double num2 = Double.parseDouble(operand2.getText().toString());
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultText.setText("Error: Cannot divide by zero");
                    return;
                }
                break;
        }

        resultText.setText(String.valueOf(result));
    }
}