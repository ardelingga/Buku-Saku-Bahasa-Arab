package ard.dev.ku2ba;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

public class KataPengantarFragment extends Fragment {
    private View view;
    private boolean isLoaded;
    TextView tv_kata_pengantar;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (isLoaded == false){
            view = inflater.inflate(R.layout.kata_pengantar_fragment, container, false);
            init(view);
            isLoaded = true;
        }

        return view;
    }

    private void init(View view) {
        tv_kata_pengantar = view.findViewById(R.id.tv_justified_paragraph);
        imageView = view.findViewById(R.id.iv_foto_kata_pengantar);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ShowImageActivity.class));
            }
        });

        Typeface stratos_light_regular = ResourcesCompat.getFont(getActivity(), R.font.stratos_light_regular);
        //or to support all versions use
        Typeface stratos_regular = ResourcesCompat.getFont(getActivity(), R.font.stratos_regular);
        tv_kata_pengantar.setTypeface(stratos_light_regular);
    }
}
