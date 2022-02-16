package intro.Chatbot;

public class EnthusiasticBot extends ChatBot{
    @Override
    public void sayHi() {
        System.out.println("Hi!!!");
    }

    @Override
    public void sayBye() {
        System.out.println("Sorry, I've got to go!B YEEE!!! It was nice talking to you!");
    }

    @Override
    public void startConversation() {
        System.out.println("You look like a very nice guy!");
    }

    @Override
    public void askFirstQuestion() {
        System.out.println("My name is Enthusiastic Bot! What is your name?");
    }

    @Override
    public void askSecondQuestion() {
        System.out.println("What a great name you've got! How old are you?");
    }

    @Override
    public void askThirdQuestion() {
        System.out.println("Nice! How are you doing?");
    }
}
