package Lab4;

import java.util.Scanner;

class Hotel {
    private int totalRooms;
    private int availableRooms;

    public Hotel(int totalRooms) {
        this.totalRooms = totalRooms;
        this.availableRooms = totalRooms;
    }

  
    public synchronized void bookRoom(String customerName) {
        while (availableRooms == 0) {
            System.out.println(customerName + " is waiting for a room");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        availableRooms--;
        System.out.println(customerName + " booked a room. Rooms left: " + availableRooms);
    }

    public synchronized void releaseRoom(String customerName) {
        availableRooms++;
        System.out.println(customerName + " released a room. Rooms left: " + availableRooms);
        notifyAll(); 
    }
}

class Customer extends Thread {
    private Hotel hotel;
    private String customerName;

    public Customer(Hotel hotel, String customerName) {
        this.hotel = hotel;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        hotel.bookRoom(customerName);

        try {
           
            Thread.sleep((int)(Math.random() * 3000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        hotel.releaseRoom(customerName);
    }
}

public class HotelManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of rooms in hotel: ");
        int totalRooms = sc.nextInt();

        System.out.print("Enter number of customers: ");
        int numCustomers = sc.nextInt();

        Hotel hotel = new Hotel(totalRooms);


        
        for (int i = 1; i <= numCustomers; i++) {
            Customer customer = new Customer(hotel, "Customer-" + i);
            customer.start();
        }

        sc.close();
    }
}

