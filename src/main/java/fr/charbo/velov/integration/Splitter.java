package fr.charbo.velov.integration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service("splitterBean")
public class Splitter extends AbstractMessageSplitter {
	private static final String[] IDS = new String[]{"6028", "3087", "3003", "3083", "3015", "10117"};
	
	private static final String URL = "https://api.jcdecaux.com/vls/v1/stations/${ID}?contract=Lyon&apiKey=681e47e9ba5d7f9316f815d7d262382d92cea6c4";

	@Override
	protected List<String> splitMessage(Message<?> arg0) {
		List<String> urls = new ArrayList<String>();
		for (String id : IDS) {
			urls.add(URL.replace("${ID}", id));
		}
		return urls;
	}

}