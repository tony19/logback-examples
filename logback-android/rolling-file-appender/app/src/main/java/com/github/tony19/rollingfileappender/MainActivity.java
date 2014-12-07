package com.github.tony19.rollingfileappender;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import ch.qos.logback.core.status.OnConsoleStatusListener;
import ch.qos.logback.core.util.StatusPrinter;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * This activity demonstrates time-based rollover by the RollingFileAppender,
 * using logback-android's code-based configuration to write logs to
 * /sdcard/logback/ at startup.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureLogback();
        writeLogs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Writes dummy logs to demonstrate the file rollover in RollingFileAppender.
     * Files are written to /sdcard/logback/.
     */
    private void writeLogs() {
        Logger log = LoggerFactory.getLogger(this.getLocalClassName());
        final String TAG = getLocalClassName();

        final int MAX_TIME_MS = 10000;
        final int SLEEP_TIME_MS = 300;

        Log.d(TAG, "starting count");
        for (int i =0; i < MAX_TIME_MS / SLEEP_TIME_MS; i++) {

            Log.d(TAG, "logging index via logback-android");
            log.info("" + i);

            try {
                Log.v(TAG, "sleeping...");
                Thread.sleep(SLEEP_TIME_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

        Log.d(TAG, "done");
    }

    /**
     * Configures logback-android RollingFileAppender to rollover if
     * a log event occurs after the second-boundary.
     */
    private void configureLogback() {
        // reset the default context (which may already have been initialized)
        // since we want to reconfigure it
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        context.reset();

        // Enable debugging to show rollover status
        OnConsoleStatusListener.addNewInstanceToContext(context);

        final String LOG_DIR = "/sdcard/logback";

        RollingFileAppender<ILoggingEvent> rollingFileAppender = new RollingFileAppender<ILoggingEvent>();
        rollingFileAppender.setAppend(true);
        rollingFileAppender.setContext(context);

        // OPTIONAL: Set an active log file (separate from the rollover files).
        // If rollingPolicy.fileNamePattern already set, you don't need this.
        rollingFileAppender.setFile(LOG_DIR + "/log.txt");

        // Set the periodicity to seconds. That is, if a log event occurs after the
        // second-boundary, the log file will rollover.
        final String PERIODICITY = "yyyy-MM-dd_HH-mm-ss";

        TimeBasedRollingPolicy<ILoggingEvent> rollingPolicy = new TimeBasedRollingPolicy<ILoggingEvent>();
        rollingPolicy.setFileNamePattern(LOG_DIR + "/log.%d{"+ PERIODICITY +"}.txt");
        rollingPolicy.setMaxHistory(5); // no more than 5 rollover files (delete oldest)
        rollingPolicy.setParent(rollingFileAppender);  // parent and context required!
        rollingPolicy.setContext(context);
        rollingPolicy.start();

        rollingFileAppender.setRollingPolicy(rollingPolicy);

        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setPattern("%logger{35} - %msg%n");
        encoder.setContext(context);
        encoder.start();

        rollingFileAppender.setEncoder(encoder);
        rollingFileAppender.start();

        // add the newly created appenders to the root logger;
        // qualify Logger to disambiguate from org.slf4j.Logger
        ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.TRACE);
        root.addAppender(rollingFileAppender);
    }
}
