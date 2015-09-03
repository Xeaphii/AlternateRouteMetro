package route.alternate.xeaphii.com.alternateroute;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 8/31/2015.
 */
public class TrainsList extends Activity {
    ListView lv;
    Context context;

    ArrayList<TrainPojo> Trains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trains_list);
        Trains = new ArrayList<>();
        Trains.add(new TrainPojo("Station1","Station2","10:20","12:20","Train1","10:20","Mon,Tues,Wed","Sl,3Ac"));
        Trains.add(new TrainPojo("Station3","Station4","10:20","12:20","Train2","1:20","Mon,Tues,Wed","Sl,3Ac,2AC"));
        Trains.add(new TrainPojo("Station1","Station4","15:20","2:20","Train3","1:20","Mon,Tues,Wed,Thurs","Sl,3Ac,2AC"));
        lv=(ListView) findViewById(R.id.available_trains);
        lv.setAdapter(new TrainCustomAdapter(this, Trains));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] ClassesAvailable = Trains.get(position).ClassesAvailable.split(",");
                final Dialog dialog = new Dialog(TrainsList.this);
                dialog.setContentView(R.layout.select_train_class_dialog);
                dialog.setTitle("Train Classes available");

                // set the custom dialog components - text, image and button
                ListView SelectClasses = (ListView) dialog.findViewById(R.id.train_classes_lov);

                SelectClasses.setAdapter(new TrainClassesAdapter(TrainsList.this, 0,ClassesAvailable,null,null));
//                SelectClasses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                    }
//                });
                Button bt_submit = (Button) dialog.findViewById(R.id.bt_submit);
                bt_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(TrainsList.this, PercentagesCovered.class);
                        startActivity(i);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}
