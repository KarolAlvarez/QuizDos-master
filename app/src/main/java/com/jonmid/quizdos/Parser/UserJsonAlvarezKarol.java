package com.jonmid.quizdos.Parser;

import com.jonmid.quizdos.Models.UserModelAlvarezKarol;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/10/17.
 */

public class UserJsonAlvarezKarol {


    public static List<UserModelAlvarezKarol> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<UserModelAlvarezKarol> modelAlvarezKarolList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            UserModelAlvarezKarol modelUser = new UserModelAlvarezKarol();

            JSONObject direcion = item.getJSONObject("address");
            modelUser.setAddress(direcion.getString("street"));

            JSONObject company=item.getJSONObject("company");
            modelUser.setNameCompany(company.getString("name"));

            modelUser.setName(item.getString("name"));
            modelUser.setEmail(item.getString("email"));
            modelUser.setPhone(item.getString("phone"));
            modelUser.setUsername(item.getString("username"));

            modelAlvarezKarolList.add(modelUser);

        }
        return modelAlvarezKarolList;
    }
}