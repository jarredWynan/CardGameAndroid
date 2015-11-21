package com.jarredwynan_adammitchell.cardgame;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Game extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setupButtons();
    }

    // Completed by Jarred Wynan ----------------
    private void setupButtons() {
        ImageButton btn = (ImageButton) findViewById(R.id.card11);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                ImageButton btn = (ImageButton) (findViewById(R.id.card11));
                btn.setImageResource(R.mipmap.card10);
            }
        });
    }
    // --------------------------------------------

    //private void randomPlacement()
    // {
    //      Object slots[] = new array[20];
    //
    //      ImageButton images[] = new array[20];
    //      //assign images[] with the 20 images (one, one, two, two, etc)
    //
    //      //there's 20 different slots array of these slots "slots"
    //      for(int i = 0;i < 20; i++)
    //      {
    //          slots[i] = findImage();
    //      }
    // }

    //private void findImage()
    // {
    //      Object image;
    //      bool found = false;
    //      while(!found)
    //      {
    //          Random rand = new Random();
    //          int randomInt = rand.nextInt(19) + 0;
    //
    //          if(images[randomInt] != null)
    //          {
    //              image = images[randomInt];
    //              images[randomInt] = null;
    //              found = true;
    //          }
    //      }
    //
    //      return image;
    // }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
