package model;

public class MainStorage {
    Plant[] data;

    public MainStorage() {
        data = null;
    }

    public MainStorage(Plant[] data) {
        this.data = data;
    }

    public void setData(Plant[] data) {
        this.data = data;
    }

    public Plant[] getData() {
        return this.data;
    }
}