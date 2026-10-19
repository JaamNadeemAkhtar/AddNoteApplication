package com.example.week5noteapp;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAddNote = findViewById(R.id.btnAddNote);

        btnAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    AddNoteActivity.class
            );
            startActivity(intent);
        });
        TextView txtSavedNote = findViewById(R.id.txtSavedNote);

        SharedPreferences preferences = getSharedPreferences(
                "NotesData",
                MODE_PRIVATE
        );

        String savedNote = preferences.getString(
                "saved_note",
                ""
        );

        if (savedNote.isEmpty()) {
            txtSavedNote.setText("No saved note yet");
        } else {
            txtSavedNote.setText(savedNote);
        }
    }
}