import java.util.Queue;

import java.util.concurrent.LinkedTransferQueue;


public class Telephone {
    public static final int TIME_CALLS = 500;
    public static final int TIME_CALL_PROCESSING = 2000;

    public volatile Queue<String> calls = new LinkedTransferQueue<>();

    public void addCalls() {
        int min = 10;
        int max = 20;

        for (int i = min; i < max; i++) {
            String str = "8 917 996 07 " + i;
            calls.add(str);
            System.out.println("Поступил звонок от: " + str);
            try {
                Thread.sleep(TIME_CALLS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void answerCalls() {
        while (!calls.isEmpty()) {
            try {
                Thread.sleep(TIME_CALL_PROCESSING);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Звонок обработан: " + calls.poll());
        }
    }









}
