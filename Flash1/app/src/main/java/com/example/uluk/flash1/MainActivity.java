package com.example.uluk.flash1;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button onOffButton;
    private Camera _camera;
    private Camera.Parameters parameters=null;
    private boolean isFlashOn=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onOffButton=(Button) findViewById(R.id.button2);
        onOffButton.setOnClickListener(this);

    }
    public void getCamera(){
        if(_camera==null){
            try {


            _camera=Camera.open();
            parameters=_camera.getParameters();
            }
            catch (Exception ex){
                Toast.makeText(this,ex.toString(),Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    public void onClick(View view){
        if(view==onOffButton){
            if(isFlashOn){
                turnOnFlash();
            }
            else{
                getCamera();
                turnOffFlash();
            }

        }

    }
    public void turnOnFlash(){
        try{
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            _camera.setParameters(parameters);
            _camera.startPreview();
            isFlashOn=true;
            onOffButton.setText("Off");
        }
        catch (Exception ex){
            Toast.makeText(this,ex.toString(),Toast.LENGTH_LONG).show();

        }
    }
    public void turnOffFlash(){
        try{
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            _camera.setParameters(parameters);
            _camera.stopPreview();
            isFlashOn=false;
            onOffButton.setText("On");
        }
        catch (Exception ex){
            Toast.makeText(this,ex.toString(),Toast.LENGTH_LONG).show();

        }
    }
    @Override
    public void onStop(){
        super.onStop();
        if(_camera!=null){
            _camera.release();
            _camera=null;
            parameters=null;

        }
    }
    @Override
    public void onRestart(){
        super.onRestart();

    }

}
