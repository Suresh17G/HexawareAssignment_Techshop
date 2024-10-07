package Collections;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import Entity.Orders;

import java.util.Date;
import java.util.ArrayList;

public class OrdersList {
    private static List<Orders> ordersList = new ArrayList<Orders>();

    public static void addOrder(Orders order) {
        ordersList.add(order);
    }

    public static void updateOrderStatus(int orderID, String status) throws Exception {
        for (Orders o : ordersList) {
            if (o.getOrderID() == orderID) {
                o.setStatus(status);
                return;
            }
        }
        throw new Exception("Order not found");
    }

    public static void removeCanceledOrders() {
        for (int i = 0; i < ordersList.size(); i++) {
            if (ordersList.get(i).getStatus().equals("Canceled")) {
                ordersList.remove(i);
                i--; // Adjust index after removal
            }
        }
    }

    public static List<Orders> getAllOrders() {
        return ordersList;
    }
    
    public static void AscendingSort(Date startDate, Date endDate) {
    	SortedSet<Orders> sortedordersList=new TreeSet<>(new AscendingSortOrderDate());
    	 for (Orders o : ordersList) {
             if ((o.getOrderDate().after(startDate) || o.getOrderDate().equals(startDate)) && 
            		 (o.getOrderDate().before(endDate) || o.getOrderDate().equals(endDate))) {
                 sortedordersList.add(o);
             }
         }
    	 for(Orders o:sortedordersList) {
    		 System.out.println("Order ID: "+o.getOrderID()+"Order Date: "+o.getOrderDate()+"Order Amount: "+o.getTotalAmount());
    	 }
    }
 public static void DescendingSort(Date startDate, Date endDate) {
	 SortedSet<Orders> sortedordersList=new TreeSet<>(new DescendingSortOrderDate());
	 for (Orders o : ordersList) {
         if ((o.getOrderDate().after(startDate) || o.getOrderDate().equals(startDate)) && 
        		 (o.getOrderDate().before(endDate) || o.getOrderDate().equals(endDate))) {
             sortedordersList.add(o);
         }
     }
	 for(Orders o:sortedordersList) {
		 System.out.println("Order ID: "+o.getOrderID()+"Order Date: "+o.getOrderDate()+"Order Amount: "+o.getTotalAmount());
	 }
    	
    }
}
