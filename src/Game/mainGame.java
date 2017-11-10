package Game;

import java.util.ArrayList;
import java.util.Scanner;

public class mainGame {
	
	public static void main (String [] args){
		int Turn = 1;
		
		ArrayList<Card> Deck1= new ArrayList();
		Deck1.add(new Card ("Dragon    ",5,3, Turn));
		Deck1.add(new Card ("Golbin    ",1,4, Turn));
		Deck1.add(new Card ("Swordsman ",3,3, Turn));
		Deck1.add(new Card ("Shield    ",0,9, Turn));
		Deck1.add(new Card ("Imp       ",1,1, Turn));
		Deck1.add(new Card ("Archer    ",2,1, Turn));
		Deck1.add(new Card ("Warrior   ",4,4, Turn));
		Deck1.add(new Card ("Troll     ",3,2, Turn));
		Deck1.add(new Card ("Mage      ",5,1, Turn));
		Deck1.add(new Card ("Ghoul     ",3,1, Turn));
		Deck1.add(new Card ("Warlock   ",5,3, Turn));
		Deck1.add(new Card ("Elf       ",1,4, Turn));
		Deck1.add(new Card ("Giant     ",3,3, Turn));
		Deck1.add(new Card ("Genius    ",1,9, Turn));
		Deck1.add(new Card ("Berserker ",6,7, Turn));
		Deck1.add(new Card ("Clown     ",2,1, Turn));
		Deck1.add(new Card ("Joker     ",4,4, Turn));
		Deck1.add(new Card ("Priest    ",1,2, Turn));
		Deck1.add(new Card ("Wolf      ",5,1, Turn));
		Deck1.add(new Card ("Lion      ",3,1, Turn));
		
		ArrayList<Card> Deck2= new ArrayList();
		Deck2.add(new Card ("Dragon    ",5,3,Turn));
		Deck2.add(new Card ("Golbin    ",1,4,Turn));
		Deck2.add(new Card ("Swordsman ",3,3,Turn));
		Deck2.add(new Card ("Shield    ",0,9,Turn));
		Deck2.add(new Card ("Imp       ",1,1,Turn));
		Deck2.add(new Card ("Archer    ",2,1,Turn));
		Deck2.add(new Card ("Warrior   ",4,4,Turn));
		Deck2.add(new Card ("Troll     ",3,2,Turn));
		Deck2.add(new Card ("Mage      ",5,1,Turn));
		Deck2.add(new Card ("Ghoul     ",3,1,Turn));
		Deck2.add(new Card ("Warlock   ",5,3,Turn));
		Deck2.add(new Card ("Elf       ",1,4,Turn));
		Deck2.add(new Card ("Giant     ",3,3,Turn));
		Deck2.add(new Card ("Genius    ",1,9,Turn));
		Deck2.add(new Card ("Berserker ",6,7,Turn));
		Deck2.add(new Card ("Clown     ",2,1,Turn));
		Deck2.add(new Card ("Joker     ",4,4,Turn));
		Deck2.add(new Card ("Priest    ",1,2,Turn));
		Deck2.add(new Card ("Wolf      ",5,1,Turn)); // Deck2.get(0).setHealth(Deck2.get(0).getHealth() - 1);
		Deck2.add(new Card ("Lion      ",3,1,Turn)); // Deck2.get(0).decreaseCardHealthByOne();
		
		
								
		Scanner keyStroke = new Scanner (System.in);
		String startGame, playerMove, field;
		int cardChosen;
		System.out.println("Welcome to J-Cards! \nAre you ready to play? (Press Enter)");
		startGame = keyStroke.nextLine();
		
		
		ArrayList<Card> player1Field =  new ArrayList();
		ArrayList<Card> player2Field= new ArrayList();
		int player1LP, player2LP;
		player1LP = 10;
		player2LP = 10;
	
		cardGen cardNumber;
		
		cardNumber = new cardGen();
		
		ArrayList<Card> player1Hand =  new ArrayList();
		ArrayList<Card> player2Hand = new ArrayList();
		
		for(int i = 0; i < 4; i++) {
			int r = cardNumber.Number(Deck1.size());
			player1Hand.add(Deck1.get(r));
			Deck1.remove(r);
		}
		for(int i = 0; i < 4; i++) {
			int r = cardNumber.Number(Deck2.size());
			player2Hand.add(Deck2.get(r));
			Deck2.remove(r);
		}
		
		int opponentCard, yourCard;
		do{
			System.out.println("\n   Player One HP :" + player1LP + Field(player1Field, player2Field) + "\n    Player Two HP :" + player2LP);
			System.out.println("\nTurn " + Turn
					+ "\n*Player One draws new cards* "
					+ "\nPlayer One, What is your move?"
					+ "\nA)Summon Card"
					+ "\nB)Attack"
					+ "\nC)End Turn");
			playerMove = keyStroke.next();
			
			if (!playerMove.equalsIgnoreCase("A")&&!playerMove.equalsIgnoreCase("b")&&!playerMove.equalsIgnoreCase("C")){
				while(!playerMove.equalsIgnoreCase("A")&&!playerMove.equalsIgnoreCase("B")&&!playerMove.equalsIgnoreCase("C")){
					System.out.println("I'm sorry, " + playerMove + " is not a valid move. Please try again.");
					playerMove = keyStroke.next();
					
				}
			}
			
			if(playerMove.equalsIgnoreCase("A")){
				for(int i = 0; i < 1; i++) {
					int r = cardNumber.Number(Deck1.size());
					player1Hand.add(Deck1.get(r));
					Deck1.remove(r);
				}
				System.out.println("Which Card would you like to summon?");
				System.out.println(displayCard(player1Hand));
				
				cardChosen = keyStroke.nextInt();
				
				if (cardChosen != 1 &&cardChosen != 2 &&cardChosen != 3&&cardChosen != 4&&cardChosen != 5){
					do{
						System.out.println("I'm sorry, " + playerMove + " is not a valid card. Please try again.");
						cardChosen = keyStroke.nextInt();
						
					}while(cardChosen != 1 &&cardChosen != 2 &&cardChosen != 3&&cardChosen != 4&&cardChosen != 5);
				}
				for (int i = 0; i<5; i++){
					if (cardChosen == i ){
					player1Field.add(player1Hand.get(i-1));
					
					player1Hand.remove(i-1);
					}
				}
				
			}
		
			System.out.println("\n   Player One HP :" + player1LP + Field(player1Field, player2Field) + "\n   Player Two HP :" + player2LP);
			System.out.println("\nTurn " + Turn
					+ "\nPlayer One, What would you like to do next?"
					+ "\nA)Summon Card (Only one per Turn)" 
					+ "\nB)Attack"
					+ "\nC)End Turn");
			
			playerMove = keyStroke.next();
			
			if (!playerMove.equalsIgnoreCase("B")&&!playerMove.equalsIgnoreCase("C")){
				while(!playerMove.equalsIgnoreCase("B")&&!playerMove.equalsIgnoreCase("C")){
					System.out.println("I'm sorry, " + playerMove + " is not a valid move. Please try again.");
					playerMove = keyStroke.next();
				}
			}
			if(playerMove.equalsIgnoreCase("B")){
				if(player1Field.size()>0){
					System.out.println(player1Side(player1Field) + "\n Which card would you like to attack with?");
					cardChosen = keyStroke.nextInt();
					
					if (player1Field.get(cardChosen-1).getTurnPlayed() != Turn){
						while(player1Field.get(cardChosen-1).getTurnPlayed() != Turn){
							System.out.println("That is not a valid card number. Enter Another Card");
							cardChosen = keyStroke.nextInt();
						}
					}
					if(cardChosen > player1Field.size()){
						while(cardChosen > player1Field.size()){
							System.out.println("That is not a valid card number. Enter Another Card");
							cardChosen = keyStroke.nextInt();
						}
					}
					
					
					yourCard = cardChosen-1;
					System.out.println(player2Side(player2Field)+ "\n\nWhich card would you like to attack with your " + player1Field.get(yourCard).getCardName());
					cardChosen = keyStroke.nextInt();
					//next line is wrong fix it
					if (player2Field.size() < cardChosen){
						while(player2Field.size() < cardChosen){
							System.out.println("That is not a valid card number. Enter Another Card");
							cardChosen = keyStroke.nextInt();
						}
					}
					
					opponentCard = cardChosen-1;
					
					System.out.println(displayAttack(player1Field.get(yourCard),player2Field.get(opponentCard)));
					player1Field.get(yourCard).setCardHealth(player1Field.get(yourCard).getCardHealth() - player2Field.get(opponentCard).getCardAttack());
					player2Field.get(opponentCard).setCardHealth(player2Field.get(opponentCard).getCardHealth() - player1Field.get(yourCard).getCardAttack());
					
					if (player1Field.get(yourCard).getCardHealth() <=0){
						System.out.println("Player One's " + player1Field.get(yourCard).getCardName().trim() + " has been destroyed");
						player1Field.remove(yourCard);
					}
					if (player2Field.get(opponentCard).getCardHealth() <=0){
						System.out.println("Player Two's " + player2Field.get(opponentCard).getCardName().trim() + " has been destroyed");
						player2Field.remove(opponentCard);
					}
					
				}
				else{
					System.out.println("You  have no cards summoned on the field!");
				}
			
			}while(!playerMove.equalsIgnoreCase("C"));
			
			
			System.out.println("Player One has ended their turn");
			
			//Start Player 2 Turn
			System.out.println("\n   Player One HP :" + player1LP + Field(player1Field, player2Field) + "\n    Player Two HP :" + player2LP);
			System.out.println("\nTurn " + Turn
					+ "\n*Player Two draws new cards* "
					+ "\nPlayer Two, What is your move?"
					+ "\nA)Summon Card"
					+ "\nB)Attack"
					+ "\nC)End Turn");
			playerMove = keyStroke.next();
			
			if (!playerMove.equalsIgnoreCase("A")&&!playerMove.equalsIgnoreCase("b")&&!playerMove.equalsIgnoreCase("C")){
				while(!playerMove.equalsIgnoreCase("A")&&!playerMove.equalsIgnoreCase("B")&&!playerMove.equalsIgnoreCase("C")){
					System.out.println("I'm sorry, " + playerMove + " is not a valid move. Please try again.");
					playerMove = keyStroke.next();
					
				}
			}
			
			if(playerMove.equalsIgnoreCase("A")){
				for(int i = 0; i < 1; i++) {
					int r = cardNumber.Number(Deck2.size());
					player2Hand.add(Deck2.get(r));
					Deck2.remove(r);
				}
				System.out.println("Which Card would you like to summon?");
				System.out.println(displayCard(player2Hand));
				
				cardChosen = keyStroke.nextInt();
				
				if (cardChosen != 1 &&cardChosen != 2 &&cardChosen != 3&&cardChosen != 4&&cardChosen != 5){
					do{
						System.out.println("I'm sorry, " + playerMove + " is not a valid card. Please try again.");
						cardChosen = keyStroke.nextInt();
						
					}while(cardChosen != 1 &&cardChosen != 2 &&cardChosen != 3&&cardChosen != 4&&cardChosen != 5);
				}
				for (int i = 0; i<5; i++){
					if (cardChosen == i ){
					player2Field.add(player2Hand.get(i-1));
					
					player2Hand.remove(i-1);
					}
				}
				
			}
		
			System.out.println("\n   Player One HP :" + player1LP + Field(player1Field, player2Field) + "\n   Player Two HP :" + player2LP);
			System.out.println("\nTurn " + Turn
					+ "\nPlayer Two, What would you like to do next?"
					+ "\nA)Summon Card (Only one per Turn)" 
					+ "\nB)Attack"
					+ "\nC)End Turn");
			
			playerMove = keyStroke.next();
			
			if (!playerMove.equalsIgnoreCase("B")&&!playerMove.equalsIgnoreCase("C")){
				while(!playerMove.equalsIgnoreCase("B")&&!playerMove.equalsIgnoreCase("C")){
					System.out.println("I'm sorry, " + playerMove + " is not a valid move. Please try again.");
					playerMove = keyStroke.next();
				}
			}
			else if(playerMove.equalsIgnoreCase("B")){
				if(player2Field.size()>0){
					System.out.println(player2Side(player2Field) + "\n Which card would you like to attack with?");
					cardChosen = keyStroke.nextInt();
					if(cardChosen > player2Field.size()){
						while(cardChosen > player2Field.size()){
							System.out.println("That is not a valid card number. Enter Another Card");
							cardChosen = keyStroke.nextInt();
						}
					}
					if (player2Field.get(cardChosen-1).getTurnPlayed() != Turn){
						while(player2Field.get(cardChosen-1).getTurnPlayed() != Turn){
							System.out.println("That is not a valid card number. Enter Another Card");
							cardChosen = keyStroke.nextInt();
						}
					}
					
					yourCard = cardChosen;
					System.out.println(player1Side(player1Field)+ "\n\nWhich card would you like to attack with your " + player2Field.get(yourCard-1).getCardName());
					cardChosen = keyStroke.nextInt();
					if (player1Field.size() < cardChosen){
						while(player1Field.size() < cardChosen){
							System.out.println("That is not a valid card number. Enter Another Card");
							cardChosen = keyStroke.nextInt();
						}
					}
					
					opponentCard = cardChosen;
					
					System.out.println(displayAttack(player2Field.get(yourCard),player1Field.get(opponentCard)));
					
				}
				else{
					System.out.println("You  have no cards summoned on the field!");
				}
			
			}while(!playerMove.equalsIgnoreCase("C"));
			
			
			System.out.println("Player Two has ended their turn");
			
			Turn++;
			
		}while (player1LP >= 0 || player2LP >= 0);
			
		System.out.println("Good Game");
	}
	
