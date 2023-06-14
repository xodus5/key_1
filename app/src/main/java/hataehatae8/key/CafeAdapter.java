//package hataehatae8.key;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentActivity;
//import androidx.fragment.app.FragmentManager;
//import androidx.lifecycle.Lifecycle;
//import androidx.viewpager2.adapter.FragmentStateAdapter;
//
//public class CafeAdapter extends FragmentStateAdapter {
//    int mNumOfTabs;
//
//    public CafeAdapter(@NonNull FragmentManager fm, int NumOfTabs) {
//        super(fm, NumOfTabs);
//        this.mNumOfTabs = NumOfTabs;
//    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position){
//            case 0: return new TabFragment();
//            case 1: return new TabFragment2();
//            case 2: return new TabFragment3();
//            default: return null;
//        }
//    }
//
//    @Override
//    public int getCount() {
//        return mNumOfTabs;
//    }
//}