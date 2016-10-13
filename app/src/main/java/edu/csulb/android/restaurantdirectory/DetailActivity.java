package edu.csulb.android.restaurantdirectory;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    int position = -1;
    TextView name;
    ImageView img;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();
        Bundle extras = i.getExtras();

        if (extras!=null){
            position = extras.getInt("position");
        }

        name = (TextView)findViewById(R.id.txtName);
        description = (TextView)findViewById(R.id.txtDescription);
        img = (ImageView)findViewById(R.id.imgFood);

        switch (position){
            case 0:
                name.setText("Tomato Soup");
                img.setImageDrawable(getResources().getDrawable(R.drawable.soup));
                description.setText("Hot tomato soup served with croutons\n\nPrice: $8");
                break;

            case 1:
                name.setText("Paneer Tikka Starter");
                img.setImageDrawable(getResources().getDrawable(R.drawable.paneer));
                description.setText("Cubes of cottage cheese, green bellpepper and onion marinated in spicy sauce and roasted " +
                        "in oven\n\nPrice: $12");
                break;

            case 2:
                name.setText("Garlic Naan");
                img.setImageDrawable(getResources().getDrawable(R.drawable.naan));
                description.setText("Fresh indian flat bread flavored with garlic and butter\n\nPrice: $4");
                break;

            case 3:
                name.setText("Paneer Butter Masala Gravy");
                img.setImageDrawable(getResources().getDrawable(R.drawable.gravy));
                description.setText("Cottage cheese served in rich spicy gravy of onions and tomatoes\n\nPrice: $12");
                break;

            case 4:
                name.setText("Veg. Hakka Noodles");
                img.setImageDrawable(getResources().getDrawable(R.drawable.noodles));
                description.setText("Wheat noodles stir fried in chilly and soya sauce with vegetables\n\nPrice: $10");
                break;

            case 5:
                name.setText("Veg. Pulao");
                img.setImageDrawable(getResources().getDrawable(R.drawable.pulao));
                description.setText("Rice stir fried with mix vegetables like peas, potato, french beans, carrots, etc.\n\n" +
                        "Price: $10");
                break;

            case 6:
                name.setText("Mocktails");
                img.setImageDrawable(getResources().getDrawable(R.drawable.mocktails));
                description.setText("Variety of mocktails available - Blueberry, Fruit Punch, etc.\n\n" +
                        "Buy 2, Get 1 Free!!!(Limited Time Offer)\n\nPrice: $8");
                break;

            case 7:

                name.setText("Chocolate Pastry");
                img.setImageDrawable(getResources().getDrawable(R.drawable.pastry));
                description.setText("Delicious freshly baked Belgian chocolate pastry\n\nPrice: $10");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DetailActivity.this, MainActivity.class));
        finish();
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
