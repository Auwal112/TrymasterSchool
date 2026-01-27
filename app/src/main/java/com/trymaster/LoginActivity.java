package com.trymaster;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.trymaster.database.UserOperation;

public class LoginActivity extends Activity {

    EditText etUsername, etPassword;
    Button btnLogin;

    UserOperation userOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // initialize views
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin   = findViewById(R.id.btn_login);

        userOperation = new UserOperation(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					String username = etUsername.getText().toString().trim();
					String password = etPassword.getText().toString().trim();

					if (username.equals("") || password.equals("")) {
						Toast.makeText(LoginActivity.this,
									   "Please fill all fields",
									   Toast.LENGTH_SHORT).show();
					} else {

						boolean success = userOperation.login(username, password);

						if (success) {
							Toast.makeText(LoginActivity.this,
										   "Login Successful",
										   Toast.LENGTH_SHORT).show();

							// go to dashboard
							Intent intent = new Intent(LoginActivity.this, MainActivity.class);
							startActivity(intent);
							finish();

						} else {
							Toast.makeText(LoginActivity.this,
										   "Invalid username or password",
										   Toast.LENGTH_SHORT).show();
						}
					}
				}
			});
    }
}
