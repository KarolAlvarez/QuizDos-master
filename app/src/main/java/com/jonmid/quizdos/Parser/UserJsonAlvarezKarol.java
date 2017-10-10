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

            countryDetail.setLanguages(languagesItem.getString("nativeName"));


            modelPhoto.setTitle(item.getString("title"));
            modelPhoto.setThumbnailUrl(item.getString("thumbnailUrl"));
            modelPhoto.setFoto(item.getString("url"));
            modelPhoto.setId(item.getInt("id"));
            modelPhotoList.add(modelPhoto);
        }
        return modelPhotoList;
    }
}