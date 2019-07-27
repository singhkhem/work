package com.waysapp.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Ac01 extends AppCompatActivity {

    RecyclerView recyclerView;
    Button editTextSearch;
    Button editTextSearchNew;


    LinearLayout linearLayout01;

    ArrayList<String> names;

    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac01);

        names = new ArrayList<>();

        names.add("Ramiz");
        names.add("Belal");
        names.add("Azad");
        names.add("Manish");
        names.add("Sunny");
        names.add("Sunny");
        names.add("Sunny1");
        names.add("Sunny2");
        names.add("Sunny3");
        names.add("Sunny4");


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        editTextSearch = (Button) findViewById(R.id.editTextSearch);
        editTextSearchNew = (Button) findViewById(R.id.editTextSearchNew);

        linearLayout01 = (LinearLayout) findViewById(R.id.linearLayout2);

        editTextSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //slideToTop(recyclerView);
                expandOrCollapse(recyclerView,"expand");


            }
        });

        editTextSearchNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                expandOrCollapse(recyclerView,"expand12");

            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CustomAdapter(names);

        recyclerView.setAdapter(adapter);
    }



    public void expandOrCollapse(final View v,String exp_or_colpse) {
        TranslateAnimation anim = null;
        if(exp_or_colpse.equals("expand"))
        {
            anim = new TranslateAnimation(0.0f, 0.0f, +v.getHeight(), 0.0f);
            v.setVisibility(View.VISIBLE);
        }
        else{
            anim = new TranslateAnimation(0.0f, 0.0f, 0.0f, +v.getHeight());
            Animation.AnimationListener  collapselistener= new Animation.AnimationListener () {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    v.setVisibility(View.GONE);
                }
            };

            anim.setAnimationListener(collapselistener);
        }

        // To Collapse
        //

        anim.setDuration(300);
        anim.setInterpolator(new AccelerateInterpolator(0.5f));
        v.startAnimation(anim);
    }
}
