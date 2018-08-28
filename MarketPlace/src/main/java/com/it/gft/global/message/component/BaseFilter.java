package com.it.gft.global.message.component;

import java.util.List;

import org.springframework.messaging.Message;

public abstract class BaseFilter {

	protected Boolean baseFilterRequest(Message<List<String>> request) {
		Boolean allInteger = true;

		for (String item : request.getPayload()) {

			try {
				Integer.parseInt(item);
			} catch (NumberFormatException e) {
				allInteger = false;
				break;
			}
		}

		return allInteger;
	}
}
