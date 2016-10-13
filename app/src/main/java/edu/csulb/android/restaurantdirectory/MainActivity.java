package edu.csulb.android.restaurantdirectory;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] itemname ={
            "Tomato Soup",
            "Paneer Tikka Starter",
            "Garlic Naan",
            "Paneer Butter Masala Gravy",
            "Veg. Hakka Noodles",
            "Veg. Pulao",
            "Mocktails",
            "Chocolate Pastry"
    };

    Integer[] imgid={
            R.drawable.soup,
            R.drawable.paneer,
            R.drawable.naan,
            R.drawable.gravy,
            R.drawable.noodles,
            R.drawable.pulao,
            R.drawable.mocktails,
            R.drawable.pastry,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomListAdapter adapter = new CustomListAdapter(this, itemname, imgid);
        list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                if (position == 7) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Allergin Information")
                            .setMessage("This chocolate pastry contains wheat, soya and/or nuts. Are you sure you" +
                                    " want to order this?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                                    intent.putExtra("position", position);
                                    startActivity(intent);
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info:
                startActivity(new Intent(this, RestaurantInformation.class));
                return true;
            case R.id.uninstall:
                Uri packageUri = Uri.parse("package:edu.csulb.android.restaurantdirectory");
                Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageUri);
                startActivity(uninstallIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}




