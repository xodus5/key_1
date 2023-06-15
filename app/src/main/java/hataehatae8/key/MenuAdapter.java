package hataehatae8.key;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuView> {
    @NonNull
    @Override
    public MenuAdapter.MenuView onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cafe_menudetail, viewGroup, false);

        return new MenuView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MenuView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MenuView extends RecyclerView.ViewHolder{
        public MenuView(@NonNull View itemView) {
            super(itemView);
        }

    }
}
