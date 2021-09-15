package intro;


public class PrintBasic {
    public static void main(String[] args) {
        System.out.println("What are your name?");
        sleep(1000);
        System.out.println("My name is Condy Bao.");
        sleep(2000);
        System.out.println("How old are you?");
        sleep(1000);
        System.out.println("I am 15 years old.");
        sleep(2000);
        System.out.println("Where are you from?");
        sleep(1000);
        System.out.println("I am from Shanghai, China.");
        sleep(2000);
        System.out.println("What are your hobbies?");
        sleep(1000);
        System.out.println("My hobbies include: coding, watching animes and movies, drawing, debating, producing music, etc.");
        sleep(2000);
        System.out.println("What coding experiences do you have?");
        sleep(1000);
        System.out.println("I have been coding C/C++ for 5 years, and I participate in USACO. I started learning python by myself when I entered Middle School, and now I have learned many algorithms and GUI. I have done a chatbot like Siri and a graphic-interface Tic Tac Toe.");
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
