package com.dialnumber.mvvm_kotlin.helpers.custom_component.progress_dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dialnumber.mvvm_kotlin.R;

/**
 * Created by Vishal Vasani on 18/09/22.
 */
public class SimpleArcDialog extends Dialog {
    // =============================================================================================
    // CONSTANTS
    // =============================================================================================


    // =============================================================================================
    // FIELDS
    // =============================================================================================

    private SimpleArcLoader mLoaderView;
    private ArcConfiguration mConfiguration;
    private LinearLayout mLayout;
    private TextView mLoadingText;
    private boolean showWindow = true;

    // =============================================================================================
    // CONSTRUCTOR
    // =============================================================================================

    public SimpleArcDialog(Context context) {
        super(context);
    }

    public SimpleArcDialog(Context context, ArcConfiguration configuration) {
        super(context);
        mConfiguration = configuration;
    }

    public SimpleArcDialog(Context context, int themeResId,ArcConfiguration configuration) {
        super(context, themeResId);
        mConfiguration = configuration;
    }

    public SimpleArcDialog(Context context, boolean cancelable, OnCancelListener cancelListener,ArcConfiguration configuration) {
        super(context, cancelable, cancelListener);
        mConfiguration = configuration;
    }

    // =============================================================================================
    // METHODS
    // =============================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.loader_layout);

        mLoaderView = (SimpleArcLoader) findViewById(R.id.loader);
        mLoadingText = (TextView) findViewById(R.id.loadertext);
        mLayout = (LinearLayout) findViewById(R.id.window);
        mLoadingText.setTextColor(Color.BLACK);

        if (mConfiguration != null) {
            mLoaderView.refreshArcLoaderDrawable(mConfiguration);
            updateLoadingText(mConfiguration);
        }

        if(showWindow)
        {
            GradientDrawable gd = new GradientDrawable();
            gd.setColor(Color.WHITE);
            gd.setCornerRadius(10);
            gd.setStroke(2, Color.WHITE);
            mLayout.setBackgroundDrawable(gd);

            if(mConfiguration != null && mConfiguration.getTextColor() == Color.WHITE)
                mLoadingText.setTextColor(Color.BLACK);
        }
    }

    private void updateLoadingText(ArcConfiguration configuration) {
        String text = configuration.getText();

        if (text.trim().length() == 0) {
            mLoadingText.setVisibility(View.GONE);
        } else {
            mLoadingText.setText(configuration.getText());
        }


        Typeface typeface = configuration.getTypeFace();
        if (typeface != null)
            mLoadingText.setTypeface(typeface);

        int textSize = configuration.getTextSize();

        if (textSize > 0)
            mLoadingText.setTextSize(textSize);


        mLoadingText.setTextColor(mConfiguration.getTextColor());
    }

    public LinearLayout getLayout()
    {
        return mLayout;
    }

    public TextView getLoadingTextView()
    {
        return mLoadingText;
    }

    public void setConfiguration(ArcConfiguration configuration) {
        mConfiguration = configuration;
    }

    public void showWindow(boolean state)
    {
        showWindow = true;
    }
}
