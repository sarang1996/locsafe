package punchtech.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class createGroup extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creategroup);
        FirebaseApp.initializeApp(this);

        final ListView listOfMessages = (ListView) findViewById(R.id.list_groups);

        FirebaseListAdapter adapter = new FirebaseListAdapter<user>(createGroup.this,
                user.class, R.layout.chat, FirebaseDatabase.getInstance().getReference().child("user")
        ) {

            @Override
            protected void populateView(View v, user model, int position) {

                TextView messageText = (TextView) v.findViewById(R.id.message_text);
                TextView messageTime = (TextView) v.findViewById(R.id.message_time);

                messageText.setText(model.getName());
                if (model.getName() != FirebaseAuth.getInstance().getCurrentUser().getDisplayName()) {
                    messageText.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(createGroup.this, MainActivity.class);
                            intent.putExtra("skip", 1);
                            startActivity(intent);
                        }
                    });
                }
            }
        };
        listOfMessages.setAdapter(adapter);
    }

    public void demo(View view) {
        List<String> demo = new ArrayList<>();
        demo.add("dsjk");
        demo.add("sjfhj");
        demo.add("sarangkachhadiya@gmail.com");

        Map<String, Object> params = new HashMap<>();
        params.put("g_name", "cs_group");
        params.put("g_members", demo);
        FirebaseDatabase.getInstance()
                .getReference().child("group")
                .push()
                .setValue(params);
    }
}
