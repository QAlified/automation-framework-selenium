package pages.sample;
import org.openqa.selenium.By;

import automation.WebAutomator;

public class AppointmentReservationPage {
	WebAutomator automator;
	
	By selectFacility = By.id("combo_facility");
	
	By checkReadMission = By.id("chk_hospotal_readmission");
		
	By inputVisitDate = By.id("txt_visit_date");
	
	By textAreaComment = By.id("txt_comment");
	
	By buttonMakeAppointment = By.id("btn-book-appointment");
	
	public AppointmentReservationPage(WebAutomator automator) {
		this.automator = automator;
	}
	
	private void selectFacility(String facility) {
		this.automator.find(selectFacility).selectByValue(facility);
	}
	
	private void enterDate(String date) {
		automator.find(inputVisitDate).setText(date);
	}
	
	private void enterComment(String commentText) {
		automator.find(textAreaComment).setText(commentText);
	}
	
	public void clickToMakeReservation() {
		automator.find(buttonMakeAppointment).click();
	}
	
	public void makeAppointment(String facility, boolean readmissionApply, String program, String visitDate, String comment) {
		this.selectFacility(facility);
		this.selectReadMissionApply(readmissionApply);
		this.selectProgram(program);
		this.enterDate(visitDate);
		this.enterComment(comment);
		this.clickToMakeReservation();
	}

	private void selectProgram(String program) {
		this.automator.find(By.id("radio_program_" + program)).click();
	}

	private void selectReadMissionApply(boolean readmissionApply) {
		if (readmissionApply) {
			automator.find(checkReadMission).click();
		}
	}

}
