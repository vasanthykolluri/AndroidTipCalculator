package com.example.tipcalculator;

import android.R.drawable;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText totalAmountText;
	private EditText tipAmountText;
	private SeekBar tipPercentSeekBar;
	private TextView tipPercentSeekBarText;
	
	private static final int TIPPERCENT10 = 10;
	private static final int TIPPERCENT15 = 15;
	private static final int TIPPERCENT20 = 20;
	private int selectedTipPercent = TIPPERCENT10;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		totalAmountText = (EditText) findViewById(R.id.totalAmountText);
		tipAmountText = (EditText) findViewById(R.id.tipAmountText);
		tipPercentSeekBar = (SeekBar) findViewById(R.id.tipPercentSeekBar1);
		tipPercentSeekBar.setProgress(TIPPERCENT10);
		tipPercentSeekBar.setMax(100);
		tipPercentSeekBarText = (TextView) findViewById(R.id.tipPercentSeekBarText);
    	tipPercentSeekBarText.setText(TIPPERCENT10 + "%");


		// on updates to total amount
		totalAmountText.addTextChangedListener(new TextWatcher() {

			public void afterTextChanged(Editable s) {
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				calculateTip(selectedTipPercent);
			}
		});
		
		tipPercentSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

		    @Override
		    public void onStopTrackingTouch(SeekBar seekBar) {
		    }

		    @Override
		    public void onStartTrackingTouch(SeekBar seekBar) {
		    }

		    @Override
		    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		    	tipPercentSeekBarText.setText(progress + "%");
		    	selectedTipPercent = progress;
		        calculateTip(selectedTipPercent);
		    }
		});
	}

	public void onTipPercentClick(View v) {
		switch (v.getId()) {
		case R.id.TipPercent10Button:
			selectedTipPercent = TIPPERCENT10;
			break;
		case R.id.TipPercent15Button:
			selectedTipPercent = TIPPERCENT15;
			break;
		case R.id.TipPercent20Button:
			selectedTipPercent = TIPPERCENT20;
			break;
		default:
			selectedTipPercent = TIPPERCENT10;
			break;
		}
		calculateTip(selectedTipPercent);
	}
	
	public void calculateTip(int tipPercent) {
		float totalAmount = 0;
		
		if (totalAmountText.getText().toString().trim().length() > 0) {
			totalAmount = Float.parseFloat(totalAmountText.getText().toString());
		}
		
		tipAmountText.setText(String.format("%.2f",  totalAmount * tipPercent/100));
	}
}
