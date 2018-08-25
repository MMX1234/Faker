package com.tri.faker.data;

import com.google.gson.annotations.SerializedName;

import org.litepal.crud.LitePalSupport;

public class Crafts extends LitePalSupport {
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

    //基础-最大ATK
    @SerializedName("atk")
    private String atk;

    //基础-最大HP
    @SerializedName("hp")
    private String hp;

    //固有技能基础-最大解放
    @SerializedName("skill")
    private String skill;

    //礼装图标
    @SerializedName("img")
    private String img;

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

    public String getAtk() {
        return atk;
    }

    public void setAtk(String atk) {
        this.atk = atk;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
