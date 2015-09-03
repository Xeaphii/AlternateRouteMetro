package route.alternate.xeaphii.com.alternateroute;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends Activity {

    AutoCompleteTextView SourceEt,DestinationET;
    Button DateSelected;
    EditText TrainNumber;
    Button BtSubmit;
    Button ClassesSelect;


    String[] ClassesList={"SL","3AC","2AC","1AC","CC","FC","3E","2S"};
    Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClassesSelect=(Button)findViewById(R.id.classes_set);
        SourceEt=(AutoCompleteTextView)findViewById(R.id.source_field);
        DestinationET=(AutoCompleteTextView)findViewById(R.id.destination_field);
        DateSelected= (Button) findViewById(R.id.date_set);
        TrainNumber = (EditText) findViewById(R.id.train_number);

        BtSubmit = (Button) findViewById(R.id.bt_submit);

        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,ClassesList);
        ClassesSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.select_train_class_dialog);
                dialog.setTitle("Train Classes available");

                // set the custom dialog components - text, image and button
                ListView SelectClasses = (ListView) dialog.findViewById(R.id.train_classes_lov);
                SelectClasses.setItemsCanFocus(true);
                SelectClasses.setAdapter(new TrainClassesAdapter(MainActivity.this, 0,ClassesList));
                SelectClasses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ClassesSelect.setText(ClassesList[position]);
                        dialog.dismiss();
                    }
                });
//                Button bt_submit = (Button) dialog.findViewById(R.id.bt_submit);
//                bt_submit.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent i = new Intent(MainActivity.this, PercentagesCovered.class);
//                        startActivity(i);
//                        dialog.dismiss();
//                    }
//                });
                dialog.show();
            }
        });
        ArrayAdapter StationLovAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.list_of_stations));
        SourceEt.setAdapter(StationLovAdapter);
        DestinationET.setAdapter(StationLovAdapter);
        //ClassesSelect.setAdapter(adapter);
        BtSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TrainNumber.getText().toString().trim().equals("")) {
                    Intent i = new Intent(MainActivity.this, TrainsList.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(MainActivity.this, PercentagesCovered.class);
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
//        DateSelected.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus) {
//                    new DatePickerDialog(MainActivity.this, date, myCalendar
//                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
//                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//                }
//            }
//        });
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
