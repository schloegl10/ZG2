package caixa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeitorDeTexto {

	public static List<String> getResult(String regex,String text) {
		
		List<String> participantList = new ArrayList<>();
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
			String participantName = matcher.group();
			participantList.add(participantName);
		}
		
		return participantList;
		
	}
	public static void main(String args[]) {
		
		String data = "";
		try { 
			data = new String(Files.readAllBytes(Paths.get("/Users/Felipe/eclipse-workspace/ZG3/src/zgh.txt")));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Text file as String in Java");
		System.out.println(data); 
		
		List<String> find= getResult("(?<=Telefone\\:\\s)\\d{9}",data);
		
		System.out.println(find.get(0));
		System.out.println(find.get(1));
		System.out.println(find.get(2));
		System.out.println(find.get(3));
	}
}
