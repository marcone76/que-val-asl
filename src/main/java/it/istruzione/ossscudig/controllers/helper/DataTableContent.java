package it.istruzione.ossscudig.controllers.helper;

import java.util.List;

public class DataTableContent<T extends Object> {
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
