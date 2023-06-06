package hataehatae8.key;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class CafeMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_menu);

        // 액션바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // 받아온 데이터를 받을 리스트
        ArrayList<Menu> menuList = new ArrayList<>();

// 데이터 받아오기 : "menuName"이 "아이스아메리카노"인 데이터 가져오기


    }
}