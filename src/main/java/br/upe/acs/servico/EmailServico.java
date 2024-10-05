package br.upe.acs.servico;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.upe.acs.dominio.dto.EmailDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServico {
	
	private final JavaMailSender emailRemetente;
	
	public void enviarEmail(EmailDTO emailInfo) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("lapesupe@gmail.com");
		email.setTo(emailInfo.getDestinatario());
		email.setText(emailInfo.getMensagem());
		email.setSubject(emailInfo.getAssunto());
		
		emailRemetente.send(email);
	}
}
