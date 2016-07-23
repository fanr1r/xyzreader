package com.example.xyzreader.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Eisdrachl on 23.07.2016.
 */
public class AspectRatioImageView extends ImageView {
    private float mAspectRatio;

    public AspectRatioImageView(Context context) {
        super(context);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int aspectRatioHeight;
        if (mAspectRatio < 0) {
            aspectRatioHeight = (int) (MeasureSpec.getSize(widthMeasureSpec) * mAspectRatio);
        } else {
            aspectRatioHeight = (int) (MeasureSpec.getSize(widthMeasureSpec) * (1/mAspectRatio));
        }
        int aspectRatioHeightSpec = MeasureSpec.makeMeasureSpec(aspectRatioHeight, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, aspectRatioHeightSpec);
    }

    public void setAspectRatio(float mAspectRatio) {
        this.mAspectRatio = mAspectRatio;
    }
}
