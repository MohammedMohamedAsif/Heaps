
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author moham
 */
public class Driver {

    public static void main(String[] args) {

//Creating new queue object
        Heap priority = new Heap();

        int totalCustomers = 0;
        int totalQueue = 0;
        int maxCustomers = 0;

        //Loops 60 times
        for (int i = 0; i < 60; i++) {

            //Creating random number generator between 0-3
            int number = new Random().nextInt(4);

            //If the random number generator outputs '0' add customer to the line
            //and compare number of customers in a queue to find max queue length 
            if (number == 0) {
                priority.add(new PriorityCustomer());
                totalQueue++;
                System.out.println("New customer is added, queue length is now" + totalQueue);
                totalCustomers++;
                if (maxCustomers < totalQueue) {
                    maxCustomers = totalQueue;
                }
            }

            //If service time for customer in the front of the line is < or = 0 remove customer 
            if (!priority.isEmpty() && priority.first.getServiceTime <= 0) {
                priority.remove();
                System.out.println("Customer is removed, queue length is now" + priority.getSize());
                totalQueue -= 1;
            }

            if (!priority.isEmpty()) {
                priority.first.decServiceTime();
            }

            System.out.println("-------------------------------------------------------------");
        }

        System.out.println("Total Customers Serverd: " + totalCustomers);
        System.out.println("Max Customers Serverd At One Point: " + maxCustomers);
    }

}
