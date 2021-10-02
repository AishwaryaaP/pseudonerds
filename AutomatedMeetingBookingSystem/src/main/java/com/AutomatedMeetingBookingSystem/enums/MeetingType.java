package com.AutomatedMeetingBookingSystem.enums;

public enum  MeetingType
{
	CLASSROOMTRAINING("CLASSROOMTRAINING"),
    ONLINETRAINING("ONLINETRAINING"),
    BUSINESS("BUSINESS"),
    CONFERENCECALL("CONFERENCECALL");
	
	public String value;
	
	MeetingType(String string) {
		value = string;
	}

}



