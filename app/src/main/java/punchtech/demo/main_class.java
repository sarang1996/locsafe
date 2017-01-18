package punchtech.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ASUS on 11-01-2017.
 */

public class main_class extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        final ListView listOfMessages = (ListView) findViewById(R.id.list_groups);

        FirebaseListAdapter adapter = new FirebaseListAdapter<group>(this,
                group.class, R.layout.chat, FirebaseDatabase.getInstance().getReference().child("group")
        ) {

            @Override
            protected void populateView(View v, group model, int position) {
                TextView messageText = (TextView) v.findViewById(R.id.message_text);
                TextView messageTime = (TextView) v.findViewById(R.id.message_time);

                messageText.setText(model.getG_name());
                messageText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(main_class.this, pager.class);
                        startActivity(intent);
                    }
                });

            }
        };
        listOfMessages.setAdapter(adapter);

    }
}
