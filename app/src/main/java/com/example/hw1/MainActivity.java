package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreateMainLayout();
        CreateTable();
    }

    private void CreateMainLayout()
    {
        // Create the main layout.
        mainLayout = new LinearLayout(this);

        LayoutParams lpMain = new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setLayoutParams(lpMain);
        mainLayout.setBackgroundColor(Color.GRAY);

        setContentView(mainLayout, lpMain);
    }

    private void CreateTable()
    {
        // Construct the table.
        tableLayout = new TableLayout(this);

        // The layout parameters for the table view.
        LayoutParams lpTable = new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        tableLayout.setStretchAllColumns(true);
        tableLayout.setBackgroundColor(Color.BLACK);
        tableLayout.setLayoutParams(lpTable);

        // Create the first table row.

        // The first table row for the table.
        TableRow tableRow1 = new TableRow(this);

        LayoutParams lpRow = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpRow.setMargins(5,5,5,5);

        // The first text box for the table row.
        TextView text1 = new TextView(this);

        text1.setText("Rules void hello1(int hour)");
        text1.setTextColor(Color.WHITE);
        text1.setGravity(Gravity.CENTER);

        tableRow1.setLayoutParams(lpRow);
        tableRow1.setBackgroundColor(Color.BLACK);
        tableRow1.addView(text1);

        tableLayout.addView(tableRow1);

        for(int i = 0; i < 5; i++) {
            CreateRow2();
        }

        // Add the table to the main view.
        mainLayout.addView(tableLayout, lpTable);
    }

    private void CreateRow2()
    {
        // The table's second row.
        TableRow tableRow2 = new TableRow(this);

        // The layout parameters for the row.
        LayoutParams lpRow = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpRow.setMargins(10, 10,10,10);

        // The first text box for the table row.
        TextView text1 = new TextView(this);
        text1.setText("TEST");
        text1.setTextColor(Color.BLACK);
        text1.setGravity(Gravity.CENTER);
        text1.setBackgroundColor(Color.WHITE);

        tableRow2.setLayoutParams(lpRow);
        tableRow2.setBackgroundColor(Color.BLACK);
        tableRow2.addView(text1);

        tableLayout.addView(tableRow2);
    }

    // Variables:

    // The table being displayed.
    private TableLayout tableLayout;

    // The main layout of the app (hard coded).
    private LinearLayout mainLayout;
}
