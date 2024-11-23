package com.example.projectdemokk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class LoginActivity extends AppCompatActivity {
    private UserViewModel viewModel;
    EditText lguedt, lgpedt;
    AppCompatButton lgbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        lguedt = findViewById(R.id.lg_username_edittext);
        lgpedt = findViewById(R.id.lg_password_edittext);
        lgbtn = findViewById(R.id.lbtn);

        lgbtn.setOnClickListener(v -> {
            String username = lguedt.getText().toString().trim();
            String password = lgpedt.getText().toString().trim();

            viewModel.loginUser(username, password, user -> {
                if (user != null) {
                    Toast.makeText(LoginActivity.this, "Welcome " + user.getFirstName(), Toast.LENGTH_LONG).show();
                    // Navigate to the home screen or another activity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("user_name", user.getFirstName() + " " + user.getLastName());
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}