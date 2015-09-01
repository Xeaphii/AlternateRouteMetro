package route.alternate.xeaphii.com.alternateroute;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sunny on 9/1/2015.
 */
public class TrainCustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<TrainPojo> Trains;
    private static LayoutInflater inflater=null;
    public TrainCustomAdapter(Context c, ArrayList<TrainPojo> tains_param) {
        // TODO Auto-generated constructor stub

        context=c;
        Trains=tains_param;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Trains.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView TrainName,StationName1,StationName2,DepartureTime,ArrivalTime,TravelTime,ClassesAvailable,RunsOnDays;

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.train_list_item, null);
        holder.TrainName=(TextView) rowView.findViewById(R.id.train_name);
        holder.StationName1=(TextView) rowView.findViewById(R.id.station_name1);
        holder.StationName2=(TextView) rowView.findViewById(R.id.station_name2);
        holder.DepartureTime=(TextView) rowView.findViewById(R.id.departure_time);
        holder.ArrivalTime=(TextView) rowView.findViewById(R.id.arrival_time);
        holder.TravelTime=(TextView) rowView.findViewById(R.id.travel_time);
        holder.ClassesAvailable=(TextView) rowView.findViewById(R.id.classes_available);
        holder.RunsOnDays=(TextView) rowView.findViewById(R.id.runs_on);

        holder.TrainName.setText(Trains.get(position).TrainName);
        holder.StationName1.setText(Trains.get(position).Station1);
        holder.StationName2.setText(Trains.get(position).Station2);
        holder.DepartureTime.setText(Trains.get(position).DepatureTime);
        holder.ArrivalTime.setText(Trains.get(position).ArrivalTime);
        holder.TravelTime.setText(Trains.get(position).TravelTime);
        holder.ClassesAvailable.setText(Trains.get(position).ClassesAvailable);
        holder.RunsOnDays.setText(Trains.get(position).RunsOnDays);

        return rowView;
    }
}

