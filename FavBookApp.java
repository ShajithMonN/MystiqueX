//Exersise 1
import java.util.Scanner;


public class FavBookApp {

	String[] favoriteBooks=new String[20];
	int index=0;
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		FavBookApp fa=new FavBookApp();
		
		int choice;
		char yesNo;
		
		do{
			//Heading Menu
			
			System.out.println("\t\t FAVORITE BOOKS APP");
			System.out.println("\t\t^^^^^^^^^^^^^^^^^^^^");
			System.out.println("\n1.ADD BOOKS.\n2.VIEW FAVORITE BOOKS");
			System.out.print("ENTER YOUR CHOICE 1 or 2:");
			choice=Integer.parseInt(sc.nextLine());
			
			//passing choice to switch to select method
			
			switch(choice){
			case 1:
				//for call addFavoriteBook method and check
				System.out.println("ENTER THE BOOK NAME:");
				String bookName=sc.nextLine();
				fa.addFavoriteBook(bookName);
				break;
			case 2:
				//for print favorite book Names
				fa.printFavoriteBooks();
				break;
			default:
				System.out.println("Invalid choice, Check your selection...");
				break;
			}
			
			System.out.println("Do you want to Continue:");
			yesNo=sc.nextLine().charAt(0);
			System.out.println("==================================");
		}while(yesNo=='y' || yesNo=='Y');
		
	}
	
	public void addFavoriteBook(String bookName){	
		bookName=bookName.toLowerCase();   //converting to lowercase so we can check the whether great is in lower case or uppercase
		if(bookName.contains("great")){
			System.out.println("BOOK NOT ADDED...");
			System.out.println("-----------------------\n");
		}
		else{
			favoriteBooks[index]=bookName;
			System.out.println("BOOK ADDED TO YOUR FAVORITE LIST...");
			index++;
			System.out.println("--------------------------\n");
		}
	}
	public void printFavoriteBooks(){
		System.out.println("\t\t FAVORITE BOOKS LIST");
		System.out.println("\t\t^^^^^^^^^^^^^^^^");
		int i=1;
		for(String book:favoriteBooks){   //using enhance for loop for print all array values
			if(book!=null){
				System.out.println(i+"."+book);
				i++;  //this i is for book Number
			}
		}
		System.out.println("Total Number of Books Added:"+(i+1));
		System.out.println("=============================");
	}

}
