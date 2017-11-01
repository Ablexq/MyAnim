package example.com.myanim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;


/**
 * 补间动画
 * <p>
 * public class AnimationSet extends Animation {...}
 * <p>
 * public class TranslateAnimation extends Animation {...}
 * <p>
 * public class AlphaAnimation extends Animation {...}
 * <p>
 * public class RotateAnimation extends Animation {...}
 * <p>
 * public class ScaleAnimation extends Animation {...}
 */


public class TweenAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private Button alpha_xml;
    private Button scale_xml;
    private Button translate_xml;
    private Button rotate_xml;
    private Button set_xml;

    private Button alpha;
    private Button scale;
    private Button translate;
    private Button rotate;
    private Button set;

    private ImageView mIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tween_layout);

        findViews();
        setListener();
    }

    private void findViews() {
        alpha_xml = ((Button) this.findViewById(R.id.alpha_xml));
        scale_xml = ((Button) this.findViewById(R.id.scale_xml));
        translate_xml = ((Button) this.findViewById(R.id.translate_xml));
        rotate_xml = ((Button) this.findViewById(R.id.rotate_xml));
        set_xml = ((Button) this.findViewById(R.id.set_xml));

        alpha = ((Button) this.findViewById(R.id.alpha));
        scale = ((Button) this.findViewById(R.id.scale));
        translate = ((Button) this.findViewById(R.id.translate));
        rotate = ((Button) this.findViewById(R.id.rotate));
        set = ((Button) this.findViewById(R.id.set));

        mIv = ((ImageView) this.findViewById(R.id.tween_iv));
    }

    private void setListener() {
        alpha_xml.setOnClickListener(this);
        rotate_xml.setOnClickListener(this);
        translate_xml.setOnClickListener(this);
        scale_xml.setOnClickListener(this);
        set_xml.setOnClickListener(this);

        alpha.setOnClickListener(this);
        rotate.setOnClickListener(this);
        translate.setOnClickListener(this);
        scale.setOnClickListener(this);
        set.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Animation animation = null;
        switch (v.getId()) {
            //加载xml中定义的补间动画
            case R.id.alpha_xml:
                animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                break;
            case R.id.scale_xml:
                animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                break;
            case R.id.translate_xml:
                animation = AnimationUtils.loadAnimation(this, R.anim.translate);
                break;
            case R.id.rotate_xml:
                animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                break;
            case R.id.set_xml:
                animation = AnimationUtils.loadAnimation(this, R.anim.set);
                break;

            //加载java代码中定义的补间动画
            case R.id.alpha:
                animation = new AlphaAnimation(0.1f, 0.9f);
                animation.setInterpolator(new AccelerateInterpolator());
                break;
            case R.id.scale://相对自己
                animation = new ScaleAnimation(
                        0.2f, 1.0f,//x
                        0.2f, 1.0f,//y
                        Animation.RELATIVE_TO_SELF, 0.5f,//缩放中心x
                        Animation.RELATIVE_TO_SELF, 0.5f);//缩放中心y
                animation.setInterpolator(new BounceInterpolator());
                break;
            case R.id.translate://相对自己
                animation = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2.0f,//x
                        Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2.0f);//y,2倍
                animation.setInterpolator(new OvershootInterpolator());
                break;
            case R.id.rotate://相对自己
                animation = new RotateAnimation(0f, 120f,//角度变化
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);//旋转中心
                animation.setInterpolator(new LinearInterpolator());
                break;
            case R.id.set://相对自己
                AnimationSet set = new AnimationSet(false);//true代表共享Interpolator，false不共享
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 0.9f);
                alphaAnimation.setInterpolator(new AccelerateInterpolator());

                ScaleAnimation scaleAnimation = new ScaleAnimation(
                        0.2f, 1.0f,//x
                        0.2f, 1.0f,//y
                        Animation.RELATIVE_TO_SELF, 0.5f,//缩放中心x
                        Animation.RELATIVE_TO_SELF, 0.5f);//缩放中心y
                scaleAnimation.setInterpolator(new BounceInterpolator());

                TranslateAnimation translateAnimation = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2.0f,//x
                        Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2.0f);//y,2倍
                translateAnimation.setInterpolator(new OvershootInterpolator());

                RotateAnimation rotateAnimation = new RotateAnimation(0f, 120f,//角度变化
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);//旋转中心
                rotateAnimation.setInterpolator(new LinearInterpolator());

                set.addAnimation(alphaAnimation);
                set.addAnimation(scaleAnimation);
                set.addAnimation(translateAnimation);
                set.addAnimation(rotateAnimation);
                animation = set;
                break;
        }

        if (animation != null) {
            animation.setFillAfter(true);//停滞在最后
            animation.setDuration(3000);//时长
            animation.setAnimationListener(new Animation.AnimationListener() {//监听
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            mIv.startAnimation(animation); //启动动画
        }
    }
}