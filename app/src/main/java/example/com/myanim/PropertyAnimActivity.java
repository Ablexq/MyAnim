package example.com.myanim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


/**
 * 属性动画:android3.0添加
 * <p>
 * public final class ObjectAnimator extends ValueAnimator {...}
 * <p>
 * public class ValueAnimator extends Animator {...}
 * <p>
 * public final class AnimatorSet extends Animator {...}
 */


public class PropertyAnimActivity extends AppCompatActivity implements View.OnClickListener {

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
    private Button simple_set;

    private ImageView mIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_layout);

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
        simple_set = ((Button) this.findViewById(R.id.simple_set));

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
        simple_set.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /**-----------------------------------加载xml中定义的属性动画--------------------------------------**/
            case R.id.alpha_xml:
                Animator alpha_xml = AnimatorInflater.loadAnimator(this, R.animator.alpha_property_xml);
                alpha_xml.setTarget(mIv);
                alpha_xml.start();
                break;
            case R.id.scale_xml:
                Animator scale_xml = AnimatorInflater.loadAnimator(this, R.animator.scale_property_xml);
                scale_xml.setTarget(mIv);
                scale_xml.start();
                break;
            case R.id.translate_xml:
                Animator translate_xml = AnimatorInflater.loadAnimator(this, R.animator.translate_property_xml);
                translate_xml.setTarget(mIv);
                translate_xml.start();
                break;
            case R.id.rotate_xml:
                Animator rotate_xml = AnimatorInflater.loadAnimator(this, R.animator.rotate_property_xml);
                rotate_xml.setTarget(mIv);
                rotate_xml.start();
                break;
            case R.id.set_xml:
                Animator set_xml = AnimatorInflater.loadAnimator(this, R.animator.set_property_xml);
                set_xml.setTarget(mIv);
                set_xml.start();
                break;

            /**-----------------------------------加载java代码中定义的属性动画--------------------------------------**/
            //------------------View类中定义的属性动画属性名-------------------------------
            //alpha   View.ALPHA

            //translationX    View.TRANSLATION_X
            //translationY    View.TRANSLATION_Y
            //translationZ    View.TRANSLATION_Z

            //x   View.X
            //y   View.Y
            //z   View.Z

            //rotation    View.ROTATION
            //rotationX   View.ROTATION_X
            //rotationY   View.ROTATION_Y

            //scaleX  View.SCALE_X
            //scaleY  View.SCALE_Y
            //---------------------自定义属性需要设置set、get方法-------------------------

            case R.id.alpha:
                ObjectAnimator alpha = ObjectAnimator.ofFloat(mIv, View.ALPHA, 1f, 0f, 1f);
                alpha.setDuration(3000);
                alpha.start();
                break;
            case R.id.scale:
                ObjectAnimator scale_x = ObjectAnimator.ofFloat(mIv, View.SCALE_X, 1f, 0.2f, 1.2f);
                scale_x.setDuration(3000);
                scale_x.start();
                break;
            case R.id.translate:
                ObjectAnimator translate = ObjectAnimator.ofFloat(mIv, View.TRANSLATION_X, -500f, 0f);
                translate.setDuration(3000);
                translate.start();
                break;
            case R.id.rotate:
                ObjectAnimator rotate = ObjectAnimator.ofFloat(mIv, View.ROTATION, 0f, 360f);
                rotate.setDuration(3000);
                rotate.start();
                break;
            case R.id.set://可设置顺序
                ObjectAnimator moveIn1 = ObjectAnimator.ofFloat(mIv, View.TRANSLATION_X, -500f, 0f);
                ObjectAnimator rotate1 = ObjectAnimator.ofFloat(mIv, View.ROTATION, 0f, 360f);
                ObjectAnimator fadeInOut1 = ObjectAnimator.ofFloat(mIv, View.ALPHA, 1f, 0f, 1f);
                AnimatorSet animSet = new AnimatorSet();
                animSet.play(rotate1).with(fadeInOut1).after(moveIn1);
                animSet.setDuration(5000);
                animSet.start();
                break;

            /**-----------------------------------Android 3.1新增ViewPropertyAnimator--------------------------------------**/
            case R.id.simple_set://同时执行,不可设置顺序
                mIv.animate()
                        .setDuration(2000)
                        .translationX(300)
                        .rotation(360)
                        .alpha(0.5f)
                        .start();
                break;
        }
    }
}





