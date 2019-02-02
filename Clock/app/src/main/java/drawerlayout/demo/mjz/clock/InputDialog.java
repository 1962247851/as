package drawerlayout.demo.mjz.clock;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InputDialog extends Dialog implements View.OnClickListener {
    private EditText mEt;
    private Button mBtn;
    private IOnClickLitener miOnClickLitstener;
    private TextView mTvTitle;

    public InputDialog(@NonNull Context context) {
        super(context);
    }

    public InputDialog setClick(IOnClickLitener iOnClickLitener) {
        this.miOnClickLitstener = iOnClickLitener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_dialog);
        mEt = findViewById(R.id.dialog_edit_input);
        mBtn = findViewById(R.id.dialog_btn_queding);
        mBtn.setOnClickListener(this);
        mTvTitle = findViewById(R.id.dialog_title);
    }

    public String getString() {
        String string = mEt.getText().toString();
        if (string.equals("")) {
            Toast.makeText(getContext(), "请输入", Toast.LENGTH_SHORT).show();
        }
        return string;
    }

    @Override
    public void onClick(View v) {
        miOnClickLitstener.onClick(this);
    }


    public interface IOnClickLitener {
        void onClick(InputDialog inputDialog);
    }
}