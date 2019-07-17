package org.techtown.hackathon.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;

import org.techtown.hackathon.R;
import org.techtown.hackathon.databinding.ActivityMainBinding;
import org.techtown.hackathon.network.BroadcastD;
import org.techtown.hackathon.viewmodel.HeartRateViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private CameraManager mCameraManager;
    private CaptureRequest.Builder mPreviewRequestBuilder;
    private CameraCaptureSession mCaptureSession;
    private CameraDevice mCameraDevice;
    private SurfaceTexture mTexture;
    private String mCameraId;
    private boolean mFlashOn;
    private HeartRateViewModel heartRateViewModel;
    String numStr;

    @SuppressLint("SetTextI18n")
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        heartRateViewModel = new HeartRateViewModel(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel();
        }

        mCameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);

        binding.morningBtn.setOnClickListener(v -> {

            @SuppressLint("SetTextI18n") TimePickerDialog.OnTimeSetListener timeListener = (view, hourOfDay, minute) -> {
                AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(MainActivity.this, BroadcastD.class);

                PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

                Calendar calNow = Calendar.getInstance();
                Calendar calSet = (Calendar)calNow.clone();

                calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calSet.set(Calendar.MINUTE, minute);

                am.set(AlarmManager.RTC_WAKEUP, calSet.getTimeInMillis(), sender);

                int isAMPM = calSet.get(Calendar.AM_PM);

                if(hourOfDay > 12 && isAMPM == 1)
                {
                    hourOfDay = hourOfDay - 12;
                }

                switch (isAMPM) {
                    case Calendar.AM:
                        binding.morningBtn.setText("아침 - 오전 " + hourOfDay + "시 " + minute + "분");
                        break;

                    case Calendar.PM:
                        binding.morningBtn.setText("아침 - 오후 " + hourOfDay + "시 " + minute + "분");
                        break;
                }

                if(calSet.compareTo(calNow) <= 0){

                    calSet.add(Calendar.DATE, 1);
                }
            };
            Calendar c = Calendar.getInstance();

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    MainActivity.this, timeListener,
                    c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE),false);

            timePickerDialog.show();
        });

        binding.lunchBtn.setOnClickListener(v -> {

            @SuppressLint("SetTextI18n") TimePickerDialog.OnTimeSetListener timeListener = (view, hourOfDay, minute) -> {
                AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(MainActivity.this, BroadcastD.class);

                PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 1, intent, 0);

                Calendar calNow = Calendar.getInstance();
                Calendar calSet = (Calendar)calNow.clone();

                calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calSet.set(Calendar.MINUTE, minute);

                am.set(AlarmManager.RTC_WAKEUP, calSet.getTimeInMillis(), sender);

                int isAMPM = calSet.get(Calendar.AM_PM);

                if(hourOfDay > 12 && isAMPM == 1)
                {
                    hourOfDay = hourOfDay - 12;
                }

                switch (isAMPM) {
                    case Calendar.AM:
                        binding.lunchBtn.setText("점심 - 오전 " + hourOfDay + "시 " + minute + "분");
                        break;

                    case Calendar.PM:
                        binding.lunchBtn.setText("점심 - 오후 " + hourOfDay + "시 " + minute + "분");
                        break;
                }

                if(calSet.compareTo(calNow) <= 0){

                    calSet.add(Calendar.DATE, 1);
                }
            };
            Calendar c = Calendar.getInstance();

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    MainActivity.this, timeListener,
                    c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE),false);

            timePickerDialog.show();
        });

        binding.dinnerBtn.setOnClickListener(v -> {

            @SuppressLint("SetTextI18n") TimePickerDialog.OnTimeSetListener timeListener = (view, hourOfDay, minute) -> {


                AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(MainActivity.this, BroadcastD.class);

                PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 2, intent, 0);

                Calendar calNow = Calendar.getInstance();
                Calendar calSet = (Calendar)calNow.clone();

                calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calSet.set(Calendar.MINUTE, minute);

                am.set(AlarmManager.RTC_WAKEUP, calSet.getTimeInMillis(), sender);

                int isAMPM = calSet.get(Calendar.AM_PM);

                if(hourOfDay > 12 && isAMPM == 1)
                {
                    hourOfDay = hourOfDay - 12;
                }

                switch (isAMPM) {
                    case Calendar.AM:
                        binding.dinnerBtn.setText("저녁 - 오전 " + hourOfDay + "시 " + minute + "분");
                        break;

                    case Calendar.PM:
                        binding.dinnerBtn.setText("저녁 - 오후 " + hourOfDay + "시 " + minute + "분");
                        break;
                }

                if(calSet.compareTo(calNow) <= 0){

                    calSet.add(Calendar.DATE, 1);
                }
            };
            Calendar c = Calendar.getInstance();

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    MainActivity.this, timeListener,
                    c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE),false);

            timePickerDialog.show();
        });

        mCameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);


        binding.flashBtn.setOnClickListener(v -> {
            flashlight();

            Handler handler = new Handler();
            handler.postDelayed(() -> {
                Random random = new Random();

                int min, max;

                min = 80;
                max = 100;

                int num = random.nextInt(max - min + 1) + min;

                binding.heartRateTextview.setText(num + "");

                numStr = Integer.toString(num);

                flashlight();
            }, 5000);


        });

        binding.sendBtn.setOnClickListener(v -> {
            Toast.makeText(this, "전송에 성공하였습니다.", Toast.LENGTH_SHORT).show();
            heartRateViewModel.postHeartRate(numStr);
        });

        binding.locationBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
            startActivity(intent);
        });


    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        openCamera();
    }

    @Override
    protected void onPause() {
        closeCamera();
        super.onPause();
    }

    private void openCamera() {
        try {
            for (String id : mCameraManager.getCameraIdList()) {
                CameraCharacteristics c = mCameraManager.getCameraCharacteristics(id);
                Boolean flashAvailable = c.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                Integer lensFacing = c.get(CameraCharacteristics.LENS_FACING);
                if (flashAvailable != null && flashAvailable
                        && lensFacing != null && lensFacing == CameraCharacteristics.LENS_FACING_BACK) {
                    mCameraId = id;
                    break;
                }
            }

            mCameraManager.openCamera(mCameraId, new CameraDevice.StateCallback() {

                @Override
                public void onOpened(@NonNull CameraDevice cameraDevice) {
                    mCameraDevice = cameraDevice;

                    try {
                        List<Surface> list = new ArrayList<>();
                        if (mTexture != null) {
                            mTexture.release();
                        }
                        mTexture = new SurfaceTexture(1);
                        Surface surface = new Surface(mTexture);
                        list.add(surface);
                        mPreviewRequestBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
                        mPreviewRequestBuilder.addTarget(surface);
                        cameraDevice.createCaptureSession(list, new CameraCaptureSession.StateCallback() {
                            @Override
                            public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
                                if (null == mCameraDevice) {
                                    return;
                                }
                                try {
                                    mCaptureSession = cameraCaptureSession;
                                    cameraCaptureSession.setRepeatingRequest(mPreviewRequestBuilder.build(), null, null);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
                            }
                        }, null);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onDisconnected(@NonNull CameraDevice cameraDevice) {
                    cameraDevice.close();
                    mCameraDevice = null;
                }

                @Override
                public void onError(@NonNull CameraDevice cameraDevice, int error) {
                    cameraDevice.close();
                    mCameraDevice = null;
                    Toast.makeText(getApplicationContext(), "A camera error has occurred. The app will finish!", Toast.LENGTH_LONG).show();
                    delayedFinish();
                }
            }, null);
        } catch (SecurityException | CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void closeCamera() {
        if (null != mTexture) {
            mTexture.release();
            mTexture = null;
        }

        if (null != mCaptureSession) {
            mCaptureSession.close();
            mCaptureSession = null;
        }

        if (null != mCameraDevice) {
            mCameraDevice.close();
            mCameraDevice = null;
        }
    }

    private void flashlight() {
        mFlashOn = !mFlashOn;

        mPreviewRequestBuilder.set(CaptureRequest.FLASH_MODE, mFlashOn ? CaptureRequest.FLASH_MODE_TORCH : CaptureRequest.FLASH_MODE_OFF);

        try {
            mCaptureSession.setRepeatingRequest(mPreviewRequestBuilder.build(), null, null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void delayedFinish() {
        new Handler().postDelayed(this::finish, 3000);
    }

    @TargetApi(Build.VERSION_CODES.O)
    public void createNotificationChannel() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationChannel notificationChannel = new NotificationChannel("channel", "channel_name", NotificationManager.IMPORTANCE_DEFAULT);
        notificationChannel.setDescription("channel description");
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.GREEN);
        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[]{100, 200, 100, 200});
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        notificationManager.createNotificationChannel(notificationChannel);
    }
}
