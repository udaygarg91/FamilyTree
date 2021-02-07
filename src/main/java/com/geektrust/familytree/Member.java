package com.geektrust.familytree;

import java.util.ArrayList;
import java.util.List;

public class Member {

	private String name;
	private Gender gender;
	private Member father;
	private Member mother;
	private Member partner;
	private List<Member> children;

	Member(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
		children = new ArrayList<Member>();
	}

	public Member(String name, Gender gender, Member father, Member mother) {
		this.name = name;
		this.gender = gender;
		this.mother = mother;
		this.father = father;
		this.partner = null;
		this.children = new ArrayList<Member>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Member getFather() {
		return father;
	}

	public void setFather(Member father) {
		this.father = father;
	}

	public Member getMother() {
		return mother;
	}

	public void setMother(Member mother) {
		this.mother = mother;
	}

	public Member getPartner() {
		return partner;
	}

	public void setPartner(Member partner) {
		this.partner = partner;
	}

	public List<Member> getChildren() {
		return children;
	}

	public void setChildren(List<Member> children) {
		this.children = children;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
