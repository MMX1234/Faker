package com.tri.faker.util;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JsonFileUtil {
    public String getJson(Context context, String fileName) {
        //获得assets资源管理器
        AssetManager assetManager = context.getAssets();

        //使用IO流读取json文件内容
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName), "utf-8"));
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
