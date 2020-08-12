package brainee.hub.test_one;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //actionbar
    private ActionBar actionBar;

    //UI Views
    private ViewPager viewPager;

    private ArrayList <MyModel> modelArrayList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();

        loadCards();

        //change pageListener
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                String title = modelArrayList.get(position).getTitle();
                actionBar.setTitle(title);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loadCards() {
        modelArrayList = new ArrayList<>();

        //add items to arraylist
        modelArrayList.add(new MyModel(
                "Title 01",
                "This is desc for title 01",
                "12/08/2020",
                R.drawable.fantasy));

        modelArrayList.add(new MyModel(
                "Title 02",
                "This is desc for title 02",
                "12/08/2020",
                R.drawable.logo));

        modelArrayList.add(new MyModel(
                "Title 03",
                "This is desc for title 03",
                "12/08/2020",
                R.drawable.book_four));

        //set up adapter
        myAdapter = new MyAdapter(this,modelArrayList);

        viewPager.setAdapter(myAdapter);

        //set default padding
        viewPager.setPadding(100,0,100,0);
    }
}