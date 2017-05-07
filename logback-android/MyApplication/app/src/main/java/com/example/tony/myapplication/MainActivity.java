package com.example.tony.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger log = LoggerFactory.getLogger(MainActivity.class);
        log.info("info msg");
        log.debug("debug msg");
        log.warn("warn msg");
        log.error("error msg");
        log.trace("trace msg");
    }
}
