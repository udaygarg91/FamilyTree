package shield.avenger.mission.notification;

import shield.avenger.Avenger;
import shield.avenger.mission.Mission;

public class SMS implements Notification {

	@Override
	public void notifyAvenger(Avenger avenger, Mission mission) {
		System.out.println("SMS notification sent to " + avenger.getAvengerName());
	}

}
