package com.example.administrator.netcenter.utility;

import android.util.Log;

import java.io.IOException;

/**
 * Created by Administrator on 2015/11/19.
 */
public class pinghost {

    public static String pingHost(String str)
    {
        String result = "";
        try
        {
            Process p = Runtime.getRuntime().exec("ping -c 1 -w 100 " + str);
            int status =  p.waitFor();
            if(status == 0)
            {
                result = "success";
            }
            else
            {
                result = "fail";
            }
        }
        catch (IOException e)
        {
        }
        catch (InterruptedException e)
        {

        }

        Log.e("result", result);
        return result;
    }
}
