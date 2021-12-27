package shield.main;

import java.util.List;

import shield.avenger.Avenger;
import shield.avenger.mission.Mission;

public class Validation {

	public static boolean isAvengerNameExistsAndAvailable(String avengers) {
		if (avengers.trim().isEmpty())
			System.err.println("Atleast one avenger needs to be assign.");
		String avengersArr[] = avengers.split(",");
		if (avengersArr.length > 2) {
			System.err.println("Can not assign more than two avengers on any mission.");
			return false;
		}
		for (String avenger : avengersArr) {
			if (!Avenger.team.contains(avenger.trim().toUpperCase())) {
				System.err.println("Sorry, " + avenger + " does not exist.");
				return false;
			}
			if (Avenger.getAvenger(avenger.trim().toUpperCase()).getCurrentMissions().size() == 2) {
				System.err.println("Sorry, " + avenger + " has already been working on two missions.");
				return false;
			}
		}
		return true;
	}

	public static boolean isAvengerNameExists(String avengerName) {
		if (!Avenger.team.contains(avengerName)) {
			System.out.println("Sorry, " + avengerName + " does not exist.");
			return false;
		}
		return true;
	}

	public static boolean checkMissionAvailability(Mission mission) {
		List<Avenger> avengers = mission.getAvengers();
		if (avengers.size() == 2) {
			String errorMessage = avengers.get(0).getAvengerName() + " and " + avengers.get(1).getAvengerName()
					+ " are already working on this mission.";
			System.err.println(errorMessage);
			return false;
		}
		return true;
	}

	public static boolean checkAvengerAvailability(Avenger avenger) {
		List<Mission> missions = avenger.getCurrentMissions();
		if (missions.size() == 2) {
			String errorMessage = avenger.getAvengerName() + " is already working on two missions.";
			System.err.println(errorMessage);
			return false;
		}
		return true;
	}
}
