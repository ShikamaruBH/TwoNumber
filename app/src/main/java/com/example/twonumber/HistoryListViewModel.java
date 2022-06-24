package com.example.twonumber;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class HistoryListViewModel extends ViewModel {

    private MutableLiveData<ArrayList<String>> arrayList;
    public LiveData<ArrayList<String>> getArrayList() {
        if (arrayList == null) {
            arrayList = new MutableLiveData<>();
            arrayList.setValue(new ArrayList<>());
        }
        return arrayList;
    }

    public void addHistory(String str) {
        ArrayList<String> l = arrayList.getValue();
        l.add(0, str);
        arrayList.setValue(l);
    }
}
