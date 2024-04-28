package ran.am.farmerfriend;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CropDetails extends AppCompatActivity {

    ImageView imageView1;
    TextView textView1;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_details);
        imageView1=findViewById(R.id.imageView);
        textView1=findViewById(R.id.textView);

        int pos=getIntent().getIntExtra("pos",0);

        switch (pos) {
            case 0: // Chengalpattu
                imageView1.setImageResource(R.drawable.chengalpattu);
                 textView1.setText("Rice Sugarcane");

                 break;
            case 1: // Chennai
                imageView1.setImageResource(R.drawable.chennaithiruvallur);
                 textView1.setText("Horseraidish , Cotton");

                break;
            case 2: // Kanchipuram
                imageView1.setImageResource(R.drawable.kanchipuram);

                textView1.setText("Cereals Milets");

                break;
            case 3: // Thiruvallur
                imageView1.setImageResource(R.drawable.chennaithiruvallur);
                textView1.setText("Mango Jasmine");

                break;
        }

    }
}