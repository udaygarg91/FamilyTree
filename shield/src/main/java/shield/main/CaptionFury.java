package shield.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import shield.avenger.Avenger;
import shield.avenger.mission.Mission;
import shield.avenger.mission.MissionStatus;
import shield.avenger.mission.notification.Notification;

public class CaptionFury {

	public static Map<String, Mission> missions = new HashMap<>();

	/**
	 * Option1 Print details of all the missions.
	 */
	public static void checkTheMissions() {
		if (missions.isEmpty()) {
			System.out.println("No Mission has been assigned to an Avenger.");
			return;
		}
		System.out.format("%-40s | %-15s | %-20s\n", "Mission Name", "Status", "Avengers");
		for (String missionName : missions.keySet()) {
			String avengers = missions.get(missionName).getAvengers().stream().map(e -> e.getAvengerName())
					.collect(Collectors.toList()).toString();
			System.out.format("%-40s | %-15s | %-20s\n", missionName, missions.get(missionName).getStatus().toString(),
					avengers.substring(1, avengers.length() - 1));
		}
	}

	/**
	 * Option2 assign mission to Avengers
	 * 
	 * @param avengers
	 * @param missionName
	 * @param missionDetails
	 */
	public static void assignMissionToAvengers(String avengers, String missionName, String missionDetails) {
		if (Validation.isAvengerNameExistsAndAvailable(avengers)) {
			Mission mission = null;
			if (missions.containsKey(missionName)) {
				mission = missions.get(missionName);
				mission.setDetails(missionDetails);
			} else
				mission = new Mission(missionName, missionDetails);
			if (mission.getAvengers().size() + avengers.split(",").length > 2) {
				System.out.println("Can not assign more than two Avengers.");
				return;
			}
			List<Avenger> avengerList = mission.getAvengers();
			for (String avengerName : avengers.split(",")) {
				Avenger avenger = updateAvengerStatus(avengerName.trim().toUpperCase(), mission);
				if (!avengerList.contains(avenger))
					avengerList.add(avenger);
			}
			mission.setAvengers(avengerList);
			missions.put(missionName.trim(), mission);
			System.out.println("Mission has been assigned.");
			for (Avenger avenger : avengerList) {
				Notification.getInstance(avenger.getNotificationMedium()).notifyAvenger(avenger, mission);
			}
		}
	}

	/**
	 * Option3 check mission details
	 * 
	 * @param missionName
	 */
	public static void checkMissionDetails(String missionName) {
		Mission mission = missions.get(missionName);
		if (mission != null) {
			System.out.println("Mission Details: " + mission.getDetails());
			System.out.println("Mission Status: " + mission.getStatus());
			StringBuilder avengers = new StringBuilder();
			for (Avenger avenger : mission.getAvengers()) {
				avengers.append(avenger.getAvengerName() + ", ");
			}
			avengers.substring(0, avengers.length() - 2);
			System.out.println("Avengers: " + avengers.substring(0, avengers.length() - 2));
		}
	}

	/**
	 * option 4 check Avenger details
	 * 
	 * @param avengerName
	 */
	public static void checkAvengerDetails(String avengerName) {
		if (Validation.isAvengerNameExists(avengerName.toUpperCase())) {
			Avenger avenger = Avenger.getAvenger(avengerName.toUpperCase());
			System.out.println("Person Name: " + avenger.getPersonName());
			System.out.println("Abilities: " + avenger.getAbilities());
			System.out.println("Mission Assigned: " + avenger.getMissionAssigned());
			System.out.println("Mission Completed :" + avenger.getMissionCompleted());
		}
	}

	/**
	 * option 5 update mission status
	 * 
	 * @param missionName
	 * @param status
	 */
	public static void updateMissionStatus(String missionName, String status) {
		if (!missions.containsKey(missionName)) {
			System.out.println(missionName + " not found");
			return;
		}
		Mission mission = missions.get(missionName);
		// Mission status can be changed from assigned to completed
		if (!mission.getStatus().equals(MissionStatus.Completed)) {
			mission.setStatus(MissionStatus.valueOf(status));
			for (Avenger avenger : mission.getAvengers()) {
				avenger.getCurrentMissions().remove(mission);
				avenger.setMissionCompleted(1);
				Notification.getInstance(avenger.getNotificationMedium()).notifyAvenger(avenger, mission);
			}
		} else {
			System.out.println("This mission is already completed");
		}
	}

	/**
	 * option 6 list Avengers
	 */
	public static void listAvengers() {
		System.out.format("%-20s | %-20s | %-20s\n", "Avenger Name", "Status", "Assigned Mission");
		for (String avengerName : Avenger.team) {
			Avenger avenger = Avenger.getAvenger(avengerName);
			avengerName = avenger.getAvengerName();
			String status = avenger.getAvailabilityStatus();
			String missions = avenger.getCurrentMissions().stream().map(e -> e.getName()).collect(Collectors.toList())
					.toString();
			System.out.format("%-20s | %-20s | %-20s\n", avengerName, status,
					missions.substring(1, missions.length() - 1));
		}
	}

	/**
	 * option 7 assign avenger to mission
	 * 
	 * @param avengerName
	 * @param missionName
	 */
	public static void assignAvengerToMission(String avengerName, String missionName) {
		Avenger avenger = Avenger.getAvenger(avengerName.toUpperCase());
		Mission mission = missions.get(missionName);
		if (Validation.checkAvengerAvailability(avenger) && Validation.checkMissionAvailability(mission)) {
			List<Avenger> avengerList = mission.getAvengers();
			Avenger assignedAvenger = updateAvengerStatus(avengerName, mission);
			if (!avengerList.contains(assignedAvenger))
				avengerList.add(assignedAvenger);
			mission.setAvengers(avengerList);
		}
	}

	private static Avenger updateAvengerStatus(String avengerName, Mission mission) {
		Avenger avenger = Avenger.getAvenger(avengerName);
		avenger.setCurrentMissions(mission);
		return avenger;
	}

}
