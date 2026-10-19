package com.example.week5noteapp;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        EditText editNote = findViewById(R.id.editNote);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String note = editNote.getText().toString().trim();

            if (note.isEmpty()) {
                editNote.setError("Please enter a note");
                editNote.requestFocus();

                Toast.makeText(
                        AddNoteActivity.this,
                        "Note cannot be empty!",
                        Toast.LENGTH_SHORT
                ).show();

            } else {
                SharedPreferences preferences = getSharedPreferences(
                        "NotesData",
                        MODE_PRIVATE
                );

                preferences.edit()
                        .putString("saved_note", note)
                        .apply();
                Toast.makeText(
                        AddNoteActivity.this,
                        "Note entered successfully!",
                        Toast.LENGTH_SHORT
                ).show();
                finish();
            }
        });

        // Find the Cancel button
        Button btnCancel = findViewById(R.id.btnCancel);

        // Return to MainActivity when Cancel is clicked
        btnCancel.setOnClickListener(v -> {
            finish();
        });
    }
}