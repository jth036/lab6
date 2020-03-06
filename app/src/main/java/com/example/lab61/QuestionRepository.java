package com.example.lab61;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;

import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class QuestionRepository {

    private MutableLiveData<ArrayList<Questions>> questionData;
    private String url = "https://opentdb.com/api.php?amount=10&category=12&difficulty=easy&type=multiple";
    private RequestQueue requestQueue;
    private Context context;
    String mUrl= "https://opentdb.com/api.php?amount=10";
    public QuestionRepository () {
        this.questionData = new MutableLiveData<>();
    }

    /**
     * @return Observerbar data (liste med brukere)
     */
    public MutableLiveData<ArrayList<Questions>> getData() {
        return this.questionData;
    }

    /**
     * Laster ned data og parser v.h.a. Gson før melding om endring gis til de som observerer.
     * @param guiContext
     */
    public void downloadUserData(Context guiContext) {
        this.requestQueue = Volley.newRequestQueue(guiContext);
        try {
            JsonArrayRequest userJsonArrayRequest = new JsonArrayRequest(
                    Request.Method.GET,
                    url,
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Gson gson;
                            GsonBuilder gsonBuilder = new GsonBuilder();
                            gson = gsonBuilder.create();
                            Type dataListType = new TypeToken<ArrayList<Questions>>(){}.getType();
                            ArrayList<Questions> downloadedUsers = gson.fromJson(response.toString(), dataListType);



                            questionData.postValue(downloadedUsers); // postValue -> Gi beskjed til observers
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
            this.requestQueue.add(userJsonArrayRequest);
        } catch (Exception e) {

        }
    }

    public void testMethod(final Context guiContext){
        CustomRequest request = new CustomRequest(Request.Method.GET, mUrl,
                new Response.Listener<byte[]>() {
                    @Override
                    public void onResponse(byte[] response) {
                        // TODO handle the response
                        try {
                            if (response!=null) {

                                FileOutputStream outputStream;
                                String name="test2.txt";
                                outputStream = guiContext.openFileOutput(name, Context.MODE_PRIVATE);
                                outputStream.write(response);
                                outputStream.close();
                                Toast.makeText(guiContext, "Download complete.", Toast.LENGTH_LONG).show();

                            }
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            Log.d("KEY_ERROR", "UNABLE TO DOWNLOAD FILE");
                            e.printStackTrace();
                        }
                    }
                } ,new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO handle the error
                error.printStackTrace();
            }
        }, null);
        RequestQueue mRequestQueue = Volley.newRequestQueue(guiContext, new HurlStack());
        mRequestQueue.add(request);}
}
