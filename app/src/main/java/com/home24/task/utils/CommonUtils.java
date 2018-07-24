package com.home24.task.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Layout;
import android.util.TypedValue;


import com.home24.task.R;
import com.home24.task.utils.custom.TextDrawable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alaeddine Khoudi .
 */

public final class CommonUtils {

    private CommonUtils() {
        //
    }

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();

        if (progressDialog.getWindow() != null)
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        progressDialog.setContentView(R.layout.view_progress_dialog);

        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        return progressDialog;
    }

    public static boolean isEmailValid(String email) {
        Pattern pattern;
        Matcher matcher;

        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat(AppConstants.TIMESTAMP, Locale.US).format(new Date());
    }

    public static Long getNegativeLong(int number) {
        return ( - (long) number);
    }


    public static TextDrawable getTextDrawable(Context context, int id) {
        TextDrawable faIcon = new TextDrawable(context);
        faIcon.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        faIcon.setTextAlign(Layout.Alignment.ALIGN_NORMAL);
        faIcon.setTypeface(Typeface.createFromAsset( context.getAssets(),"fonts/FontAwesome.otf"));
        faIcon.setText(context.getResources().getText(id));
        faIcon.setTextColor(Color.WHITE);
        return faIcon;
    }

}
