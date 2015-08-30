package route.alternate.xeaphii.com.alternateroute;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class MainActivity extends Activity {

    AutoCompleteTextView ClassesSelect;
    String[] ClassesList={"SL-sleeper ","java","IOS","SQL","JDBC","Web services"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClassesSelect=(AutoCompleteTextView)findViewById(R.id.classes_select);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,ClassesList);

        ClassesSelect.setAdapter(adapter);
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
}
