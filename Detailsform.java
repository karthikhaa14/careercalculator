package careercalci;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class Detailsform extends JFrame implements Calculator {
	JTextField idfield,uname,degree,year_of_completion,career_gap,hrs,days,start_date,live_projects;
	JButton calci;
	Details obj=new Details();
	public Detailsform() {
		JLabel title=new JLabel("Career Calculator");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel idlabel = new JLabel("Id:");
        idfield = new JTextField(20);

		JLabel namelabel = new JLabel("Name:");
        uname = new JTextField(20);

        JLabel degreelabel = new JLabel("Degree:");
        degree= new JTextField(20);

        JLabel yearlabel = new JLabel("Year of Completion:");
        year_of_completion= new JTextField(20);

        JLabel gaplabel = new JLabel("Career gap:");
        career_gap= new JTextField(20);

        JLabel hrslabel = new JLabel("Approximate hours spend per day:");
        hrs= new JTextField(20);

        JLabel dayslabel = new JLabel("Approximate days spend per week:");
        days= new JTextField(20);

        JLabel datelabel = new JLabel("Start date:(DD-MM-YYYY)");
        start_date= new JTextField(20);
        
        JLabel projectslabel = new JLabel("Are you interested in live projects(yes/no):");
        live_projects= new JTextField(20);

        calci = new JButton("Submit");
        
        JPanel panel = new JPanel(new GridLayout(5, 4));
        panel.add(idlabel);
        panel.add(idfield);
        panel.add(namelabel);
        panel.add(uname);
        panel.add(degreelabel);
        panel.add(degree);
        panel.add(yearlabel);
        panel.add(year_of_completion);
        panel.add(gaplabel);
        panel.add(career_gap);
        panel.add(hrslabel);
        panel.add(hrs);
        panel.add(dayslabel);
        panel.add(days);
        panel.add(datelabel);
        panel.add(start_date);
        panel.add(projectslabel);
        panel.add(live_projects);
        
        setLayout(new BorderLayout()); 
        add(title, BorderLayout.NORTH); 
        add(panel, BorderLayout.CENTER); 
        add(calci, BorderLayout.SOUTH); 
        
        setSize(400, 400);
        setVisible(true);
        calci.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	calculate();
            }
       });
	}
	
	public void calculate() {
	
		
        String arr[] = new String[] { "CSE", "IT", "AML", "ADS" };
        ArrayList<String> degg = new ArrayList<>(Arrays.asList(arr));
        
        obj.setId(Integer.parseInt(idfield.getText()));
        obj.setUname(uname.getText());
        obj.setDegree(degree.getText().toUpperCase());
        obj.setYearOfCompletion(Integer.parseInt(year_of_completion.getText()));
        obj.setCareergap(Integer.parseInt(career_gap.getText()));
        obj.setHours(Integer.parseInt(hrs.getText()));
        obj.setDays(Integer.parseInt(days.getText()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        obj.setStartDate(LocalDate.parse(start_date.getText(), formatter));
        obj.setLiveProjects(live_projects.getText().toLowerCase());

        if (!degg.contains(obj.getDegree()) || obj.getCareergap() > 5) {
            JOptionPane.showMessageDialog(null, "You're not eligible");
        } else {
            obj.calculatecompletiondate();
            display();
            Careercal.insertDetails(obj);
        }
    }
	
	
	public void display() {
		JOptionPane.showMessageDialog(calci,"Hello "+obj.getUname()+"\nTotal days to complete: "+obj.getTotalDays()+
				"\nTotal weeks to complete: "+obj.getTotalWeeks()+"\nTotal Months to complete: "+obj.getTotalMonths()+
				"\nCourse completion date "+obj.getCompletionDate());
	}
}
