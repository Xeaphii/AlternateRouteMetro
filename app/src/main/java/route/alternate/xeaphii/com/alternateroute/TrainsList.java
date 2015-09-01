package route.alternate.xeaphii.com.alternateroute;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

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
    }
}
