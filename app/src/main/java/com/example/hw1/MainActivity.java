package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.GridLayout;
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

    // Creates the main layout for the entire table.
    private void CreateMainLayout()
    {
        // Create the main layout.
        mainLayout = new LinearLayout(this);

        // The layout params for the main table.
        LayoutParams lpMain = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);

        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setLayoutParams(lpMain);
        mainLayout.setBackgroundColor(Color.GRAY);

        setContentView(mainLayout, lpMain);
    }

    // Creates the main table. It has two rows, one for the header, and another for the grid.
    private void CreateTable()
    {
        // Construct the table.
        tableLayout = new TableLayout(this);

        // The layout parameters for the table view.
        TableLayout.LayoutParams lpTable = new TableLayout.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT);

        // The layout parameters for the table row 1.
        TableRow.LayoutParams lpRow1 = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        lpRow1.weight = 1;
        lpRow1.setMargins(4,4,4,4);

        tableLayout.setStretchAllColumns(true);
        tableLayout.setBackgroundColor(Color.BLACK);
        tableLayout.setLayoutParams(lpTable);

        // Create the first table row.

        // The first table row for the table.
        TableRow tableRow1 = new TableRow(this);

        // The first text box for the table row.
        TextView text1 = new TextView(this);

        tableRow1.setLayoutParams(lpRow1);
        tableRow1.setBackgroundColor(Color.BLACK);

        text1.setLayoutParams(lpRow1);
        text1.setText("Rules void hello1(int hour)");
        text1.setTextColor(Color.WHITE);
        text1.setBackgroundColor(Color.BLACK);
        text1.setTextSize(10.0f);
        text1.setGravity(Gravity.CENTER);

        tableRow1.addView(text1);

        tableLayout.addView(tableRow1);

        CreateRow2();

        // Add the table to the main layout.
        mainLayout.addView(tableLayout, lpTable);
    }

    // Creates the second row of the table, which is a grid layout of all the text values.
    private void CreateRow2()
    {
        // The table's second row.
        TableRow tableRow2 = new TableRow(this);

        // The grid layout for all the individual cells with large black border lines.
        GridLayout gridLayout = new GridLayout(this);

        // The padding for the text boxes.
        int textBoxPaddingH = 8;
        int textBoxPaddingV = 2;

        // The color codes for the different text colors.
        String ColorWhiteStr = "#FFFFFF";
        String ColorBlueStr = "#A0EAFF";
        String ColorYellowStr = "#FFFF99";
        String ColorOrangeStr = "#FFC099";

        // The layout parameters for the row.
        TableRow.LayoutParams lpRow = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        lpRow.setMargins(4, 4,4,4);

        // Set up the grid layout.
        gridLayout.setLayoutParams(lpRow);
        gridLayout.setBackgroundColor(Color.BLACK);

        // Set up the table row.
        tableRow2.setLayoutParams(lpRow);
        tableRow2.addView(gridLayout);

        tableLayout.addView(tableRow2);

        // The specifications for the grid.
        GridLayout.Spec[] specRow = new GridLayout.Spec[5];
        GridLayout.Spec[] specColumn = new GridLayout.Spec[3];

        // Compute the grid specifications.
        for(int i = 0; i < 5; i++)
        {
            specRow[i] = GridLayout.spec(i);
        }

        for(int i = 0; i < 3; i++)
        {
            specColumn[i] = GridLayout.spec(i);
        }

        // The columns that belong to each grid cell.
        LinearLayout[][] columns = new LinearLayout[5][3];

        // The current column being modified.
        LinearLayout CurColumn;

        // Create all of the linear layouts for the grid cells.
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                // The current grid layout parameters.
                GridLayout.LayoutParams lpGridLayout =
                        new GridLayout.LayoutParams(specRow[i], specColumn[j]);
                lpGridLayout.width = GridLayout.LayoutParams.WRAP_CONTENT;
                lpGridLayout.height = GridLayout.LayoutParams.WRAP_CONTENT;

                // Choose the correct gravity fill.
                if(i == 0 && j == 0)
                {
                    lpGridLayout.setGravity(Gravity.FILL);
                }
                else
                {
                    lpGridLayout.setGravity(Gravity.FILL_HORIZONTAL);
                }

                lpGridLayout.setMargins(4,4,4,4);

                // Create a new linear layout for a column inside of the grid cell.
                CurColumn = new LinearLayout(this);

                columns[i][j] = CurColumn;

                CurColumn.setLayoutParams(lpGridLayout);
                CurColumn.setOrientation(LinearLayout.VERTICAL);
                CurColumn.setBackgroundColor(Color.BLACK);

                // Choose the correct gravity fill.
                if(i == 0 && j == 0)
                {
                    CurColumn.setGravity(Gravity.FILL);
                }
                else
                {
                    CurColumn.setGravity(Gravity.FILL_HORIZONTAL);
                }

                gridLayout.addView(CurColumn);
            }
        }

        // The layout parameters for a centered column.
        LinearLayout.LayoutParams lpColumnCenter = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        lpColumnCenter.setMargins(2, 2,2,2);
        lpColumnCenter.weight = 1;
        lpColumnCenter.gravity = Gravity.CENTER;

        // The layout parameters for a left column.
        LinearLayout.LayoutParams lpColumnLeft = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        lpColumnLeft.setMargins(2, 2,2,2);
        lpColumnLeft.weight = 1;
        lpColumnLeft.gravity = Gravity.START;

        // The layout parameters for a right column.
        LinearLayout.LayoutParams lpColumnRight = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        lpColumnRight.setMargins(2, 2,2,2);
        lpColumnRight.weight = 1;
        lpColumnRight.gravity = Gravity.END;

        // Grid cell (0, 0)
        CurColumn = columns[0][0];

        // The first text box for the table row.
        CurColumn.addView(CreateCell("properties", ColorWhiteStr,
                false, 40, textBoxPaddingV,
                Gravity.CENTER, lpColumnCenter));


        // Grid cell (0, 1)
        CurColumn = columns[0][1];

        CurColumn.addView(CreateCell("name", ColorWhiteStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.CENTER, lpColumnCenter));

        CurColumn.addView(CreateCell("category", ColorWhiteStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.CENTER, lpColumnCenter));


        // Grid cell (0, 2)
        CurColumn = columns[0][2];

        CurColumn.addView(CreateCell("Day Hour Classification", ColorWhiteStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.START, lpColumnLeft));

        CurColumn.addView(CreateCell("Day and Time", ColorWhiteStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.START, lpColumnLeft));


        // Grid cell (1, 0)
        CurColumn = columns[1][0];

        CurColumn.addView(CreateCell("Rule", ColorBlueStr,
                true, textBoxPaddingH, textBoxPaddingV,
                Gravity.CENTER, lpColumnCenter));


        // Grid cell (1, 1)
        CurColumn = columns[1][1];

        CurColumn.addView(CreateCell("C1", ColorBlueStr,
                true, textBoxPaddingH, textBoxPaddingV,
                Gravity.CENTER, lpColumnCenter));


        // Grid cell (1, 2)
        CurColumn = columns[1][2];

        // The first text box for the table row.
        CurColumn.addView(CreateCell("A1", ColorBlueStr,
                true, textBoxPaddingH, textBoxPaddingV,
                Gravity.CENTER, lpColumnCenter));


        // Grid cell (2, 0)
        CurColumn = columns[2][0];

        CurColumn.addView(CreateCell(" ", ColorBlueStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.CENTER, lpColumnCenter));

        CurColumn.addView(CreateCell(" ", ColorBlueStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.CENTER, lpColumnCenter));


        // Grid cell (2, 1)
        CurColumn = columns[2][1];

        CurColumn.addView(CreateCell("min <= hour && hour <= max", ColorBlueStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.CENTER, lpColumnCenter));

        // The linear layout that contains horizontal text boxes.
        LinearLayout row3Column2InnerRow1 = new LinearLayout(this);

        // The linear layout params for the row linear layout.
        LinearLayout.LayoutParams lpRowLinearLayout = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        lpRowLinearLayout.weight = 1;
        lpRowLinearLayout.gravity = Gravity.FILL_HORIZONTAL;

        row3Column2InnerRow1.setOrientation(LinearLayout.HORIZONTAL);
        row3Column2InnerRow1.setLayoutParams(lpRowLinearLayout);
        row3Column2InnerRow1.setGravity(Gravity.FILL_HORIZONTAL);

        CurColumn.addView(row3Column2InnerRow1);

        row3Column2InnerRow1.addView(CreateCell("int min", ColorBlueStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.CENTER, lpColumnCenter));

        row3Column2InnerRow1.addView(CreateCell("int max", ColorBlueStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.CENTER, lpColumnCenter));


        // Grid cell (2, 2)
        CurColumn = columns[2][2];

        CurColumn.addView(CreateCell("System.out.println(greeting + \",World!\"", ColorBlueStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.CENTER, lpColumnCenter));

        CurColumn.addView(CreateCell("String greeting", ColorBlueStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.CENTER, lpColumnCenter));


        // Grid cell (3, 0)
        CurColumn = columns[3][0];

        CurColumn.addView(CreateCell("Rule", ColorWhiteStr,
                true, textBoxPaddingH, textBoxPaddingV,
                Gravity.START, lpColumnLeft));


        // Grid cell (3, 1)
        CurColumn = columns[3][1];

        // The linear layout that contains horizontal text boxes.
        LinearLayout row4Column2InnerRow1 = new LinearLayout(this);

        row4Column2InnerRow1.setOrientation(LinearLayout.HORIZONTAL);
        row4Column2InnerRow1.setLayoutParams(lpRowLinearLayout);
        row4Column2InnerRow1.setGravity(Gravity.FILL_HORIZONTAL);

        row4Column2InnerRow1.addView(CreateCell("From", ColorYellowStr,
                true, textBoxPaddingH, textBoxPaddingV,
                Gravity.START, lpColumnLeft));

        row4Column2InnerRow1.addView(CreateCell("To", ColorYellowStr,
                true, textBoxPaddingH, textBoxPaddingV,
                Gravity.START, lpColumnLeft));

        CurColumn.addView(row4Column2InnerRow1);


        // Grid cell (3, 2)
        CurColumn = columns[3][2];

        CurColumn.addView(CreateCell("Greeting", ColorOrangeStr,
                true, textBoxPaddingH, textBoxPaddingV,
                Gravity.START, lpColumnLeft));


        // Grid cell (4, 0)
        CurColumn = columns[4][0];

        CurColumn.addView(CreateCell("R10", ColorWhiteStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.START, lpColumnLeft));

        CurColumn.addView(CreateCell("R20", ColorWhiteStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.START, lpColumnLeft));

        CurColumn.addView(CreateCell("R30", ColorWhiteStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.START, lpColumnLeft));

        CurColumn.addView(CreateCell("R40", ColorWhiteStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.START, lpColumnLeft));


        // Grid cell (4, 1)
        CurColumn = columns[4][1];

        // The linear layout that contains horizontal text boxes.
        LinearLayout row5Column2InnerRow1 = new LinearLayout(this);
        row5Column2InnerRow1.setLayoutParams(lpRowLinearLayout);
        row5Column2InnerRow1.setOrientation(LinearLayout.HORIZONTAL);
        row5Column2InnerRow1.setGravity(Gravity.FILL_HORIZONTAL);

        // The linear layout that contains horizontal text boxes.
        LinearLayout row5Column2InnerRow2 = new LinearLayout(this);
        row5Column2InnerRow2.setLayoutParams(lpRowLinearLayout);
        row5Column2InnerRow2.setOrientation(LinearLayout.HORIZONTAL);
        row5Column2InnerRow2.setGravity(Gravity.FILL_HORIZONTAL);

        // The linear layout that contains horizontal text boxes.
        LinearLayout row5Column2InnerRow3 = new LinearLayout(this);
        row5Column2InnerRow3.setLayoutParams(lpRowLinearLayout);
        row5Column2InnerRow3.setOrientation(LinearLayout.HORIZONTAL);
        row5Column2InnerRow3.setGravity(Gravity.FILL_HORIZONTAL);

        // The linear layout that contains horizontal text boxes.
        LinearLayout row5Column2InnerRow4 = new LinearLayout(this);
        row5Column2InnerRow4.setLayoutParams(lpRowLinearLayout);
        row5Column2InnerRow4.setOrientation(LinearLayout.HORIZONTAL);
        row5Column2InnerRow4.setGravity(Gravity.FILL_HORIZONTAL);

        row5Column2InnerRow1.addView(CreateCell("0", ColorYellowStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.END, lpColumnRight));

        row5Column2InnerRow1.addView(CreateCell("11", ColorYellowStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.END, lpColumnRight));

        row5Column2InnerRow2.addView(CreateCell("12", ColorYellowStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.END, lpColumnRight));

        row5Column2InnerRow2.addView(CreateCell("17", ColorYellowStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.END, lpColumnRight));

        row5Column2InnerRow3.addView(CreateCell("18", ColorYellowStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.END, lpColumnRight));

        row5Column2InnerRow3.addView(CreateCell("21", ColorYellowStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.END, lpColumnRight));

        row5Column2InnerRow4.addView(CreateCell("22", ColorYellowStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.END, lpColumnRight));

        row5Column2InnerRow4.addView(CreateCell("23", ColorYellowStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.END, lpColumnRight));

        CurColumn.addView(row5Column2InnerRow1);
        CurColumn.addView(row5Column2InnerRow2);
        CurColumn.addView(row5Column2InnerRow3);
        CurColumn.addView(row5Column2InnerRow4);


        // Grid cell (4, 2)
        CurColumn = columns[4][2];

        CurColumn.addView(CreateCell("Good Morning", ColorOrangeStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.START, lpColumnLeft));

        CurColumn.addView(CreateCell("Good Afternoon", ColorOrangeStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.START, lpColumnLeft));

        CurColumn.addView(CreateCell("Good Evening", ColorOrangeStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.START, lpColumnLeft));

        CurColumn.addView(CreateCell("Good Night", ColorOrangeStr,
                false, textBoxPaddingH, textBoxPaddingV,
                Gravity.START, lpColumnLeft));
    }

    // Creates a single cell for the table grid layout columns and rows.
    // @text - The text that goes inside of the cell.
    // @colorStr - The color value represented as #FFFFFF.
    // @paddingH - The horizontal padding for the text.
    // @paddingV - The vertical padding for the text.
    // @gravity - The gravity type for the text box.
    // lp - The layout parameters for the text box.
    private TextView CreateCell(String text,
                            String colorStr,
                            boolean bold,
                            int paddingH,
                            int paddingV,
                            int gravity,
                            LinearLayout.LayoutParams lp)
    {
        // The text box for the grid layout column or row.
        TextView cell = new TextView(this);

        cell.setText(text);
        cell.setTextColor(Color.BLACK);
        cell.setGravity(gravity);
        cell.setBackgroundColor(Color.parseColor(colorStr));
        cell.setPadding(paddingH, paddingV, paddingH, paddingV);
        cell.setLayoutParams(lp);
        cell.setTextSize(10.0f);

        // Set the text to bold if needed.
        if(bold)
        {
            cell.setTypeface(Typeface.DEFAULT_BOLD);
        }

        return cell;
    }

    // Variables:

    // The table being displayed.
    private TableLayout tableLayout;

    // The main layout of the app (hard coded).
    private LinearLayout mainLayout;
}
