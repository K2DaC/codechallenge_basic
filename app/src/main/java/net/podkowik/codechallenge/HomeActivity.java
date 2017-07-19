package net.podkowik.codechallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ArrayList<Item> itemList = generateItems();

        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.list_item, itemList, new View.OnClickListener() {

            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Clicked Item", Toast.LENGTH_SHORT).show();

            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);

    }

    private ArrayList<Item> generateItems() {
        ArrayList<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            itemList.add(new Item("Item " + i));
        }
        return itemList;
    }

}
