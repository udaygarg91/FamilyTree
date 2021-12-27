package shield.avenger.mission;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;

import shield.avenger.Avenger;

public class Mission implements Serializable {
	private String name;
	private String details;
	private List<Avenger> avengers = new ArrayList<>();
	private MissionStatus status = MissionStatus.Assigned;

	public Mission(String name, String details) {
		this.name = name;
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<Avenger> getAvengers() {
		return avengers;
	}

	public void setAvengers(List<Avenger> avengers) {
		this.avengers = avengers;
	}

	public MissionStatus getStatus() {
		return status;
	}

	public void setStatus(MissionStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Mission [name=" + name + ", details=" + details + ", avengers=" + avengers + ", status=" + status + "]";
	}

	public static void main(String[] args) {
		Mission m = new Mission("a", "abc");
		m.getAvengers().add(Avenger.getAvenger("THOR"));
		Mission m1 = SerializationUtils.roundtrip(m);
		m1.name = "b";
		m1.getAvengers().add(Avenger.getAvenger("HULK"));
		System.out.println(m);
		System.out.println(m1);
	}

}
