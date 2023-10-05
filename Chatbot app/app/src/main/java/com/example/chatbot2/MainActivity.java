package com.example.chatbot2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView chatRecyclerView;
    private EditText userInputEditText;
    private List<ChatMessage> chatMessageList;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatRecyclerView = findViewById(R.id.chatRecyclerView);
        userInputEditText = findViewById(R.id.userInputEditText);
        Button sendButton = findViewById(R.id.sendButton);

        chatMessageList = new ArrayList<>();
        chatAdapter = new ChatAdapter(chatMessageList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        chatRecyclerView.setLayoutManager(layoutManager);
        chatRecyclerView.setAdapter(chatAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMessage = userInputEditText.getText().toString().trim();
                if (!userMessage.isEmpty()) {
                    // Add user message to the chat
                    ChatMessage userChatMessage = new ChatMessage(userMessage, true);
                    chatMessageList.add(userChatMessage);

                    // Add chatbot response
                    String chatbotResponse = getChatbotResponse(userMessage);
                    ChatMessage chatbotChatMessage = new ChatMessage(chatbotResponse, false);
                    chatMessageList.add(chatbotChatMessage);

                    // Notify adapter of data changes
                    chatAdapter.notifyDataSetChanged();

                    // Scroll to the last message
                    chatRecyclerView.smoothScrollToPosition(chatAdapter.getItemCount() - 1);

                    // Clear user input
                    userInputEditText.setText("");
                }
            }
        });
    }

    private String getChatbotResponse(String userMessage) {
        // Simple chatbot logic
        if (userMessage.equalsIgnoreCase("hi") || userMessage.equalsIgnoreCase("hey") || userMessage.equalsIgnoreCase("hello")) {
            return "Hi! How can I help you?";
        }
        else if (userMessage.equalsIgnoreCase("How to file a missing person report?")||userMessage.equalsIgnoreCase("File missing person complaint")||userMessage.equalsIgnoreCase("File missing person report")) {
            return "Register by choosing Need Assistance from the\n" +
                    "drop-down> Choose File missing person complaint > Fill the form> Upload missing person's photo > Submit the form.";
        }
        else if (userMessage.equalsIgnoreCase("Donate")|| userMessage.equalsIgnoreCase("how to donate?")) {
            return "Register by choosing Donate from the" +
                    "drop-down> Choose type Donation > Navigate to any of the given platforms to donate";
        }
        else if (userMessage.equalsIgnoreCase("Need Assistance ")|| userMessage.equalsIgnoreCase("I need assistance")) {
            return "Register by choosing Need Assistance from the" +
                    "drop-down> Choose type of Assistance needed  > Submit the form";
        }
        else if (userMessage.equalsIgnoreCase("Others")) {
            return "Please contact our 24/7 helpline number";
        }
        else if (userMessage.equalsIgnoreCase("Assign rescue task")||userMessage.equalsIgnoreCase("Assign rescue team")) {
            return "Register by choosing Volunteer/Relief team from the drop-down> Choose Assign Rescue Task >" +
                    " Enter Current Location and submit";
        }
        else {
            return "I didn't understand that.";
        }
    }
}
