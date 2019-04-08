package Client.client;


import Client.remote_object.CalcObject1;
import Client.remote_object.CalcObject2;
import Client.remote_object.CalcObject3;

import java.util.Arrays;

public class MyClient {

	public static void main(String[] args) {
		
		
		if(args.length == 0 || args.length == 1 || args.length == 2) {
			System.out.println("You have to enter three RMI objects addresses in the form: //host_address/service_name");
			return;
		}
		String adres = args[0];
		String adres2 = args[1];
		String adres3 = args[2];
		
		if(System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		CalcObject1 ob1;
		CalcObject2 ob2;
		CalcObject3 ob3;
		
		int[] first_array = {11,7,3,10,53,72,23};
		int[] second_array = {15,20,10,3,7};
		
		int[] first_array_sorted;
		int[] second_array_sorted;
		int[] two_arrays_merged_and_sorted;
		
		try {
			ob1 = (CalcObject1) java.rmi.Naming.lookup(adres);
			ob2 = (CalcObject2) java.rmi.Naming.lookup(adres2);
			ob3 = (CalcObject3) java.rmi.Naming.lookup(adres3);
		} catch (Exception e) {
			System.out.println("Nie mo�na pobra� referencji do "+adres+" lub " + adres2 + " lub "+adres3);
			e.printStackTrace();
			return;
		}
		System.out.println("Referencja do "+adres + " i " + adres2 + " i "+adres3 +" jest pobrana");
		
		try {
			first_array_sorted = ob1.sort_array(first_array);
			System.out.println("pierwsza: "+Arrays.toString(first_array_sorted));
			second_array_sorted = ob2.sort_array(second_array);
			System.out.println("druga: "+Arrays.toString(second_array_sorted));
			two_arrays_merged_and_sorted = ob3.merge_arrays_and_sort(first_array, second_array);
			System.out.println("trzecia: "+Arrays.toString(two_arrays_merged_and_sorted));

		} catch (Exception e) {
			System.out.println("B��d zdalnego wywo�ania");
			e.printStackTrace();
			return;
		}
	}

}
