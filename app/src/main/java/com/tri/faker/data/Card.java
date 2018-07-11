package com.tri.faker.data;

public class Card {
    private String name;
    private int imgId;
    private int cardType;

    public Card(String name, int imgId, int cardType) {
        this.name = name;
        this.imgId = imgId;
        this.cardType = cardType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }
}
