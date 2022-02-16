package intro.Chatbot;
import java.util.Scanner;

// runs our chatbot program. do not edit this, 
// my code should run as desired once you've finished 
// your 3 subclasses
public class ChatBotRunner {

	public static void main(String[] args) {
		
		// decides the chatbot type
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to ChatBot. Choose the personality of your new friend:");
		System.out.println("Sarcastic");
		System.out.println("Enthusiastic");
		System.out.println("Depressed");
		String personality = in.nextLine();
		
		// creates the chatbot. 
		// notice what it is declared as vs what it is defined as.
		ChatBot bot;
		if (personality.equalsIgnoreCase("Sarcastic"))
			bot = new SarcasticBot();
		else if (personality.equalsIgnoreCase("Enthusiastic"))
			bot = new EnthusiasticBot();
		else
			bot = new DepressedBot();
		
		// runs a structured conversation between the user and the chatbot
		bot.sayHi();
		String hello = in.nextLine();
		bot.startConversation();
		String convo = in.nextLine();
		bot.askFirstQuestion();
		String answer1 = in.nextLine();
		bot.askSecondQuestion();
		String answer2 = in.nextLine();
		bot.askThirdQuestion();
		String answer3 = in.nextLine();
		bot.sayBye();
		in.close();
	}
}
