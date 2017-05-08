package kh.edu.rupp.fe.ruppmad;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by MK COMPUTER on 5/8/2017.
 */

public class EditProfileActivity extends AppCompatActivity {

    ImageButton back_btn;
    EditText editName, editGender, editTel, editMail, editDept;
    Button save_btn;
    public static String PREFERENCE_NAME = "profile.pref";
    public static String NAME_KEY = "name";
    public static String GENDER_KEY = "gender";
    public static String TEL_KEY = "tel";
    public static String EMAIL_KEY = "email";
    public static String DEPT_KEY = "dept";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        back_btn = (ImageButton) findViewById(R.id.back_btn);
        editName = (EditText) findViewById(R.id.edit_name);
        editGender = (EditText) findViewById(R.id.edit_gender);
        editTel = (EditText) findViewById(R.id.edit_tel);
        editMail = (EditText) findViewById(R.id.edit_mail);
        editDept = (EditText) findViewById(R.id.edit_dept);
        save_btn = (Button) findViewById(R.id.save_btn);

        getDataFromSharePreference();
        save_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                saveProfileData();
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getDataFromSharePreference(){
        SharedPreferences preferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        String nameKey = preferences.getString(NAME_KEY, null);
        editName.setText(nameKey);
        editGender.setText(preferences.getString(GENDER_KEY, null));
        editTel.setText(preferences.getString(TEL_KEY, null));
        editMail.setText(preferences.getString(EMAIL_KEY, null));
        editDept.setText(preferences.getString(DEPT_KEY, null));
    }

    private void saveProfileData(){
        String data_name = editName.getText().toString();
        String data_gender = editGender.getText().toString();
        String data_tel = editTel.getText().toString();
        String data_email = editMail.getText().toString();
        String data_dept = editDept.getText().toString();
        if(data_name.isEmpty() || data_gender.isEmpty() || data_tel.isEmpty() || data_email.isEmpty() || data_dept.isEmpty())
            {Toast.makeText(this, "No inputs.", Toast.LENGTH_LONG).show();}
        else {
            SharedPreferences preference = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = preference.edit();
            editor.putString(NAME_KEY, data_name);
            editor.putString(GENDER_KEY, data_gender);
            editor.putString(TEL_KEY, data_tel);
            editor.putString(EMAIL_KEY, data_email);
            editor.putString(DEPT_KEY, data_dept);
            editor.apply();
            finish();
        }

    }
}
