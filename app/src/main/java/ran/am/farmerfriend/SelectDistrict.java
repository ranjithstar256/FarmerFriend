package ran.am.farmerfriend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SelectDistrict extends AppCompatActivity {
    private Spinner spinnerDistricts;
    private ImageView imageView1, imageView2;
    private TextView textView1, textView2;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_select_district);
        spinnerDistricts = findViewById(R.id.spinnerDistricts);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
         textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        // Array of districts
        String[] districts = {"Chengalpattu", "Chennai", "Kanchipuram", "Thiruvallur"};

        // Creating adapter for spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, districts);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDistricts.setAdapter(adapter);

        spinnerDistricts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateImages(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }
    private void updateImages(int position) {
        switch (position) {
            case 0: // Chengalpattu
                imageView1.setImageResource(R.drawable.blacksoil);
                imageView2.setImageResource(R.drawable.mixedsoil);
                 textView1.setText("black Soil");
                textView2.setText("Mixed Soil");

                pos=position;
                break;
            case 1: // Chennai
                imageView1.setImageResource(R.drawable.claysoil);
                imageView2.setImageResource(R.drawable.sandstonesoil);
                 textView1.setText("Clay Soil");
                textView2.setText("Sandstone Soil");
                pos=position;

                 break;
            case 2: // Kanchipuram
                imageView1.setImageResource(R.drawable.alluvialsoil);
                imageView2.setImageResource(R.drawable.mixedsoil);

                textView1.setText("Alluvial Soil");
                textView2.setText("Mixed Soil");
                pos=position;

                break;
            case 3: // Thiruvallur
                imageView1.setImageResource(R.drawable.coastalalluvial);
                  textView1.setText("Coastal Alluvial Soil ");
                  textView2.setText("");
                  imageView2.setImageResource(0);
                pos=position;

                 break;
        }
    }

    public void onButtonClick(View view) {


        startActivity(new Intent(SelectDistrict.this,
                CropDetails.class)
                .putExtra("pos",pos)
        );

    }
}