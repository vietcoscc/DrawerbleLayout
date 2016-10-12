package com.t3h.model;

/**
 * Created by vaio on 10/10/2016.
 */

public class ItemListView {
    private int iv;
    private String tv;

    public ItemListView(int iv, String tv) {
        this.iv = iv;
        this.tv = tv;
    }

    public int getIv() {
        return iv;
    }

    public void setIv(int iv) {
        this.iv = iv;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }
}
