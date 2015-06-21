package teo.dim.gomena.mydaggerexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject MyDataModule myDataModule;
    ArrayList<String> arrayListData;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication app = (MyApplication) getApplication();
        app.getObjectGraph().inject(this);

        //Injects data
        arrayListData = myDataModule.createMyDataItems();

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter(this, arrayListData ));
    }


    private class MyAdapter extends ArrayAdapter<String> {
        public MyAdapter(Context context, ArrayList<String> data) {
            super(context, 0, data);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);

            TextView tvData = (TextView) convertView.findViewById(R.id.item_textview);
            tvData.setText(arrayListData.get(position));

            return convertView;
        }
    }


}
