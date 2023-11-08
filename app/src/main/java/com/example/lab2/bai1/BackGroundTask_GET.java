package com.example.lab2.bai1;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.example.lab2.MainActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BackGroundTask_GET extends AsyncTask<Void, Void, Void> {
    String duongdan = Bai1Activity.link_api;
    TextView tvResult;
    String strName, strScore;
    String str;
    ProgressDialog progressDialog;
    Context context;

    public BackGroundTask_GET(TextView tvResult, String strName, String strScore, Context context) {
        this.tvResult = tvResult;
        this.strName = strName;
        this.strScore = strScore;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        duongdan += "?name=" + this.strName + "&score=" + this.strScore;
        try {
            URL url = new URL(duongdan);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line = "";
            StringBuffer stringBuffer =  new StringBuffer();
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            str = stringBuffer.toString();
            httpURLConnection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("sending...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
            tvResult.setText(str);
    }
}
