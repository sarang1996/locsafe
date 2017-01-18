package punchtech.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ASUS on 11-01-2017.
 */

public class fragment_user extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user, container, false);
        ListView listOfMessages = (ListView) v.findViewById(R.id.list_of_messages);

        FirebaseListAdapter<user> adapter = new FirebaseListAdapter<user>(getActivity(), user.class,
                R.layout.chat, FirebaseDatabase.getInstance().getReference().child("user")) {
            @Override
            protected void populateView(View v, user model, int position) {
                TextView messageText = (TextView) v.findViewById(R.id.message_text);
                TextView messageUser = (TextView) v.findViewById(R.id.message_user);
                TextView messageTime = (TextView) v.findViewById(R.id.message_time);

                // Set their text
                messageText.setText(model.getName());
                messageText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), p_chat.class));
                    }
                });
            }
        };
        listOfMessages.setAdapter(adapter);

        return v;
    }
}
