package example.com.myanim.upvote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import example.com.myanim.R;
import example.com.myanim.upvote.PeriscopeLayout;

/**
 * 贝塞尔曲线 + 属性动画
 * 点赞效果:来自http://www.jianshu.com/p/03fdcfd3ae9c
 */

public class UpvoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upvote_layout);

        final PeriscopeLayout periscopeLayout = (PeriscopeLayout) findViewById(R.id.periscope);
        periscopeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                periscopeLayout.addHeart();
            }
        });
    }
}
