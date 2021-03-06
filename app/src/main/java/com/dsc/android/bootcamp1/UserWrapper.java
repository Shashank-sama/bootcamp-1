package com.dsc.android.bootcamp1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class UserWrapper implements Serializable {

    @SerializedName("datalist")
    @Expose
    private List<RecyclerViewdata> recyclerViewdata;

    public List<RecyclerViewdata> getRecyclerViewdata() {
        return recyclerViewdata;
    }

    public void setRecyclerViewdata(List<RecyclerViewdata> recyclerViewdata) {
        this.recyclerViewdata = recyclerViewdata;
    }
}