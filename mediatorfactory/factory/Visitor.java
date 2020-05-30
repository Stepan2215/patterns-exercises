package mediatorfactory.factory;

import mediatorfactory.mediator.MessageMediator;
import mediatorfactory.mediator.User;

public class Visitor extends User {

    public Visitor(MessageMediator med, String type, String name) {
        super(med, type);
        setName(name);
        System.out.println(name + " " + type + " joined to the chat!");
    }

    @Override
    public void send(String msg) {
        System.out.println(this.getName() + " sends: " + msg);
        messageMediator.sendMessage(msg, this);
        if (msg.equals("addBot")) {
            new UserFactory().createUser(messageMediator, "Bot", "Bot");
        }
    }

    @Override
    public void receive(String msg, String userName) {
        System.out.println(this.getName() + " receives:" + msg);
    }
}
