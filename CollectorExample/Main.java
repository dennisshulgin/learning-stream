import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Main {
	static <T, R> Collector<T, ?, Optional<R>> minMax(Comparator<? super T> comparator,
							BiFunction<? super T, ? super T, ? extends R> finisher) {
		Objects.requireNonNull(comparator);
		Objects.requireNonNull(finisher);
		class Acc {
			T min;
			T max;
			boolean present;

			void add(T element) {
				if(present) {
					min  = comparator.compare(element, min) < 0 ? element : min;
					max  = comparator.compare(element, max) > 0 ? element : max; 
				}else {
					min = max = element;
					present = true;
				}
			}

			Acc combine(Acc other) {
				if(!other.present) 
					return this;
				if(!present)
					return other;
				min = comparator.compare(other.min, min) < 0 ? other.min : min;
				max = comparator.compare(other.max, max) > 0 ? other.max : max;
				return this;
			}
		}
		return Collector.of(Acc::new,
				Acc::add,
				Acc::combine,
				acc -> acc.present ? Optional.of(finisher.apply(acc.min, acc.max)) : Optional.empty());


	}

	public static void main(String... args) {
		Optional<String> str = Stream.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero")
			.collect(minMax((a, b) -> a.length() - b.length(), (a, b) -> a + "|" + b));
		System.out.println(str.get());

	}
}
