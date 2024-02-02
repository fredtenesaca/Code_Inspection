import java.util.Scanner;
@SuppressWarnings("PMD.UseUtilityClass") //This rule was suppressed due to a step specified in the workshop document.
public class DiningExperienceManager {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        boolean finish=false;
	        int[] quantities = new int[5];
	        do {
	        System.out.println("Welcome to the Dining Experience Manager!");
	        // Initialize menu with meal options and prices
	        String[] menu = {"Meal A", "Meal B", "Meal C", "Meal D", "Meal E"};
	        double[] prices = {10.0, 15.0, 12.0, 8.0, 20.0};
	        boolean[] selectedMeals= {false,false,false,false,false};
	        int mealsNumber=0;
        	int confirmExit;
	        for(int x=0; x<5; x++) {
	        	quantities[x]=0;
	        }
	        double totalCost = 5.0; // Base cost

	        // Display menu
	        System.out.println("Menu:");
	        for (int i = 0; i < menu.length; i++) {
	            System.out.println(i + 1 + ". " + menu[i] + " - $" + prices[i]);
	        }
	        
	        do {
	        	int meal;
	        	try {
	        	System.out.println("Select a number of a meal in the menu: ");
                meal = scanner.nextInt();
                if(meal > 0 && meal <= 5) {
                if(selectedMeals[meal-1]==true) {
    	        	System.out.println("Meal already selected!");      	
                }else {
                	System.out.println("Meal selected!");
                	mealsNumber+=1;
                	selectedMeals[meal-1]=true;
                }
                }else {
    	        	System.out.println("Please select an available meal!");      	
                }
                System.out.println("Do you want another meal? (1 for Yes, 0 or another number for No):");
                confirmExit = scanner.nextInt();
	        	}catch(Exception ex) {
	        		System.out.println("Select a valid option (only integer numbers)!");
	        		scanner.reset();
	        		System.out.println("Do you want another meal? (1 for Yes, 0 or another number for No):");
	                confirmExit = scanner.nextInt();
	        	}
                
	        	
	        }while(mealsNumber<4   && confirmExit == 1);            
	            int i=0;
	            while(i < menu.length){
	            	try {
		            	if(selectedMeals[i]) {
		                System.out.print("Enter quantity for " + menu[i] + ": ");
		                int quantity = scanner.nextInt();

		                if (quantity < 0) {
		                    System.out.println("Invalid quantity. Please enter a positive integer between 0 and 100.");
		                    i--;
		                }else if(totalQuantity(quantities)+quantity > 100){
		                	System.out.println("Please enter a quantity that does not exceed 100 meals in total.");
		                	i--;
		                }else{
		                quantities[i] = quantity;
		                totalCost += quantity * prices[i];
		                }
		            	}
		            	}catch(Exception ex) {
		            		System.out.println("Type a valid quantity (only integer numbers)!");
			        		scanner.reset();
			        		i--;
		            	}
	                i++;
	            }
	      

	        // Apply discounts based on total quantity
	        if (totalQuantity(quantities) > 5) {
	            totalCost *= 0.9; // 10% discount
	        }
	        if (totalQuantity(quantities) > 10) {
	            totalCost *= 0.8; // 20% discount
	        }

	        // Special offer discounts
	        if (totalCost > 50) {
	            totalCost -= 10.0; // $10 discount
	        }
	        if (totalCost > 100) {
	            totalCost -= 25.0; // $25 discount
	        }

	        // Display selected meals, quantities, and total cost for user confirmation
	        System.out.println("Selected Meals and Quantities:");
	        
	        for (i = 0; i < menu.length; i++) {
	            if (quantities[i] > 0) {
	                System.out.println(menu[i] + " - Quantity: " + quantities[i]);
	            }
	        }
	        System.out.println("Total Cost: $" + totalCost);

	        // User confirmation
	        System.out.print("Confirm the order? (1 for Yes, 0 or another number for cancel the order): ");
	        int confirm = scanner.nextInt();

	        if (confirm == 1) {
	            System.out.println("Order confirmed. Total cost: $" + (int) totalCost);
	            finish=true;
	        }else {
	            System.out.println("Order canceled.");
	            totalCost = -1;
	            System.out.println(totalCost);
	            System.out.println("Redirecting to the beginning so you can make a new selection!");

	        }
	        }while(!finish);
	        scanner.close();
	    }

	    // Helper method to calculate the total quantity of meals
	    private static int totalQuantity(int... quantities) {
	        int total = 0;
	        for (int quantity : quantities) {
	            total += quantity;
	        }
	        return total;
	    }

}
