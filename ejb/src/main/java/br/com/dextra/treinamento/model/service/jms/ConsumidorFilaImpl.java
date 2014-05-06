package br.com.dextra.treinamento.model.service.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
	@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
	@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/minhaFila") })
public class ConsumidorFilaImpl implements MessageListener {

    @Override
    public void onMessage(Message msg) {

	TextMessage mensagem = (TextMessage) msg;
	try {
	    String m = mensagem.getText();
	    System.out.println(m);
	} catch (JMSException e) {

	}

    }

}
