package brainee.hub.test_one;

import android.content.Context;
import android.view.View;

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
        return false;
    }
}
