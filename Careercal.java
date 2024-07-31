package careercalci;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Careercal {

    public static void main(String[] args) {
         new Detailsform(); 
    }

    public static void insertDetails(Details obj) {
    	
    	try {
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/careercal", "root", "Kar@2004");
    		String query = "INSERT INTO user_details (id, uname, deg, year_of_completion, career_gap, hrsperday, daysperweek, live_projects, start_date, total_days, total_weeks, total_months, end_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
    		PreparedStatement statement = con.prepareStatement(query);
    		
            statement.setInt(1, obj.getId());
            statement.setString(2, obj.getUname());
            statement.setString(3, obj.getDegree());
            statement.setInt(4, obj.getYearOfCompletion());
            statement.setInt(5, obj.getCareergap());
            statement.setInt(6, obj.getHours());
            statement.setInt(7, obj.getDays());
            statement.setString(8, obj.getLiveprojects());
            Date startdate = Date.valueOf(obj.getStartDate());
            statement.setDate(9, startdate);
            statement.setInt(10, obj.getTotalDays());
            statement.setInt(11, obj.getTotalWeeks());
            statement.setInt(12, obj.getTotalMonths());
            Date completionDate = Date.valueOf(obj.getCompletionDate());
            statement.setDate(13, completionDate);

            statement.executeUpdate();
            System.out.println(" row inserted");
   

        } 
    	
    	catch (Exception e) {
           System.out.println(e);
        }
    	
    	showresults();
    }
    
    public static  void showresults() {
		System.out.println("Enter the id of the person whose details have to be displayed");
		Scanner s=new Scanner(System.in);
		int uid=s.nextInt();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/careercal", "root", "Kar@2004");
			String query="select uname,total_days,total_weeks,total_months,end_date from user_details where id = ?";
			PreparedStatement statement=con.prepareStatement(query);
			statement.setInt(1,uid);
			ResultSet rs=statement.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString("uname");
				int tdays=rs.getInt("total_days");
				int tweeks=rs.getInt("total_weeks");
				int tmonths=rs.getInt("total_months");
				String date=String.valueOf(rs.getDate("end_date"));
				 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate completiondate=LocalDate.parse(date,formatter);
				System.out.println("Name: "+name+"\nTotal days: "+tdays+"\nTotal weeks: "+tweeks+"\nTotal months: "+tmonths+
						"\nCourse Completion duration: "+completiondate );
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
    }
}
