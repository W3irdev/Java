package edu.prueba.chat;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class MainPrueba {

	
	public static void main(String[] args) {
		OpenAiService gpt = new OpenAiService("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");
		CompletionRequest completionRequest = CompletionRequest.builder().prompt("Hola chatGPT").model("gpt-3.5-turbo").echo(true)
		        .build();
		System.out.println(gpt.createCompletion(completionRequest).getChoices().toArray());
		
	}
}
