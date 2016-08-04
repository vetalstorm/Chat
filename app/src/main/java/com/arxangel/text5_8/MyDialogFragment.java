package com.arxangel.text5_8;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Архангел on 02.08.2016.
 */
public class MyDialogFragment extends DialogFragment {
    OnMyDialogResult mDialogResult;
    String value;
    Button btnSend;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth);
    }

    Button btnBack;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dialog_fragment, container, false);

        final EditText editText = (EditText) root.findViewById(R.id.editText1);
        btnSend = (Button) root.findViewById(R.id.btnSend);
        btnBack = (Button) root.findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = editText.getText().toString();

                    if (mDialogResult != null && !value.equals("")&&!value.equals(" ")&&
                            !value.equals("  ")&&!value.equals("   ")) {
                        mDialogResult.finish(value);
                    }

                dismiss();
            }
        });
        return root;
    }

    public void setDialogResult(OnMyDialogResult dialogResult) {
        mDialogResult = dialogResult;
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }

    public interface OnMyDialogResult {
        void finish(String result);
    }
}