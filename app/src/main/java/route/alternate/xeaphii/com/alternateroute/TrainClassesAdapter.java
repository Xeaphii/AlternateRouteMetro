package route.alternate.xeaphii.com.alternateroute;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 8/31/2015.
 */
public class TrainClassesAdapter extends BaseAdapter
{
    private Context mContext;
    private int mSelectedVariation;
    String[] AvailableClasses;

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return AvailableClasses.length;
    }

    public TrainClassesAdapter(Context context, int selectedVariation,String[] AvailableClasses)
    {
        mContext = context;
        mSelectedVariation = selectedVariation;
        this.AvailableClasses = AvailableClasses;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        if(view==null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.train_class_list_item, null);
        }



        TextView name = (TextView) view.findViewById(R.id.class_name);
        RadioButton radio = (RadioButton) view.findViewById(R.id.class_checkbox);

        name.setText(AvailableClasses[position]);
        if(position==mSelectedVariation) radio.setChecked(true);
        else radio.setChecked(false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectedVariation = position;
                TrainClassesAdapter.this.notifyDataSetChanged();
            }
        });

        return view;
    }


}