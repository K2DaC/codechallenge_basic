package net.podkowik.codechallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class HomeActivity extends AppCompatActivity {

    ArrayList<Item> itemList;
    ItemArrayAdapter itemArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        itemList = generateItems();
        itemArrayAdapter = new ItemArrayAdapter(R.layout.list_item, itemList, new View.OnClickListener() {

            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Clicked Item", Toast.LENGTH_SHORT).show();

            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private ArrayList<Item> generateItems() {
        ArrayList<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            itemList.add(new Item("Item " + i));
        }
        return itemList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Collections.reverse(itemList);
                itemArrayAdapter.notifyDataSetChanged();
                break;
            default:
                break;
        }

        return true;
    }

}
