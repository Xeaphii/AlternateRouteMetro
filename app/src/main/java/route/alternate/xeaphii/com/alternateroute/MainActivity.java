package route.alternate.xeaphii.com.alternateroute;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends Activity {

    AutoCompleteTextView SourceEt, DestinationET;
    Button DateSelected;
    EditText TrainNumber;
    Button BtSubmit;
    Button ClassesSelect;
    Button ClearTrainNumber,ClearSource,ClearDestination;


    String[] ClassesList = {"All Classes", "SL", "3AC", "2AC", "1AC", "CC", "FC", "3E", "2S"};
    Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClassesSelect = (Button) findViewById(R.id.classes_set);
        SourceEt = (AutoCompleteTextView) findViewById(R.id.source_field);
        DestinationET = (AutoCompleteTextView) findViewById(R.id.destination_field);
        DateSelected = (Button) findViewById(R.id.date_set);
        TrainNumber = (EditText) findViewById(R.id.train_number);
        ClearTrainNumber = (Button) findViewById(R.id.clear_train_no);
        ClearSource = (Button) findViewById(R.id.clear_source);
        ClearDestination = (Button) findViewById(R.id.clear_destination);

        ClearTrainNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrainNumber.setText("");
                ClearTrainNumber.setVisibility(View.GONE);
            }
        });
        TrainNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(TrainNumber.getText().toString().trim().length()>=0){
                    ClearTrainNumber.setVisibility(View.VISIBLE);
                }else{
                    ClearTrainNumber.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ClearDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DestinationET.setText("");
                ClearDestination.setVisibility(View.GONE);
            }
        });
        DestinationET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(DestinationET.getText().toString().trim().length()>=0){
                    ClearDestination.setVisibility(View.VISIBLE);
                }else{
                    ClearDestination.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ClearSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SourceEt.setText("");
                ClearSource.setVisibility(View.GONE);
            }
        });
        SourceEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(SourceEt.getText().toString().trim().length()>=0){
                    ClearSource.setVisibility(View.VISIBLE);
                }else{
                    ClearSource.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        BtSubmit = (Button) findViewById(R.id.bt_submit);
//        TrainNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(!hasFocus){
//                    if(TrainNumber.getText().toString().trim().equals("")){
//                        ClearTrainNumber.setVisibility(View.GONE);
//                    }else{
//                        ClearTrainNumber.setVisibility(View.VISIBLE);
//                    }
//                }
//            }
//        });

        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,ClassesList);
        ClassesSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.select_train_class_dialog);
                dialog.setTitle("Train Classes available");
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));


                // set the custom dialog components - text, image and button
                ListView SelectClasses = (ListView) dialog.findViewById(R.id.train_classes_lov);
                SelectClasses.setItemsCanFocus(true);
                SelectClasses.setAdapter(new TrainClassesAdapter(MainActivity.this,
                        Arrays.asList(ClassesList).indexOf(ClassesSelect.getText().toString())
                        , ClassesList, dialog, ClassesSelect));
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
        ArrayAdapter StationLovAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.list_of_stations));
        SourceEt.setAdapter(StationLovAdapter);
        DestinationET.setAdapter(StationLovAdapter);
        //ClassesSelect.setAdapter(adapter);
        BtSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!SourceEt.getText().toString().trim().equals("")) {
                    if (!DestinationET.getText().toString().trim().equals("")) {

                        if (getDayCount(DateSelected.getText().toString())>=0) {
                            if (TrainNumber.getText().toString().trim().equals("")) {
                                Intent i = new Intent(MainActivity.this, TrainsList.class);
                                startActivity(i);
                            } else {
                                Intent i = new Intent(MainActivity.this, PercentagesCovered.class);
                                startActivity(i);
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Can't choose previous date", Toast.LENGTH_LONG).show();
                        }
                    } else {
                       // Toast.makeText(MainActivity.this, "Destination station can't be empty", Toast.LENGTH_LONG).show();
                        DestinationET.setError("Destination station can't be empty");
                    }
                } else {
                  //  Toast.makeText(MainActivity.this, "Source station can't be empty", Toast.LENGTH_LONG).show();
                    SourceEt.setError("Source station can't be empty");
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
    public static long getDayCount( String end) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy");
        long diff = -1;
        try {
            Date dateStart = new Date();
            Date dateEnd = simpleDateFormat.parse(end);

            //time is always 00:00:00 so rounding should help to ignore the missing hour when going from winter to summer time as well as the extra hour in the other direction
            diff = Math.round((dateEnd.getTime() - dateStart.getTime()) / (double) 86400000);
        } catch (Exception e) {
            //handle the exception according to your own situation
        }
        Log.e("Date",Long.toString(diff));
        return diff;
    }
}
