package Collections;

import java.util.Comparator;

import Entity.Orders;

public class DescendingSortOrderDate implements Comparator<Orders> {
	@Override
	public int compare(Orders o1, Orders o2) {
		// TODO Auto-generated method stub
		return o2.getOrderDate().compareTo(o1.getOrderDate());
	}
}
