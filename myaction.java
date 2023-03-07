package com.example.myapplication;

import android.app.Activity;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Process;
import android.os.Environment;
import android.os.UserManager;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import android.content.ContentResolver;


public class MyAction {

    public Activity activity;
    public MyAction(Activity a)
    {
        this.activity = a;
    }
    public void writeToFile(String filename, String content) throws IOException {
        File path = this.activity.getApplicationContext().getFilesDir();
        Log.e("tag", path.getPath());
        FileOutputStream writer = new FileOutputStream(new File(path, filename));
        writer.write(content.getBytes());
        writer.close();
        //Toast.makeText(this.activity.getApplicationContext(),"got random", Toast.LENGTH_SHORT).show();
    }


    public void getBuildInformation() throws IOException {
        String underlying_board = "underlying_board: " + Build.BOARD + "\n";
        String system_bootloader_version_number = "system_bootloader_version_number: " + Build.BOOTLOADER + "\n";
        String consumer_visible_brand = "consumer_visible_brand: " + Build.BRAND + "\n";
        String industrial_design = "industrial_design: " + Build.DEVICE + "\n";
        String build_ID_string = "build_ID_string: " + Build.DISPLAY + "\n";
        String uniquely_identifies_this_build = "uniquely_identifies_this_build: " + Build.FINGERPRINT + "\n";
        String HARDWARE = "HARDWARE: " + Build.HARDWARE + "\n";
        String HOST = "HOST: " + Build.HOST + "\n";
        String ID = "ID: " + Build.ID + "\n";
        String MANUFACTURER = "MANUFACTURER: " + Build.MANUFACTURER + "\n";
        String MODEL = "MODEL: " + Build.MODEL + "\n";
        String PRODUCT = "PRODUCT: " + Build.PRODUCT + "\n";
        String TAGS = "TAGS: " + Build.TAGS + "\n";
        String TYPE = "TYPE: " + Build.TYPE + "\n";
        String USER = "USER: " + Build.USER + "\n";
        String base = "Base: " + Build.VERSION_CODES.BASE + "\n";
        ContentResolver ContentResolver = this.activity.getContentResolver();
        String device_id = "device id: " +  Settings.Secure.getString(ContentResolver ,Settings.Secure.ANDROID_ID) + "\n";
        String device_name = "device: " +  Settings.Secure.getString(ContentResolver ,Settings.Global.ADB_ENABLED) + "\n";
        String input_method = "input method : " +  Settings.Secure.getString(ContentResolver ,Settings.Secure.DEFAULT_INPUT_METHOD) + "\n";
        String ENABLED_INPUT_METHODS = "ENABLED_INPUT_METHODS : " +  Settings.Secure.getString(ContentResolver ,Settings.Secure.ENABLED_INPUT_METHODS) + "\n";
        String INSTALL_NON_MARKET_APPS = "INSTALL_NON_MARKET_APPS : " +  Settings.Secure.getString(ContentResolver , Settings.Secure.INSTALL_NON_MARKET_APPS) + "\n";
        String LOCATION_MODE = "LOCATION_MODE : " +  Settings.Secure.getString(ContentResolver , Settings.Secure.LOCATION_MODE) + "\n";

        String CODENAME = "CODENAME: " + Build.VERSION.CODENAME + "\n";
        String INCREMENTAL = "INCREMENTAL: " + Build.VERSION.INCREMENTAL + "\n";

        String PREVIEW_SDK_INT = "PREVIEW_SDK_INT: " + Build.VERSION.PREVIEW_SDK_INT + "\n";
        String RELEASE = "RELEASE: " + Build.VERSION.RELEASE + "\n";
        String SDK_INT = "SDK_INT: " + Build.VERSION.SDK_INT + "\n";
        String SOC_MANUFACTURER;

        String RELEASE_OR_CODENAME;
        if (Build.VERSION.SDK_INT > 30){
            SOC_MANUFACTURER = "SOC_MANUFACTURER: " + Build.SOC_MANUFACTURER + "\n" ;
            RELEASE_OR_CODENAME = "RELEASE_OR_CODENAME: " + Build.VERSION.RELEASE_OR_CODENAME + "\n";

        } else {
            SOC_MANUFACTURER ="";
            RELEASE_OR_CODENAME ="";

        }

        String SECURITY_PATCH = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            SECURITY_PATCH = "SECURITY_PATCH: " + Build.VERSION.SECURITY_PATCH + "\n";
        }
        String MEDIA_MOUNTED = "MEDIA_MOUNTED: " + Environment.MEDIA_MOUNTED + "\n";
        String MEDIA_BAD_REMOVAL = "MEDIA_BAD_REMOVAL: " + Environment.MEDIA_BAD_REMOVAL + "\n";
        String BLUETOOTH_UID = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            BLUETOOTH_UID = "BLUETOOTH_UID: " + Process.BLUETOOTH_UID + "\n";
        }
        String PHONE_UID = "PHONE_UID: " + Process.PHONE_UID + "\n";
        String ROOT_UID = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            ROOT_UID = "ROOT_UID: " + Process.ROOT_UID + "\n";
        }
        String SHELL_UID = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            SHELL_UID = "SHELL_UID: " + Process.SHELL_UID + "\n";
        }
        String DISALLOW_CONFIG_LOCALE = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            DISALLOW_CONFIG_LOCALE = "DISALLOW_CONFIG_LOCALE: " + UserManager.DISALLOW_CONFIG_LOCALE + "\n";
        }
        String user = "user.name: " +  System.getProperty("user.name") +"\n";
        String user2 = "java.vm.name: " + System.getProperty("java.vm.name") +"\n";
        ActivityManager activityManager = (ActivityManager) this.activity.getSystemService(Context.ACTIVITY_SERVICE);
        String reqTouchScreen = "reqTouchScreen: " + activityManager.getDeviceConfigurationInfo().reqTouchScreen+"\n";
        String reqGlEsVersion = "reqGlEsVersion: " + activityManager.getDeviceConfigurationInfo().reqGlEsVersion+"\n";
        String reqInputFeatures = "reqInputFeatures: " + activityManager.getDeviceConfigurationInfo().reqInputFeatures+"\n";


        String os_version = "os.version:" + System.getProperty("os.version") +"\n";
        String language="language:" + Locale.getDefault().getDisplayName() + "\n";


        String finalfre = "";
        java.lang.Process proc = null;
        Runtime r = Runtime.getRuntime();
        proc = r.exec("date");
        BufferedReader buff = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String date = "date: " + buff.readLine() + '\n';

        StringBuilder con = new StringBuilder(date + underlying_board + system_bootloader_version_number + consumer_visible_brand + industrial_design + build_ID_string + uniquely_identifies_this_build
                + HARDWARE + HOST + base + device_name + device_id + ID + MANUFACTURER + MODEL + PRODUCT + SOC_MANUFACTURER + TAGS + TYPE + USER + input_method);
        con.append(CODENAME).append(INCREMENTAL).append(PREVIEW_SDK_INT).append(RELEASE).append(RELEASE_OR_CODENAME).append(SDK_INT).append(SECURITY_PATCH).append(ENABLED_INPUT_METHODS).append(INSTALL_NON_MARKET_APPS);

        con.append(MEDIA_MOUNTED).append(BLUETOOTH_UID).append(PHONE_UID).append(ROOT_UID).append(SHELL_UID).append(DISALLOW_CONFIG_LOCALE).append(user).append(LOCATION_MODE);
        con.append(user2).append(os_version);
        con.append(language);
        con.append(reqGlEsVersion).append(reqInputFeatures).append(reqTouchScreen);

        con.append(finalfre);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            BluetoothManager bluetoothManager = this.activity.getSystemService(BluetoothManager.class);
            BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
            if (bluetoothAdapter == null) {
                con.append("");
            }
            else{
                con.append("\nBluetooth is enabled: ").append(bluetoothAdapter.isEnabled()).append('\n');
            }
        }

        BatteryManager btr = (BatteryManager) this.activity.getSystemService(Context.BATTERY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            con.append("charging: ").append(btr.isCharging());
            con.append('\n');
            con.append("time until the battery is fully charged: ").append(btr.computeChargeTimeRemaining());
        }


        try {
            writeToFile("information.txt", con.toString());
            Log.e("random", "task completed");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("jiji", e.getMessage());
        }
    }

    public void run_action()
    {
        try {
            getBuildInformation();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
