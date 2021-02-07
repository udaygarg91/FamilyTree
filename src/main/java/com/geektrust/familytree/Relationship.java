package com.geektrust.familytree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Relationship {

	public Member getMemberInFamilyTree(Member head, String memberName) {
		if (head == null || memberName == null) {
			return null;
		}
		if (head.getName().equals(memberName))
			return head;
		if (head.getPartner() != null)
			if (head.getPartner().getName().equals(memberName))
				return head.getPartner();
		List<Member> childList = new ArrayList<Member>();
		if (head.getGender().equals(Gender.FEMALE))
			childList = head.getChildren();
		else if (head.getPartner() != null)
			childList = head.getPartner().getChildren();

		for (Member member : childList) {
			Member m = getMemberInFamilyTree(member, memberName);
			if (m != null)
				return m;
		}
		return null;
	}

	public List<String> getPaternalUncle(Member member) {
		if (member.getFather() != null) {
			List<Member> setOfPUncle = new ArrayList<>();
			if (member.getFather().getMother() != null)
				setOfPUncle = getSon(member.getFather().getMother());
			setOfPUncle.remove(member.getFather());
			return setOfPUncle.stream().map(Member::getName).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	public List<String> getMaternalUncle(Member member) {
		if (member.getMother() != null) {
			List<Member> setOfMUncle = new ArrayList<>();
			if (member.getMother().getMother() != null)
				setOfMUncle = getSon(member.getMother().getMother());
			return setOfMUncle.stream().map(Member::getName).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	public List<String> getPaternalAunt(Member member) {
		if (member.getFather() != null) {
			List<Member> setOfPAunt = new ArrayList<>();
			if (member.getFather().getMother() != null)
				setOfPAunt = getDaughter(member.getFather().getMother());
			return setOfPAunt.stream().map(Member::getName).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	public List<String> getMaternalAunt(Member member) {
		if (member.getMother() != null) {
			List<Member> setOfMAunt = new ArrayList<>();
			if (member.getMother().getMother() != null)
				setOfMAunt = getDaughter(member.getMother().getMother());
			setOfMAunt.remove(member.getMother());
			return setOfMAunt.stream().map(Member::getName).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	public List<String> getSisterInLaws(Member member) {
		List<Member> sistetInLaws = new ArrayList<>();
		if (member.getPartner() != null) {
			sistetInLaws = getDaughter(member.getPartner().getMother());
			sistetInLaws.remove(member.getPartner());
		}
		List<Member> brothers = null;
		if (member.getMother() != null) {
			brothers = getSon(member.getMother());
			brothers.remove(member);
			for (Member brother : brothers) {
				if (brother.getPartner() != null)
					sistetInLaws.add(brother.getPartner());
			}
		}
		if (!sistetInLaws.isEmpty())
			return sistetInLaws.stream().map(Member::getName).collect(Collectors.toList());
		return new ArrayList<>();
	}

	public List<String> getBrotherInLaws(Member member) {
		List<Member> brotherInLaws = new ArrayList<>();
		if (member.getPartner() != null) {
			brotherInLaws = getSon(member.getPartner().getMother());
			brotherInLaws.remove(member.getPartner());
		}
		List<Member> sisters = null;
		if (member.getMother() != null) {
			sisters = getDaughter(member.getMother());
			sisters.remove(member);
			for (Member sister : sisters) {
				if (sister.getPartner() != null)
					brotherInLaws.add(sister.getPartner());
			}
		}
		if (!brotherInLaws.isEmpty())
			return brotherInLaws.stream().map(Member::getName).collect(Collectors.toList());
		return new ArrayList<>();
	}

	public List<Member> getDaughter(Member member) {
		if (member != null && member.getPartner() != null) {
			if (!Gender.FEMALE.equals(member.getGender()))
				member = member.getPartner();
			return member.getChildren().stream().filter(s -> s.getGender().equals(Gender.FEMALE))
					.collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	public List<Member> getSon(Member member) {
		if (member != null && member.getPartner() != null) {
			if (!Gender.FEMALE.equals(member.getGender()))
				member = member.getPartner();
			return member.getChildren().stream().filter(s -> s.getGender().equals(Gender.MALE))
					.collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	public List<Member> getSiblings(Member member) {
		if (member != null && member.getMother() != null) {
			List<Member> siblings = member.getMother().getChildren();
			siblings.remove(member);
			return siblings;
		}
		return new ArrayList<>();
	}

}
