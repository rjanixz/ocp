package streams;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestingCollect {

	
	public static void main(String[] args) {
		reduce();
	}
	
	private static void print(List l) {
		l.forEach(n -> System.out.println(n));
	}
	
	public static void stream() {
		List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
		
		List<String> collected2 = Stream.of("a", "b", "c").collect(toList());
		
		
		//assertEquals(Arrays.asList("a", "b", "c"), collected);
	}
	
	public static void map() {
		List<Number> collected = Stream.of("10", "20", "30")
									.map( item -> Integer.parseInt(item))
									.collect(toList());
		
		print(collected);
	}
	
	public static void filter() {
		List<String> beginningWithNumbers =
				Stream.of("a", "1abc", "abc1")
				.filter(value -> value.startsWith("1"))
				.collect(toList());
		
		print(beginningWithNumbers);
	}
	
	public static void flatMap() {
		
		List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
									.flatMap(numbers -> numbers.stream())
									.collect(toList());
		
		List<Integer> list = Stream.of(10, 20, 30, 40, 50)
									.flatMap(n -> Stream.of(n))
									.collect(toList());
									
		
		print(list);
	}
	
	public static void min() {
		List<String> tracks = asList("10", "8", "4");
		
		String min = tracks.stream()
			.min(Comparator.comparing(s -> Integer.parseInt(s) )).get();
		
		System.out.println("min: " + min);
	}
	
	public static void reduce() {
		int count = Stream.of(1, 2, 3)
						.reduce(0, (acc, element) -> acc + element);
		
		System.out.println(count);
	}
}