package shield.avenger;

import java.util.ArrayList;
import java.util.List;

import shield.avenger.mission.Mission;
import shield.avenger.mission.notification.NotificationEnum;

public class CaptainAmerica implements Avenger {

	final String avengerName = "Captain America";
	final String personName = "Steve Rogers";
	final String abilities = "Enhanced strength, speed, stamina, durability, agility, reflexes, senses, and mental processing";
	int missionAssigned;
	int missionCompleted;
	List<Mission> currentMissions = new ArrayList<>();
	NotificationEnum notificationMedium = NotificationEnum.SMS;
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

	private static CaptainAmerica INSTANCE;

	public synchronized static CaptainAmerica getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CaptainAmerica();
		}
		return INSTANCE;
	}
}
