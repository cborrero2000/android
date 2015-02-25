package com.example.dialogfragment;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by carlos on 2015-02-24.
 */
public class MyDialog extends DialogFragment implements View.OnClickListener {

    Button yes, no;
    Communicator comm;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        comm = (Communicator) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_dialog, null);
        yes = (Button) view.findViewById(R.id.yes);
        no = (Button) view.findViewById(R.id.no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

        setCancelable(false);
        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.yes) {
            comm.onDialogMessage("Yes was clicked");
            dismiss();
        } else {
            comm.onDialogMessage("No was clicked");
            dismiss();
        }
    }

    interface Communicator {
        public void onDialogMessage(String message);
    }
}
