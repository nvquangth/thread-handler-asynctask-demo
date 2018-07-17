package com.quangnv.threadhandlerasynctaskdemo.model;

import android.os.AsyncTask;

import com.quangnv.threadhandlerasynctaskdemo.presenter.ImagePresenter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageTask extends AsyncTask<File, Void, List<String>> {

    private ImagePresenter mImagePresenter;

    public ImageTask(ImagePresenter imagePresenter) {
        mImagePresenter = imagePresenter;
    }

    @Override
    protected List<String> doInBackground(File... files) {
        List<String> fileNames = new ArrayList<>();
        ImageUtil.loadAllImage(files[0], fileNames);
        return fileNames;
    }

    @Override
    protected void onPostExecute(List<String> files) {
        mImagePresenter.onLoadImageComplete(files);
    }
}
