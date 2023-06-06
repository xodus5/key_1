package hataehatae8.key;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CafeMainActivity extends AppCompatActivity {

    Button btn_menu1;
    ImageView fingerImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_main);

        fingerImageView = findViewById(R.id.finger1);
        btn_menu1 = findViewById(R.id.c_menu1);

        fingerImageView.post(new Runnable() {
            @Override
            public void run() {
                // finger 초기 위치 설정
                float startX = fingerImageView.getX();
                float startY = fingerImageView.getY();

                // 버튼 1로 finger 이동하는 위치 설정
                float destinationX = btn_menu1.getX() + btn_menu1.getWidth() / 2 - fingerImageView.getWidth() / 5;
                float destinationY = btn_menu1.getY() + btn_menu1.getHeight() / 2 - fingerImageView.getHeight() / 5;

                ObjectAnimator animatorX = ObjectAnimator.ofFloat(fingerImageView, "x", startX, destinationX);
                ObjectAnimator animatorY = ObjectAnimator.ofFloat(fingerImageView, "y", startY, destinationY);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animatorX, animatorY);
                animatorSet.setDuration(1500);
                animatorSet.start();
            }
        });

        btn_menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼을 클릭했을 때
                // 애니메이션 취소하고 finger 숨기기
                fingerImageView.animate().cancel();
                fingerImageView.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(CafeMainActivity.this, CafeMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 액션바 숨기기
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}