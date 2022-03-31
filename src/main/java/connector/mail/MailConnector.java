package connector.mail;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class MailConnector {
	
	public Message [] conectarMailYObtenerInboxConIMAP(String tipoMail, String mail, String pass) throws MessagingException {
		
		Properties prop = new Properties();
		
		prop.setProperty("http.proxyHost", "192.168.0.1");

		prop.setProperty("http.proxyPort", "8080"); 

		prop.setProperty("mail.store.protocol", "imaps");
		
		Session session = Session.getInstance(prop);
		session.setDebug(true);
		
		Store store = session.getStore("imaps");
		store.connect("imap."+tipoMail+".com", mail, pass);

		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);

		return  folder.getMessages();
	}
	
	public Message [] conectarMailYObtenerInboxConPOP3(String tipoMail,String mail, String pass ) throws MessagingException {
		
		Properties prop = new Properties();

		//We disable TLS
		prop.setProperty("mail.pop3.starttls.enable", "false");//true

		// You have to use SSL
		prop.setProperty("mail.pop3.socketFactory.class","javax.net.ssl.SSLSocketFactory" );
		prop.setProperty("mail.pop3.socketFactory.fallback", "false");//true

		// Port 995 to connect.
		prop.setProperty("mail.pop3.port","995");
		prop.setProperty("mail.pop3.socketFactory.port", "995");
		
		
		Session sesion = Session.getInstance(prop);
		sesion.setDebug(true);
			
		Store store = sesion.getStore("pop3");
		store.connect("pop."+tipoMail+".com",mail,pass);
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);

		return  folder.getMessages();
	}
	
	
	
	
}