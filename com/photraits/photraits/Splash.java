package com.photraits.photraits;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

@SuppressLint({"NewApi"})
public class Splash extends Activity {

    /* renamed from: com.photraits.photraits.Splash.1 */
    class C01661 extends Thread {
        C01661() {
        }

        public void run() {
            try {
                C01661.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Splash.this.startActivity(new Intent(Splash.this, MainActivity.class));
            }
        }
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0165R.layout.activity_splash);
        getActionBar().hide();
        new C01661().start();
    }

    public void onPause() {
        super.onPause();
        finish();
    }
}
