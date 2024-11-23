package com.example.projectdemokk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class SignupActivity extends AppCompatActivity {
    private UserViewModel viewModel;
    EditText fedt, ledt, eledt, uedt, pedt;
    AppCompatButton sgbtn;
    TextView goLoginPageBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        fedt = findViewById(R.id.firstname_edittext);
        ledt = findViewById(R.id.lastname_edittext);
        eledt = findViewById(R.id.email_edittext);
        uedt = findViewById(R.id.username_edittext);
        pedt = findViewById(R.id.password_edittext);
        sgbtn = findViewById(R.id.sbtn);
        goLoginPageBtn = findViewById(R.id.moveToLogin);

        sgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = fedt.getText().toString();
                String lastName = ledt.getText().toString();
                String email = eledt.getText().toString();
                String username = uedt.getText().toString();
                String password = pedt.getText().toString();


                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()){
                    Toast.makeText(SignupActivity.this, "Please fill all fields", Toast.LENGTH_LONG).show();
                    return;
                }

                viewModel.registerUser(firstName,lastName,email,username,password);
                Toast.makeText(SignupActivity.this,"Registraion Successful", Toast.LENGTH_LONG).show();
                finish();
                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        goLoginPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}