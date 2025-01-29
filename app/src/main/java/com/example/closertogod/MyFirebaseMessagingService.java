package com.example.closertogod;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import android.util.Log;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        // Check if message contains a notification payload
        if (remoteMessage.getNotification() != null) {
            // Handle the notification message (for example, show a log or a notification)
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Check if message contains a data payload
        if (remoteMessage.getData().size() > 0) {
            // Handle the data message
            Log.d(TAG, "Message Data: " + remoteMessage.getData());
        }
    }

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        // This method is called when a new token is generated
        Log.d(TAG, "New FCM Token: " + token);
        // You can send this token to your server if needed
    }
}
