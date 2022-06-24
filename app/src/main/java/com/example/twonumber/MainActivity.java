package com.example.twonumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.twonumber.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private HistoryListViewModel historyModel;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        historyModel = new ViewModelProvider(this).get(HistoryListViewModel.class);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, historyModel.getArrayList().getValue());
        binding.lvHistory.setAdapter(arrayAdapter);
    }

    public void OperationsHandler(View v) {
        try {
            float a = Float.parseFloat(binding.etA.getText().toString());
            float b = Float.parseFloat(binding.etB.getText().toString());
            String str;
            if (v.getId() == binding.btAdd.getId()) {
                str = a + " + " + b + " = " + (a + b);
            } else if (v.getId() == binding.btSub.getId()) {
                str = a + " - " + b + " = " + (a - b);
            } else if (v.getId() == binding.btMul.getId()) {
                str = a + " * " + b + " = " + (a * b);
            } else {
                str = a + " / " + b + " = " + (a / b);
            }
            historyModel.addHistory(str);
            arrayAdapter.notifyDataSetChanged();
        } catch (Exception ignored) {
            Toast.makeText(getApplicationContext(), "Chỉ được nhập số", Toast.LENGTH_SHORT).show();
        }
    }
}