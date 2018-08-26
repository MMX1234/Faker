package com.tri.faker.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tri.faker.data.Crafts;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CraftsUtil {
    public void setCraftsData(Context context) {
        JsonFileUtil jsonFileUtil = new JsonFileUtil();
        String json = jsonFileUtil.getJson(context, "json/礼装图鉴.json");

        /*String url = "https://raw.githubusercontent.com/MMX1234/Faker/master/app/src/main/assets/json/link.json";
        OkHttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                Log.e("TAG", responseText);
            }

            @Override
            public void onFailure(Call call, IOException e) {

            }
        });*/

        Gson gson = new Gson();
        List<Crafts> list = gson.fromJson(json, new TypeToken<List<Crafts>>() {
        }.getType());
        for (int i = 0; i < list.size(); i++) {
            Crafts crafts = new Crafts();
            crafts.setId(list.get(i).getId());
            crafts.setCnName(list.get(i).getCnName());
            crafts.setRank(list.get(i).getRank());
            crafts.setCost(list.get(i).getCost());
            crafts.setAtk(list.get(i).getAtk());
            crafts.setHp(list.get(i).getHp());
            crafts.setSkill(list.get(i).getSkill());
            crafts.setImg(list.get(i).getImg());
            crafts.setIcon(list.get(i).getIcon());
            crafts.setDescription(list.get(i).getDescription());
            crafts.save();
        }

        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString("isTrue", "true");
        editor.apply();
    }
}
