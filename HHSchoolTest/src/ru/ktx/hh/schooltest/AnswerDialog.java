package ru.ktx.hh.schooltest;

import android.app.AlertDialog;
import android.app.Dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;


public class AnswerDialog extends DialogFragment {
        
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder adb = new AlertDialog.Builder(getActivity())
		  .setTitle("Ответ")
		  .setMessage(getArguments().getString("Answer"))
		  .setPositiveButton("Ok", null)
		  .setIcon(R.drawable.logo);  
		return adb.create();
	}

}
