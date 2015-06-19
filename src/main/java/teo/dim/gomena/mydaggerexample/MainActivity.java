package teo.dim.gomena.mydaggerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject MyDataModule myDataModule;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication app = (MyApplication) getApplication();
        app.getObjectGraph().inject(this);

        textView = (TextView) findViewById(R.id.my_data);
        if (myDataModule != null) {
            textView.setText(myDataModule.createMyDataItems());
        } else {
            textView.setText("Its NULL");
        }

    }

}
