package hataehatae8.key;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import hataehatae8.key.Main;

public class Intro_Screen extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] images = {R.drawable.intro_1, R.drawable.intro_2, R.drawable.intro_3};
    private static final long SLIDE_DELAY = 3000;

    private int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        viewPager = findViewById(R.id.viewPager);
        ImageAdapter imageAdapter = new ImageAdapter();
        viewPager.setAdapter(imageAdapter);

        for (int imageResource : images) {
            imageAdapter.addImage(imageResource);
        }

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        // 이미지 클릭 시 다음 Activity로 이동
        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPage == images.length - 1) {
                    // 마지막 페이지에서 클릭하면 Main 액티비티로 이동
                    Intent intent = new Intent(Intro_Screen.this, Main.class);
                    startActivity(intent);
                } else {
                    // 다음 페이지로 넘어감
                    viewPager.setCurrentItem(currentPage + 1);
                }
            }
        });

        // 이미지 자동 전환 시작
        startSlideShow();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopSlideShow();
    }

    private void startSlideShow() {
        viewPager.postDelayed(slideRunnable, SLIDE_DELAY);
    }

    private void stopSlideShow() {
        viewPager.removeCallbacks(slideRunnable);
    }

    private Runnable slideRunnable = new Runnable() {
        @Override
        public void run() {
            if (currentPage == images.length - 1) {
                // 마지막 페이지일 경우 처음 페이지로 돌아감
                viewPager.setCurrentItem(0);
            } else {
                // 다음 페이지로 넘어감
                viewPager.setCurrentItem(currentPage + 1);
            }
            startSlideShow();
        }
    };

    private class ImageAdapter extends androidx.viewpager.widget.PagerAdapter {
        private int[] imageResources;

        public ImageAdapter() {
            imageResources = new int[images.length];
        }

        public void addImage(int imageResource) {
            imageResources[currentPage] = imageResource;
            notifyDataSetChanged();
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