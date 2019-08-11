package tw.brad.apps.brad21;
//玩viewpager
//有三個按鈕一個viewpager
//每一個都繼承Fragment,我現在要統一去管理他,對我剛開始來說他們沒有不一樣
//所以我會宣告陣列去代表三個統一管理的frgament
//你把這些Frgament去當作listView去處理他,所以需要一個調變器去把資料灌進來
//剛剛的調變器已經把fmgr把這個介紹給他認識所以viwepager可以處理
//iphone拉會有一個效果,放手彈回去,我們安卓要做的話就是做第0頁跟第四頁,但你拉不過去達到此效果
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private Fragment[] fs = new Fragment[5]; //所以我會宣告陣列去代表三個統一管理的frgament
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);

        fs[0] = new P0(); //物件實體化
        fs[1] = new P1(); //物件實體化
        fs[2] = new P2();
        fs[3] = new P3();
        fs[4] = new P4(); //物件實體化

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager())); //設置調變器(我寫好的調變器方法(得到協助frgetmt經理人))

        //把0,4頁做出效果,類似iphone
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){//設置一個你換頁觸發的事件(簡單換頁式件人來聽),進行override來處理
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.v("brad","pos =" +position);
                if(position == 0){ //如果postion式0舊第一頁的話
                    viewPager.setCurrentItem(1); //硬把你拉回第一頁
                }else if(position == 4){
                    viewPager.setCurrentItem(3);
                }
            }
        });
        viewPager.setCurrentItem(1); //一開始就設置在第一頁
    }


    //給按鈕設置點擊事件
    public void gotoPage1(View view) {
        viewPager.setCurrentItem(1); //頁面按鈕設置第一頁
    }

    public void gotoPage2(View view) {
        viewPager.setCurrentItem(2); //頁面按鈕設置第二頁
    }

    public void gotoPage3(View view) {
        viewPager.setCurrentItem(3); //頁面按鈕設置第三頁
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
