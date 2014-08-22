package com.pivotallabs;

import android.content.Intent;
import android.widget.Button;
import ch.qos.logback.classic.util.ContextInitializer;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.robolectric.Robolectric.shadowOf;

@RunWith(RobolectricTestRunner.class)
public class HomeActivityTest {
    private HomeActivity activity;
    private Button pressMeButton;

    @BeforeClass
    public static void beforeClass() {
      // Robolectric somehow prevents logback from grabbing assets,
      // so tell logback to look in a specific location
      System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, "assets/logback.xml");
    }

    @AfterClass
    public static void afterClass() {
      System.clearProperty(ContextInitializer.CONFIG_FILE_PROPERTY);
    }

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(HomeActivity.class).create().visible().get();
        pressMeButton = (Button) activity.findViewById(R.id.press_me_button);
    }

    @Test
    public void pressingTheButtonShouldStartTheListActivity() throws Exception {
        // This calls HomeActivity.onClick(), which invokes an SLF4J log
        // call, causing logback to write to target/logback/.../log.txt
        pressMeButton.performClick();

        ShadowActivity shadowActivity = shadowOf(activity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        assertThat(shadowIntent.getComponent().getClassName(), equalTo(NamesActivity.class.getName()));
    }
}
