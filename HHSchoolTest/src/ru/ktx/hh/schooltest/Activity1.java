package ru.ktx.hh.schooltest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.annotation.SuppressLint;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.content.Intent;

@SuppressLint("SimpleDateFormat")
public class Activity1 extends FragmentActivity implements OnClickListener {
	Spinner    spinnerGender;
    Button     btnSend;
    EditText   etPerson;
    EditText   etPosition;
    EditText   etAmount;
    EditText   etPhone;
    EditText   etEMail;
    DatePicker dpBD;
    
    static final int SEND_REQUEST = 0;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity1);
	 
		
		ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource
				(this, R.array.gender, android.R.layout.simple_spinner_item);
		
		spinnerGender = (Spinner) findViewById(R.id.spinnerGender);
		spinnerGender.setAdapter(adapter);
		
		btnSend = (Button) findViewById(R.id.btnSend);
		btnSend.setOnClickListener(this);
		
		etPerson = (EditText) findViewById(R.id.etPerson);
		etPosition = (EditText) findViewById(R.id.etPosition); 
		etAmount  = (EditText) findViewById(R.id.etAmount);
		etPhone = (EditText) findViewById(R.id.etPhone);
		etEMail = (EditText) findViewById(R.id.etEmail);
		
		dpBD = (DatePicker) findViewById(R.id.dpBD);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_activity1, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btnSend:
			
			Intent intent = new Intent(this, Activity2.class);
			
			intent.putExtra("Person", etPerson.getText().toString());
			intent.putExtra("Gender", spinnerGender.getSelectedItem().toString());
			intent.putExtra("Position", etPosition.getText().toString());
			intent.putExtra("Amount", etAmount.getText().toString());
			intent.putExtra("Phone", etPhone.getText().toString());
			intent.putExtra("EMail", etEMail.getText().toString());

			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		    Calendar calendar = Calendar.getInstance();
		    calendar.set(dpBD.getYear(), dpBD.getMonth(), dpBD.getDayOfMonth());
			intent.putExtra("BirthDate", sdf.format(calendar.getTime()));
			

			startActivityForResult(intent, SEND_REQUEST);
			break;
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if (data == null) {
			System.out.print("Empty intent");
			return;
		}
		if (resultCode == RESULT_OK && requestCode == SEND_REQUEST) {
			  AnswerDialog dlg = new AnswerDialog();
			  dlg.setArguments(data.getExtras());
			  dlg.show(getSupportFragmentManager(),"answer_dlg");
		  }
	}

}
