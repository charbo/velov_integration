package fr.charbo.velov.integration;

import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service("splitterBean")
public class Splitter extends AbstractMessageSplitter {

	@Override
	protected Station[] splitMessage(Message<?> arg0) {
		return (Station[]) arg0.getPayload();
	}

}