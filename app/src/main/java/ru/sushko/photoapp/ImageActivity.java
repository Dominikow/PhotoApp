package ru.sushko.photoapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;
import java.io.FileFilter;

public class ImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        File imgFile = findImage();

        if(imgFile.exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

            ImageView myImage = (ImageView) findViewById(R.id.Img);

            myImage.setImageBitmap(myBitmap);

        }
    }

    public static File findImage()
    {

            String dir = "/storage/emulated/0/DCIM/USBCameraTest/";
            File fl = new File(dir);
            File[] files = fl.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return file.isFile();
                }
            });
            long lastMod = Long.MIN_VALUE;
            File choice = null;
            for (File file : files) {
                if (file.lastModified() > lastMod) {
                    choice = file;
                    lastMod = file.lastModified();
                }
            }
            return choice;

    }
}
