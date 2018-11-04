package tw.brad.otherui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

import co.ceryle.segmentedbutton.SegmentedButtonGroup;

public class MainActivity extends AppCompatActivity {
    private CheckBox opt1;
    private RadioGroup years;
    private ToggleButton tbtn;
    private SegmentedButtonGroup sbg;
    private TextView newdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opt1 = findViewById(R.id.opt1);
        opt1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        years = findViewById(R.id.years);

        years.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.year1:
                        Toast.makeText(MainActivity.this, "20-", Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.year2:
                        Toast.makeText(MainActivity.this, "20-40", Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.year3:
                        Toast.makeText(MainActivity.this, "40-60", Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.year4:
                        Toast.makeText(MainActivity.this, "60+", Toast.LENGTH_SHORT)
                                .show();
                        break;
                }
            }
        });

        tbtn = findViewById(R.id.tbtn);
        tbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this,
                        (isChecked?"開":"關"),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        sbg = findViewById(R.id.sbg);
        sbg.setOnPositionChangedListener(new SegmentedButtonGroup.OnPositionChangedListener() {
            @Override
            public void onPositionChanged(int position) {
                Toast.makeText(MainActivity.this,
                        "pos: " + position,
                        Toast.LENGTH_SHORT)
                        .show();

            }
        });

        newdate = findViewById(R.id.newdate);


    }

    public void chDate(View view) {
        Calendar cal = Calendar.getInstance();
        int yy = cal.get(Calendar.YEAR);
        int mm = cal.get(Calendar.MONTH);
        int dd = cal.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(this,
                android.app.AlertDialog.THEME_DEVICE_DEFAULT_DARK,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        newdate.setText(year + "-" + (month+1) + "-" + dayOfMonth);
                    }
                },
                yy, mm, dd).show();

    }
}
