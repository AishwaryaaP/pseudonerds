package com.app.service;
import java.util.List;
import com.app.model.BookingInformation;

public interface BookingInformationService {
	public List<MeetingRoom> getAvailableMeetingRoom();
}
