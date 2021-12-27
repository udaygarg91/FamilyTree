package shield;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import shield.main.CaptionFury;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CaptionFuryTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	@Test
	public void _01_option1_checkTheMissionsTest() {
		assertEquals(CaptionFury.missions.size(), 0);
	}

	@Test
	public void _02_option2_assignMissionToAvengersTest() {
		String avengers = "Thor, Hawkeye";
		String missionName = "Find the Space Infinity Stone";
		String missionDetails = "Loki has stolen the Space Infinity Stone which needs to be captured";
		CaptionFury.assignMissionToAvengers(avengers, missionName, missionDetails);
		assertTrue(outContent.toString().contains("Mission has been assigned."));
		assertTrue(outContent.toString().contains("Pager notification sent to Thor"));
		assertTrue(outContent.toString().contains("SMS notification sent to Hawkeye"));
	}

	@Test
	public void _03_option2_assignMissionToAvengersTest() {
		String avengers = "Black Widow, Hawkeye";
		String missionName = "Get the Hulk back";
		String missionDetails = "Hulk has gone underground again, find him and bring him back.";
		CaptionFury.assignMissionToAvengers(avengers, missionName, missionDetails);
		assertTrue(outContent.toString().contains("Mission has been assigned."));
		assertTrue(outContent.toString().contains("Email notification sent to Black Widow"));
		assertTrue(outContent.toString().contains("SMS notification sent to Hawkeye"));
		assertTrue(CaptionFury.missions.size() == 2);
	}

	@Test
	public void _04_option2_assignMissionToAvengersTest() {
		String avengers = "Hawkeye";
		String missionName = "Get the Hulk back";
		String missionDetails = "Hulk has gone underground again, find him and bring him back.";
		CaptionFury.assignMissionToAvengers(avengers, missionName, missionDetails);
		assertTrue(errContent.toString().contains("Sorry, Hawkeye has already been working on two missions."));
		assertTrue(CaptionFury.missions.size() == 2);
	}

	@Test
	public void _05_option1_checkTheMissionsTest() {
		CaptionFury.checkTheMissions();
		assertTrue(outContent.toString()
				.contains("Mission Name                             | Status          | Avengers"));
		assertTrue(outContent.toString()
				.contains("Get the Hulk back                        | Assigned        | Black Widow, Hawkeye"));
		assertTrue(outContent.toString()
				.contains("Find the Space Infinity Stone            | Assigned        | Thor, Hawkeye"));
	}

	@Test
	public void _06_option3_checkMissionDetailsTest() {
		CaptionFury.checkMissionDetails("Get the Hulk back");
		assertTrue(outContent.toString()
				.contains("Mission Details: Hulk has gone underground again, find him and bring him back."));
		assertTrue(outContent.toString().contains("Mission Status: Assigned"));
		assertTrue(outContent.toString().contains("Avengers: Black Widow, Hawkeye"));
	}

	@Test
	public void _07_option4_checkAvengerDetailsTest() {
		CaptionFury.checkAvengerDetails("Iron Man");
		assertTrue(outContent.toString().contains("Person Name: Tony Stark"));
		assertTrue(outContent.toString().contains("Abilities: Highly Intelligent Suit of Armor"));
		assertTrue(outContent.toString().contains("Mission Assigned: 0"));
		assertTrue(outContent.toString().contains("Mission Completed :0"));
	}

	@Test
	public void _08_option5_updateMissionStatusTest() {
		CaptionFury.updateMissionStatus("Get the Hulk back", "Completed");
		assertTrue(outContent.toString().contains("Email notification sent to Black Widow"));
		assertTrue(outContent.toString().contains("SMS notification sent to Hawkeye"));
	}

	@Test
	public void _09_option1_checkMissionDetailsTest() {
		CaptionFury.checkTheMissions();
		assertTrue(outContent.toString()
				.contains("Mission Name                             | Status          | Avengers"));
		assertTrue(outContent.toString()
				.contains("Get the Hulk back                        | Completed       | Black Widow, Hawkeye"));
		assertTrue(outContent.toString()
				.contains("Find the Space Infinity Stone            | Assigned        | Thor, Hawkeye"));
	}

	@Test
	public void _10_option6_listAvengersTest() {
		CaptionFury.listAvengers();
		// If Avenger do not have any mission then table shows available with blank
		// assigned mission. Ex: Black window
		assertTrue(outContent.toString().contains("Avenger Name         | Status               | Assigned Mission"));
		assertTrue(outContent.toString().contains("Black Widow          | Available            |"));
		assertTrue(outContent.toString().contains("Captain America      | Available            |"));
		assertTrue(outContent.toString().contains("Iron Man             | Available            |"));
		assertTrue(outContent.toString()
				.contains("Hawkeye              | On Mission           | Find the Space Infinity Stone"));
		assertTrue(outContent.toString().contains("Hulk                 | Available            |"));
	}

	// If Avenger do not have any mission then table shows available with blank
	// assigned mission. Ex: Black window
	@Test
	public void _11_option7_assignAvengerToMissionTest() {
		CaptionFury.assignAvengerToMission("Iron man", "Find the Space Infinity Stone");
		assertTrue(errContent.toString().contains("Thor and Hawkeye are already working on this mission."));
	}

}
