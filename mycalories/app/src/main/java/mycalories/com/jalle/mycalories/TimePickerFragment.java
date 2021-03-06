package mycalories.com.jalle.mycalories;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.widget.TimePicker;

import java.util.Calendar;

// Class used for time picker
public class TimePickerFragment extends DialogFragment implements
        TimePickerDialog.OnTimeSetListener {

    public static interface OnTimeSetListener {
        void onTimeSet(Time time);
    }

    private OnTimeSetListener onTimeSetListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
     /*  if (onTimeSetListener != null) {
           Time newTime =new Time(hourOfDay+":"+minute+ "");
            onTimeSetListener.onTimeSet(newTime);
        }*/
        if (onTimeSetListener != null) {
            Time newTime = new Time();
            newTime.setToNow();
            newTime.hour = hourOfDay;
            newTime.minute = minute;
            onTimeSetListener.onTimeSet(newTime);
        }
    }

    public void setOnTimeSetListener(OnTimeSetListener onTimeSetListener) {
        this.onTimeSetListener = onTimeSetListener;
    }
}