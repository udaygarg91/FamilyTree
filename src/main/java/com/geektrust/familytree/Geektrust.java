package com.geektrust.familytree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Geektrust {

	public static void main(String[] args) throws Exception {
		String filePath = args[0];
		addMembersAndreadCommandsFromFile(filePath);

	}

	@SuppressWarnings("resource")
	public static void addMembersAndreadCommandsFromFile(String filePath) throws IOException {
		FamilyTree family = new FamilyTree();
		family.addHeadMember("King Shan", Gender.MALE);
		family.addPartner("King Shan", "Queen Anga", Gender.FEMALE);
		family.addChild("Queen Anga", "Chit", Gender.MALE);
		family.addPartner("Chit", "Amba", Gender.FEMALE);
		family.addChild("Queen Anga", "Ish", Gender.MALE);
		family.addChild("Queen Anga", "Vich", Gender.MALE);
		family.addPartner("Vich", "Lika", Gender.FEMALE);
		family.addChild("Queen Anga", "Aras", Gender.MALE);
		family.addPartner("Aras", "Chitra", Gender.FEMALE);
		family.addChild("Queen Anga", "Satya", Gender.FEMALE);
		family.addPartner("Satya", "Vyan", Gender.MALE);
		family.addChild("Amba", "Dritha", Gender.FEMALE);
		family.addPartner("Dritha", "Jaya", Gender.MALE);
		family.addChild("Amba", "Tritha", Gender.FEMALE);
		family.addChild("Amba", "Vritha", Gender.MALE);
		family.addChild("Lika", "Vila", Gender.FEMALE);
		family.addChild("Lika", "Chika", Gender.FEMALE);
		family.addChild("Chitra", "Ahit", Gender.MALE);
		family.addChild("Chitra", "Jnki", Gender.FEMALE);
		family.addPartner("Jnki", "Arit", Gender.MALE);
		family.addChild("Satya", "Asva", Gender.MALE);
		family.addPartner("Asva", "Satvy", Gender.FEMALE);
		family.addChild("Satya", "Vyas", Gender.MALE);
		family.addPartner("Vyas", "Krpi", Gender.FEMALE);
		family.addChild("Satya", "Atya", Gender.FEMALE);
		family.addChild("Dritha", "Yodhan", Gender.MALE);
		family.addChild("Jnki", "Laki", Gender.MALE);
		family.addChild("Jnki", "Lavnya", Gender.FEMALE);
		family.addChild("Satvy", "Vasa", Gender.MALE);
		family.addChild("Krpi", "Kriya", Gender.MALE);
		family.addChild("Krpi", "Krithi", Gender.FEMALE);

		List<String[]> cmdList = new ArrayList<String[]>();
		File file = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null)
			if (st.trim().length() != 0)
				cmdList.add(st.split(" "));

		for (String[] cmd : cmdList) {
			if (Constants.ADD_CHILD.equalsIgnoreCase(cmd[0]) && cmd.length == 4) {
				Gender gender = (cmd[3].equalsIgnoreCase(Gender.FEMALE.toString())) ? Gender.FEMALE : Gender.MALE;
				System.out.println(family.addChild(cmd[1], cmd[2], gender));
			} else if (Constants.GET_RELATIONSHIP.equalsIgnoreCase(cmd[0]) && cmd.length == 3) {
				System.out.println(family.getMembersByRelationshipName(family.getHeadMember(), cmd[1], cmd[2]));
			} else {
				System.out.println(Constants.INVALID_COMMAND);
			}
		}
	}
}
