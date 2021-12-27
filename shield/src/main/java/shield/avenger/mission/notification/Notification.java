package shield.avenger.mission.notification;

import shield.avenger.Avenger;
import shield.avenger.mission.Mission;

public interface Notification {
	public void notifyAvenger(Avenger avenger, Mission mission);

	public static Notification getInstance(NotificationEnum type) {
		switch (type) {
		case EMAIL:
			return new Email();
		case SMS:
			return new SMS();
		case PAGER:
			return new Pager();
		default:
			return null;
		}

	}
}
