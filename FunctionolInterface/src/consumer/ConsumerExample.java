package consumer;

import java.util.function.Consumer;

public class ConsumerExample {

 public static void main(String[] args) {
	
	 Consumer<String>s=str->System.out.println(str);
	 s.accept("satyam");
	 
}
}
