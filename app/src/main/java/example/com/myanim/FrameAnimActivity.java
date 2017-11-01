package example.com.myanim;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 帧动画
 */

public class FrameAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start;
    private Button stop;
    private ImageView animIv;
    private AnimationDrawable animDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);

        findViews();
        setListener();
    }

    private void setListener() {
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    private void findViews() {
        animIv = ((ImageView) this.findViewById(R.id.frame_iv));
        //获取动画的AnimationDrawable
        animDrawable = ((AnimationDrawable) animIv.getDrawable());

        start = ((Button) this.findViewById(R.id.start));
        stop = ((Button) this.findViewById(R.id.stop));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                //启动动画
                animDrawable.start();
                break;
            case R.id.stop:
                if (animDrawable != null && animDrawable.isRunning()) {
                    //停止动画
                    animDrawable.stop();
                }
                break;
        }
    }
}
