package net.jejer.threebody.ui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by GreenSkinMonster on 2016-11-23.
 */

public class BottomDialog extends BottomSheetDialog {

    public BottomDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int orientation = getContext().getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        } else {
            DisplayMetrics metrics = new DisplayMetrics();
            getWindow().getWindowManager().getDefaultDisplay().getMetrics(metrics);

            int width = metrics.widthPixels;
            getWindow().setLayout((int) (width * 0.7), ViewGroup.LayoutParams.MATCH_PARENT);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            final WindowManager.LayoutParams params = getWindow().getAttributes();
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            getWindow().setAttributes(params);
        }
    }
}
