package com.eduonix.app;

import android.annotation.SuppressLint;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.fest.assertions.api.ANDROID.assertThat;



@Config(manifest = "src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class EduonixActivityTest {

    private EduonixActivity activity;


    @Before
    public void setup() {
        activity = Robolectric.buildActivity(EduonixActivity.class).create().start().get();
    }


    @Test
    @SuppressLint("NewApi")
    public void shouldFail() {
        assertThat(activity).isNotNull();


    }

}
