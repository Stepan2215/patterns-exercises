package mediatorfactory;

import mediatorfactory.factory.UserFactory;
import mediatorfactory.mediator.ChatMediator;
import mediatorfactory.mediator.MessageMediator;
import mediatorfactory.mediator.User;

public class MainClass {
    public static void main(String[] args) {
        MessageMediator mediator = new ChatMediator();

        UserFactory userFactory = new UserFactory();

        User goshoVisitor = userFactory.createUser(mediator, "Visitor", "Gosho");
        User stefchoVisitor = userFactory.createUser(mediator, "Visitor", "Stefcho");

        goshoVisitor.send("addBot");

        User bot = userFactory.createUser(mediator, "Bot", "bot1253");
        stefchoVisitor.send("cat");
        goshoVisitor.send("It's a sed:(");
        stefchoVisitor.send("as");
    }
}
