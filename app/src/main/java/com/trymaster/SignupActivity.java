package com.trymaster;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.trymaster.database.User;
import com.trymaster.database.UserOperation;

public class SignupActivity extends Activity {

    EditText etFullname, etUsername, etEmail, etContact, etPassword;
    Button btnSignup;

    UserOperation userOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize views
        etFullname = findViewById(R.id.et_fullname);
        etUsername = findViewById(R.id.et_username);
        etEmail    = findViewById(R.id.et_email);
        etContact  = findViewById(R.id.et_contact);
        etPassword = findViewById(R.id.et_password);
        btnSignup  = findViewById(R.id.btn_signup);

        userOperation = new UserOperation(this);

        btnSignup.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					String fullname = etFullname.getText().toString().trim();
					String username = etUsername.getText().toString().trim();
					String email    = etEmail.getText().toString().trim();
					String contact  = etContact.getText().toString().trim();
					String password = etPassword.getText().toString().trim();

					if (fullname.equals("") || username.equals("") ||
                        email.equals("") || contact.equals("") || password.equals("")) {

						Toast.makeText(SignupActivity.this,
									   "All fields are required",
									   Toast.LENGTH_SHORT).show();
						return;
					}

					if (userOperation.isUsernameExists(username)) {
						Toast.makeText(SignupActivity.this,
									   "Username already exists",
									   Toast.LENGTH_SHORT).show();
						return;
					}

					User user = new User();
					user.setFullname(fullname);
					user.setUsername(username);
					user.setEmail(email);
					user.setContact(contact);
					user.setPassword(password);

					userOperation.insertUser(user);

					Toast.makeText(SignupActivity.this,
								   "Signup successful",
								   Toast.LENGTH_SHORT).show();

					startActivity(new Intent(SignupActivity.this, LoginActivity.class));
					finish();
				}
			});
    }
}
