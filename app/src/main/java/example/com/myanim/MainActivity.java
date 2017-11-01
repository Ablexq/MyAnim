package example.com.myanim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import example.com.myanim.drag.DragActivity;
import example.com.myanim.upvote.UpvoteActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListener();
    }

    private void setListener() {
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
        mBtn5.setOnClickListener(this);
    }

    private void findViews() {
        mBtn1 = ((Button) this.findViewById(R.id.btn1));
        mBtn2 = ((Button) this.findViewById(R.id.btn2));
        mBtn3 = ((Button) this.findViewById(R.id.btn3));
        mBtn4 = ((Button) this.findViewById(R.id.btn4));
        mBtn5 = ((Button) this.findViewById(R.id.btn5));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                startActivity(new Intent(MainActivity.this, FrameAnimActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(MainActivity.this, TweenAnimActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(MainActivity.this, PropertyAnimActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(MainActivity.this, UpvoteActivity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(MainActivity.this, DragActivity.class));
                break;
        }
    }
}
