public class Details{
	private int id;
	private String name;
	private String deg;
	private int yofc;
	private int gap;
	private int hours;
	private int day;
	private LocalDate startdate;
    private String liveprojects;
    private LocalDate completiondate;
    private int totaldays;
    private int totalweeks;
    private int totalmonths;
    
    public int getId() {
    	return id;
    }
    public void setId(int id) {
    	this.id=id;
    }
    
    public String getUname() {
    	return name;
    }
    public void setUname(String name) {
    	this.name=name;
    }
    
    
    public String getDegree() {
    	return deg;
    }
    public void setDegree(String deg) {
    	this.deg=deg;
    }
    
    
    
    public int getYearOfCompletion() {
    	return yofc;
    }
    public void setYearOfCompletion(int yofc) {
    	this.yofc=yofc;
    }
    
    
    
    public int getCareergap() {
    	return gap;
    }
    public void setCareergap(int gap) {
    	this.gap=gap;
    }
    
    
    
    public int getHours() {
    	return hours;
    }
    public void setHours(int hours) {
    	this.hours=hours;
    }
    
    
    
    public int getDays() {
    	return day;
    }
    public void setDays(int day) {
    	this.day=day;
    }
    
    
    
    public LocalDate getStartDate() {
    	return startdate;
    }
    
    public void setStartDate(LocalDate startdate) {
    	this.startdate=startdate;
    }
    
    
    
    public String getLiveprojects() {
    	return liveprojects;
    }
    public void setLiveProjects(String liveprojects) {
    	this.liveprojects=liveprojects;
    }
    
    public LocalDate getCompletionDate() {
    	return completiondate;
    }
    public int getTotalDays() {
    	return totaldays;
    }
    public int getTotalWeeks() {
    	return totalweeks;
    }
    public int getTotalMonths() {
    	return totalmonths;
    }
    
    
	
	public void calculatecompletiondate() {
    	int entirecourseduration=800;
		int durationperweek=hours*day;
		totalweeks=Math.ceilDiv(entirecourseduration, durationperweek);
		totaldays=(totalweeks*7)+10;
		totalweeks=Math.ceilDiv(totaldays,7);
		totalmonths=Math.ceilDiv(totalweeks,4);
		if(liveprojects.equals("yes")) {
			totaldays+=15;
			totalweeks+=3;
			totalmonths+=1;
		}
		completiondate=startdate.plusDays((long)totaldays);
   }
}    		 

