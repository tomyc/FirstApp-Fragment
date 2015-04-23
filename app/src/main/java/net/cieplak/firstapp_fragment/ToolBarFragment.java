package net.cieplak.firstapp_fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/**
 * Created by Tomasz on 2015-04-23.
 */


public class ToolBarFragment extends Fragment implements OnSeekBarChangeListener{

    private static int seekvalue =10;
    private static EditText edittext;

    ToolbarListener activityCallBack;

    public interface ToolbarListener {
        public void onButtonClick(int postion, String text);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityCallBack =(ToolbarListener)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+" musi zaimplementowac ToolbarListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        View view = inflater.inflate(R.layout.toolbar_fragment,container,true);

        edittext =(EditText)view.findViewById(R.id.editText1);
        final SeekBar seekbar = (SeekBar)view.findViewById(R.id.seekBar1);
        seekbar.setOnSeekBarChangeListener(this);

        final Button button = (Button)view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                buttonClicked(v);
            }
        });
        return view;
    }

    private void buttonClicked(View v) {
        activityCallBack.onButtonClick(seekvalue,edittext.getText().toString());
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seekvalue=progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
