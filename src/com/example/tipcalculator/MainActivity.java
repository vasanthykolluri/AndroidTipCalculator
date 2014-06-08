package com.example.tipcalculator;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends Activity {

	private EditText totalAmountText;
	private EditText tipAmountText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		totalAmountText = (EditText) findViewById(R.id.totalAmountText);
		tipAmountText = (EditText) findViewById(R.id.tipAmountText);
	}

	public void onTipPercentClick(View v) {
		float totalAmount = Float.parseFloat(totalAmountText.getText().toString());
		double tipAmount = 0;
		
		switch(v.getId()) {
		case R.id.TipPercent10Button:
			tipAmount  = (totalAmount * 0.1);
			break;
		case R.id.TipPercent15Button:
			tipAmount = (totalAmount * 0.15);
			break;
		case R.id.TipPercent20Button:
			tipAmount = (totalAmount * 0.2);
			break;
		}
		
		tipAmountText.setText(Double.toString(tipAmount));
	}
}
