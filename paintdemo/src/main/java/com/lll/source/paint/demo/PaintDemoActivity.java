package com.lll.source.paint.demo;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import com.lll.source.paint.demo.matrix.Custom3DViewActivity;
import com.lll.source.paint.demo.path.PathDemoActivity;
import com.lll.source.paint.demo.xfermodes.scratch.ScratchViewDemoActivity;
import com.lll.source.paint.demo.canvas.particle.ParticleActivity;
import com.lll.source.paint.demo.colorfilter.ColorFilterActivity;
import com.lll.source.paint.demo.xfermodes.XfermodesActivity;

import static android.graphics.Paint.STRIKE_THRU_TEXT_FLAG;
import static android.graphics.Paint.UNDERLINE_TEXT_FLAG;

/**
 * Version 1.0
 * Created by lll on 2020/4/13.
 * Description
 * <p>
 * copyright generalray4239@gmail.com
 */
public class PaintDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testLinePaint();
        findViewById(R.id.matrix).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActivity(Custom3DViewActivity.class);
                return true;
            }
        });
    }

    private void testLinePaint() {
        TextView p1 = findViewById(R.id.paint_1);
        p1.setPaintFlags(UNDERLINE_TEXT_FLAG);
        p1.setText("Text_UnderLine");
//        p1.initWidget(PaintUtils.newTextPaint(), "Text_UnderLine");

        TextView p2 = findViewById(R.id.paint_2);
        p2.setPaintFlags(STRIKE_THRU_TEXT_FLAG);
        p2.getPaint().setStrokeCap(Paint.Cap.ROUND);
        p2.getPaint().setStrokeJoin(Paint.Join.MITER);
        p2.setText("Text_delete");
    }

    public void showScratch(View view) {
        startActivity(ScratchViewDemoActivity.class);
    }

    public void showXfermodes(View view) {
        startActivity(XfermodesActivity.class);
    }

    public void showColorFilter(View view) {
        startActivity(ColorFilterActivity.class);
    }


    public void showParticle(View view) {
        startActivity(ParticleActivity.class);
    }

    public void showQQ(View view) {
        startActivity(PathDemoActivity.class);
    }


    private void startActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

}
