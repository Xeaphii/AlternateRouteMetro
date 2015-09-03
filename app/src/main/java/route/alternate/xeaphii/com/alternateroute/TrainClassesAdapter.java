package route.alternate.xeaphii.com.alternateroute;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
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
    Dialog dialog;
    Button BtToSave;

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

    public TrainClassesAdapter(Context context, int selectedVariation,String[] AvailableClasses,Dialog d,Button temp1)
    {
        mContext = context;
        mSelectedVariation = selectedVariation;
        this.AvailableClasses = AvailableClasses;
        this.dialog = d;
        this.BtToSave = temp1;

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

        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectedVariation = position;
                TrainClassesAdapter.this.notifyDataSetChanged();
                dialog.dismiss();
                BtToSave.setText(AvailableClasses[position]);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectedVariation = position;
                TrainClassesAdapter.this.notifyDataSetChanged();
                dialog.dismiss();
                BtToSave.setText(AvailableClasses[position]);
            }
        });

        return view;
    }


}