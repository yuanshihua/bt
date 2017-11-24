package com.example.service2;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class MathService {

	public Stream<Long> factorialStream() {
		return Stream.generate(new Supplier<Long>() {
			private long f = 1;
			private long n = 1;
			private long current = 0;
			private long pre = 0;

			@Override
			public Long get() {
				if (n == 1) {
					pre = 1;
					n++;
					return (long) 1;
				}
				if (n == 2) {
					current = 1;
					n++;
					return (long) 1;
				}
				if (n > 2) {
					f = current + pre;
					pre = current;
					current = f;
				}
				return f;
			}
		});
	}
}
