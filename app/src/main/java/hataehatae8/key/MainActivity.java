package hataehatae8.key;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.cafe_1);
        Button button1 = (Button) findViewById(R.id.fast_1);
        Button h_btn = (Button) findViewById(R.id.help);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CafeMainActivity.class);
                startActivity(intent);
            }
        });

        h_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, HelpMainActivity.class);
                startActivity(intent1);
            }
        });

        // 액션바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
}