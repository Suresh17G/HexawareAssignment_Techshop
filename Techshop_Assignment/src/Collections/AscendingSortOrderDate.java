package Collections;
import Entity.Orders;
import java.util.Comparator;

public class AscendingSortOrderDate implements Comparator<Orders> {
	@Override
	public int compare(Orders o1, Orders o2) {
		// TODO Auto-generated method stub
		return o1.getOrderDate().compareTo(o2.getOrderDate());
	}
}

