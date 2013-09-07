package ru.ktx.hh.schooltest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends Activity implements OnClickListener{
    TextView tvPerson;
    TextView tvBD;
    TextView tvGender;
    TextView tvPosition;
    TextView tvAmount;
    TextView tvPhone;
    TextView tvEMail;
    EditText etAnswer;
    Button btnSendAnswer;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity2);
		
		tvPerson = (TextView) findViewById(R.id.tvPerson);
		tvBD = (TextView) findViewById(R.id.tvBD);
		tvGender = (TextView) findViewById(R.id.tvGender);
		tvPosition = (TextView) findViewById(R.id.tvPosition);
		tvAmount = (TextView) findViewById(R.id.tvAmount);
		tvPhone = (TextView) findViewById(R.id.tvPhone);
		tvEMail = (TextView) findViewById(R.id.tvEmail);
		etAnswer = (EditText) findViewById(R.id.etAnswer);
		
		Intent intent = getIntent();
		tvPerson.setText(intent.getCharSequenceExtra("Person"));
		tvBD.setText(intent.getCharSequenceExtra("BirthDate"));
		tvGender.setText(intent.getCharSequenceExtra("Gender"));
		tvPosition.setText(intent.getCharSequenceExtra("Position"));
		tvAmount.setText(intent.getCharSequenceExtra("Amount"));
		tvPhone.setText(intent.getCharSequenceExtra("Phone"));
		tvEMail.setText(intent.getCharSequenceExtra("EMail"));
				
		btnSendAnswer = (Button) findViewById(R.id.btnSendAnswer);
		btnSendAnswer.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_activity2, menu);
		return true;
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		intent.putExtra("Answer", etAnswer.getText().toString());
		this.setResult(RESULT_OK, intent);
        finish();
	}

}
