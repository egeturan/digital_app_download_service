package com.example.demo.components;

public class Settings {
    int set_id;
    int theme;
    int layout;

    public int getSet_id() {
        return set_id;
    }

    public void setSet_id(int set_id) {
        this.set_id = set_id;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public int getDark_mode() {
        return dark_mode;
    }

    public void setDark_mode(int dark_mode) {
        this.dark_mode = dark_mode;
    }

    int dark_mode;
}
