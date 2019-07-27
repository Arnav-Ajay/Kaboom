package com.example.msarn.operatingsystems.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.Random;

public class GameActivity extends AppCompatActivity {


    int current  ;
    Integer pile;
    String[]  rank    = { "ace" , "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
    String[]    suit    = { "clubs", "diamonds", "hearts", "spades" };
    String[] cards = {"clubsace", "clubs2", "clubs3","clubs4","clubs5",
            "clubs6","clubs7","clubs8","clubs9","clubs10","clubsjack",
            "clubsqueen","clubsking",

            "diamondsace", "diamonds2", "diamonds3","diamonds4","diamonds5",
            "diamonds6","diamonds7","diamonds8","diamonds9","diamonds10","diamondsjack",
            "diamondsqueen","diamondsking",

            "heartsace", "hearts2", "hearts3","hearts4","hearts5",
            "hearts6","hearts7","hearts8","hearts9","hearts10","heartsjack",
            "heartsqueen","heartsking",

            "spadesace", "spades2", "spades3","spades4","spades5",
            "spades6","spades7","spades8","spades9","spades10","spadesjack",
            "spadesqueen","spadesking",};

    int action;
    String player[] = new String[4];
    String opponent[] = new String[4];
    Integer[] images = {R.drawable.clubsace, R.drawable.clubs2, R.drawable.clubs3,R.drawable.clubs4,R.drawable.clubs5,
            R.drawable.clubs6,R.drawable.clubs7,R.drawable.clubs8,R.drawable.clubs9,R.drawable.clubs10,R.drawable.clubsjack,
            R.drawable.clubsqueen,R.drawable.clubsking,

            R.drawable.diamondsace,R.drawable.diamonds2,R.drawable.diamonds3,R.drawable.diamonds4,R.drawable.diamonds5,
            R.drawable.diamonds6,R.drawable.diamonds7,R.drawable.diamonds8,R.drawable.diamonds9,R.drawable.diamonds10,
            R.drawable.diamondsjack,R.drawable.diamondsqueen,R.drawable.diamondsking,

            R.drawable.heartsace,R.drawable.hearts2,R.drawable.hearts3,R.drawable.hearts4,R.drawable.hearts5,
            R.drawable.hearts6,R.drawable.hearts7,R.drawable.hearts8,R.drawable.hearts9,R.drawable.hearts10,
            R.drawable.heartsjack,R.drawable.heartsqueen,R.drawable.heartsking,

            R.drawable.spadesace,R.drawable.spades2,R.drawable.spades3,R.drawable.spades4,R.drawable.spades5,
            R.drawable.spades6,R.drawable.spades7,R.drawable.spades8,R.drawable.spades9,R.drawable.spades10,
            R.drawable.spadesjack,R.drawable.spadesqueen,R.drawable.spadesking};
    Integer[] opponentimage = new Integer[4];
    Integer[] playerimage = new Integer[4];

    String p,o;
    Integer pi;

    public void shuffleDeck()
    {
        for (int i = 0; i < 52; i++)
        {
            int r = (int) (Math.random() * (51));
            String t = cards[r];
            cards[r] = cards[i];
            cards[i] = t;
            Integer j = images[r];
            images[r] = images[i];
            images[i] = j;
        }
        current = 0;
        Toast.makeText(getApplicationContext(),"Shuffled",Toast.LENGTH_SHORT).show();

    }

    public String deal() //Deals cards to player
    {

        return (cards[current]);
    }

    public void PlayerCards()
    {
        player[0]= deal();
        playerimage[0]=images[current];
        ImageView imageView0 = (ImageView) findViewById(R.id.img_playerd0);
        imageView0.setImageResource(images[current]);
        current++;
        player[1]= deal();
        playerimage[1]=images[current];
        ImageView imageView1 = (ImageView) findViewById(R.id.img_playerd1);
        imageView1.setImageResource(images[current]);
        current++;
        player[2]= deal();
        playerimage[2]=images[current];
        current++;
        player[3]= deal();
        playerimage[3]=images[current];
        current++;
    }

    public void OpponentCards()
    {
        opponent[0]= deal();
        opponentimage[0]=images[current];
        current++;
        opponent[1]= deal();
        opponentimage[1]=images[current];
        current++;
        opponent[2]= deal();
        opponentimage[2]=images[current];
        current++;
        opponent[3]= deal();
        opponentimage[3]=images[current];

    }

    public void BackFlip()
    {
        ImageView imageView1 = (ImageView) findViewById(R.id.img_playerd1);
        imageView1.setImageResource(R.drawable.card_backside_2);
        ImageView imageView0 = (ImageView) findViewById(R.id.img_playerd0);
        imageView0.setImageResource(R.drawable.card_backside_2);
    }

    public void clickOnAction(View view) //If button ACTION is clicked on
    {
        action = 1;

    }

    public void clickOnReplace(View view) //If button REPLACE is clicked on
    {
        action = 2;
        Button swapButton1 = (Button) findViewById(R.id.button8);
        swapButton1.setVisibility(View.GONE);
        Button swapButton2 = (Button) findViewById(R.id.button9);
        swapButton2.setVisibility(View.GONE);
        Button swapButton3 = (Button) findViewById(R.id.button10);
        swapButton3.setVisibility(View.GONE);
        Button swapButton4 = (Button) findViewById(R.id.button11);
        swapButton4.setVisibility(View.GONE);

    }

    public void clickOnNoAction(View view) //If button NO ACTION is clicked on
    {
        action = 3;
        ImageView imageView = (ImageView) findViewById(R.id.lay_pile_cards);
        imageView.setImageResource(images[current]);
        Button swapButton1 = (Button) findViewById(R.id.button8);
        swapButton1.setVisibility(View.GONE);
        Button swapButton2 = (Button) findViewById(R.id.button9);
        swapButton2.setVisibility(View.GONE);
        Button swapButton3 = (Button) findViewById(R.id.button10);
        swapButton3.setVisibility(View.GONE);
        Button swapButton4 = (Button) findViewById(R.id.button11);
        swapButton4.setVisibility(View.GONE);

    }

    public void clickOnDeck(View view)
    {
        Button swapButton1 = (Button) findViewById(R.id.button8);
        swapButton1.setVisibility(View.GONE);
        Button swapButton2 = (Button) findViewById(R.id.button9);
        swapButton2.setVisibility(View.GONE);
        Button swapButton3 = (Button) findViewById(R.id.button10);
        swapButton3.setVisibility(View.GONE);
        Button swapButton4 = (Button) findViewById(R.id.button11);
        swapButton4.setVisibility(View.GONE);
        Button actionButton = (Button) findViewById(R.id.action);
        actionButton.setVisibility(View.VISIBLE);
        current++;
        ImageView imageView = (ImageView) findViewById(R.id.lay_deck_cards);
        imageView.setImageResource(images[current]);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageView imageView = (ImageView) findViewById(R.id.lay_deck_cards);
                imageView.setImageResource(R.drawable.card_backside_2);

            }
        }, 5000);

        if(cards[current].matches("(.*)king(.*)") || cards[current].matches("(.*)ace(.*)") || cards[current].matches("(.*)2(.*)") || cards[current].matches("(.*)3(.*)")
                ||cards[current].matches("(.*)4(.*)") ||cards[current].matches("(.*)5(.*)") || cards[current].matches("(.*)6(.*)"))
        {

            actionButton.setVisibility(View.GONE);
        }
    }

    public void showcards(View view)
    {
        shuffleDeck();
        PlayerCards();
        OpponentCards();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                BackFlip();
            }
        }, 5000);
        Button showButton = (Button) findViewById(R.id.button2);
        showButton.setVisibility(View.GONE);
    }

    public void swap(String x,String y)
    {
        String t = x;
        x = y;
        y = t;
    }
    public void swapimage(Integer x, Integer y)
    {
        Integer t = x;
        x = y;
        y = t;
    }

    public void computer()
    {
        current++;
        int x = (int)getRandomNumber(1,3);

        switch(x)
        {

            case '1' : Action();
                break;

            case '2' : Discard();
                break;

            case '3' : Replace();
                break;

        }

        ImageView imageView = (ImageView) findViewById(R.id.lay_pile_cards);
        imageView.setImageResource(images[current]);

    }

    public void Action()
    {
        int x = getRandomNumber(0,3);

        int y = getRandomNumber(0,3);
        String c;
//use regex for comparison
        if(cards[current].matches("(.*)7(.*)") || cards[current].matches("(.*)8(.*)"))
        {
            c="System saw it's " + x + "th card";
            Toast.makeText(getApplicationContext(),"System saw it's " + x + "th card",Toast.LENGTH_SHORT).show();
        }
        else if(cards[current].matches("(.*)9(.*)") || cards[current].matches("(.*)10(.*)"))
        {
            c="System saw your " + x + "th card";
            Toast.makeText(getApplicationContext(),"System saw your " + x + "th card",Toast.LENGTH_SHORT).show();
        }
        else if(cards[current].matches("(.*)jack(.*)") || cards[current].matches("(.*)queen(.*)"))
        {
            c="System swapped it's " + x + "th card with your " + y + "th card";

            swap(opponent[x],player[y]);
            swapimage(opponentimage[x],playerimage[y]);
            Toast.makeText(getApplicationContext(),"System swapped it's " + x + "th card with your " + y + "th card",Toast.LENGTH_SHORT).show();
        }
        else
        {
            computer();
        }


    }

    public void Discard()
    {
        String c="System discarded the drawn card";
        Toast.makeText(getApplicationContext(),"System discarded the drawn card",Toast.LENGTH_SHORT).show();

    }

    public void Replace()
    {
        int x = getRandomNumber(0,3);
        String c = "System replaced the drawn card with it's" + x + "th card";
        swap(cards[current],opponent[x]);
        swapimage(images[current],playerimage[x]);
        Toast.makeText(getApplicationContext(),"System replaced the drawn card with it's" + x + "th card",Toast.LENGTH_SHORT).show();

    }


    public int getRandomNumber(int min, int max){

        Random rand = new Random();
        int x = min + rand.nextInt((max-min)+1);
        return x;

    }



    public void clickOnOpponent0(View view)
    {

        if(cards[current].matches("(.*)9(.*)") || cards[current].matches("(.*)10(.*)"))
        {
            ImageView imageView = (ImageView) findViewById(R.id.img_playera0);
            imageView.setImageResource(opponentimage[0]);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ImageView imageView = (ImageView) findViewById(R.id.img_playera0);
                    imageView.setImageResource(R.drawable.card_backside_2);
                }
            }, 5000);

            ImageView imageView1 = (ImageView) findViewById(R.id.lay_pile_cards);
            imageView1.setImageResource(images[current]);
        }
        computer();
    }

    public void clickOnOpponent0c(View view)
    {
        String t = opponent[0];
        opponent[0] = p;
        p = t;
        Integer ti = opponentimage[0];
        opponentimage[0] = pi;
        pi = ti;
        ImageView imageView = (ImageView) findViewById(R.id.lay_pile_cards);
        imageView.setImageResource(images[current]);
        computer();
    }

    public void clickOnOpponent1(View view)
    {
        if(cards[current]=="clubs9"  || cards[current]=="clubs10" || cards[current]=="hearts10"|| cards[current]=="hearts9"
                || cards[current]=="spades10" || cards[current]=="spades9"|| cards[current]=="diamonds10" || cards[current]=="diamonds9")
        {
            ImageView imageView = (ImageView) findViewById(R.id.img_playera1);
            imageView.setImageResource(opponentimage[1]);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ImageView imageView = (ImageView) findViewById(R.id.img_playera1);
                    imageView.setImageResource(R.drawable.card_backside_2);
                }
            }, 5000);

            ImageView imageView1 = (ImageView) findViewById(R.id.lay_pile_cards);
            imageView1.setImageResource(images[current]);

        }
        computer();
    }

    public void clickOnOpponent1c(View view)
    {

        String t = opponent[1];
        opponent[1] = p;
        p = t;
        Integer ti = opponentimage[1];
        opponentimage[1] = pi;
        pi = ti;
        ImageView imageView = (ImageView) findViewById(R.id.lay_pile_cards);
        imageView.setImageResource(images[current]);
        computer();
    }

    public void clickOnOpponent2(View view)
    {
        if(cards[current]=="clubs9"  || cards[current]=="clubs10" || cards[current]=="hearts10"|| cards[current]=="hearts9"
                || cards[current]=="spades10" || cards[current]=="spades9"|| cards[current]=="diamonds10" || cards[current]=="diamonds9")
        {
            ImageView imageView = (ImageView) findViewById(R.id.img_playera2);
            imageView.setImageResource(opponentimage[2]);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ImageView imageView = (ImageView) findViewById(R.id.img_playera2);
                    imageView.setImageResource(R.drawable.card_backside_2);
                }
            }, 5000);

            ImageView imageView1 = (ImageView) findViewById(R.id.lay_pile_cards);
            imageView1.setImageResource(images[current]);

        }
        computer();

    }

    public void clickOnOpponent2c(View view)
    {
        String t = opponent[2];
        opponent[2] = p;
        p = t;
        Integer ti = opponentimage[2];
        opponentimage[2] = pi;
        pi = ti;
        ImageView imageView = (ImageView) findViewById(R.id.lay_pile_cards);
        imageView.setImageResource(images[current]);
        computer();
    }

    public void clickOnOpponent3(View view)
    {
        if(cards[current]=="clubs9"  || cards[current]=="clubs10" || cards[current]=="hearts10"|| cards[current]=="hearts9"
                || cards[current]=="spades10" || cards[current]=="spades9"|| cards[current]=="diamonds10" || cards[current]=="diamonds9")
        {
            ImageView imageView = (ImageView) findViewById(R.id.img_playera3);
            imageView.setImageResource(opponentimage[3]);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ImageView imageView = (ImageView) findViewById(R.id.img_playera3);
                    imageView.setImageResource(R.drawable.card_backside_2);
                }
            }, 5000);

            ImageView imageView1 = (ImageView) findViewById(R.id.lay_pile_cards);
            imageView1.setImageResource(images[current]);

        }
        computer();
    }

    public void clickOnOpponent3c(View view)
    {
        String t = opponent[3];
        opponent[3] = p;
        p = t;
        Integer ti = opponentimage[3];
        opponentimage[3] = pi;
        pi = ti;
        ImageView imageView = (ImageView) findViewById(R.id.lay_pile_cards);
        imageView.setImageResource(images[current]);
        computer();
    }

    public void clickOnPlayer0(View view)
    {
        if(action==2)//replace
        {
            String t = player[0];
            player[0] = cards[current];
            cards[current] = t;
            Integer ti = playerimage[0];
            playerimage[0] = images[current];
            images[current] = ti;

            ImageView imageView = (ImageView) findViewById(R.id.lay_pile_cards);
            imageView.setImageResource(images[current]);
            computer();
        }
        if(action==3)//no action
        {

            computer();


        }
        if(action==1)
        {
            if(cards[current]=="clubs7"  || cards[current]=="clubs8" || cards[current]=="hearts7"|| cards[current]=="hearts8"
                    || cards[current]=="spades7" || cards[current]=="spades8"|| cards[current]=="diamonds7" || cards[current]=="diamonds8")
            {
                ImageView imageView = (ImageView) findViewById(R.id.img_playerd0);
                imageView.setImageResource(playerimage[0]);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ImageView imageView = (ImageView) findViewById(R.id.img_playerd0);
                        imageView.setImageResource(R.drawable.card_backside_2);
                    }
                }, 5000);
                ImageView imageView1 = (ImageView) findViewById(R.id.lay_pile_cards);
                imageView1.setImageResource(images[current]);

                computer();
            }
            else
            {

                p = player[0];
                pi = playerimage[0];
                Button swapButton1 = (Button) findViewById(R.id.button8);
                swapButton1.setVisibility(View.VISIBLE);
                Button swapButton2 = (Button) findViewById(R.id.button9);
                swapButton2.setVisibility(View.VISIBLE);
                Button swapButton3 = (Button) findViewById(R.id.button10);
                swapButton3.setVisibility(View.VISIBLE);
                Button swapButton4 = (Button) findViewById(R.id.button11);
                swapButton4.setVisibility(View.VISIBLE);
            }

        }
    }

    public void clickOnPlayer1(View view)
    {
        if(action==2)//replace
        {
            String t = player[1];
            player[1] = cards[current];
            cards[current] = t;
            Integer ti = playerimage[1];
            playerimage[1] = images[current];
            images[current] = ti;
            ImageView imageView = (ImageView) findViewById(R.id.lay_pile_cards);
            imageView.setImageResource(images[current]);
            computer();
        }
        else if(action==3)//no action
        {
            computer();

        }
        else
        {
            if(cards[current]=="clubs7"  || cards[current]=="clubs8" || cards[current]=="hearts7"|| cards[current]=="hearts8"
                    || cards[current]=="spades7" || cards[current]=="spades8"|| cards[current]=="diamonds7" || cards[current]=="diamonds8")
            {
                ImageView imageView = (ImageView) findViewById(R.id.img_playerd1);
                imageView.setImageResource(playerimage[1]);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ImageView imageView = (ImageView) findViewById(R.id.img_playerd1);
                        imageView.setImageResource(R.drawable.card_backside_2);
                    }
                }, 5000);
                ImageView imageView1 = (ImageView) findViewById(R.id.lay_pile_cards);
                imageView1.setImageResource(images[current]);
                computer();

            }
            else
            {

                p = player[1];
                pi = playerimage[1];
                Button swapButton1 = (Button) findViewById(R.id.button8);
                swapButton1.setVisibility(View.VISIBLE);
                Button swapButton2 = (Button) findViewById(R.id.button9);
                swapButton2.setVisibility(View.VISIBLE);
                Button swapButton3 = (Button) findViewById(R.id.button10);
                swapButton3.setVisibility(View.VISIBLE);
                Button swapButton4 = (Button) findViewById(R.id.button11);
                swapButton4.setVisibility(View.VISIBLE);
            }

        }
    }

    public void clickOnPlayer2(View view)
    {
        if(action==2)//replace
        {
            String t = player[2];
            player[2] = cards[current];
            cards[current] = t;
            Integer ti = playerimage[2];
            playerimage[2] = images[current];
            images[current] = ti;
            ImageView imageView = (ImageView) findViewById(R.id.lay_pile_cards);
            imageView.setImageResource(images[current]);
            computer();
        }
        else if(action==3)//no action
        {
            computer();

        }
        else
        {
            if(cards[current]=="clubs7"  || cards[current]=="clubs8" || cards[current]=="hearts7"|| cards[current]=="hearts8"
                    || cards[current]=="spades7" || cards[current]=="spades8"|| cards[current]=="diamonds7" || cards[current]=="diamonds8")
            {
                ImageView imageView = (ImageView) findViewById(R.id.img_playerd2);
                imageView.setImageResource(playerimage[2]);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ImageView imageView = (ImageView) findViewById(R.id.img_playerd2);
                        imageView.setImageResource(R.drawable.card_backside_2);
                    }
                }, 5000);
                ImageView imageView1 = (ImageView) findViewById(R.id.lay_pile_cards);
                imageView1.setImageResource(images[current]);
                computer();
            }
            else
            {
                p = player[2];
                pi = playerimage[2];
                Button swapButton1 = (Button) findViewById(R.id.button8);
                swapButton1.setVisibility(View.VISIBLE);
                Button swapButton2 = (Button) findViewById(R.id.button9);
                swapButton2.setVisibility(View.VISIBLE);
                Button swapButton3 = (Button) findViewById(R.id.button10);
                swapButton3.setVisibility(View.VISIBLE);
                Button swapButton4 = (Button) findViewById(R.id.button11);
                swapButton4.setVisibility(View.VISIBLE);
            }

        }
    }


    public void clickOnPlayer3(View view)
    {
        if(action==2)//replace
        {
            String t = player[3];
            player[3] = cards[current];
            cards[current] = t;
            Integer ti = playerimage[3];
            playerimage[3] = images[current];
            images[current] = ti;
            computer();
            ImageView imageView = (ImageView) findViewById(R.id.lay_pile_cards);
            imageView.setImageResource(images[current]);

        }
        else if(action==3)//no action
        {

            computer();
        }
        else
        {
            if(cards[current]=="clubs7"  || cards[current]=="clubs8" || cards[current]=="hearts7"|| cards[current]=="hearts8"
                    || cards[current]=="spades7" || cards[current]=="spades8"|| cards[current]=="diamonds7" || cards[current]=="diamonds8")
            {
                ImageView imageView = (ImageView) findViewById(R.id.img_playerd3);
                imageView.setImageResource(playerimage[3]);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ImageView imageView = (ImageView) findViewById(R.id.img_playerd3);
                        imageView.setImageResource(R.drawable.card_backside_2);
                    }
                }, 5000);
                computer();
                ImageView imageView1 = (ImageView) findViewById(R.id.lay_pile_cards);
                imageView1.setImageResource(images[current]);
            }
            else
            {

                p = player[3];
                pi = playerimage[3];
                Button swapButton1 = (Button) findViewById(R.id.button8);
                swapButton1.setVisibility(View.VISIBLE);
                Button swapButton2 = (Button) findViewById(R.id.button9);
                swapButton2.setVisibility(View.VISIBLE);
                Button swapButton3 = (Button) findViewById(R.id.button10);
                swapButton3.setVisibility(View.VISIBLE);
                Button swapButton4 = (Button) findViewById(R.id.button11);
                swapButton4.setVisibility(View.VISIBLE);
            }

        }
    }

    public int calculate()
    {
        int playersum =0;
        int oppsum = 0;
        for(int i=0;i<4;i++)
        {
            if(player[i].matches("(.*)7(.*)"))
                playersum=playersum+7;
            else if(player[i].matches("(.*)ace(.*)"))
                playersum=playersum+1;
            else if(player[i].matches("(.*)2(.*)"))
                playersum=playersum+2;
            else if(player[i].matches("(.*)3(.*)"))
                playersum=playersum+3;
            else if(player[i].matches("(.*)4(.*)"))
                playersum=playersum+4;
            else if(player[i].matches("(.*)5(.*)"))
                playersum=playersum+5;
            else if(player[i].matches("(.*)6(.*)"))
                playersum=playersum+6;
            else if(player[i].matches("(.*)8(.*)"))
                playersum=playersum+8;
            else if(player[i].matches("(.*)9(.*)"))
                playersum=playersum+9;
            else if(player[i].matches("(.*)king(.*)"))
                playersum=playersum+0;
            else
                playersum=playersum+10;

        }
        for(int i=0;i<4;i++)
        {
            if(opponent[i].matches("(.*)7(.*)"))
                oppsum=oppsum+7;
            else if(opponent[i].matches("(.*)ace(.*)"))
                oppsum=oppsum+1;
            else if(opponent[i].matches("(.*)2(.*)"))
                oppsum=oppsum+2;
            else if(opponent[i].matches("(.*)3(.*)"))
                oppsum=oppsum+3;
            else if(opponent[i].matches("(.*)4(.*)"))
                oppsum=oppsum+4;
            else if(opponent[i].matches("(.*)5(.*)"))
                oppsum=oppsum+5;
            else if(opponent[i].matches("(.*)6(.*)"))
                oppsum=oppsum+6;
            else if(opponent[i].matches("(.*)8(.*)"))
                oppsum=oppsum+8;
            else if(opponent[i].matches("(.*)9(.*)"))
                oppsum=oppsum+9;
            else if(opponent[i].matches("(.*)king(.*)"))
                oppsum=oppsum+0;
            else
                oppsum=oppsum+10;

        }

        if(oppsum > playersum)
            return 0;
        else
            return 1;
    }


    public void end(View view)
    {
        if(calculate()==1)
        {
            Intent i = new Intent(this, PlayerWinActivity.class);
            startActivity(i);
        }
        else
        {
            Intent i = new Intent(this, ComputerWinActivity.class);
            startActivity(i);

        }
    }

    public void KABOOM(final View view)
    {

        ImageView imageView = (ImageView) findViewById(R.id.img_playerd3);
        imageView.setImageResource(playerimage[3]);
        ImageView imageView1 = (ImageView) findViewById(R.id.img_playerd2);
        imageView1.setImageResource(playerimage[2]);
        ImageView imageView2 = (ImageView) findViewById(R.id.img_playerd1);
        imageView2.setImageResource(playerimage[1]);
        ImageView imageView3 = (ImageView) findViewById(R.id.img_playerd0);
        imageView3.setImageResource(playerimage[0]);

        ImageView imageView4 = (ImageView) findViewById(R.id.img_playera3);
        imageView4.setImageResource(opponentimage[3]);
        ImageView imageView5 = (ImageView) findViewById(R.id.img_playera2);
        imageView5.setImageResource(opponentimage[2]);
        ImageView imageView6 = (ImageView) findViewById(R.id.img_playera1);
        imageView6.setImageResource(opponentimage[1]);
        ImageView imageView7 = (ImageView) findViewById(R.id.img_playera0);
        imageView7.setImageResource(opponentimage[0]);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                end(view);
            }
        }, 5000);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Button swapButton1 = (Button) findViewById(R.id.button8);
        swapButton1.setVisibility(View.GONE);
        Button swapButton2 = (Button) findViewById(R.id.button9);
        swapButton2.setVisibility(View.GONE);
        Button swapButton3 = (Button) findViewById(R.id.button10);
        swapButton3.setVisibility(View.GONE);
        Button swapButton4 = (Button) findViewById(R.id.button11);
        swapButton4.setVisibility(View.GONE);

    }
}
