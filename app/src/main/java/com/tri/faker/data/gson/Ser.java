package com.tri.faker.data.gson;

import com.google.gson.annotations.SerializedName;

import org.litepal.crud.LitePalSupport;

public class Ser extends LitePalSupport {
    // 编号
    @SerializedName("id")
    private int id;

    // 中文名
    @SerializedName("cnName")
    private String cnName;

    // 英文名（罗马音）
    @SerializedName("enName")
    private String enName;

    // 日文名
    @SerializedName("jpName")
    private String jpName;

    //职阶
    @SerializedName("class")
    private String className;

    // 星级
    @SerializedName("rank")
    private String rank;

    // 阵营（天地人星兽）
    @SerializedName("faction")
    private String faction;

    // 基础Atk
    @SerializedName("baseATK")
    private String baseATK;

    // 基础Hp
    @SerializedName("baseHP")
    private String baseHP;

    // 灵基4阶段ATK
    @SerializedName("break4ATK")
    private String break4ATK;

    // 灵基4阶段HP
    @SerializedName("break4HP")
    private String break4HP;

    // 蓝卡Hits
    @SerializedName("artsHits")
    private String hitsArts;

    // 红卡Hits
    @SerializedName("busterHits")
    private String hitsBuster;

    // 绿卡Hits
    @SerializedName("quickHits")
    private String hitsQuick;

    // Extra卡Hits
    @SerializedName("extraHits")
    private String hitsExtra;

    // 绘师
    @SerializedName("painter")
    private String painter;

    // CV
    @SerializedName("cv")
    private String cv;

    // 属性（秩序·善）
    @SerializedName("align")
    private String align;

    // 性别
    @SerializedName("gender")
    private String gender;

    // 地域
    @SerializedName("region")
    private String region;

    // 出处
    @SerializedName("source")
    private String source;

    // 身高
    @SerializedName("height")
    private String height;

    // 体重
    @SerializedName("weight")
    private String weight;

    // 掉星率
    @SerializedName("starGeneration")
    private String starGeneration;

    // 即死率
    @SerializedName("death")
    private String death;

    // 暴击权重
    @SerializedName("starAbsorption")
    private String starAbsorption;

    // 进攻NP获取率
    @SerializedName("npChargeATK")
    private String npChargeATK;

    // 受伤NP获取率
    @SerializedName("npChargeDEF")
    private String npChargeDEF;

    // 成长曲线
    @SerializedName("growth")
    private String growth;

    // 昵称
    @SerializedName("nickName")
    private String nickName;

    // 特性（所爱之人）
    @SerializedName("traits")
    private String traits;

    // 入手途径
    @SerializedName("way")
    private String way;
    // 筋力tension
    // 耐久durable
    // 敏捷agile
    // 魔力magic
    // 幸运lucky
    // 宝具treasure

    /*public Ser(int id, String cnName, String enName, String jpName, String rank, String faction, String baseATK, String baseHP, String break4ATK, String break4HP, String hitsArts, String hitsBuster, String hitsQuick, String hitsExtra, String painter, String cv, String align, String gender, String region, String source, String height, String weight, String starGeneration, String death, String starAbsorption, String npChargeATK, String npChargeDEF, String growth, String nickName, String traits, String way) {
        this.id = id;
        this.cnName = cnName;
        this.enName = enName;
        this.jpName = jpName;
        this.rank = rank;
        this.faction = faction;
        this.baseATK = baseATK;
        this.baseHP = baseHP;
        this.break4ATK = break4ATK;
        this.break4HP = break4HP;
        this.hitsArts = hitsArts;
        this.hitsBuster = hitsBuster;
        this.hitsQuick = hitsQuick;
        this.hitsExtra = hitsExtra;
        this.painter = painter;
        this.cv = cv;
        this.align = align;
        this.gender = gender;
        this.region = region;
        this.source = source;
        this.height = height;
        this.weight = weight;
        this.starGeneration = starGeneration;
        this.death = death;
        this.starAbsorption = starAbsorption;
        this.npChargeATK = npChargeATK;
        this.npChargeDEF = npChargeDEF;
        this.growth = growth;
        this.nickName = nickName;
        this.traits = traits;
        this.way = way;
    }*/

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

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getJpName() {
        return jpName;
    }

    public void setJpName(String jpName) {
        this.jpName = jpName;
    }

    @Override
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
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

    public String getBreak4ATK() {
        return break4ATK;
    }

    public void setBreak4ATK(String break4ATK) {
        this.break4ATK = break4ATK;
    }

    public String getBreak4HP() {
        return break4HP;
    }

    public void setBreak4HP(String break4HP) {
        this.break4HP = break4HP;
    }

    public String getHitsArts() {
        return hitsArts;
    }

    public void setHitsArts(String hitsArts) {
        this.hitsArts = hitsArts;
    }

    public String getHitsBuster() {
        return hitsBuster;
    }

    public void setHitsBuster(String hitsBuster) {
        this.hitsBuster = hitsBuster;
    }

    public String getHitsQuick() {
        return hitsQuick;
    }

    public void setHitsQuick(String hitsQuick) {
        this.hitsQuick = hitsQuick;
    }

    public String getHitsExtra() {
        return hitsExtra;
    }

    public void setHitsExtra(String hitsExtra) {
        this.hitsExtra = hitsExtra;
    }

    public String getPainter() {
        return painter;
    }

    public void setPainter(String painter) {
        this.painter = painter;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getStarGeneration() {
        return starGeneration;
    }

    public void setStarGeneration(String starGeneration) {
        this.starGeneration = starGeneration;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getStarAbsorption() {
        return starAbsorption;
    }

    public void setStarAbsorption(String starAbsorption) {
        this.starAbsorption = starAbsorption;
    }

    public String getNpChargeATK() {
        return npChargeATK;
    }

    public void setNpChargeATK(String npChargeATK) {
        this.npChargeATK = npChargeATK;
    }

    public String getNpChargeDEF() {
        return npChargeDEF;
    }

    public void setNpChargeDEF(String npChargeDEF) {
        this.npChargeDEF = npChargeDEF;
    }

    public String getGrowth() {
        return growth;
    }

    public void setGrowth(String growth) {
        this.growth = growth;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTraits() {
        return traits;
    }

    public void setTraits(String traits) {
        this.traits = traits;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }
}
