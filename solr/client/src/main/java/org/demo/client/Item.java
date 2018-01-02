package org.demo.client;

public class Item {
    private String id;
    private String name;
    private String store_no;
    private String update_time;
    private String insert_time;

    public Item() {
        this.id = "";
        this.name = "";
        this.store_no = "";
        this.update_time = "";
        this.insert_time = "";
    }

    public Item(String id, String name, String store_no, String update_time, String insert_time) {
        this.id = id;
        this.name = name;
        this.store_no = store_no;
        this.update_time = update_time;
        this.insert_time = insert_time;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String _id) {
        this.id = _id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String _name) {
        this.name = _name;
    }

    public String getStore_no() {
        return this.store_no;
    }
    public void setStore_no(String _store_no) {
        this.store_no = _store_no;
    }

    public String getUpdate_time() {
        return this.update_time;
    }
    public void setUpdate_time(String _update_time) {
        this.update_time = _update_time;
    }

    public String getInsert_time() {
        return this.insert_time;
    }
    public void setInsert_time(String _insert_time) {
        this.insert_time = _insert_time;
    }
}
