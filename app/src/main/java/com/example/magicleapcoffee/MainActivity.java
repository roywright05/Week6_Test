package com.example.magicleapcoffee;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView mListView;

    String [] mTitle = {"Basic", "Americano", "Latte", "Frappiccino", "Mocha"};

    String [ ] mDescription  = {"Standard Beans and Water, cheap", "Coffee with a shot of extra",
                                "Coffee with milk", "Icy, thick and tasty", "Chocolate-y goodness"};
    int [] mImages = {R.drawable.coffee, R.drawable.americano, R.drawable.latte,
            R.drawable.frappe, R.drawable.mocha};

    Button mBtn [];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, mImages, mBtn);
        mListView.setAdapter(adapter);
    }

    class MyAdapter extends ArrayAdapter<String>{

        Context mContext;
        String rTitle [];
        String rDescription [];
        int rImages [];
        Button mBtn [];

        public MyAdapter(@NonNull Context context, String[] rTitle, String[] rDescription, int[] rImages, Button btn[]) {

            super(context, R.layout.row, R.id.tvOne, rTitle);
            this.mContext = context;
            this.rTitle = rTitle;
            this.rDescription = rDescription;
            this.rImages = rImages;
            this.mBtn = btn;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView tvTitle = row.findViewById(R.id.tvOne);
            TextView tvDescription = row.findViewById(R.id.tvTwo);


            images.setImageResource(rImages[position]);
            tvTitle.setText(rTitle[position]);
            tvDescription.setText(rDescription[position]);

            return row;
        }
    }
}
