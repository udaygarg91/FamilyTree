package com.geektrust.familytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyTree {

	private Member headMember;
	Relationship relation;

	public FamilyTree() {
		relation = new Relationship();
	}

	public Member getHeadMember() {
		return headMember;
	}

	public void setHeadMember(Member headMember) {
		this.headMember = headMember;
	}

	public void addHeadMember(String name, Gender gender) {
		this.headMember = new Member(name, gender);
	}

	public String addChild(String motherName, String childName, Gender gender) {
		Member mother = relation.getMemberInFamilyTree(headMember, motherName);
		if (mother == null) {
			return Constants.PERSON_NOT_FOUND;
		}
		if (mother.getGender().equals(Gender.MALE)) {
			return Constants.CHILD_ADDITION_FAILED;
		}
		if (childName != null && gender != null) {
			Member child = new Member(childName, gender, mother.getPartner(), mother);
			mother.getChildren().add(child);
			return Constants.CHILD_ADDITION_SUCCEEDED;
		}
		return Constants.CHILD_ADDITION_FAILED;
	}

	public String addPartner(String partner1, String partner2, Gender gender) {
		Member m = relation.getMemberInFamilyTree(headMember, partner1);
		if (m == null) {
			return Constants.PERSON_NOT_FOUND;
		}

		if (m != null && partner2 != null && gender != null) {
			Member partner = new Member(partner2, gender);
			m.setPartner(partner);
			partner.setPartner(m);
			return "PARTNER_ADDITION_SUCCEEDED";
		}
		return "PARTNER_ADDITION_FAILED";
	}

	public String getMembersByRelationshipName(Member head, String memberName, String relationshipName) {
		Member member = relation.getMemberInFamilyTree(head, memberName);
		if (member == null)
			return Constants.PERSON_NOT_FOUND;
		if (relationshipName == null)
			return Constants.NONE;
		List<String> output = new ArrayList<String>();
		switch (relationshipName) {
		case Constants.PATERNAL_UNCLE:
			output = relation.getPaternalUncle(member);
			break;
		case Constants.MATERNAL_UNCLE:
			output = relation.getMaternalUncle(member); 
			break;
		case Constants.PATERNAL_AUNT:
			output = relation.getPaternalAunt(member);
			break;
		case Constants.MATERNAL_AUNT:
			output = relation.getMaternalAunt(member);
			break;
		case Constants.SISTER_IN_LAW:
			output = relation.getSisterInLaws(member);
			break;
		case Constants.BROTHER_IN_LAW:
			output = relation.getBrotherInLaws(member);
			break;
		case Constants.SON:
			output = relation.getSon(member).stream().map(Member::getName).collect(Collectors.toList());
			break;
		case Constants.DAUGHTER:
			output = relation.getDaughter(member).stream().map(m -> m.getName()).collect(Collectors.toList());
			break;
		case Constants.SIBLINGS:
			output = relation.getSiblings(member).stream().map(Member::getName).collect(Collectors.toList());
			break;
		default:
			output = new ArrayList<>(Arrays.asList(Constants.INVALID_COMMAND));
			break;
		}
		StringBuilder sb = new StringBuilder();
		if (output.size() == 0)
			return Constants.NONE;
		for (String string : output) {
			sb.append(string + " ");
		}
		return sb.toString();
	}
}