	public static String displayCard(ArrayList <Card> hand){
		String display = "\n";
		int s = hand.size();
		for (int i = 0; i < s; i++) {
			display += "      " + (i + 1) + "     ";
		}
		display += "\n";
		
		for (int i = 0; i < s; i++) {
			display += " __________ ";
		}
		display += "\n";
		
		for (int i = 0; i < s; i++) {
			display += "|" + hand.get(i).getCardName() + "|";
		}
		display += "\n";
		
		for (int i = 0; i < s; i++) {
			display += "|          |";
		}
		display += "\n";
		for (int i = 0; i < s; i++) {
			display += "|A       HP|";
		}
		display += "\n";
		for (int i = 0; i < s; i++) {
			display += "|" + hand.get(i).getCardAttack() +"        "+ hand.get(i).getCardHealth() + "|";
		}
		display += "\n";
		for (int i = 0; i < s; i++) {
			display += "|__________|";
		}
		display += "\n";
		
		return display;
		
	}
	
	public static String Field(ArrayList <Card> oneSummoned,ArrayList <Card> twoSummoned ){
		String field;
		field = "\n";
		
		for (int i = 0 ; i<5 ; i++){
			field+= " ___";
		}
		field+= "\n";
		
		for (int i = 0 ; i<5 ; i++){
			if (i< oneSummoned.size() )
				field += ("|" + oneSummoned.get(i).getCardName().substring(0,1) + "  ");
			else
				field+= "|   ";
		}
		field+= "|\n";
		
		for (int i = 0 ; i<5 ; i++){
			field+= "|___";
		}
		field+= "|\n";
		
		for (int i = 0 ; i<5 ; i++){
			if (i< twoSummoned.size() )
				field += ("|" + twoSummoned.get(i).getCardName().substring(0,1) + "  ");
			else
				field+= "|   ";
		}
		field+= "|\n";
		
		for (int i = 0 ; i<5 ; i++){
			field+= "|___";
		}
		field+= "|\n";
		return field;
		
	}
	
