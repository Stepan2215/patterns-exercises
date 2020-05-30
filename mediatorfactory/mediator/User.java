package mediatorfactory.mediator;

public abstract class User {
    protected MessageMediator messageMediator;
    protected String type;
    protected String name;

    public User(MessageMediator med, String type){
        this.messageMediator = med;
        this.type = type;

    }

    public MessageMediator getMessageMediator() {
        return messageMediator;
    }

    public void setMessageMediator(MessageMediator messageMediator) {
        this.messageMediator = messageMediator;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg, String userName);
}