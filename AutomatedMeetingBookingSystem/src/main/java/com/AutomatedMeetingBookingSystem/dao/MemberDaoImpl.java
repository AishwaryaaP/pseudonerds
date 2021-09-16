package com.AutomatedMeetingBookingSystem.dao;


public class MemberDaoImpl implements MemberDao {

	public MemberScheduleDao() 
	{
		
		try {
					
		
		con = ConnectionManager.getConnection();
		
		} catch ( SQLException | ClassNotFoundException e ) {

			System.out.println(e);
		}
	}
	public List<Meeting> meetingScheduleDao(User user)
	{
		List<Meeting> meetingSchedule =new ArrayList<Meeting>();
		try 
		{
			
			PreparedStatement ps = con.prepareStatement ( "select id, title, organized_by, meeting_date, start_time, end_time, meeting_room_id, meeting_type from meeting where ? = any(attendees)" );
			ps.setString ( 1, user.getUser_id () );
			ResultSet rs = ps.executeQuery ();
			
			while(rs.next()) {
				
				
				Meeting m1= new Meeting();
				m1.setId(Integer.parseInt(rs.getString(1)));
				m1.setTitle(rs.getString(2));
				m1.setOrganizedBy(rs.getString(3));
				
				m1.setMeetingDateDT(rs.getDate(4));
				m1.setStartTimeTM((rs.getTime(5)));
				m1.setEndTime(rs.getString(6));
				
				m1.setMeetingRoomId(rs.getString(7));
				m1.setMeetingTypeName(rs.getString(8));

				
				meetingSchedule.add(m1);
	
			}
			

			
			}catch(SQLException e) {

				System.out.println(e);
			}
			
			return meetingSchedule;
		
		
	}
	public User memberDetailsDao(int userId);
	{
		User u = new User();
		try
		{
			PreparedStatement ps = con.prepareStatement ( "select userId, name, phone, credit, role from User where userId = ?");
			ps.setString ( 1, userId );
			ResultSet rs = ps.executeQuery ();
			while(rs.next())
			{
				u.setUserId(Integer.parseInt(rs.getString(1)));
				u.setName(rs.getString(2));
				u.setPhone(rs.getString(3));
				u.setCredit(Integer.parseInt(rs.getString(4)));
				u.setRole(rs.getString(5));
			}
		}catch(SQLException e) {

			System.out.println(e);
		}
		
		return u;

		
	}
		
	
}

