package com.example.myapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TextViewModel extends ViewModel {

    private MutableLiveData<String> text = new MutableLiveData<>("Hallo ich bin ein ViewModel");

    public MutableLiveData<String> getText() {
        return text;
    }

    public void setText(String text) {
        this.text.setValue(text);
    }
}
