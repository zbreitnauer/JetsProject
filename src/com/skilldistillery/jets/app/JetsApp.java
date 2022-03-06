package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImpl;

public class JetsApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		JetsApp jet = new JetsApp();
		AirField air = new AirField();

		jet.makeAirfield(air);
		ArrayList<Jet> jetList = air.getJetList();

		jet.printMenu(kb, air, jetList);
	}

	public void makeAirfield(AirField air) {
		air.fillHangar();
	}

	public void printMenu(Scanner kb, AirField air, ArrayList<Jet> jetList) {
		while (true) {
			System.out.println("-----TOP GUN-----");
			System.out.println();
			System.out.println("1. List Fleets");
			System.out.println("2. Fly All Jets");
			System.out.println("3. Fastest Jet");
			System.out.println("4. Longest Range");
			System.out.println("5. Load Up Cargo");
			System.out.println("6. Dog Fight");
			System.out.println("7. Add A Jet");
			System.out.println("8. Remove A Jet");
			System.out.println("9. Quit");
			System.out.println();
			System.out.println("Talk To Me Goose. What Do You Want To Do? ( 1 - 9 )");

			int choice = kb.nextInt();

			switch (choice) {

			case 1:
				for (Jet obj : jetList) {
					System.out.println(obj);
				}
				System.out.println();
				break;
			case 2:
				air.flyAllJets();
				System.out.println();
				break;
			case 3:
				double topSpeed = 0.0;
				int atIndex = 0;

				if (jetList.size() != 0) {
					for (int i = 0; i < jetList.size(); i++) {
						if (jetList.get(i).getSpeed() > topSpeed) {

							atIndex = i;
							topSpeed = jetList.get(i).getSpeed();
						}
					}
				} else {
					System.out.println("No Planes In Hangar.");
				}

				System.out.println("Fastest Plane: " + jetList.get(atIndex) + " " + topSpeed);
				System.out.println();
				break;
			case 4:
				int longestRange = 0;
				int indexer = 0;
				if (jetList.size() != 0) {
					for (int i = 0; i < jetList.size(); i++) {
						if (jetList.get(i).getRange() > longestRange) {

							longestRange = jetList.get(indexer).getRange();
							indexer = i;
						}
					}
				}
				System.out.println("Longest Range: " + jetList.get(indexer) + " " + longestRange);
				System.out.println();
				break;
			case 5:
				for (Jet load : jetList) {
					if (load instanceof CargoPlane) {
						((CargoPlane) load).loadCargo();
					}
				}
				break;
			case 6:
				for (Jet fighting : jetList) {
					if (fighting instanceof FighterJet) {
						((FighterJet) fighting).fight();
					}
				}
				System.out.println();
				break;

			case 7:
				String model = "";
				int speed = 0;
				int range = 0;
				double price = 0;

				System.out.println("Input Model:");
				model = kb.next();
				System.out.println("Input Speed:");
				speed = kb.nextInt();
				System.out.println("Input Range:");
				range = kb.nextInt();
				System.out.println("Input Price:");
				price = kb.nextDouble();

				System.out.println("What Class Does It Belong To?");
				System.out.println("1. CargoPlane");
				System.out.println("2. FighterJet");
				System.out.println("3. JetImpl");

				int selector = kb.nextInt();
				kb.nextLine();

				switch (selector) {
				case 1:
					Jet cargoCreator = new CargoPlane(model, speed, range, price);
					jetList.add(cargoCreator);
					break;

				case 2:
					Jet fighterCreator = new FighterJet(model, speed, range, price);
					jetList.add(fighterCreator);
					break;

				case 3:
					Jet jetImplementor = new JetImpl(model, speed, range, price);
					jetList.add(jetImplementor);
					break;

				default:
					System.err.println("ERROR");
					break;

				}
				for (Jet obj : jetList) {
					System.out.println(obj);
				}
				System.out.println();
				break;

			case 8:
				for (Jet obj : jetList) {
					System.out.println(obj);
				}
				System.out.println();
				System.out.println("Remove A Jet Using Nums.");

				int type;
			
				type = kb.nextInt();
				jetList.remove(type - 1);

				
				break;
			case 9:
				System.out.println("LATER GOOSE");
				return;

			default:
				System.err.println("ERROR!");
				System.out.println();
				printMenu(kb, air, jetList);
				break;
			}
		}

	}

	}