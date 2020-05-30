package mediatorfactory.factory;

import mediatorfactory.mediator.MessageMediator;
import mediatorfactory.mediator.User;

public class Bot extends User {

    public static Bot singletonInstance = null;

    private Bot(MessageMediator med, String type, String name) {
        super(med, type);
        setName(name);
        System.out.println(name + " " + type + " joined to the chat! ");
    }

    public static Bot getSingletonInstance(MessageMediator med, String type, String name) {
        if (singletonInstance == null) {
            singletonInstance = new Bot(med, type, name);
            med.addUser(singletonInstance);
        }
        return singletonInstance;
    }

    @Override
    public void send(String msg) {
        System.out.println(this.getName() + " sends: " + msg);
        messageMediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg, String userName) {
        System.out.println(this.getName() + " receives: " + msg);
        if (msg.equals("cat")) {
            messageMediator.removeUser(userName);
            messageMediator.sendMessage(msg + " is forbidden word in this chatroom! User " + userName + " has been kicked from chat!", this);
        }
    }
}
