package com.example.bottomsheeddialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonsheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonsheet = findViewById(R.id.bottom_sheet);
        buttonsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        final Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);
        LinearLayout editLayout=dialog.findViewById(R.id.linearLayoutEdit);
        LinearLayout shareLayout=dialog.findViewById(R.id.linearLayoutShare);
        LinearLayout printLayout=dialog.findViewById(R.id.linearLayoutPrint);
        LinearLayout uploadLayout=dialog.findViewById(R.id.linearLayoutUpload);
        ImageView exitImageView=dialog.findViewById(R.id.exitImageView);


        editLayout.setOnClickListener(view ->{Toast.makeText(MainActivity.this,"edited click",Toast.LENGTH_SHORT).show();
        });
        shareLayout.setOnClickListener(view -> Toast.makeText(MainActivity.this,"share click",Toast.LENGTH_SHORT).show());
        printLayout.setOnClickListener(view -> Toast.makeText(MainActivity.this,"print click",Toast.LENGTH_SHORT).show());
        uploadLayout.setOnClickListener(view -> Toast.makeText(MainActivity.this,"upload click",Toast.LENGTH_SHORT).show());
        exitImageView.setOnClickListener(view -> {
            dialog.dismiss();
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}