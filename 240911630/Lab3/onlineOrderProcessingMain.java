import java.util.Scanner;

public class onlineOrderProcessingMain {

    static class OrderTask implements Runnable {
        private String orderId;

        public OrderTask(String orderId) {
            this.orderId = orderId;
        }

        @Override
        public void run() {
            try {
                System.out.println("Processing started for Order: " + orderId);

                System.out.println("Order " + orderId + ": Validation started.");
                Thread.sleep(2000);
                System.out.println("Order " + orderId + ": Validation completed.");

                System.out.println("Order " + orderId + ": Payment processing started.");
                Thread.sleep(3000);
                System.out.println("Order " + orderId + ": Payment completed.");

                System.out.println("Order " + orderId + ": Shipment started.");
                Thread.sleep(4000);
                System.out.println("Order " + orderId + ": Shipment completed.");

                System.out.println("Processing finished for Order: " + orderId);
              

            } catch (InterruptedException e) {
                System.out.println("Order " + orderId + " interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Online Order Processing System");
        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        Thread[] orders = new Thread[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Order ID for order " + (i + 1) + ": ");
            String orderId = sc.nextLine();
            orders[i] = new Thread(new OrderTask(orderId));
        }

        for (Thread order : orders) {
            order.start();
        }

        System.out.println("All orders are being processed concurrently.");
        sc.close();
    }
}
