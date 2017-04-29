package io.darkpiv.xoso.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

import io.darkpiv.xoso.R;

/**
 * Created by darkpiv on 4/5/17.
 */

public class ViewUtil {
    public static void hideKeyboardFrom(Context context, View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    public static Dialog getWaitingDialog(Context c) {
        Dialog ret = new Dialog(c);
        LayoutInflater inf = ((LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        View v = inf.inflate(R.layout.dialog_waiting, null);
        ret.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ret.setContentView(v);
        ret.setCanceledOnTouchOutside(false);
        ret.getWindow().setDimAmount(0.0f);
        ret.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        return ret;

    }
}
