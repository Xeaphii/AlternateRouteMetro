package route.alternate.xeaphii.com.alternateroute;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends Activity {

    AutoCompleteTextView ClassesSelect,SourceEt,DestinationET;
    EditText DateSelected,TrainNumber;
    Button BtSubmit;

    String[] ClassesList={"SL-sleeper ","java","IOS","SQL","JDBC","Web services"};
    Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClassesSelect=(AutoCompleteTextView)findViewById(R.id.classes_select);
        SourceEt=(AutoCompleteTextView)findViewById(R.id.source_field);
        DestinationET=(AutoCompleteTextView)findViewById(R.id.destination_field);
        DateSelected= (EditText) findViewById(R.id.date_selected);
        TrainNumber = (EditText) findViewById(R.id.train_number);

        BtSubmit = (Button) findViewById(R.id.bt_submit);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,ClassesList);

        ArrayAdapter StationLovAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.list_of_stations));
        SourceEt.setAdapter(StationLovAdapter);
        DestinationET.setAdapter(StationLovAdapter);
        ClassesSelect.setAdapter(adapter);
        BtSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TrainNumber.getText().toString().trim().equals("")){
                    Intent i = new Intent(MainActivity.this,TrainsList.class);
                    startActivity(i);
                }else{
                    Intent i = new Intent(MainActivity.this,PercentagesCovered.class);
                    startActivity(i);
                }
            }
        });



        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        updateLabel();
        DateSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        DateSelected.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    new DatePickerDialog(MainActivity.this, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            }
        });
                //ClassesList.setThreshold(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        DateSelected.setText(sdf.format(myCalendar.getTime()));
    }
}
