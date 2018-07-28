package com.tri.faker.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tri.faker.data.Equip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class EquipUtil {
    public void setEquipData(Context context) {
        String fileName = "json/equip.json";
        StringBuilder stringBuilder = new StringBuilder();
        //获得assets资源管理器
        AssetManager assetManager = context.getAssets();
        //使用IO流读取json文件内容
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName), "utf-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json = stringBuilder.toString();
        Gson gson = new Gson();
        List<Equip> list = gson.fromJson(json, new TypeToken<List<Equip>>() {
        }.getType());
        for (int i = 0; i < list.size(); i++) {
            Equip equip = new Equip();
            equip.setId(list.get(i).getId());
            equip.setCnName(list.get(i).getCnName());
            equip.setRank(list.get(i).getRank());
            equip.setCost(list.get(i).getCost());
            equip.setPainter(list.get(i).getPainter());
            equip.setBaseATK(list.get(i).getBaseATK());
            equip.setBaseHP(list.get(i).getBaseHP());
            equip.setMaxATK(list.get(i).getMaxATK());
            equip.setMaxHP(list.get(i).getMaxHP());
            equip.setSkillBase(list.get(i).getSkillBase());
            equip.setSkillMax(list.get(i).getSkillMax());
            equip.setIcon(list.get(i).getIcon());
            equip.setDescription(list.get(i).getDescription());
            equip.save();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("注意！");
        builder.setMessage("在点击图标进入详情时\n\n会获取高清立绘，并自动缓存\n\n下次加载不消耗流量\n\n建议wifi环境下查看\n\n后续完善图片开关");
        builder.create().show();

        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString("isTrue", "true");
        editor.apply();
    }
}
