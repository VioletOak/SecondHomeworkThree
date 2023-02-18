package com.example.secondhomeworkthree;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * Имеется отличный астрономический телескоп стоимостью 14 000 серебряных
     * монет (далее монет)
     * На счету имеется 1 000 монет и ежемесячно поступает стипендия в размере
     * 2 500 монет из которых все средства можно отложить на телескоп
     * Ваши накопления хранятся в банке под 5 % годовых
     * Необходимо рассчитать, за сколько времени при данных условиях можно
     * накопить на телескоп, ответ необходимо вывести на экран приложения
     */

    private float telescopePrice = 14_000;
    private int account = 1_000;
    private float salary = 2500;
    private float percentBank = 5;
    private float[] monthlyPayments = new float[36]; // 3 года

    private float telescopePriseWith() {
        return telescopePrice - account;
    }

    private int countMonth(float total, float salary, float percentBankYear) {
        float percentPayMonth = percentBankYear / 12;
        int count = 0;

        while (total > 0) {
            total = (total + (total * percentPayMonth) / 100) - salary;

            if (total > salary) {
                monthlyPayments[count] = salary;
            } else {
                monthlyPayments[count] = total;
            }
            count++;
        }
        return count;
    }

    private TextView countMonth;
    private TextView payments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView countMonth = findViewById(R.id.countMonth);
        TextView payments = findViewById(R.id.payments);

        String label = "Расчеты по кредиту";

        int count = countMonth(telescopePriseWith(), salary, percentBank);

        countMonth.setText(Integer.toString(count));

        String s = "";

        for (int i = 0; i < count; i++) {
            s += monthlyPayments[i] + " ; ";
        }
        payments.setText(s);
    }
}