package tw.org.iii.leo.leo28;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test1(View view) {
        DatePickerDialog dialog = new DatePickerDialog(this,
                DatePickerDialog.THEME_DEVICE_DEFAULT_DARK,null,2020,4-1,12);

        dialog.show();

    }
}
