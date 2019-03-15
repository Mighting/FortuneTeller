package zbc.assignment.fortuneteller;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPRequest extends AsyncTask<String, Void, Void> {
    URL url;
    String json;
    Gson gson;
    FortunePresenter fortunePresenter;

    public HTTPRequest(FortunePresenter fortunePresenter) {
        this.fortunePresenter = fortunePresenter;
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            url = new URL("http://yerkee.com/api/fortune");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            json = convertInputStreamToString(inputStream);
            Log.e("tg", "doInBackground: call");
        } catch (IOException ex) {

        }
        return null;
    }

    private String convertInputStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        //Use Gson here

        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

        Fortune fortuneintextform = gson.fromJson(json,Fortune.class);

        //Log.e("tg", fortuneintextform.getFortune());

        fortunePresenter.SetFortune(fortuneintextform);
    }
}
