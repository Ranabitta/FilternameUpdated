
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Program to sort and filter a list of Company Names.
*/
public class FilteringCompanyName { 
	
	public static void main(String[] args) {
		int count;
		Scanner scan = new Scanner(System.in);
	    //User will be asked to enter the count of strings 
	    System.out.print("Enter the total number of companies in the list:");
	    count = scan.nextInt();
	    
	    String str[]  = new String[count];
	    List<String> list = Arrays.asList(str); 
	    Scanner companyName = new Scanner(System.in);
	    
	    //The entered strings are stored in an array
	    System.out.println("Enter the Company Name one by one:");
	    for(int i = 0; i < count; i++) {
	    	str[i] = companyName.nextLine();
	    }
	    scan.close();
	    companyName.close();
	    
	    System.out.println("List of Company Names...\n");
	    for (String res : list) {
	    	System.out.print(res+"\n");
	    }
	    
	   
	    
	    /*
         * filters the name, starts with "J".
         * Ignoring case
         * Ignoring whitespace.
         * 
         * Returns a stream consisting of the elements of this stream
         * that match the given predicate.
         */ 
	    Stream<String> stream = list.stream().filter(name -> name.toUpperCase().startsWith("J")).map(name -> name.replaceAll(" ", ""));
	    System.out.println("\nNames of Companies beginning with letter J\n "+stream.collect(Collectors.toList()));
	   
	    //Filtering the list of company names in alphabetical order
	    System.out.println("Sorting the list of company names in alphabetical order\n");
	    Stream<String> asc = list.stream().filter(name -> name.toUpperCase().startsWith("J")).map(name -> name.replaceAll(" ", "")).sorted();
	    System.out.println("The List are\n:"+asc.collect(Collectors.toList()));
	    
	    //Filtering the list of company names in reverse alphabetical order
	    System.out.println("Sorting the list of company names in reverse alphabetical order:\n");
	    Stream<String> dsc = list.stream().filter(name -> name.toUpperCase().startsWith("J")).map(name -> name.replaceAll(" ", "")).sorted(Comparator.reverseOrder());
	    System.out.println("The list are:\n"+dsc.collect(Collectors.toList()));
	}
}