package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="skill")
@XmlAccessorType(XmlAccessType.FIELD)

public class Skill {
	private String skillName;
	private String skillValue;
	
	public Skill() {
		skillName="Умение";
		skillValue="30";
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillValue() {
		return skillValue;
	}

	public void setSkillValue(String skillValue) {
		this.skillValue = skillValue;
	}
}
