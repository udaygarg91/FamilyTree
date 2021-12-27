package shield.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Driver {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Check the missions\r\n" + "2. Assign mission to Avengers\r\n"
				+ "3. Check mission’s details\r\n" + "4. Check Avenger’s details\r\n" + "5. Update Mission’s status\r\n"
				+ "6. List Avengers\r\n" + "7. Assign avenger to mission.\r\n" + "");
		while (true) {
			System.out.print("Enter the option: ");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				CaptionFury.checkTheMissions();
				break;
			case 2:
				System.out.print("Enter Avengers: ");
				String avengers = reader.readLine().trim();
				System.out.print("Enter Mission Name: ");
				String missionName = reader.readLine().trim();
				System.out.print("Enter Mission Details: ");
				String missionDetails = reader.readLine();
				CaptionFury.assignMissionToAvengers(avengers, missionName, missionDetails);
				break;
			case 3:
				System.out.println("Enter Mission Name: ");
				String missionName1 = reader.readLine().trim();
				CaptionFury.checkMissionDetails(missionName1);
				break;
			case 4:
				System.out.println("Enter Avenger Name: ");
				String avengerName = reader.readLine().trim();
				CaptionFury.checkAvengerDetails(avengerName);
				break;
			case 5:
				System.out.println("Enter Mission Name:");
				String missionName2 = reader.readLine().trim();
				System.out.println("Enter new status: ");
				String status = reader.readLine().trim();
				CaptionFury.updateMissionStatus(missionName2, status);
				break;
			case 6:
				CaptionFury.listAvengers();
				break;
			case 7:
				System.out.println("Enter Avenger Name:");
				String avengerName1 = reader.readLine().trim();
				System.out.println("Enter Mission Name:");
				String missionName3 = reader.readLine().trim();
				CaptionFury.assignAvengerToMission(avengerName1, missionName3);
				break;
			default:
				System.out.println("Select a valid option");
				break;
			}
		}
	}
}
