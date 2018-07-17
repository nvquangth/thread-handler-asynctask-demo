package com.quangnv.threadhandlerasynctaskdemo.presenter;

import com.quangnv.threadhandlerasynctaskdemo.model.ImageTask;
import com.quangnv.threadhandlerasynctaskdemo.view.MainView;

import java.io.File;
import java.util.List;

public class PresenterImpl implements Presenter, ImagePresenter {

    private MainView mMainView;
    private File mFile;

    public PresenterImpl(File file, MainView mainView) {
        mMainView = mainView;
        mFile = file;
    }

    @Override
    public void loadImage() {
        ImageTask task = new ImageTask(this);
        task.execute(mFile);
    }

    @Override
    public void onLoadImageComplete(List<String> files) {
        mMainView.showImage(files);
    }
}
