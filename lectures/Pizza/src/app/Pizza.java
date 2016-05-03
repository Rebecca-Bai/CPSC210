package app;

import java.util.ArrayList;
import java.util.List;

// Represents a pizza

public class Pizza {

	// Set the cost of a crust
	static private int CRUSTCOST = 5;

	// Every pizza must have a crust
	private Crust crust;

	// And can optionally have ingredients
	private List<Ingredient> ingredients;

	// Constructor
	public Pizza() {
ingredients=new ArrayList<Ingredient>();
		crust=new Crust();
	}

	// Add an ingredient
	// REQUIRES: newIngredient is not null
	// MODIFIES: this
	// EFFECTS: newIngredient is added to end of list of ingredients
	public void addIngredient(Ingredient newIngredient) {
		ingredients.add(newIngredient);
	}

	// Returns all of the ingredients on pizza, including crust, as a a string
	// EFFECTS: the returned string starts with "crust" followed by
	// all ingredients with " toppedBy " between each ingredient
	public String ingredientsAsString() {
		String string="";
		for (int i=0;i<ingredients.size();i++){
			string=string+" toppedBy "+ingredients.get(i).getName();
		}
		return "crust"+string;
	}

	// Return the total cost calculated for the pizza
	// EFFECTS: Return the total cost of the pizza with crust and
	// all ingredients. Total cost >= CRUSTCOST
	public int totalCost() {
		int total=0;
		for (int i=0;i<ingredients.size();i++){
			total+=ingredients.get(i).computeCost();
		}
		return CRUSTCOST+total;
	}

}
