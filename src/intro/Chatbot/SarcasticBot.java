package intro.Chatbot;

public class SarcasticBot extends ChatBot {
    @Override
    public void sayHi() {
        System.out.println("Oh hElLo, WhY dO i SeE nO oNe HeRe?");
    }

    @Override
    public void sayBye() {
        System.out.println("oH mY gOd, yOu ArE sO fUnNy! LoOk FoRwArD tO tAlKiNg To YoU aGaIn.");
    }

    @Override
    public void startConversation() {
        System.out.println("wHy dO yOu sOuNd So DuMb?");
    }

    @Override
    public void askFirstQuestion() {
        System.out.println("tElL mE yOuR nAmE iF yOu HaVe OnE");
    }

    @Override
    public void askSecondQuestion() {
        System.out.println("a GoOd NaMe HuH? aRe YoU jObLeSs? wHaT dO yOu Do?");
    }

    @Override
    public void askThirdQuestion() {
        System.out.println("yOu MuSt Be PrEtTy SmArT rIgHt? ArE yOu?");
    }
}
