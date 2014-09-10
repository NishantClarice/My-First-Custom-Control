package com.example.demo1;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class HomeActivity extends Activity {

	TextView textView1, textView2;
	Button buttonNext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		String name = getIntent().getStringExtra("Email_ID");
		textView1 = (TextView) findViewById(R.id.textView1Home);
		textView2 = (TextView) findViewById(R.id.textView2Home);
		textView1.setTextSize(20);
		String strWelcomeUser = "Welcome : " + name;
		textView1.setText(strWelcomeUser);
		buttonNext = (Button) findViewById(R.id.nextbutton);

		buttonNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String emailId = textView1.getText().toString();
				Intent intent = new Intent(getApplicationContext(),
						PieActivity.class);
				intent.putExtra("Email_ID", emailId);

				startActivity(intent);

			}
		});

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
}
