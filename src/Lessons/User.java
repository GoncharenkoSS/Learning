package Lessons;

import java.util.List;

public class User {
    private String userName;
    private List<User> subscriptions;

    public User(String userName, List<User> subscriptions) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User: " + userName + ".\n";
    }

    public List<User> getSubscriptions() {
        return subscriptions;
    }

    public void subscribe(User user){
        subscriptions.add(user);
    }

    public boolean isSubscribed(User user){
        return subscriptions.contains(user);
    }

    public boolean isFried(User user){

        return false;
    }

    public void sendMessage(User user, String text){

    }
}
