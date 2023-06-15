package hataehatae8.key;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;

public class Cafe_menu extends AppCompatActivity {

    RecyclerView MenuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_menu);

        // 액션바 없애기
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        initialize();

    }

    private void initialize() {
        MenuView = findViewById(R.id.MenuView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        MenuView.setLayoutManager(gridLayoutManager);

    }

}