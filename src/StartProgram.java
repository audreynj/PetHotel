import java.util.List;
import java.util.Scanner;

import controller.PetHelper;
import model.Pets;

/**
 * Audrey N. Johnston - ajohnston10
 * CIS175
 * Jan 29, 2024
 */
public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static PetHelper ph = new PetHelper();
	
	private static void addAPet() {
		// TODO Auto-generated method stub
		System.out.print("Enter the pet's type: ");
		String type = in.nextLine();
		System.out.print("Enter pet's name: ");
		String name = in.nextLine();
		System.out.print("Enter the pet's owner: ");
		String owner = in.nextLine();
		Pets toAdd = new Pets(type,name, owner);
		ph.insertPet(toAdd);

	}
	
	private static void deleteAPetInformation() {
		// TODO Auto-generated method stub
		System.out.print("Enter the type: ");
		String type = in.nextLine();
		System.out.print("Enter pet name: ");
		String name = in.nextLine();
		System.out.print("Enter the owner: ");
		String owner = in.nextLine();
		Pets toDelete = new Pets(type,name, owner);
		ph.deletePetInformation(toDelete);
	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Type");
		System.out.println("2 : Search by Name");
		System.out.println("3 : Search by Owner");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Pets> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the pet's type: ");
			String petType = in.nextLine();
			foundItems = ph.searchForPetByType(petType);
			
		} else if (searchBy == 2){
			System.out.print("Enter the pet's name: ");
			String petName = in.nextLine();
			foundItems = ph.searchForPetByName(petName);
			
		}else {
			System.out.print("Enter the pet's owner: ");
			String petOwner = in.nextLine();
			foundItems = ph.searchForPetByOwner(petOwner);
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Pets l : foundItems) {
				System.out.println(l.getId()+" : " + l.returnPetDetails());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Pets toEdit = ph.searchForPetById(idToEdit);
			System.out.println("Retrieved Type:" + toEdit.getType() + " - Name: " + toEdit.getName() + " - Owner: " + toEdit.getOwner());
			System.out.println("1 : Update Type");
			System.out.println("2 : Update Name");
			System.out.println("3 : Update Owner");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Type: ");
				String newType = in.nextLine();
				toEdit.setType(newType);
			} else if (update == 2) {
				System.out.print("New Name: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
			}else if (update == 3){
				System.out.print("New Owner: ");
				String newOwner = in.nextLine();
				toEdit.setOwner(newOwner);
			}
			

			ph.updatePetImformation(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to this hotel for pets! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Enter a pet");
			System.out.println("*  2 -- Edit a pet's information");
			System.out.println("*  3 -- Delete a pet's information");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			
			if (selection == 1) {
				addAPet();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAPetInformation();
			} else if (selection == 4) {
				viewTheList();
			} else {
				ph.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}
	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<Pets> allPets = ph.showAllPets();
		for(Pets singlePet : allPets) {
			System.out.println("\n" + singlePet.returnPetDetails());
		}

	}
}
