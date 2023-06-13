package hataehatae8.key;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {
    Button btn_cafe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        btn_cafe = (Button) findViewById(R.id.cafe_1);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Main.this, 카페인트로(포장/먹고가기).class);
//                startActivity(intent);
//            }
//        });


        // 액션바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
}