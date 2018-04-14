private static void assignstaff(int hotel_id,int room_number,int checkinid,service_name)
{
	 try{
		//check if the service has already been availed by the room
		result=statement.executeQuery(String.format(“select  service_name from Pricings where checkin_id=’%d’ and room_number=’%d’”,checkinid,room_number));
		//If not
		if(!result.next()) {
			// find available staff and insert into serves and Pricings table
			result=statement.executeQuery(“Select id from Staffs where availability=’Yes’ and ROWNUM=1”)
			statement.executeUpdate(String.format(“Insert into Serves values(‘%d’,’%d’,’%s’,’%d’)”,  staff_id,hotel_id,service_name,result.getInt(‘id’)));
			statement.executeUpdate(String.format(“Insert into Pricings values(‘%d’,’%d’,,’%d’,’%d’,’%s’)”,  1,checkin_id,room_number,hotel_id,service_name));
		} else {
			//Update count in pricings
			statement.executeUpdate(String.format(“Update Pricings set count=count+1 where checkin_id=’%d’ and room_number=’%d’”,checkinid,room_number));
		}
	} catch(SQLException e) {
		e.printStackTrace();
	}

}