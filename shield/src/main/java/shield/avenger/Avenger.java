package shield.avenger;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import shield.avenger.mission.Mission;
import shield.avenger.mission.notification.NotificationEnum;

public interface Avenger extends Serializable {

	static Set<String> team = new HashSet<>(
			Arrays.asList("IRON MAN", "CAPTAIN AMERICA", "HULK", "THOR", "BLACK WIDOW", "HAWKEYE"));

	public String getAvengerName();

	public String getPersonName();

	public String getAbilities();

	public int getMissionAssigned();

	public int getMissionCompleted();

	public void setMissionCompleted(int missionCompleted);

	public String getAvailabilityStatus();

	public List<Mission> getCurrentMissions();

	public void setCurrentMissions(Mission mission);

	public NotificationEnum getNotificationMedium();

	public void setNotificationMedium(NotificationEnum notificationMedium);

	static Avenger getAvenger(String name) {
		switch (name) {
		case "IRON MAN":
			return IronMan.getInstance();
		case "CAPTAIN AMERICA":
			return CaptainAmerica.getInstance();
		case "HULK":
			return Hulk.getInstance();
		case "THOR":
			return Thor.getInstance();
		case "BLACK WIDOW":
			return BlackWidow.getInstance();
		case "HAWKEYE":
			return Hawkeye.getInstance();
		default:
			break;
		}
		return null;
	}
}
