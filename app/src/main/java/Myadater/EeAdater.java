package Myadater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Bean.Users;
import test.bwie.com.mygouwucar.AmountView;
import test.bwie.com.mygouwucar.MainActivity;
import test.bwie.com.mygouwucar.R;

/**
 * Created by 白玉春 on 2017/10/19.
 */

public class EeAdater extends BaseExpandableListAdapter {
    Context context;
    List<Users.DataBean>  Dp ;
    MainActivity ac;
    private AmountView mAmountView;
    public EeAdater(Context context, List<Users.DataBean> dp, MainActivity ac) {
        this.context = context;
        Dp = dp;
        this.ac = ac;
    }

    @Override
    public int getGroupCount() {
        return Dp.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return Dp.get(i).getDatas().size();
    }

    @Override
    public Object getGroup(int i) {
        return Dp.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return Dp.get(i).getDatas().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {

            view = View.inflate(context, R.layout.yiji,null);
            CheckBox checkBoxis= view.findViewById(R.id.checkbox);
            TextView textView = view.findViewById(R.id.tt);

            textView.setText(Dp.get(i).getTitle());

             checkBoxis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                 @Override
                 public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                     Dp.get(i).setCallCex(b);

                     for (Users.DataBean.DatasBean l :Dp.get(i).getDatas()) {
                         l.setZisCallCex(b);
                     }
                     notifyDataSetChanged();


                     for(int j=0; j < Dp.size();j++){
                         Users.DataBean u = Dp.get(j);
                         if(!u.isCallCex()){
                             ac.Boo(false);
                         } else{
                             ac.Boo(true);
                         }
                     }
                 }
             });

            checkBoxis.setChecked(Dp.get(i).isCallCex());


        return view;
    }


    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.erji,null);
        final CheckBox checkBoxis1= view.findViewById(R.id.checkboxs);
        TextView textView1 = view.findViewById(R.id.tts);
        mAmountView = view. findViewById(R.id.amount_view);
        mAmountView.setGoods_storage(50);
        textView1.setText(Dp.get(i).getDatas().get(i1).getType_name());
        mAmountView.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                Sum(amount);
            }
        });
        checkBoxis1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Dp.get(i).getDatas().get(i1).setZisCallCex(b);

                if(b){
                    for(int j=0;j<Dp.get(i).getDatas().size();j++){
                       if(Dp.get(i).getDatas().get(j).isZisCallCex()){
                           Dp.get(i).getDatas().get(j).setZisCallCex(true);
                           Sum(1);
                       }else{
                           Dp.get(i).getDatas().get(j).setZisCallCex(false);
                           return;
                       }
                    }
                    Dp.get(i).setCallCex(true);

                }else{
                    Dp.get(i).setCallCex(false);
                }
                notifyDataSetChanged();
            }

        });

        checkBoxis1.setChecked(Dp.get(i).getDatas().get(i1).isZisCallCex());
        return view;
    }



    public void Quan(){
        for(int i=0;i<Dp.size();i++){
            Dp.get(i).setCallCex(true);
            Sum(i);
//            Dp.get(i).getDatas().get(i).setZisCallCex(true);
        }
        notifyDataSetChanged();
    }

    public void Fanquan(){
        for(int i=0;i<Dp.size();i++){
            Dp.get(i).setCallCex(false);

            for(int i1=0; i1<Dp.get(i).getDatas().size();i1++){
                Dp.get(i).getDatas().get(i1).setZisCallCex(false);
                Sum(i1);
            }
        }
        notifyDataSetChanged();
    }
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    public interface  jiekou{
        void Sum(int num,int  price);
    }

    private jiekou jiekous;

    public void setJiekous(jiekou jiekous) {
        this.jiekous = jiekous;
    }

    public void Sum(int su){
        int num = 0;
        int price=0;
        List<Users.DataBean> user = Dp;

        for (Users.DataBean u:user
             ) {
            for(Users.DataBean.DatasBean us:u.getDatas()){
                if(us.isZisCallCex()){
                    num ++;
                    price += us.getPrice()*su;

                    jiekous.Sum(num+su,price);
                }
            }
        }
    }
}
