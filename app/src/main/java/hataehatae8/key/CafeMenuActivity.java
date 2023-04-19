package hataehatae8.key;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CafeMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_menu);

        // 액션바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
}