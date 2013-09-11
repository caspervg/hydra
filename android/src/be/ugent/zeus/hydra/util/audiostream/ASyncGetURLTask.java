/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.zeus.hydra.util.audiostream;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageButton;
import be.ugent.zeus.hydra.R;
import be.ugent.zeus.hydra.Urgent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author silox
 */
public class ASyncGetURLTask extends AsyncTask<String, Void, String> {

    Urgent parent;
    
    public ASyncGetURLTask(Urgent parent) {
        this.parent = parent;
    }

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
        parent.attachListener();
    }
}
