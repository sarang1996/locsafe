package punchtech.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
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

public class fragment_chat extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.activity_creategroup, container, false);
        ListView listOfMessages = (ListView) v.findViewById(R.id.list_of_messages);
        final EditText input = (EditText) v.findViewById(R.id.input);
        Button btn = (Button) v.findViewById(R.id.fab_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Read the input field and push a new instance
                // of ChatMessage to the Firebase database
                FirebaseDatabase.getInstance()
                        .getReference().child("group").child("message")
                        .push()
                        .setValue(new chatMessages(input.getText().toString(),
                                FirebaseAuth.getInstance().getCurrentUser()
                                        .getDisplayName())
                        );

                // Clear the input
                input.setText("");
            }
        });
        FirebaseListAdapter<chatMessages> adapter = new FirebaseListAdapter<chatMessages>(getActivity(), chatMessages.class,
                R.layout.chat, FirebaseDatabase.getInstance().getReference().child("group").child("message")) {
            @Override
            protected void populateView(View v, chatMessages model, int position) {
                // Get references to the views of message.xml
                TextView messageText = (TextView) v.findViewById(R.id.message_text);
                TextView messageUser = (TextView) v.findViewById(R.id.message_user);
                TextView messageTime = (TextView) v.findViewById(R.id.message_time);

                // Set their text
                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());

                // Format the date before showing it
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                        model.getMessageTime()));
            }
        };
        listOfMessages.setAdapter(adapter);

        return v;
    }
}
