package com.mrmo.mimageviewerlib;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mrmo.mimageviewerlib.widget.touchimageview.ExtendedViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片查看器。
 * <p>参数：</p>
 * <p>图片地址集合@{@link #PARAM_LIST_IMAGE_DATA}</p>
 * <p>查看图片位置@{@link #PARAM_INT_IMAGE_POSITION}</p>
 * <p>
 * Created by moguangjian on 15/7/12 16:09.
 */
public class MImageViewerActivity extends AppCompatActivity {

    /**
     * 图片数据源List<String>
     */
    public static final String PARAM_LIST_IMAGE_DATA = "param_list_image_data";
    /**
     * 当前查看图片位置
     */
    public static final String PARAM_INT_IMAGE_POSITION = "param_int_image_position";

    private TextView tvIndex;

    private ExtendedViewPager viewPager;
    private MImageViewerAdapter adapter;
    private List<String> list;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_activity_image_view);

        tvIndex = (TextView) findViewById(R.id.tvIndex);
        initImageViewViewPager();
    }

    private void initImageViewViewPager() {
        list = new ArrayList<>();

        position = getIntent().getIntExtra(PARAM_INT_IMAGE_POSITION, 0);
        List imageList = getIntent().getStringArrayListExtra(PARAM_LIST_IMAGE_DATA);

        if (imageList != null) {
            list.addAll(imageList);
        }

        viewPager = (ExtendedViewPager) findViewById(R.id.viewPager);
        adapter = new MImageViewerAdapter(this, list);
        viewPager.setAdapter(adapter);

        if (position >= viewPager.getAdapter().getCount()) {
            position = viewPager.getAdapter().getCount() - 1;
        }

        if (position < 0) {
            position = 0;
        }
        viewPager.setCurrentItem(position);
        tvIndex.setText((position + 1) + "/" + list.size());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                tvIndex.setText((position + 1) + "/" + list.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        adapter.setOnClickImageListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
