
import java.util.Scanner;

class HotelService implements Runnable {
    private String serviceName;
    private int duration; 

    public HotelService(String serviceName, int duration) {
        this.serviceName = serviceName;
        this.duration = duration;
    }

    @Override
    public void run() {
        try {
            System.out.println(serviceName + " started.");
            Thread.sleep(duration); 
            System.out.println(serviceName + " completed.");
        } catch (InterruptedException e) {
            System.out.println(serviceName + " interrupted.");
        }
    }
}

public class HotelRoomServiceMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hotel Room Service Management System");
        System.out.print("Enter number of service requests: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        Thread[] services = new Thread[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter service name (e.g., Room Cleaning, Food Delivery, Maintenance): ");
            String serviceName = sc.nextLine();

            System.out.print("Enter duration in milliseconds for " + serviceName + ": ");
            int duration = sc.nextInt();
            sc.nextLine();

            services[i] = new Thread(new HotelService(serviceName, duration));
        }

        
        for (Thread service : services) {
            service.start();
        }

        System.out.println("\nAll hotel service requests have been initiated concurrently.");
        sc.close();
    }
}
