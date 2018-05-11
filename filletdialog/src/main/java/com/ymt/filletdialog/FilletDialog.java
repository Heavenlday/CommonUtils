package com.ymt.filletdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by HuangPengHua on 2018-04-25.
 */

public class FilletDialog extends Dialog {
    private TextView cancel;
    private TextView tv_exit;
    private setExitClick setExitClick;
    private TextView tv_tips;
    private String tips;
    private String okText;
    public FilletDialog(@NonNull Context context, setExitClick setExitClick, String tips, String okText) {
        super(context, R.style.Theme_AppCompat_Dialog);
        this.setExitClick=setExitClick;
        this.tips=tips;
        this.okText=okText;
        setCancelable(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.exit_dialog_layout);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        super.onCreate(savedInstanceState);
        cancel= (TextView) findViewById(R.id.tv_cancel);
        tv_exit= (TextView) findViewById(R.id.tv_exit);
        tv_tips= (TextView) findViewById(R.id.tv_tips);
        tv_exit.setText(okText);
        tv_tips.setText(tips);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        tv_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                setExitClick.onClick();
            }
        });
    }
    @Override
    public void show() {
        super.show();

        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity= Gravity.CENTER;
        layoutParams.width= LinearLayout.LayoutParams.MATCH_PARENT;
        layoutParams.height= LinearLayout.LayoutParams.WRAP_CONTENT;

        getWindow().getDecorView().setPadding(0, 0, 0, 0);

        getWindow().setAttributes(layoutParams);

    }
    public interface setExitClick
    {
        void onClick();
    }
}
