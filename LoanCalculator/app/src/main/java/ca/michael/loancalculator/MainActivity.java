package ca.michael.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etLoan, etYear, etRate;
    TextView monthlyRes, totalInterestRes, totalPaymentRes;
    int year;
    double loan, rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get a handle for the text fields
        etLoan = (EditText) findViewById(R.id.loanInput);
        etYear = (EditText) findViewById(R.id.yearInput);
        etRate = (EditText) findViewById(R.id.rateInput);
        monthlyRes = (TextView) findViewById(R.id.monthlyResult_tv);
        totalPaymentRes = (TextView) findViewById(R.id.totalPaymentResult_tv);
        totalInterestRes = (TextView) findViewById(R.id.totalInterestResult_tv);
    }

    public void calcMonthlyPayment(View v) {
        if (etLoan.getText().toString().equals("") || etYear.getText().toString().equals("") || etRate.getText().toString().equals("")) {
            Toast msg = Toast.makeText(this, getString(R.string.errorMsg), Toast.LENGTH_LONG);
            msg.show();
        }
        else {
            loan = Double.parseDouble(etLoan.getText().toString());
            year = Integer.parseInt(etYear.getText().toString());
            rate = Double.parseDouble(etRate.getText().toString());
            LoanCalculator lc = new LoanCalculator(loan, year, rate);

            //Formatting the number
            monthlyRes.setText(String.format("%.2f", lc.getMonthlyPayment()));
            totalPaymentRes.setText(String.format("%.2f", lc.getTotalCostOfLoan()));
            totalInterestRes.setText(String.format("%.2f" ,lc.getTotalInterest()));
        }
    }

    public void clearText(View v) {
        etLoan.setText(getString(R.string.empty));
        etYear.setText(getString(R.string.empty));
        etRate.setText(getString(R.string.empty));
        monthlyRes.setText(getString(R.string.empty));
        totalPaymentRes.setText(getString(R.string.empty));
        totalInterestRes.setText(getString(R.string.empty));
    }
}
