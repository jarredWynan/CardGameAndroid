package com.jarredwynan_adammitchell.cardgame;

import android.media.Image;
import android.os.Debug;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Game extends ActionBarActivity {

    // Completed by Jarred Wynan ----------------

    // store the id's of all the cards
    private Integer cardImages[] = {R.mipmap.facedown,
                                    R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.four, R.mipmap.five,
                                    R.mipmap.six, R.mipmap.seven, R.mipmap.eight, R.mipmap.nine, R.mipmap.ten};

    // store the matrix of imagebuttons in a 2D array
    private int cardField[][] = {{R.id.card11, R.id.card12, R.id.card13, R.id.card14}, // 5cells * 4cells = 20 cells
                                 {R.id.card21, R.id.card22, R.id.card23, R.id.card24},
                                 {R.id.card31, R.id.card32, R.id.card33, R.id.card34},
                                 {R.id.card41, R.id.card42, R.id.card43, R.id.card44},
                                 {R.id.card51, R.id.card52, R.id.card53, R.id.card54}};

    private int gameField[][] = new int [5][4];// holds ints 1-10, which are the cards, 0 for empty

    private boolean firstClick = false;
    private boolean secondClick = false; // make sure user can't press another card while selected cards are being displayed
    private int selectedCardID = 0;

    private int tempi = 0;
    private int tempj = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setupButtons();
    }


    private void setupButtons() {
        for (int i=1; i <= 10; i++){ // go through 10 pairs and place them into the gameField
            Random rand = new Random();
            boolean firstCardDown = false;
            while (!firstCardDown) {
                int x = rand.nextInt(5); // generate random number between 0 and 4
                int y = rand.nextInt(4);
                if (gameField[x][y] == 0) {
                    gameField[x][y] = i; // put down first card of the pair
                    firstCardDown = true;
                }
            }
            boolean secondCardDown = false;
            while (!secondCardDown) {
                int x = rand.nextInt(5); // generate random number between 0 and 4
                int y = rand.nextInt(4);
                if (gameField[x][y] == 0) {
                    gameField[x][y] = i; //put down second card of the pair
                    secondCardDown = true;
                }
            }
        }

        ImageButton btn11 = (ImageButton) findViewById(cardField[0][0]);
        btn11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[0][0]));
                    int n = gameField[0][0];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn12 = (ImageButton) findViewById(cardField[0][1]);
        btn12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[0][1]));
                    int n = gameField[0][1];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn13 = (ImageButton) findViewById(cardField[0][2]);
        btn13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[0][2]));
                    int n = gameField[0][2];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn14 = (ImageButton) findViewById(cardField[0][3]);
        btn14.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[0][3]));
                    int n = gameField[0][3];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn21 = (ImageButton) findViewById(cardField[1][0]);
        btn21.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[1][0]));
                    int n = gameField[1][0];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn22 = (ImageButton) findViewById(cardField[1][1]);
        btn22.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[1][1]));
                    int n = gameField[1][1];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn23 = (ImageButton) findViewById(cardField[1][2]);
        btn23.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[1][2]));
                    int n = gameField[1][2];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn24 = (ImageButton) findViewById(cardField[1][3]);
        btn24.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[1][3]));
                    int n = gameField[1][3];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn31 = (ImageButton) findViewById(cardField[2][0]);
        btn31.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[2][0]));
                    int n = gameField[2][0];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn32 = (ImageButton) findViewById(cardField[2][1]);
        btn32.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[2][1]));
                    int n = gameField[2][1];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn33 = (ImageButton) findViewById(cardField[2][2]);
        btn33.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[2][2]));
                    int n = gameField[2][2];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn34 = (ImageButton) findViewById(cardField[2][3]);
        btn34.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[2][3]));
                    int n = gameField[2][3];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn41 = (ImageButton) findViewById(cardField[3][0]);
        btn41.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[3][0]));
                    int n = gameField[3][0];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn42 = (ImageButton) findViewById(cardField[3][1]);
        btn42.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[3][1]));
                    int n = gameField[3][1];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn43 = (ImageButton) findViewById(cardField[3][2]);
        btn43.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[3][2]));
                    int n = gameField[3][2];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn44 = (ImageButton) findViewById(cardField[3][3]);
        btn44.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[3][3]));
                    int n = gameField[3][3];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn51 = (ImageButton) findViewById(cardField[4][0]);
        btn51.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[4][0]));
                    int n = gameField[4][0];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn52 = (ImageButton) findViewById(cardField[4][1]);
        btn52.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[4][1]));
                    int n = gameField[4][1];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn53 = (ImageButton) findViewById(cardField[4][2]);
        btn53.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[4][2]));
                    int n = gameField[4][2];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });

        ImageButton btn54 = (ImageButton) findViewById(cardField[4][3]);
        btn54.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // flip the card over to reveal its face
                if (!secondClick) {
                    ImageButton btn = (ImageButton) (findViewById(cardField[4][3]));
                    int n = gameField[4][3];// get card stored in this cell
                    btn.setImageResource(cardImages[n]);

                    if (firstClick == false) {
                        selectedCardID = n; // gets card ID stored in this cell
                        firstClick = true;
                    } else if (firstClick == true && secondClick == false) {
                        secondClick = true;
                        finishTurn(selectedCardID, n);
                    }
                }
            }
        });
    }

    private void finishTurn(int ID1, int ID2){
        if (ID1 == ID2){
            // turn cards invisible
            for(int i = 0; i < 5;i++)
            {
                for(int j = 0; j < 4;j++)
                {
                    if(ID1 == gameField[i][j])
                    {
                        //ImageButton btn = (ImageButton) (findViewById(cardField[i][j]));
                        //btn.setImageResource(cardImages[0]);
                        firstClick = false;
                        secondClick = false;

                    }
                }
            }
        }
        else {
            // hold cards face up for 2 seconds then flip back over
            int i = 0;
            int j = 0;
            for(i = 0; i < 5;i++)
            {
                for(j = 0; j < 4;j++)
                {
                    tempi = i;
                    tempj = j;
                    if(ID1 == gameField[i][j] || ID2 == gameField[i][j])
                    {
                        //3 second countdown until stuff happens
                        new CountDownTimer(3000, 1000) {
                            private int test_i = tempi;
                            private int test_j = tempj;
                            public void onTick(long millisUntilFinished) {}

                            public void onFinish() {
                                ImageButton btn = (ImageButton) (findViewById(cardField[test_i][test_j]));
                                btn.setImageResource(cardImages[0]);
                                firstClick = false;
                                secondClick = false;
                            }
                        }.start();
                    }
                }
            }
        }
    }
    // -------------------------------------------

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
