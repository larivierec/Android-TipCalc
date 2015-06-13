package developpements.lariviere.android_tipcalc;

import developpements.lariviere.android_tipcalc.model.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements NavigationDrawerFragment.NavigationDrawerCallbacks{

    private EditText txtPrice;
    private Spinner txtGovtTax;
    private Spinner txtTipPercent;
    private InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPrice = (EditText) findViewById(R.id.txtPrice);
        txtGovtTax  = (Spinner) findViewById(R.id.spinner_tax);
        txtTipPercent = (Spinner) findViewById(R.id.spinner_tip);
        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void calculate(View view){


        imm.hideSoftInputFromWindow(txtGovtTax.getWindowToken(), 0);

        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        if(validateFields()){

            double tipPercent = Double.parseDouble(txtTipPercent.getSelectedItem().toString())/100;
            double taxMoney = Double.parseDouble(txtGovtTax.getSelectedItem().toString())/100;

            TipSystem.getInstance().createTip(Double.parseDouble(txtPrice.getText().toString()),  tipPercent, taxMoney);
            text = "" + TipSystem.getInstance().calculateTotal();
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    private boolean validateFields(){
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = null;

        if(txtPrice.getText().toString() == null){
            text = "Price is invalid, consider reviewing";
            toast = Toast.makeText(context, text, duration);
            toast.show();
            return false;
        }
        else if(txtGovtTax.getSelectedItem().toString() == null){
            text = "Government tax problem, e-mail support.";
            toast = Toast.makeText(context, text, duration);
            toast.show();
            return false;
        }
        else if(txtTipPercent.getSelectedItem().toString() == null){
            text = "Tip percentage problem, e-mail support.";
            toast = Toast.makeText(context, text, duration);
            toast.show();
            return false;
        }
        return true;
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

    }
}
