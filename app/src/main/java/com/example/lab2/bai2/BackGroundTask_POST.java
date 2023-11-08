package com.example.lab2.bai2;

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
import java.security.Principal;

public class BackGroundTask_POST extends AsyncTask<Void, Void, Void> {
    String duongdanbai2 = Bai2Activity.link_api_bai2;
    Context context;
    String strCD, strCR;
    TextView tvResultbai2;
    ProgressDialog progressDialog;
    String strResult;

    public BackGroundTask_POST(Context context, String strCD, String strCR, TextView tvResultbai2) {
        this.context = context;
        this.strCD = strCD;
        this.strCR = strCR;
        this.tvResultbai2 = tvResultbai2;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(duongdanbai2);
            String param = "chieurong=" + URLEncoder.encode(strCR, "utf-8") + "&chieudai="
                    + URLEncoder.encode(strCD, "utf-8");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setFixedLengthStreamingMode(param.getBytes().length);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            printWriter.print(param);
            printWriter.close();

            String line = "";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuffer stringBuffer =new StringBuffer();
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            strResult = stringBuffer.toString();
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
        progressDialog.setMessage("Calculating...");
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
        tvResultbai2.setText(strResult);
    }
}
