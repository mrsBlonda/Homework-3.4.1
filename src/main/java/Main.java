

public class Main {
    public static void main (String[] args) throws InterruptedException {
        Telephone telephoneStation = new Telephone();
        Thread call = new Thread(null, () -> telephoneStation.addCalls(), "АТС");
        ThreadGroup specialists = new ThreadGroup("specialists");
        Thread specialist1 = new Thread(specialists, () -> telephoneStation.answerCalls(), "Специалист 1");
        Thread specialist2 = new Thread(specialists, () -> telephoneStation.answerCalls(), "Специалист 2");
        Thread specialist3 = new Thread(specialists, () -> telephoneStation.answerCalls(), "Специалист 3");
        Thread specialist4 = new Thread(specialists, () -> telephoneStation.answerCalls(), "Специалист 4");


        call.start();
        Thread.sleep(Telephone.TIME_CALL_PROCESSING);

        specialist1.start();
        specialist2.start();
        specialist3.start();
        specialist4.start();

        specialist1.join();
        specialist2.join();
        specialist3.join();
        specialist4.join();


        System.out.println("Конец");
















    }
}
