package kh.edu.rupp.fe.ruppmad;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by MK COMPUTER on 5/8/2017.
 */

public class ViewProfileActivity extends Fragment {
    private ImageButton imageButton;
    private TextView name, gender, tel, email, dept;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.activity_view_profile, container, false);

        imageButton = (ImageButton) contentView.findViewById(R.id.edit_btn);
        name = (TextView) contentView.findViewById(R.id.text_name);
        gender = (TextView) contentView.findViewById(R.id.text_gender);
        tel = (TextView) contentView.findViewById(R.id.text_tel);
        email = (TextView) contentView.findViewById(R.id.text_email);
        dept = (TextView) contentView.findViewById(R.id.text_dept);
        getDataFromSharePreference();

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("Here", "Click");
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(intent);
            }
        });
        return contentView;
    }

    private void getDataFromSharePreference(){
        SharedPreferences preferences = getActivity().getSharedPreferences(EditProfileActivity.PREFERENCE_NAME, Context.MODE_PRIVATE);
        String nameKey = preferences.getString(EditProfileActivity.NAME_KEY, null);
        name.setText(nameKey);
        gender.setText(preferences.getString(EditProfileActivity.GENDER_KEY, null));
        tel.setText(preferences.getString(EditProfileActivity.TEL_KEY, null));
        email.setText(preferences.getString(EditProfileActivity.EMAIL_KEY, null));
        dept.setText(preferences.getString(EditProfileActivity.DEPT_KEY, null));
    }

    @Override
    public void onResume() {
        super.onResume();
        getDataFromSharePreference();
    }
}
