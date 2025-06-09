
package subham.sinha.dev.CatFacts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import android.view.Gravity;


public class MainActivity extends Activity {
	TextView tv;
	Button btn;
	LinearLayout outline,root;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new FetchCatFact().execute("https://catfact.ninja/fact");
		
		tv=findViewById(R.id.activity_mainTextView);
		outline=findViewById(R.id.outline);
		btn=findViewById(R.id.activity_mainButton);
		root=findViewById(R.id.root);
		getActionBar().hide();
		getWindow().setNavigationBarColor(Color.parseColor("#8F87F1"));
		getWindow().setStatusBarColor(Color.parseColor("#8F87F1"));
		GradientDrawable gd=new GradientDrawable();
		
		gd.setCornerRadius(30);
		gd.setStroke(3,Color.BLACK);
		gd.setColor(Color.parseColor("#E9A5F1"));
		
		GradientDrawable gd_=new GradientDrawable();

		gd_.setCornerRadius(30);
		gd_.setStroke(3,Color.BLACK);
		gd_.setColor(Color.parseColor("#C68EFD"));
		
		outline.setBackgroundDrawable(gd);
		btn.setBackgroundDrawable(gd_);
	
		btn.setOnClickListener(new View.OnClickListener(){
			public void onClick(View  v){
				
				new FetchCatFact().execute("https://catfact.ninja/fact");
				//root.setBackgroundColor(Color.parseColor("#410445"));
				Toast.makeText(getApplication(), "Recieved", Toast.LENGTH_SHORT).show();
			}
			
		});
		}
		


		
		public void github(View v){
		
			Intent i=new Intent().setAction(Intent.ACTION_VIEW).setData(Uri.parse("https://github.com/subhamsinhadev"));
			startActivity(i);
		}
		
		public void info (View v){
			AlertDialog dialog = new AlertDialog.Builder(this)
				.setTitle("About")
				.setMessage("Coded By Subham Kumar Sinha :) API Implementation ")
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dia, int which) {

                    }
				})
				
				.create();
			dialog.show();
			GradientDrawable gd_=new GradientDrawable();

			gd_.setCornerRadius(30);
			gd_.setStroke(3,Color.BLACK);
			gd_.setColor(Color.parseColor("#C68EFD"));
			
			dialog.getWindow().setBackgroundDrawable(gd_);
		}
		

	
	private class FetchCatFact extends AsyncTask<String,Void,String> {

		@Override
		protected String doInBackground(String[] str) {
			StringBuilder response=new StringBuilder();
			try {
				URL link=new URL(str[0]);
				try {
					HttpsURLConnection con=(HttpsURLConnection) link.openConnection();
					con.setRequestMethod("GET");
					con.setReadTimeout(5000);
					con.setConnectTimeout(5000);
					if(con.getResponseCode()==HttpsURLConnection.HTTP_OK){
						InputStream is=	con.getInputStream();
						InputStreamReader isr=new InputStreamReader(is);
						BufferedReader read=new BufferedReader(isr);
						String line;
						while((line=read.readLine())!=null){
							response.append(line).append("\n");
							
						}
						
						read.close();
						//response.append(read);
						//tv.setText(response);
						//setContentView(tv);

con.disconnect();


					}else{
						//tv.setText("Error");
					}
				} catch (IOException e) {}
				

			} catch (MalformedURLException e) {}
			return response.toString();
			
	}

		@Override
		protected void onPostExecute(String result) {
			try {
				JSONObject json=new JSONObject(result);
			String fact=	json.getString("fact");
			tv.setText(fact);
			} catch (JSONException e) {}
			//tv.setText();
			super.onPostExecute(result);
		}

		
	} 

	
	
} /* Released_By_SubhamSinha https://t.me/Masked_Modder */


