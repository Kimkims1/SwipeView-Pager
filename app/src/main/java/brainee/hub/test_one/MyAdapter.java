package brainee.hub.test_one;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public
class MyAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<MyModel> arrayList;

    public MyAdapter(Context context, ArrayList<MyModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //inflate layout for the cards

        View view = LayoutInflater.from(context).inflate(R.layout.card_item, container, false);

        //Initialise views
        ImageView imageViewIv = view.findViewById(R.id.imageView);
        TextView titleTv = view.findViewById(R.id.title);
        TextView descTv = view.findViewById(R.id.desc);
        TextView dateTv = view.findViewById(R.id.date);

        //get data
        MyModel model = arrayList.get(position);

        final String title = model.getTitle();
        final String desc = model.getDesc();
        final String date = model.getDate();
        int image = model.getImage();

        //Set data to respective uis
        titleTv.setText(title);
        descTv.setText(desc);
        dateTv.setText(date);
        imageViewIv.setImageResource(image);

        //Handle card clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, title + "\n" + desc + "\n" + date, Toast.LENGTH_LONG).show();
            }
        });

        //Add view to container
        container.addView(view,position);

        return view;
    }
}
