package jp.techacademy.konoka.fujiwara.dot_list_20190203;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // データを準備
        //String[] items = {"item 0", "item 1", "item 2"};

        final List<String> items = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            items.add("item " + i);
        }

        // Adapterを準備
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, items);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout
                .simple_list_item_1, items);

        // ListViewにAdapterを設置
        final ListView myListView = (ListView) findViewById(R.id.myListView);

        //データがない時に空ですよって表示する。
        myListView.setEmptyView(findViewById(R.id.empty));
        myListView.setAdapter(adapter);


        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // Toast.makeText(MyActivity.this, Integer.toString(i) + "番目の要素です", Toast
                // .LENGTH_SHORT).show();
                // String s = myListView.getItemAtPosition(i).toString();
                // Toast.makeText(MyActivity.this, s, Toast.LENGTH_SHORT).show();

                TextView tv = (TextView) view;
                if(i == 2){
                    tv.setText("Clicked!特別！");
                }else {
                    tv.setText("Clicked!");
                }
            }
        });
        
    }
}