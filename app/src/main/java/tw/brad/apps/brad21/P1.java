package tw.brad.apps.brad21;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;


public class P1 extends Fragment {
    private View mainView;
    private Context context;
    private ViewFlipper viewFlipper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //叫出f1畫面
        if (mainView == null){
            mainView = inflater.inflate(R.layout.fragment_p1, container, false);
            viewFlipper = mainView.findViewById(R.id.viewFlipper);

            View f1 = viewFlipper.getChildAt(0); //抓到viewFlipper裡面的兒子元素(0位置)
            View f2 = viewFlipper.getChildAt(1);
            View f3 = viewFlipper.getChildAt(2);
            FlipperListener flipperListener = new FlipperListener();
            f1.setOnClickListener(flipperListener); //按鈕點擊觸發事件
            f2.setOnClickListener(flipperListener);
            f3.setOnClickListener(flipperListener);

        }
        return mainView;
    }


    private class FlipperListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            viewFlipper.showNext();
        }
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}