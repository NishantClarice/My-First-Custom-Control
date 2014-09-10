package com.example.demo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.*;

public class MainActivity extends Activity {

	TextView textViewClarice, textViewLogin, textViewForgotPasswd;
	Button loginButton, cancelButton;
	EditText editTextEmail, editTextPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textViewClarice = (TextView) findViewById(R.id.textView1Main);
		textViewLogin = (TextView) findViewById(R.id.textView2Main);
		textViewForgotPasswd = (TextView) findViewById(R.id.textView3Main);
		loginButton = (Button) findViewById(R.id.button1Main);
		cancelButton = (Button) findViewById(R.id.button2Main);
		editTextEmail = (EditText) findViewById(R.id.editText1Main);
		editTextPassword = (EditText) findViewById(R.id.editText2Main);
		loginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String emailId = editTextEmail.getText().toString();
				Intent intent = new Intent(getApplicationContext(),
						HomeActivity.class);
				intent.putExtra("Email_ID", emailId);

				startActivity(intent);
			}
		});
		cancelButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				editTextEmail.setText("");
				editTextPassword.setText("");
			}
		});

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
