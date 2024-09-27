package com.example.assignmenttwo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class assignment2 extends AppCompatActivity {

    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    private RadioGroup radioGroup;
    private RatingBar ratingBar;
    private SeekBar seekBar;
    private TextView resultTextView, tackTimeText;
    private Switch notificationSwitch;
    private Button Done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment2);

        checkBox1 = findViewById(R.id.jaflong);
        checkBox2 = findViewById(R.id.Bisnakandi);
        checkBox3 = findViewById(R.id.srimongol);
        checkBox4 = findViewById(R.id.GrandSultan);
        checkBox5 = findViewById(R.id.LemonGarden);

        radioGroup = findViewById(R.id.radiogroup);

        ratingBar = findViewById(R.id.ratingBar);

        seekBar = findViewById(R.id.seekbar);
        notificationSwitch = findViewById(R.id.btn_switch);
        Done = findViewById(R.id.Done_btn);
        resultTextView = findViewById(R.id.value);

        resultTextView.setText("Happy percentage is " + seekBar.getProgress()+ " %");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                resultTextView.setText("Happy percentage is: " + progress + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(assignment2.this, "Adjusting ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(assignment2.this, "set", Toast.LENGTH_SHORT).show();
            }
        });

        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(assignment2.this, "Happyness Enabled", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(assignment2.this, "Happyness Disabled", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Done.setOnClickListener(V ->{
            StringBuilder selectedTasks = new StringBuilder("Selected Place are: ");

            if (checkBox1.isChecked())
            {
                selectedTasks.append("\n- ").append(checkBox1.getText());
            }
            if (checkBox2.isChecked())
            {
                selectedTasks.append("\n- ").append(checkBox2.getText());
            }
            if (checkBox3.isChecked())
            {
                selectedTasks.append("\n- ").append(checkBox3.getText());
            }
            if (checkBox4.isChecked())
            {
                selectedTasks.append("\n- ").append(checkBox5.getText());
            }
            if (checkBox5.isChecked())
            {
                selectedTasks.append("\n- ").append(checkBox5.getText());
            }

            int selectedRadioId = radioGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedRadioId);
            String timeOfDay = selectedRadioButton.getText().toString();

            float productivityRating = ratingBar.getRating();
            int taskTime = seekBar.getProgress();

            String resultText = selectedTasks.toString() +
                    "\nGoing with: " + timeOfDay +
                    "\nHappyness rating: " + productivityRating +
                    "\nEstimated  happy percentage: " + taskTime + " %" +
                    "\nAre fullly happy: " + (notificationSwitch.isChecked() ? "Yes" : "NO");
            resultTextView.setText(resultText);
        });


    }
}