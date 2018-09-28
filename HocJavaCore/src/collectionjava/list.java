package collectionjava;

import java.util.ArrayList;
import java.util.List;

public class list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1 = new ArrayList<String>();
		list1.add("list 1");
		list1.add("list 2");
		for (String item : list1) {
			System.out.println(item);
		}
		
	}

}
