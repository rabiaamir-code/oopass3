// Emergency Alert System
class EmergencyAlert {
    // Method to trigger an alert based on vital signs
    public void triggerAlert(String vitalSign) {
        System.out.println("Alert! " + vitalSign + " has exceeded critical threshold.");
    }
}

class NotificationService {
    // sending an email alert
    public void sendEmailAlert(String email, String message) {
        System.out.println("Email sent to " + email + ": " + message);
    }

    //  sending an SMS alert
    public void sendSmsAlert(String phoneNumber, String message) {
        System.out.println("SMS sent to " + phoneNumber + ": " + message);
    }
}

class PanicButton {
    private EmergencyAlert emergencyAlert = new EmergencyAlert();

    // When panic button is pressed, a manual alert is triggered
    public void pressButton() {
        emergencyAlert.triggerAlert("Manual Panic Triggered");
    }
}

// Chat & Video Consultation
class ChatServer {
    // Receives and displays a message on the server
    public void receiveMessage(String message) {
        System.out.println("Message received on server: " + message);
    }
}

class ChatClient {
    // Sends a message from client
    public void sendMessage(String message) {
        System.out.println("Message sent from client: " + message);
    }
}

class VideoCall {
    // Starts a video call by displaying the meeting link
    public void startCall(String link) {
        System.out.println("Opening video consultation at: " + link);
    }
}

// Notifications & Reminders

// Interface to define notification behavior
interface Notifiable {
    void notifyUser(String contact, String message);
}

// Reminder service that uses a Notifiable implementation
class ReminderService {
    private Notifiable notifier;

    // Constructor accepts a Notifiable instance (email or SMS)
    public ReminderService(Notifiable notifier) {
        this.notifier = notifier;
    }

    // Sends reminder using the provided notifier
    public void sendReminder(String contact, String message) {
        notifier.notifyUser(contact, message);
    }
}

// Sends email notifications
class EmailNotification implements Notifiable {
    @Override
    public void notifyUser(String email, String message) {
        System.out.println("Email Notification to " + email + ": " + message);
    }
}

// Sends SMS notifications
class SMSNotification implements Notifiable {
    @Override
    public void notifyUser(String phoneNumber, String message) {
        System.out.println("SMS Notification to " + phoneNumber + ": " + message);
    }
}

// Main method to demonstrate the functionality
public class RemortHealthSystem {
    public static void main(String[] args) {
        // Emergency Alert System Demonstration
        EmergencyAlert alert = new EmergencyAlert();
        alert.triggerAlert("Heart Rate"); // Simulate a critical vital sign alert

        NotificationService notificationService = new NotificationService();
        notificationService.sendEmailAlert("doctor@rabia.com", "Patient's heart rate is critical.");
        notificationService.sendSmsAlert("92331789638", "Patient's heart rate is critical.");

        PanicButton panicButton = new PanicButton();
        panicButton.pressButton(); // Simulate panic button press

        //  Chat & Video Consultation Demonstration 
        ChatServer chatServer = new ChatServer();
        chatServer.receiveMessage("Hello Doctor");

        ChatClient chatClient = new ChatClient();
        chatClient.sendMessage("Hello Patient");

        VideoCall videoCall = new VideoCall();
        videoCall.startCall("https://zoom.us/meet465"); // Simulate video call

        // Notifications & Reminders Demonstration 
        // Email reminder
        Notifiable emailNotifier = new EmailNotification();
        ReminderService emailReminder = new ReminderService(emailNotifier);
        emailReminder.sendReminder("patient@rabeea.com", "Take your medication at 8 pm (mid dinner)");

        // SMS reminder
        Notifiable smsNotifier = new SMSNotification();
        ReminderService smsReminder = new ReminderService(smsNotifier);
        smsReminder.sendReminder("92345532410", "Appointment tomorrow at 7 pm");
    }
}
