package com.example.myapp;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.button.MaterialButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(view -> {
            String password = passwordEditText.getText().toString().trim();

            if (password.isEmpty()) {
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            } else if (password.equals("123")) {
                // Proceed to the next activity after successful login
                Intent intent = new Intent(LoginActivity.this, YearSelectionActivity.class);
                startActivity(intent);
                finish(); // Finish this activity
            } else {
                Toast.makeText(this, "Invalid password. Please try again.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
