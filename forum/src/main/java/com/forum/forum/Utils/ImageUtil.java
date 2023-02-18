package com.forum.forum.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {
    private String iconBasePath = "/Users/dhawit/Desktop/forum/src/main/resources/static/images/uploads/";

    public int store(MultipartFile thumbnail, String fileName) throws IOException {

        File thumbnailPath = new File(iconBasePath + fileName + ".png");
        FileOutputStream thumbnailOutput;
        int status = 0;
        try {
            thumbnailOutput = new FileOutputStream(thumbnailPath);
            thumbnailOutput.write(thumbnail.getBytes());
            thumbnailOutput.close();
            thumbnailPath.createNewFile();
            status = 1;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return status;
    }
}
