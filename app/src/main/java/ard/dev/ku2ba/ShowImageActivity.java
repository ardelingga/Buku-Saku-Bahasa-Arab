package ard.dev.ku2ba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ShowImageActivity extends AppCompatActivity {
    PhotoViewAttacher photoViewAttacher;
    ImageView imageView;
    FloatingActionButton btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_show_image);
        btn_back = findViewById(R.id.btn_back);
        imageView = findViewById(R.id.imageView);
        photoViewAttacher = new PhotoViewAttacher(imageView);
        photoViewAttacher.update();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();

    }
}