	public static String player1Side(ArrayList <Card> oneSummoned){
		String player1Side;
		player1Side = "\n";
		for (int i = 0; i <5; i++) {
			player1Side += "     " + (i + 1) + "     ";
		}
		player1Side += "\n";
		for (int i = 0 ; i<5 ; i++){
			player1Side+= " __________";
		}
		player1Side+= "\n";
		
		for (int i = 0 ; i<5 ; i++){
			if (i< oneSummoned.size() )
				player1Side += ("|" + oneSummoned.get(i).getCardName());
			else
				player1Side+= "|          ";
		}
		player1Side+= "|\n";
		for (int i  = 0; i<5; i++){
			player1Side+= "|          ";
		}
		player1Side +="|\n";
		for (int i = 0; i <5; i++) {
			if(i < oneSummoned.size()){
				player1Side += "|A       HP";
			}
			else{
				player1Side += "|          ";
			}
		}
		player1Side += "|\n";
		for (int i = 0; i <5; i++) {
			if(i < oneSummoned.size()){
				player1Side += "|" + oneSummoned.get(i).getCardAttack() +"        "+ oneSummoned.get(i).getCardHealth() ;
			}
			else{
				player1Side += "|          ";
			}
		}
		player1Side += "|\n";
		for (int i = 0 ; i<5 ; i++){
			player1Side+= "|__________";
		}
		player1Side+= "|\n";
		
		return player1Side;
	}
	public static String player2Side(ArrayList <Card> twoSummoned){
		String player2Side;
		player2Side = "\n";
		for (int i = 0; i<5; i++){
			player2Side+= "     " + (i + 1) + "     ";
		}
		player2Side+= "\n";
		for (int i = 0 ; i<5 ; i++){
			player2Side+= " __________";
		}
		player2Side+= "\n";
		
		for (int i = 0 ; i<5 ; i++){
			if (i< twoSummoned.size() )
				player2Side += ("|" + twoSummoned.get(i).getCardName());
			else
				player2Side+= "|          ";
		}
		player2Side+= "|\n";
		for (int i  = 0; i<5; i++){
			player2Side+= "|          ";
		}
		player2Side +="|\n";
		for (int i = 0; i <5; i++) {
			if(i < twoSummoned.size()){
				player2Side += "|A       HP";
			}
			else{
				player2Side += "|          ";
			}
		}
		player2Side += "|\n";
		for (int i = 0; i <5; i++) {
			if(i < twoSummoned.size()){
				player2Side += "|" + twoSummoned.get(i).getCardAttack() +"        "+ twoSummoned.get(i).getCardHealth() ;
			}
			else{
				player2Side += "|          ";
			}
		}
		player2Side += "|\n";
		for (int i = 0 ; i<5 ; i++){
			player2Side+= "|__________";
		}
		player2Side+= "|\n";
		
		return player2Side;
	}
	public static String displayAttack(Card Attacker, Card Defender){
		String displayAttack = "\n";
		System.out.println( " __________ "
						+ "\n|"+Defender.getCardName()+"|"
						+ "\n|          |"
						+ "\n|A       HP|         Their Card"
						+ "\n|"+Defender.getCardAttack() +"        "+ Defender.getCardHealth()+"|"
						+ "\n|__________|");
		System.out.println( " __________ "
						+ "\n|"+Attacker.getCardName()+"|"
						+ "\n|          |"
						+ "\n|A       HP|          Your Card"
						+ "\n|"+Attacker.getCardAttack() +"        "+ Attacker.getCardHealth()+"|"
						+ "\n|__________|");
		return displayAttack;
		
	}
}