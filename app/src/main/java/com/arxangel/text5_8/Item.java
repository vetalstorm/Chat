package com.arxangel.text5_8;

/**
 * Created by Архангел on 02.08.2016.
 */
public class Item {
    private String sex;
    private String text;
    private int type;


    public Item(String sex, String text) {
        this.sex = sex;
        this.text = text;
    }

    public Item(String sex, String text, int type) {
        this.sex = sex;
        this.text = text;
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public String getText() {
        return text;
    }

    public int getType() {
        return type;
    }
}
