package com.tri.faker.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tri.faker.data.Crafts;

import java.util.List;

public class CraftsUtil {
    public void setCraftsData(Context context) {
        JsonFileUtil jsonFileUtil = new JsonFileUtil();
        String json = jsonFileUtil.getJson(context, "json/礼装图鉴.json");
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
