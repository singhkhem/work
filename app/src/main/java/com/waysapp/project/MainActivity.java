package com.waysapp.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button editTextSearch;
    Button editTextSearchNew;


    LinearLayout linearLayout01;

    ArrayList<String> names;

    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sendNewActivity();
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_dropdown);

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

                Log.d("magic","start");



                //Animation animation = new SlideAnimation(recyclerView, params.height,0);

                // this interpolator only speeds up as it keeps going
                //animation.setInterpolator(new AccelerateInterpolator());
                //animation.setDuration(1000);
                //recyclerView.setAnimation(animation);
                //recyclerView.startAnimation(animation);
                /*

               names.clear();

                names.add("Ramiz");
                names.add("Belal");
                names.add("Azad");
                names.add("Manish");
                names.add("Sunny");
                names.add("Shahid");

               adapter.notifyDataSetChanged();*/


              //int total =   recyclerView.getLayoutManager().getItemCount();
              //Log.d("magic","item:"+total);


               // Animation slideDown = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_down);

                //toggling visibility
               // linearLayout01.setVisibility(View.VISIBLE);

                //adding sliding effect
               // linearLayout01.startAnimation(slideDown);

                //linearLayout01.setVisibility(View.VISIBLE);
                //Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
                //linearLayout01.startAnimation(slide_down);
                expand(recyclerView);


            }
        });

        editTextSearchNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_upnew);
                //linearLayout01.startAnimation(slide_up);

                collapse(recyclerView);
                //linearLayout01.setVisibility(View.GONE);

            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CustomAdapter(names);

        recyclerView.setAdapter(adapter);
        //recyclerView.setBackgroundColor(0xFFAED581);


        //linearLayout01.setBackgroundColor(0xFFAED581);

        //ViewGroup.LayoutParams params=recyclerView.getLayoutParams();
        //params.height=800;
        //recyclerView.setLayoutParams(params);
        ViewGroup.LayoutParams layoutParams = linearLayout01.getLayoutParams();
        layoutParams.height=800;
    }

    public static void expand(final View v) {

        v.measure(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? WindowManager.LayoutParams.WRAP_CONTENT
                        : (int)(targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        //a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        a.setDuration(500);
        a.setInterpolator(new AccelerateInterpolator());
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(interpolatedTime == 1){
                    v.setVisibility(View.GONE);
                }else{
                    v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        //a.setDuration((int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        a.setDuration(500);
        a.setInterpolator(new AccelerateInterpolator());
        v.startAnimation(a);
    }


    public void sendNewActivity(){

        Intent myIntent = new Intent(MainActivity.this, Ac01.class);
       // myIntent.putExtra("key", value); //Optional parameters
        MainActivity.this.startActivity(myIntent);
    }
}
