package com.tri.faker.data;

import com.google.gson.annotations.SerializedName;

import org.litepal.crud.LitePalSupport;

public class Equip extends LitePalSupport {
    //礼装id
    @SerializedName("id")
    private int id;

    //礼装名称
    @SerializedName("cnName")
    private String cnName;

    //礼装星级
    @SerializedName("rank")
    private String rank;

    //消耗
    @SerializedName("cost")
    private String cost;

    //礼装绘师
    @SerializedName("painter")
    private String painter;

    //基础ATK
    @SerializedName("baseATK")
    private String baseATK;

    //基础HP
    @SerializedName("baseHP")
    private String baseHP;

    //最高ATK
    @SerializedName("maxATK")
    private String maxATK;

    //最高HP
    @SerializedName("maxHP")
    private String maxHP;

    //固有技能基础
    @SerializedName("skillBase")
    private String skillBase;

    //固有技能最大
    @SerializedName("skillMax")
    private String skillMax;

    //技能图标
    @SerializedName("icon")
    private String icon;

    //礼装说明
    @SerializedName("description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPainter() {
        return painter;
    }

    public void setPainter(String painter) {
        this.painter = painter;
    }

    public String getBaseATK() {
        return baseATK;
    }

    public void setBaseATK(String baseATK) {
        this.baseATK = baseATK;
    }

    public String getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(String baseHP) {
        this.baseHP = baseHP;
    }

    public String getMaxATK() {
        return maxATK;
    }

    public void setMaxATK(String maxATK) {
        this.maxATK = maxATK;
    }

    public String getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(String maxHP) {
        this.maxHP = maxHP;
    }

    public String getSkillBase() {
        return skillBase;
    }

    public void setSkillBase(String skillBase) {
        this.skillBase = skillBase;
    }

    public String getSkillMax() {
        return skillMax;
    }

    public void setSkillMax(String skillMax) {
        this.skillMax = skillMax;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
