package com.mangoblogger.app;

import android.support.v7.app.AppCompatActivity;


/*
* This is just for testing do not consider it.
* */
public class ManogMain extends AppCompatActivity {



    /*List<Object> list;
    Map<String, Object> postMap;
    Map<String, Object> anoMap;
    String postTitle[];
    ProgressDialog progressDialog;
    Gson gson;
    String url = "https://www.mangoblogger.com/wp-json/wp/v2/posts/?per_page=60";
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loding.....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                gson = new Gson();
                list = (List) gson.fromJson(response, List.class);
                postTitle = new String[list.size()];

                for (int i = 0; i < list.size(); i++) {

                    postMap = (Map<String, Object>) list.get(i);
                    anoMap = (Map<String, Object>) postMap.get("title");
                    postTitle[i] = (String)anoMap.get("rendered");

                }

                listView.setAdapter(new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, postTitle));
                progressDialog.dismiss();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "There is something error", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);


    }*/
}
