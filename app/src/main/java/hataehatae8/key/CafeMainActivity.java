package hataehatae8.key;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CafeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_main);

        Button button = (Button) findViewById(R.id.c_menu1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CafeMainActivity.this, CafeMenuActivity.class);
                startActivity(intent);
            }
        });

        // 액션바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
}