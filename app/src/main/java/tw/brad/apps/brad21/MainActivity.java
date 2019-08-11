package tw.brad.apps.brad21;
//玩viewpager
//有三個按鈕一個viewpager
//每一個都繼承Fragment,我現在要統一去管理他,對我剛開始來說他們沒有不一樣
//所以我會宣告陣列去代表三個統一管理的frgament
//你把這些Frgament去當作listView去處理他,所以需要一個調變器去把資料灌進來
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private Fragment[] fs = new Fragment[3]; //所以我會宣告陣列去代表三個統一管理的frgament
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);

        fs[0] = new P1(); //物件實體化
        fs[1] = new P2();
        fs[2] = new P3();

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager())); //設置調變器(我寫好的類別(得到協助frgetmt經理人))
    }

    //處理調變器給他處理資料灌進去 1.實做要做 2.建構是要做
    private  class MyPagerAdapter extends FragmentStatePagerAdapter{

        public MyPagerAdapter(FragmentManager fm) { //建構式就出現FragentManger了,代表他會做這件事
            super(fm);
        }

        @Override //第幾個你就要傳給我,我只要定義好就好
        public Fragment getItem(int position) { //取得資料的item位置資料
            return fs[position];
        }

        @Override
        public int getCount() { //你裡面有幾組
            return fs.length;
        }
    }
}
