package Start;

import java.awt.Color;
import java.util.*;

import quidditch.*;

//import java.awt.FlowLayout;
//import java.awt.event.*; 
//import javax.swing.*; 

public final class Start {
	
	private Start(){}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		if(start(sc) == 1)
			Jeu.GetInstance();
		else
			System.out.println("You chose to quit the game.\nSee you soon!");
	}
	
	//Donne le choix au joueur du nombre de souaffle, Cognard et Vif d'Or
	public static int[] initBalls(Scanner sc){
		int[] nbBalls = new int[3];
		int choice;
		
		try{
			 	System.out.printf("How many Quaffles do you want?\n"+
					 "\t 3 or 5 ? \n");
	            do  {
	            	choice = sc.nextInt();
	            	if(choice !=  3 && choice != 5)
	            		System.out.printf("Not valid number, try again.\n");
	            }while (choice !=  3 && choice != 5);
	            nbBalls[0] = choice;
	            
	            System.out.printf("How many Bludgers do you want?\n"+
	   				 "\t 0, 1 or 2 ? \n");
	            do  {
	            	choice = sc.nextInt();
	            	if(choice < 0 || choice > 2)
	            		System.out.printf("Not valid number, try again.\n");
	            }while (choice < 0 || choice > 2);
	            nbBalls[1] = choice;
	            
	            System.out.printf("How many goldenSnitch do you want?\n"+
		   				 "\t 0 or 1 ? \n");
	            do  {
	            	choice = sc.nextInt();
	            	if(choice < 0 || choice > 1)
	            		System.out.printf("Not valid number, try again.\n");
	            }while (choice < 0 || choice > 1);
	            nbBalls[2] = choice;
	           
	} catch(Exception e){
		throw new RuntimeException("Error.\nYou need to Enter a number");
	}
		 return nbBalls;
	}
	
	//Donne le choix au joueur de sa couleur(equipe) entre Gryffondor / Poufsouffle / Serdaigle / Serpentard
	public static Joueur[] initPlayer(Scanner sc){
		Joueur[] player = new Joueur[2];
		int otherTeam = 0;
		String name;
		int team ;
		try{
			for (int i = 0 ; i < 2; i++) {
				System.out.println("Player " + (i+1) + " : \nEnter your Name : \n");
				name = sc.nextLine();
				System.out.println("Player "+ (i+1) + " : " + name + "\n");
				team = chooseTeam(sc, otherTeam);
				sc.nextLine(); //this line consume the \n, otherwise the 2nd name can't have an input
				otherTeam = team;
				
				if (team == 1)
					player[i] = new Joueur(name, i, Color.red);
				else if (team == 2)
					player[i] = new Joueur(name, i, Color.blue);
				else if (team == 3)
					player[i] = new Joueur(name, i, Color.yellow);
				else if (team == 4)
					player[i] = new Joueur(name, i, Color.green);
				else
					throw new RuntimeException("Error.\n");
			}
		
	   	} catch(Exception e){
	   		throw new RuntimeException("Error.\nYou need to Enter a string");
	    }
		
		return player;
	}
	
	public static int chooseTeam(Scanner sc, int otherTeam) {
		System.out.printf("Which team do you want to join? \n"+
				 "\t1. Gryffindor (red)\n"+
	    		 "\t2. Hufflepuff (blue)\n"+
	    		 "\t3. Ravenclaw (yellow)\n"+
	    		 "\t4. Slytherin (green)\n");
		 try{
	            int choice = sc.nextInt();
	            if (choice <  1 || choice > 4) {
	            	System.out.printf("Not valid number, try again.\n");
	            	return chooseTeam(sc, otherTeam);
	            }else if (choice == otherTeam) {
	            	System.out.printf("You can't pick the same color , pick another one.\n");
	            	return chooseTeam(sc, otherTeam);
	            }
	            else
	            	return choice;
	        } catch(Exception e){
	            throw new RuntimeException("Error.\nYou need to Enter a number");
	        }
	}
	//menu de depart 
	public static int start(Scanner sc){
        System.out.printf("What do you want to do ? \n"+
        		"\t1. Start Quiddich Tournament !\n"+
        		"\t2. Information\n"+
        		"\t3. Quit\n");
        //try/catch affiche un message d'erreur si un int n'est pas rentré dans ligne de commande
        try{
            int choice = sc.nextInt();
            if (choice == 2){
                info(sc);
                start(sc);
            }
            return choice;
        } catch(Exception e){
            throw new RuntimeException("Error.\nYou need to Enter a number");
        }
    }
	
	//menu d'information
	public static void info(Scanner sc){
        System.out.printf("Which information do you want?\n"+
        		"\t1. Game\n"+
        		"\t2. Teams\n" +
        		"\t3. Balls\n"+
        		"\t4. Quit\n");
        //try/catch affiche un message d'erreur si un int n'est pas rentré dans ligne de commande
        try{
            int choice = sc.nextInt();
            if (choice == 1) {
                Information.jeu();
            	Information.field();
            } else if (choice == 2)
            	detailTeams(sc);
            else if (choice == 3)
                detailBalls(sc);
            else
                return;
        } catch(Exception e){
            throw new RuntimeException("Error.\nYou need to Enter a number");
        }
    }

	private static void detailBalls(Scanner sc) {
		 Information.balls();
	     System.out.printf("Which Ball information do you want?\n"+
	    		 "\t1. Quaffles\n"+
	    		 "\t2. Bludgers\n"+
	    		 "\t3. GoldenSnitch\n"+
	    		 "\t4. Quit\n");
	        //try/catch affiche un message d'erreur si un int n'est pas rentré dans ligne de commande
	     try{
	    	 int choice = sc.nextInt();
	    	 if (choice == 1)
	    		 Information.quaffles();
	         else if (choice == 2)
	         	Information.bludgers();
	         else if (choice == 2)
	        	 Information.goldenSnitch();
	         else
	        	 return;
	        } catch(Exception e){
	            throw new RuntimeException("Error.\nYou need to Enter a number");
	        }
	}

	private static void detailTeams(Scanner sc) {
		 Information.teams();
	     System.out.printf("Which Team information do you want?\n"+
	    		 "\t1. Gryffindor\n"+
	    		 "\t2. Hufflepuff\n"+
	    		 "\t3. Ravenclaw\n"+
	    		 "\t4. Slytherin\n"+
	    		 "\t5. Quit\n");
	        //try/catch affiche un message d'erreur si un int n'est pas rentré dans ligne de commande
	     try{
	    	 int choice = sc.nextInt();
	    	 if (choice == 1)
	    		 Information.gryffindor();
	         else if (choice == 2)
	         	Information.hufflepuff();
	         else if (choice == 2)
	        	 Information.ravenclaw();
	         else if (choice == 2)
	        	 Information.slytherin();
	         else
	        	 return;
	        } catch(Exception e){
	            throw new RuntimeException("Error.\nYou need to Enter a number");
	        }
		
	}
//	public static void showWindow() {
//		   JFrame frame = new JFrame("Quidditch Tournament");  
//	       JPanel panel = new JPanel();  
//	       panel.setLayout(new FlowLayout());  
//	       JLabel label = new JLabel("Do you want to play Quidditch?");  
//	       JButton button = new JButton();
//	       ImageIcon test = new ImageIcon("Image/start.jpg");
////	       JLabel image = new JLabel(test);
//	       button.setText("Start");  
//	       panel.add(label);  
//	       panel.add(button);  
//	       frame.add(panel); 
//	     //  frame.add(test);
//	       frame.setSize(1000, 500);  
//	       frame.setLocationRelativeTo(null);  
//	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//	       frame.setVisible(true);  
//	   
//	}
}
