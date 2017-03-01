package info.minifly.com.phoneinfo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView infoTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();
    }

    public void initViews(){
        infoTxt = (TextView)findViewById(R.id.info_txt);


        infoTxt.setText(getDeviceInfo());
    }


    public String getDeviceInfo(){
        StringBuffer sb = new StringBuffer("系统信息列表：");

        sb.append("主板："+Build.BOARD+"\n");
        sb.append("android 系统定制商："+Build.BRAND+"\n");
//        sb.append("指令集："+Build.SUPPORTED_ABIS+"\n");
        sb.append("设备参数："+Build.DEVICE+"\n");
        sb.append("显示屏参数："+Build.DISPLAY+"\n");
        sb.append("唯一编号："+Build.FINGERPRINT+"\n");
        sb.append("硬件序列号："+Build.SERIAL+"\n");
        sb.append("硬件制造商："+Build.MANUFACTURER+"\n");
        sb.append("版本："+Build.MODEL+"\n");
        sb.append("硬件名："+Build.HARDWARE+"\n");
        sb.append("手机产品名："+Build.PRODUCT+"\n");
        sb.append("源码控制版本："+Build.VERSION.INCREMENTAL+"\n");
        sb.append("sdk版本号："+Build.VERSION.SDK_INT+"\n");
        sb.append("编译时间(系统打包时间)："+stampToDate(Build.TIME+"")+"\n");
        sb.append("os 系统架构版本："+System.getProperty("os.arch")+"\n");
        sb.append("os 系统版本："+System.getProperty("os.version")+"\n");
        sb.append("os 名称："+System.getProperty("os.name")+"\n");
        sb.append("时区："+System.getProperty("user.timezone")+"\n");
        sb.append("java class 版本："+System.getProperty("java.class.version")+"\n");
        sb.append("java版本："+System.getProperty("java.version")+"\n");
        sb.append("java home 属性："+System.getProperty("java.home")+"\n");

        return sb.toString();
    }
    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        if(s==null || "".equals(s)){
            return "";
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

}
