package win.yuanhongbao.slidingmenudemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity {

    private SlidingMenu menu;
    private Button mMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMenuBtn = (Button) findViewById(R.id.btn_menu);
        mMenuBtn.setText("打开");
        mMenuBtn.setBackgroundColor(Color.GREEN);

        menu = new SlidingMenu(MainActivity.this);//创建SlidingMenu对象

        //设置侧滑栏的位置
        menu.setMode(SlidingMenu.LEFT);
        //设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        //根据资源文件ID来设置滑动菜单的阴影效果
        menu.setShadowDrawable(R.drawable.shadow);
        //设置滑动菜单式图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        //设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        //把滑动菜单添加进所有的Activity中
        menu.attachToActivity(MainActivity.this, SlidingMenu.SLIDING_CONTENT);
        //为滑动菜单设置布局
        menu.setMenu(R.layout.leftmenu);

        menu.setOnOpenListener(new SlidingMenu.OnOpenListener() {
            @Override
            public void onOpen() {
                mMenuBtn.setText("关闭");
                mMenuBtn.setBackgroundColor(Color.YELLOW);
                Toast.makeText(MainActivity.this, "打开了！", Toast.LENGTH_SHORT).show();
            }
        });
        menu.setOnCloseListener(new SlidingMenu.OnCloseListener() {
            @Override
            public void onClose() {
                mMenuBtn.setText("打开");
                mMenuBtn.setBackgroundColor(Color.GREEN);
                Toast.makeText(MainActivity.this, "关上了！", Toast.LENGTH_SHORT).show();
            }
        });

        mMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle();
            }
        });
    }


}
