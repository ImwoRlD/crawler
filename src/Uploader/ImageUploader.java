package Uploader;

import java.io.*;

public class ImageUploader {
    public static String upload(byte[] data,String uuid){
        File file=new File("F:\\captcha\\"+uuid+".jpeg");
        try {
            OutputStream os=new FileOutputStream(file);
            os.write(data);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return null;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return "ok";
    }
}
