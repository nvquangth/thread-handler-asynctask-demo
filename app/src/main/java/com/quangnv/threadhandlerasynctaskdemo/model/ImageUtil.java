package com.quangnv.threadhandlerasynctaskdemo.model;

import java.io.File;
import java.util.List;

public class ImageUtil {

    private static final String TAG_JPG = ".jpg";
    private static final String TAG_PNG = ".png";

    public static void loadAllImage(File dir, List<String> files) {
        File[] listFile = dir.listFiles();
        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    loadAllImage(listFile[i], files);
                } else {
                    if (listFile[i].getName().endsWith(TAG_JPG) || listFile[i].getName().endsWith(TAG_PNG)) {
                        files.add(listFile[i].getAbsolutePath());
                    }
                }
            }
        }
    }
}
