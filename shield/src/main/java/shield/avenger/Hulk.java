package shield.avenger;

import java.util.ArrayList;
import java.util.List;

import shield.avenger.mission.Mission;
import shield.avenger.mission.notification.NotificationEnum;

public class Hulk implements Avenger {

	final String avengerName = "Hulk";
	private final String personName = "Robert Bruce Banner";
	private final String abilities = "Incredible superhuman strength, durability, and healing factor";
	private int missionAssigned;
	private int missionCompleted;
	List<Mission> currentMissions = new ArrayList<>();
	NotificationEnum notificationMedium = NotificationEnum.PAGER;
	String availabilityStatus = "Available";

	public String getAvengerName() {
		return avengerName;
	}
	
	public String getPersonName() {
		return personName;
	}

	public String getAbilities() {
		return abilities;
	}

	public int getMissionAssigned() {
		return missionAssigned;
	}

	public int getMissionCompleted() {
		return missionCompleted;
	}

	public void setMissionCompleted(int missionCompleted) {
		this.missionCompleted = this.missionCompleted + missionCompleted;
		if (getCurrentMissions().size() == 0) {
			this.availabilityStatus = "Available";
		}
	}

	public List<Mission> getCurrentMissions() {
		return currentMissions;
	}

	public void setCurrentMissions(Mission mission) {
		this.currentMissions.add(mission);
		this.availabilityStatus = "On Mission";
		this.missionAssigned = this.missionAssigned + 1;
	}

	public NotificationEnum getNotificationMedium() {
		return notificationMedium;
	}

	public void setNotificationMedium(NotificationEnum notificationMedium) {
		this.notificationMedium = notificationMedium;
	}

	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	private static Hulk INSTANCE;

	public synchronized static Hulk getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Hulk();
		}
		return INSTANCE;
	}

}
