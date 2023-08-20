package com.example.Try;

import android.app.Activity;
import android.Manifest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.content.Intent;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class upload extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
        initViews();
        String Acc = (String) getIntent().getExtras().getString("ACC");
        String Pw = (String) getIntent().getExtras().getString("PW");

        logout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent logout = new Intent();
                logout.setClass(upload.this, login.class);
                startActivity(logout);
                finish();
            }
        });
        personal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Bundle bundle = new Bundle();
                bundle.putString("A", Acc.toString());
                bundle.putString("P", Pw.toString());
                Intent personal = new Intent();
                personal.putExtras(bundle);
                personal.setClass(upload.this, personal.class);
                startActivity(personal);
            }
        });
        knowledge.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent knowledge = new Intent();
                knowledge.setClass(upload.this, knowledge.class);
                startActivity(knowledge);
            }
        });
        contact.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent contact = new Intent();
                contact.setClass(upload.this, contact.class);
                startActivity(contact);
            }
        });
    }


    private Button logout;
    private Button identify;
    private Button Camupload;
    private Button Photoupload;
    private ImageView img;
    private ImageButton personal;
    private ImageButton knowledge;
    private ImageButton contact;

    private String TAG = "tag";
    //需要的權限數組 讀/寫/相機
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};

    private Uri ImageUri;
    public static final int TAKE_PHOTO = 101;
    public static final int TAKE_CAMARA = 100;

    private void initViews()
    {
        logout = (Button)findViewById(R.id.button6);
        identify = (Button)findViewById(R.id.button7);
        Camupload = (Button)findViewById(R.id.button8);
        Photoupload = (Button)findViewById(R.id.button10);
        img = (ImageView) findViewById(R.id.imageView2);
        personal = (ImageButton) findViewById(R.id.imageButton3);
        knowledge = (ImageButton) findViewById(R.id.imageButton4);
        contact = (ImageButton) findViewById(R.id.imageButton5);

        Camupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //檢查是否已經獲得相機的權限
                if (verifyPermissions(upload.this, PERMISSIONS_STORAGE[2]) == 0) {
                    Log.i(TAG, "提示是否要授權");
                    ActivityCompat.requestPermissions(upload.this, PERMISSIONS_STORAGE, 3);
                } else {
                    //已經有權限
                    toCamera();  //打開相機
                }
            }
        });
        Photoupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPicture();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        //將拍攝的照片顯示出来
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(ImageUri));
                        img.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case TAKE_CAMARA:
                if (resultCode == RESULT_OK) {
                    try {
                        //將相冊的照片顯示出来
                        Uri uri_photo = data.getData();
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri_photo));
                        img.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }


    /**
     * 檢查是否有對應權限
     *
     * @param activity   上下文
     * @param permission 要檢查的權限
     * @return 结果標示
     */
    public int verifyPermissions(Activity activity, java.lang.String permission) {
        int Permission = ActivityCompat.checkSelfPermission(activity, permission);
        if (Permission == PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "已經同意權限");
            return 1;
        } else {
            Log.i(TAG, "沒有同意權限");
            return 0;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults != null && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "用戶授權");
            toCamera();
        } else {
            Log.i(TAG, "用戶未授權");
        }
    }

    //跳轉相冊
    private void toPicture() {
        Intent intent = new Intent(Intent.ACTION_PICK);  //跳转到 ACTION_IMAGE_CAPTURE
        intent.setType("image/*");
        startActivityForResult(intent, TAKE_CAMARA);
        Log.i(TAG, "跳轉相簿成功");
    }

    //跳轉相機
    private void toCamera() {
        //建立File對象，用於儲存拍照后的圖片
//        File outputImage = new File(getExternalCacheDir(), "outputImage.jpg");
        File outputImage = new File(getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
        if (outputImage.exists()) {
            outputImage.delete();
        } else {
            try {
                outputImage.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //判斷SDK版本高低，ImageUri方法不同
        if (Build.VERSION.SDK_INT >= 24) {
            ImageUri = FileProvider.getUriForFile(upload.this, "com.example.Try.fileprovider", outputImage);
        } else {
            ImageUri = Uri.fromFile(outputImage);
        }

        //啟動相機
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, ImageUri);
        startActivityForResult(intent, TAKE_PHOTO);
    }

}
