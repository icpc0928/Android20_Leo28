package tw.org.iii.leo.leo28;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView birthday;
    Boolean isWarn = true;
    private View rootView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        birthday = findViewById(R.id.birthday);
        rootView = findViewById(R.id.rootView);
    }

    public void test1(View view) {
        newDate();



    }


    private void newDate(){
        DatePickerDialog dialog = new DatePickerDialog(this,
                DatePickerDialog.THEME_DEVICE_DEFAULT_DARK, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                birthday.setText(year + "/" + (month + 1) + "/" + dayOfMonth);
            }
        }, 2020, 4 - 1, 12);


        DatePicker picker = dialog.getDatePicker();
        Calendar limit = Calendar.getInstance();
        limit.set(2020, 3, 12);

        picker.setMaxDate(limit.getTimeInMillis());

        dialog.show();

    }


    public void test2(View view) {

        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            }
        },12,30,true);



        dialog.show();
    }

    private void showMyToast(String mesg){
        LayoutInflater inflater = getLayoutInflater();
        View view =inflater.inflate(R.layout.toast,null);

        TextView toast_mesg = view.findViewById(R.id.toast_mesg);
        ImageView img = view.findViewById(R.id.toast_img);

        toast_mesg.setText(mesg);
        img.setImageResource(isWarn?R.drawable.warning:R.drawable.info);


        Toast toast = new Toast(this);
        toast.setGravity(Gravity.NO_GRAVITY,0,200);

        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

    }

//toast
    public void test3(View view) {
        showMyToast("Hello,World");
    }


    //snackBar
    public void test4(View view) {
        Snackbar.make(rootView,"Hello,World",Snackbar.LENGTH_LONG).show();

    }
}
