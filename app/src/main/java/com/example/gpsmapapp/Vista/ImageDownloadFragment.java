package com.example.gpsmapapp.Vista;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gpsmapapp.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownloadFragment extends Fragment implements SensorEventListener {

    private ImageView mImageView;
    private TextView mTextViewSensor;
    private SensorManager sensorManager;
    private Sensor rotationVectorSensor;

    private static final String IMAGE_URL = "https://picsum.photos/400/200";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_download, container, false);

        mImageView = view.findViewById(R.id.imageView);
        Button btnDescargar = view.findViewById(R.id.btnDescargar);
        mTextViewSensor = new TextView(getContext());
        mTextViewSensor = view.findViewById(R.id.textViewSensor); // Si decides agregarlo al layout

        btnDescargar.setOnClickListener(v -> {
            new Thread(() -> {
                final Bitmap bitmap = loadImageFromNetwork(IMAGE_URL);
                if (bitmap != null) {
                    mImageView.post(() -> {
                        mImageView.setImageBitmap(bitmap);
                        Toast.makeText(getActivity(), "Imagen descargada y mostrada.", Toast.LENGTH_SHORT).show();
                    });
                } else {
                    mImageView.post(() -> {
                        Toast.makeText(getActivity(), "Error al descargar la imagen.", Toast.LENGTH_LONG).show();
                    });
                }
            }).start();
        });

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        rotationVectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);

        if (rotationVectorSensor == null) {
            mTextViewSensor.setText("Sensor de Vector de Rotación NO disponible.");
        }

        return view;
    }

    private Bitmap loadImageFromNetwork(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (rotationVectorSensor != null) {
            sensorManager.registerListener(this, rotationVectorSensor, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (rotationVectorSensor != null) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            String sensorData = String.format("Vector de Rotación:\nX: %.3f\nY: %.3f\nZ: %.3f", x, y, z);
            mTextViewSensor.setText(sensorData);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Opcional
    }
}
