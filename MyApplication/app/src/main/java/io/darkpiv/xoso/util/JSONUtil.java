package io.darkpiv.xoso.util;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by darkpiv on 4/3/17.
 */

public class JSONUtil {
    public static String loadJSONFromAsset(Context context,String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName+".json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
