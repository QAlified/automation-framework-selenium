package connector.mail;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;

public class MailHandler {
	
	Multipart multi;

	public boolean findMailBySubjectAndFrom(Message[] mailList, String from, String subject) throws MessagingException, IOException {
		boolean found = false;
		for (int i = mailList.length-1; i > mailList.length - 3; i--){
			if((mailList[i].getSubject().equals(subject)) && (mailList[i].getFrom()[0].toString().equals(from))){
				found = true;
			}
		}
		return found;
	}

	public void analizarCorreo(Message mail) throws MessagingException, IOException {
		 Multipart multi;
		 multi = (Multipart) mail.getContent();
		 Part unaParte = multi.getBodyPart(0);
			if (unaParte.isMimeType("text/*")) {
				//Take actions with plain text/
			}
	}

	public void leerMailYAnalizarlo(Message[] mails, String remisor, String subject) throws IOException, MessagingException {
		Boolean encontre = false;

		for (int i=mails.length-1;i>mails.length-4;i--)
		{
			try {
				if (!encontre && mails[i].getSubject().contains(subject) && (mails[i].getFrom()[0].toString().contains(remisor))) {
					analizarCorreo(mails[i]);			
				}			

			} catch (Exception e) {
				e.printStackTrace();
				System.out.print("ERROR");
			}
		}
	}
}