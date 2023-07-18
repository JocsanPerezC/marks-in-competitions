package Lógica;

import javax.activation.DataSource;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

///**
// * Este es la clase de Enviar correo donde se van a crear y llamar las funciones necesarias para enviar un correo
// * @author Kendall Rodríguez Camacho 2022049438 y Jocsan Adriel Perez Coto 2022437948 
// */

public class EnviarCorreo
{
    public void envioDeCorreo(String correoDestino, String asunto, String mensaje)throws AddressException, MessagingException
    {
        String correoEnvia = "jocsan2pc@gmail.com";//aqui va el correo que envia
        String contrasena = "ybunzksevobedfrp";// la contraseña del correo

        Properties propiedad = new Properties();//todo esto es para conectar a la cuenta de gmail

        propiedad.put("mail.smtp.host","smtp.gmail.com");
        propiedad.put("mail.smtp.ssl.trust","smtp.gmail.com");

        propiedad.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");

        propiedad.setProperty("mail.smtp.user", correoEnvia);
        propiedad.setProperty("mail.smtp.auth", "true");

        Session sesion = Session.getDefaultInstance(propiedad);//variable tipo sesion

        MimeMessage mail = new MimeMessage(sesion); 

        mail.setFrom(new InternetAddress(correoEnvia));//desde donde se enviar el correo

        mail.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));//la persona que lo recibe
        mail.setSubject(asunto);//el asunto
        mail.setText(mensaje);//todo el mensaje

        Transport transporte = sesion.getTransport("smtp");//esto es para ejecutarlo

        transporte.connect(correoEnvia,contrasena);//quien lo envia 
        transporte.sendMessage(mail, mail.getAllRecipients());//transporta el mensaje
        transporte.close();

        JOptionPane.showMessageDialog(null, "Correo enviado");
    
    }
}
