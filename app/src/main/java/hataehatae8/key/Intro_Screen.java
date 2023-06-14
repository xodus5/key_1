package hataehatae8.key;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class Intro_Screen extends AppCompatActivity {

    private ViewPager viewPager;
    Button btn_next;
    private int[] images = {R.drawable.intro_1, R.drawable.intro_2, R.drawable.intro_3}; // 이미지 리소스 배열
    private static final long SLIDE_DELAY = 3000; // 이미지 전환 간격 (3초)

    private Handler handler;
    private Runnable runnable;
    private int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        viewPager = findViewById(R.id.viewPager);
        btn_next = (Button) findViewById(R.id.btn_next);

        ImageAdapter imageAdapter = new ImageAdapter();
        viewPager.setAdapter(imageAdapter);


        for (int imageResource : images) {
            imageAdapter.addImage(imageResource);
        }

        handler = new Handler();
        runnable = new Runnable() {
            public void run() {
                if (currentPage == images.length - 1) {
                    currentPage = 0;
                } else {
                    currentPage++;
                }
                viewPager.setCurrentItem(currentPage);
                handler.postDelayed(this, SLIDE_DELAY);
            }
        };

        // 이미지 자동 전환 시작
        handler.postDelayed(runnable, SLIDE_DELAY);

        // 이미지 클릭 시 다음 Activity로 이동
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_Screen.this, Main.class);
                startActivity(intent);
            }
        });


        // 액션바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    private class ImageAdapter extends PagerAdapter {
        private int[] imageResources;

        public ImageAdapter() {
            imageResources = new int[images.length * 2];
            for (int i = 0; i < images.length; i++) {
                imageResources[i] = images[i];
                imageResources[i + images.length] = images[i];
            }
        }

        public void addImage(int imageResource) {
            // 이미지 추가
        }

        @Override
        public int getCount() {
            return imageResources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(Intro_Screen.this);
            imageView.setImageResource(imageResources[position]);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((ImageView) object);
        }

    }
}