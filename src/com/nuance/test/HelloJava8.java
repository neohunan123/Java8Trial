package com.nuance.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class HelloJava8 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Formula formula = new Formula() {
			@Override	
			public double calculate(int a) {
			    return sqrt(a * 100);
			}
		};
		formula.calculate(100);     // 100.0
		formula.sqrt(16);           // 4.0
		
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//		Collections.sort(names, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		});
//		Collections.sort(names, (String a, String b) -> {
//			return b.compareTo(a);
//			});
		
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		Collections.sort(names, (a, b) -> b.compareTo(a));
		System.out.println(names);

//		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		
		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123
		
		class Something {
			    String startsWith(String s) {
			        return String.valueOf(s.charAt(0));
			    }
		}
		Something something = new Something();
		Converter<String, String> converter1 = something::startsWith;
		String converted1 = converter1.convert("Java");
		System.out.println(converted1);    // "J"
		
		Converter<String, String> conv3 = (a) -> a.substring(0, a.length()-2);
		System.out.println(conv3.convert("woquba"));
		
		
		
		PersonFactory personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
		System.out.println(person);
		
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		backToString.apply("123");     // "123"
		
		Supplier<Person> personSupplier = Person::new;
		personSupplier.get();   // new Person
		
		Consumer<Person> greeter = (p) -> p.outputName();//("Hello, " + p.firstName);
		greeter.accept(new Person("Luke", "Skywalker"));
		
		Optional<String> optional = Optional.of("bam");
		optional.isPresent();           // true
		optional.get();                 // "bam"
		optional.orElse("fallback");    // "bam"
		optional.ifPresent((s) -> System.out.println(s.charAt(1)));    // "b"
		
//		int max = 1000000;
//		List values = new ArrayList<>(max);
//		for (int i = 0; i < max; i++) {
//			UUID uuid = UUID.randomUUID();
//			values.add(uuid.toString());
//		}
		
//		long t0 = System.nanoTime();
//		long count = values.stream().sorted().count();
//		System.out.println(count);
//		long t1 = System.nanoTime();
//		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
//		System.out.println(String.format("sequential sort took: %d ms", millis));
		// sequential sort took: 899 ms
		
//		long t0 = System.nanoTime();
//		long count = values.parallelStream().sorted().count();
//		System.out.println(count);
//		long t1 = System.nanoTime();
//		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
//		System.out.println(String.format("parallel sort took: %d ms", millis));
		// parallel sort took: 472 ms
		
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val" + i); 
		}
		
		map.forEach((id, val) -> System.out.println(val));
		List<String> list = new ArrayList<String>();
		
		list.stream().filter(a -> a.startsWith("9")).allMatch((a) -> a instanceof String);

	}
}

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

class Person {
    String firstName;
    String lastName;
    Person() {}
    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void outputName() {
    	System.out.println("hello, Mr." + this.firstName +" "+ this.lastName);
    }
}

interface PersonFactory {
	Person create(String firstName, String lastName);
}

