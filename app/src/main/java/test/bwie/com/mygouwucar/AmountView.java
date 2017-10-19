package test.bwie.com.mygouwucar;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by 白玉春 on 2017/10/19.
 */

public class AmountView extends LinearLayout implements View.OnClickListener ,TextWatcher{

    private EditText etAmount;
    private Button left;
    private Button right;
    private int amount = 1; //购买数量
    private int goods_storage = 1; //商品库存
    private OnAmountChangeListener mListener;
    public AmountView(Context context) {
        super(context);
    }

    public AmountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_amount,this);
        etAmount = findViewById(R.id.etAmount);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        etAmount.setOnClickListener(this);

        TypedArray t = context.obtainStyledAttributes(attrs,R.styleable.AmountView);
        int btnwidht = t.getDimensionPixelSize(R.styleable.AmountView_btnWidth,80);
        int tvwidht = t.getDimensionPixelSize(R.styleable.AmountView_tvWidth,50);
        int tvtextsize =t.getDimensionPixelSize(R.styleable.AmountView_tvTextSize,0);
        int btnTextsize = t.getDimensionPixelSize(R.styleable.AmountView_btnTextSize,0);

        t.recycle();

        LayoutParams layoutParams = new LayoutParams(btnwidht, ViewGroup.LayoutParams.MATCH_PARENT);
        left.setLayoutParams(layoutParams);
        right.setLayoutParams(layoutParams);
        if(btnTextsize!=0){
            left.setTextSize(TypedValue.COMPLEX_UNIT_PX,btnTextsize);
            right.setTextSize(TypedValue.COMPLEX_UNIT_PX,btnTextsize);
        }

        LayoutParams layoutParams1 = new LayoutParams(tvtextsize, ViewGroup.LayoutParams.MATCH_PARENT);
        etAmount.setLayoutParams(layoutParams1);
        if(tvtextsize!=0){
            etAmount.setTextSize(tvtextsize);
        }

    }

    public void setOnAmountChangeListener(OnAmountChangeListener onAmountChangeListener) {
        this.mListener = onAmountChangeListener;
    }

    public void setGoods_storage(int goods_storage) {
        this.goods_storage = goods_storage;
    }

    @Override
    public void onClick(View view) {
        int i  =view.getId();
        if(i==R.id.left){
            if(amount >1){
                amount--;
                etAmount.setText(amount+"");
            }
        }else if(i == R.id.right){
            if(amount<goods_storage){
                amount++;
                etAmount.setText(amount+"");
            }
        }

        etAmount.clearFocus();
        if (mListener != null) {
            mListener.onAmountChange(this, amount);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.toString().isEmpty())
            return;
        amount = Integer.valueOf(s.toString());
        if (amount > goods_storage) {
            etAmount.setText(goods_storage + "");
            return;
        }

        if (mListener != null) {
            mListener.onAmountChange(this, amount);
        }
    }


    public interface OnAmountChangeListener {
        void onAmountChange(View view, int amount);
    }
}
