package com.jonmid.quizdos.Fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.jonmid.quizdos.Adapter.UserAdapterAlvarezKarol;
import com.jonmid.quizdos.Conection.HttpManagerAlvarezKarol;
import com.jonmid.quizdos.Models.UserModelAlvarezKarol;
import com.jonmid.quizdos.Parser.UserJsonAlvarezKarol;
import com.jonmid.quizdos.R;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {
    private ProgressBar progressBar;
    private Button button;
    private RecyclerView recyclerView;
    List<UserModelAlvarezKarol> userModelAlvarezKarolList;
    private UserAdapterAlvarezKarol userAdapterAlvarezKarol;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        progressBar = (ProgressBar) findViewById(R.id.id_pb_item_2);
        button = (Button) findViewById(R.id.id_btn_listcountries_2);
        recyclerView = (RecyclerView) findViewById(R.id.id_rv_item_2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        loadData2();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }


    public void loadData2() {
        TaskCountry2 taskCountry = new TaskCountry2();
        taskCountry.execute("https://jsonplaceholder.typicode.com/users");

    }

    public void processData() {
        //adapterCountry = new AdapterCountry(countryList, getApplicationContext());
        //recyclerView.setAdapter(adapterCountry);
        userAdapterAlvarezKarol = new UserAdapterAlvarezKarol(userModelAlvarezKarolList, getActivity());
        recyclerView.setAdapter(userAdapterAlvarezKarol);
    }

    public class TaskCountry2 extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            String content = null;
            try {
                content = HttpManagerAlvarezKarol.getData(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                //countryList = JsonCountry.getData(s);
                userModelAlvarezKarolList = UserJsonAlvarezKarol.getData(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            processData();

            progressBar.setVisibility(View.GONE);
        }
    }


}
