package mediatorfactory.factory;

import mediatorfactory.mediator.MessageMediator;
import mediatorfactory.mediator.User;

public class UserFactory {

    public User createUser(MessageMediator messageMediator, String type, String userName){
        User user = null;
        if(type.equals("Bot")){
            user = Bot.getSingletonInstance(messageMediator,type, userName);
        }

        if(type.equals("Visitor")){
            user = new Visitor(messageMediator, type, userName);
            messageMediator.addUser(user);
        }

        return user;
    }
}
