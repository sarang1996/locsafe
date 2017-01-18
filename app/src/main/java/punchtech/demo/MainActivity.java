package punchtech.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    int SIGN_IN_REQUEST_CODE = 1;
    protected boolean _active = true;
    protected int _splashTime = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);

        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(100);
                        if (_active) {
                            waited += 100;
                        }
                    }
                } catch (Exception ignored) {

                } finally {

                    if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                        // Start sign in/sign up activity
                        startActivityForResult(
                                AuthUI.getInstance()
                                        .createSignInIntentBuilder()
                                        .build(),
                                SIGN_IN_REQUEST_CODE
                        );
                    } else {
                        startActivity(new Intent(MainActivity.this, main_class.class));
                    }

                }
            }
        };
        splashTread.start();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGN_IN_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this,
                        "Successfully signed in. Welcome!",
                        Toast.LENGTH_LONG)
                        .show();
                Map<String, Object> params = new HashMap<>();
                params.put("name", FirebaseAuth.getInstance()
                        .getCurrentUser()
                        .getDisplayName());
                params.put("id", FirebaseAuth.getInstance()
                        .getCurrentUser()
                        .getUid());
                params.put("email", FirebaseAuth.getInstance()
                        .getCurrentUser()
                        .getEmail());
                params.put("lat", "23.30");
                params.put("long", "72.64");
                FirebaseDatabase.getInstance()
                        .getReference().child("user")
                        .push()
                        .setValue(params);
            } else {
                Toast.makeText(this,
                        "We couldn't sign you in. Please try again later.",
                        Toast.LENGTH_LONG)
                        .show();

                // Close the app
                finish();
            }
        }

    }

}
