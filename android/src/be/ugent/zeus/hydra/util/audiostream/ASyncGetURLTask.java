/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.zeus.hydra.util.audiostream;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author silox
 */
public class ASyncGetURLTask extends AsyncTask<String, Void, String> {

    protected String doInBackground(String... URL) {

        BufferedReader in;

        try {
            URL urls = new URL(URL[0]);
            in = new BufferedReader(new InputStreamReader(urls.openStream()));

            String str;
            String url = "";
            while ((str = in.readLine()) != null) {
                if (str.startsWith("http://")) {
                    url = str;
                }
            }
            
            try {
                in.close();
            } catch (IOException e) {
            }
            
            return url;
            
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    protected void onPostExecute(String URL) {
        MusicService.mp3URL = URL;
    }
}
