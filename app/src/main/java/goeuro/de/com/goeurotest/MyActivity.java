package goeuro.de.com.goeurotest;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.psdev.stabbedandroid.ForApplication;
import goeuro.de.com.goeurotest.abstractclasses.AbstractActivity;
import goeuro.de.com.goeurotest.adapter.LocationAutoCompleteAdapter;
import goeuro.de.com.goeurotest.entities.Location;
import goeuro.de.com.goeurotest.events.DefaultEventBus;
import goeuro.de.com.goeurotest.ui.components.DelayAutoCompleteTextView;


public class MyActivity extends AbstractActivity {

    private static final int THRESHOLD = 2;
    @Inject
    @ForApplication
    protected DefaultEventBus mEventBus;

    public static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};


    @InjectView(R.id.txt_from)
    DelayAutoCompleteTextView txtFromLocation;

    @InjectView(R.id.txt_destination)
    DelayAutoCompleteTextView txtToLocation;

    @InjectView(R.id.txtDate)
    TextView txtDate;

    @OnClick(R.id.txtDate)
    public void onDateClicked() {
        showDatePickerDialog();
    }

    @OnClick(R.id.btnSearch)
    public void onSearchClicked() {
        Toast.makeText(this , getResources().getString(R.string.search_not_implemented) , Toast.LENGTH_SHORT).show();
    }

    /**
     * Opens DatePicker Dialog
     */
    private void showDatePickerDialog() {
        final Calendar c = Calendar.getInstance();
        final int mYear = c.get(Calendar.YEAR);
        final int mMonth = c.get(Calendar.MONTH);
        final int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

            // when dialog box is closed, below method will be called.
            public void onDateSet(DatePicker view, int selectedYear,
                                  int selectedMonth, int selectedDay) {
                txtDate.setText(selectedDay + " "
                        + MONTHS[selectedMonth] + " "
                        + selectedYear + " ");
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                datePickerListener, mYear, mMonth, mDay);

        datePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == DialogInterface.BUTTON_NEGATIVE) {
                            dialog.cancel();
                        }
                    }
                });

        datePickerDialog.setCancelable(false);
        datePickerDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.inject(this);
        setContentView(R.layout.activity_my);

        //Initialize first textView.
        txtFromLocation.setThreshold(THRESHOLD);
        txtFromLocation.setAdapter(new LocationAutoCompleteAdapter(this)); // 'this' is Activity instance
        txtFromLocation.setLoadingIndicator(
                (android.widget.ProgressBar) findViewById(R.id.pb_from_indicator));
        txtFromLocation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Location location = (Location) adapterView.getItemAtPosition(position);
                txtFromLocation.setText(location.getName());
            }
        });


        //Initialize second textView.
        txtToLocation.setThreshold(THRESHOLD);
        txtToLocation.setAdapter(new LocationAutoCompleteAdapter(this)); // 'this' is Activity instance
        txtToLocation.setLoadingIndicator(
                (android.widget.ProgressBar) findViewById(R.id.pb_destination_indicator));
        txtToLocation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Location location = (Location) adapterView.getItemAtPosition(position);
                txtToLocation.setText(location.getName());
            }
        });
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
