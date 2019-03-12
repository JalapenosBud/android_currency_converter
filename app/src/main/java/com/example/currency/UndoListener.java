package com.example.currency;

import android.view.View;

public class UndoListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        System.out.println("undid users last action");
    }
}
