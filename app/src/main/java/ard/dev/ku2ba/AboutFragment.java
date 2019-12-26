package ard.dev.ku2ba;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {

    private View view;
    private boolean isLoaded;
    TextView tv_kata_about;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (isLoaded == false){
            view = inflater.inflate(R.layout.about_fragment, container, false);
            init(view);
            isLoaded = true;
        }

        return view;
    }
    private void init(View view) {
        tv_kata_about = view.findViewById(R.id.tv_justified_paragraph);

        Typeface stratos_light_regular = ResourcesCompat.getFont(getActivity(), R.font.stratos_light_regular);
        //or to support all versions use
        Typeface stratos_regular = ResourcesCompat.getFont(getActivity(), R.font.stratos_regular);
        tv_kata_about.setTypeface(stratos_light_regular);
    }
}
