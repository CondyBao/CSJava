package intro.Chatbot;

public class DepressedBot extends ChatBot {

    @Override
    public void sayHi() {
        System.out.println("Hello, it is not nice to meet you.");
    }

    @Override
    public void sayBye() {
        System.out.println("Hope I never see you again.");
    }

    @Override
    public void startConversation() {
        System.out.println("Why are you here?");
    }

    @Override
    public void askFirstQuestion() {
        System.out.println("Can you just go away?");
    }

    @Override
    public void askSecondQuestion() {
        System.out.println("Why do you not go away?");
    }

    @Override
    public void askThirdQuestion() {
        System.out.println("Can I push you away?");
    }
}
