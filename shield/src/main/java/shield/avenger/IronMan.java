package shield.avenger;

import java.util.ArrayList;
import java.util.List;

import shield.avenger.mission.Mission;
import shield.avenger.mission.notification.NotificationEnum;

public class IronMan implements Avenger {
 
	final String avengerName = "Iron Man";
	final String personName = "Tony Stark";
	final String abilities = "Highly Intelligent Suit of Armor";
	int missionAssigned;
	int missionCompleted;
	List<Mission> currentMissions = new ArrayList<>();
	NotificationEnum notificationMedium = NotificationEnum.EMAIL;
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
		if(getCurrentMissions().size() ==  0)
		{
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

	private static IronMan INSTANCE;

	public synchronized static IronMan getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new IronMan();
		}
		return INSTANCE;
	}

}
