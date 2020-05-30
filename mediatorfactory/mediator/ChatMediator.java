package mediatorfactory.mediator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatMediator implements MessageMediator {

    private List<User> users;

    public ChatMediator() {
        users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User user) {
        Iterator<User> itr = users.iterator();
        while (itr.hasNext()) {
            if (users.contains(user)) {
                User currentUser = itr.next();
                if (!currentUser.getName()
                        .equals(user.getName())) {

                    currentUser.receive(message, user.getName());
                }
            }

        }

    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void removeUser(String userName) {
        User user = this.users.stream()
                .filter(e -> userName.equals(e.getName()))
                .findFirst()
                .get();
        users.remove(user);
    }

}
