package com.quangnv.threadhandlerasynctaskdemo.view;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.quangnv.threadhandlerasynctaskdemo.R;
import com.quangnv.threadhandlerasynctaskdemo.model.ImageAdapter;
import com.quangnv.threadhandlerasynctaskdemo.presenter.PresenterImpl;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView mRecyclerView;
    private ImageAdapter mImageAdapter;

    private PresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        mPresenter.loadImage();

    }

    private void init() {
        mRecyclerView = findViewById(R.id.recycler_view);

        File file = Environment.getExternalStorageDirectory();
        mPresenter = new PresenterImpl(file, this);

        mImageAdapter = new ImageAdapter(this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mImageAdapter);
    }

    @Override
    public void showImage(List<String> files) {
        mImageAdapter.setFiles(files);
    }

}
