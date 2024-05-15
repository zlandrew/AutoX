package org.autojs.autojs.ui.log;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.stardust.autojs.core.console.ConsoleImpl;
import com.stardust.autojs.core.console.ConsoleView;

import org.androidannotations.annotations.Click;
import org.autojs.autojs.autojs.AutoJs;
import org.autojs.autojs.ui.BaseActivity;
import org.autojs.autoxjs.R;

public class LogActivity extends BaseActivity {
    ConsoleView mConsoleView;

    private ConsoleImpl mConsoleImpl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        applyDayNightMode();
    }

    @Override
    protected void initView() {
        mConsoleView = findViewById(R.id.console);
        findViewById(R.id.fab).setOnClickListener(view -> {
            clearConsole();
        });
        setupViews();
    }

    void setupViews() {
        setToolbarAsBack(getString(R.string.text_log));
        mConsoleImpl = AutoJs.getInstance().getGlobalConsole();
        mConsoleView.setConsole(mConsoleImpl);
        mConsoleView.findViewById(R.id.input_container).setVisibility(View.GONE);
    }

    void clearConsole() {
        mConsoleImpl.clear();
    }
}
