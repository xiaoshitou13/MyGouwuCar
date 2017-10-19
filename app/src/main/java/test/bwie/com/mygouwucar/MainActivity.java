package test.bwie.com.mygouwucar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import Bean.Users;
import Myadater.EeAdater;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    ExpandableListView mExpandedMenu;

    CheckBox checkBox;
    private List<Users.DataBean> userses = new ArrayList<>();
    private ArrayList<List<Users.DataBean>> eruser = new ArrayList<>();
    private EeAdater eeAdater;
    private TextView t1;
    private Button t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.tv);
        //ButterKnife.bind(this);
        checkBox = (CheckBox) findViewById(R.id.cb);
        t2= (Button) findViewById(R.id.button);
        mExpandedMenu  = (ExpandableListView) findViewById(R.id.expanded_menu);
        InitData();

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()){
                    eeAdater.Quan();
                    eeAdater.notifyDataSetChanged();
                }else{
                     eeAdater.Fanquan();

                    eeAdater.notifyDataSetChanged();
                }
            }
        });
    }
    public  void Boo(boolean b){

        if(b){
            checkBox.setChecked(true);
        }else{
            checkBox.setChecked(false);
        }
    }
    /**
     *  初始化数据
     */
    private void InitData() {

        String url = "http://result.eolinker.com/iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=evaluation";

        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
               Users u =  new Gson().fromJson(result,Users.class);
               userses.addAll(u.getData());
                eeAdater = new EeAdater(MainActivity.this,userses,MainActivity.this);
               mExpandedMenu.setAdapter(eeAdater);
                eeAdater.setJiekous(new EeAdater.jiekou() {
                    @Override
                    public void Sum(int num, int price) {
                        t1.setText("共"+num+"件商品~");
                        t2.setText(""+price+"元");
                    }
                });
            }


            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
