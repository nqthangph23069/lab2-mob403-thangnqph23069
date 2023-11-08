package com.example.lab2.bai3;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackGroundTask_Bai3 extends AsyncTask<String, Void, Void> {
    String duongdan = Bai3Activity.link_api_bai3;
    String strKq;
    TextView tvKq;
    Context context;
    ProgressDialog progressDialog;

    public BackGroundTask_Bai3(TextView tvKq, Context context) {
        this.tvKq = tvKq;
        this.context = context;
    }

    @Override
    protected Void doInBackground(String... params) {
        try {
            URL url = new URL(duongdan);
            String param = "canh=" + URLEncoder.encode(params[0].toString(), "utf-8");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setFixedLengthStreamingMode(param.getBytes().length);
            httpURLConnection.setRequestProperty("Content-Type", "application/X-www-form-urlencoded");

            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            printWriter.print(param);
            printWriter.close();

            String line = "";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            strKq = stringBuffer.toString();
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
        progressDialog.setMessage("Caculating...");
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
        tvKq.setText(strKq);
    }
}
