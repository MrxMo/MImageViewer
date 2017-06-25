package com.mrmo.mimageviewerlib;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import com.mrmo.mimageviewerlib.widget.touchimageview.TouchImageView;

import java.util.List;

/**
 * 图片浏览查看适配器
 * Created by moguangjian on 15/7/12 16:25.
 */
public class MImageViewerAdapter extends PagerAdapter {

    private Context context;
    private List list;

    private View.OnClickListener onClickListener;

    public MImageViewerAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = getItemView(R.layout.m_viewpager_item_image_view, container, position);
        TouchImageView ivTouchImageView = (TouchImageView) itemView.findViewById(R.id.ivTouchImageView);

        String imageUrl = (String) list.get(position);

        UrlImageViewHelper.setUrlDrawable(ivTouchImageView, imageUrl);

        ivTouchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onClick(v);
                }
            }
        });
        return itemView;
    }

    private View getItemView(int layoutId, ViewGroup container, int position) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, null, false);
        container.addView(itemView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        return itemView;
    }

    public void setOnClickImageListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
