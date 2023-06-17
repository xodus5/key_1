package hataehatae8.key;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.gif.GifBitmapProvider;

import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {
    private ArrayList<MenuData> menuList;
    private Context context;
    LayoutInflater layoutInflater;

    public MenuAdapter(ArrayList<MenuData> menuList, Context context) {
        this.menuList = menuList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(layoutInflater == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view == null) {
            view = layoutInflater.inflate(R.layout.cafe_menu_item,null);
        }
        ImageView gridImage = view.findViewById(R.id.gv_menu);
        TextView gridName = view.findViewById(R.id.gv_name);
        TextView gridPrice = view.findViewById(R.id.gv_name);

        Glide.with(context).load(menuList.get(i).getMenu()).into(gridImage);
        gridName.setText(menuList.get(i).getName());
        gridPrice.setText(menuList.get(i).getPrice());

        return view;
    }
}
