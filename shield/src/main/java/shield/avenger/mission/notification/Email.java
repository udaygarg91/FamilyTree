package shield.avenger.mission.notification;

import shield.avenger.Avenger;
import shield.avenger.mission.Mission;

public class Email implements Notification {

	@Override
	public void notifyAvenger(Avenger avenger, Mission mission) {
		System.out.println("Email notification sent to " + avenger.getAvengerName());
	}

}
