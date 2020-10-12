package android.example.userinteraction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**menambah komponen**/
    Spinner spinner;
    EditText editText;
    TextView textView;
    String label="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner_label);
        editText = findViewById(R.id.edit_input);
        textView = findViewById(R.id.textPhone);

        /**membuat dropdown lewat java**/
        ArrayAdapter<CharSequence> adapter=ArrayAdapter
                .createFromResource(this, R.array.labels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        /**pengecekan**/
        if(spinner != null){
            spinner.setAdapter(adapter); /**diintegrasikan antara spinner dan adapternya**/

            /**untuk membuat user dapat memilih spinner: **/
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    label = adapterView.getItemAtPosition(i).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

    }

    /**untuk yang ditampilkan apa saja**/
    public void showText(View view) {
        String showString="Phone Number: "+label+" - "+editText.getText().toString();
        textView.setText(showString);

    }

    public void onRadioButtonClicked(View view) {
        /**mengecek radio button**/
        boolean checked = ((RadioButton)view).isChecked();
        /**cara mengecek radio button mana yg mau dicek menggunakan switch**/
        switch (view.getId()){
            case R.id.radio_p1:
                if(checked)
                    Toast.makeText(this, "Anda memilih pilihan 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_p2:
                if(checked)
                    Toast.makeText(this, "Anda memilih pilihan 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_p3:
                if(checked)
                    Toast.makeText(this, "Anda memilih pilihan 3", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public void showAlert(View view) {
    }
}