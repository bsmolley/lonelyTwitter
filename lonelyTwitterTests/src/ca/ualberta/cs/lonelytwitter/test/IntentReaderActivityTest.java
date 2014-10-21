package ca.ualberta.cs.lonelytwitter.test;

import android.content.Intent;
import android.test.ViewAsserts;
import static junit.framework.Assert.*;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

public class IntentReaderActivityTest extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {
	
	public IntentReaderActivityTest() {
			super(IntentReaderActivity.class);
	}
	
	public void testSendText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "test string");
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertEquals("test string", activity.getText());
	}
	
	public void testDoubleText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "test string ");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertEquals("test string test string ", activity.getText());
	}
	
	public void testDisplayText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "test string");
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("test string", widget.getText());
	}
	
	public void testDisplayTextDirect() throws Throwable{
		getActivity();
		runTestOnUiThread(new Runnable() {		
			@Override
			public void run() {
				IntentReaderActivity activity = (IntentReaderActivity) getActivity();
				TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
				widget.setText("test string ");
			}
		});
		
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("test string ", widget.getText());
	}
	
	public void testReverseText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "test string ");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertEquals(" gnirts tset", activity.getText());	
	}
	
	public void testDefaultText() throws Throwable{
		getActivity();
		runTestOnUiThread(new Runnable() {		
			@Override
			public void run() {
				IntentReaderActivity activity = (IntentReaderActivity) getActivity();
				TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
				widget.setText("");
			}
		});		
		runTestOnUiThread(new Runnable() {		
			@Override
			public void run() {
				IntentReaderActivity activity = (IntentReaderActivity) getActivity();
				TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
				if (widget.getText().length() == 0)
					widget.setText("DEFAULT");
				
			}
		});	
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("DEFAULT", widget.getText());
	}
	
	public void testOnScreen() throws Throwable {
		getActivity();
		runTestOnUiThread(new Runnable() {		
			@Override
			public void run() {
				IntentReaderActivity activity = (IntentReaderActivity) getActivity();
				TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
				widget.setText("");
			}
		});		
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), widget);
	}
	
	

}
