package ru.otus.iostream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Entry2 {
	private int x, y;
	private String message;

	Entry2() {}

	Entry2(int x, int y, String message) {
		this.x = x;
		this.y = y;
		this.message = message;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Entry{" +
				"x=" + x +
				", y=" + y +
				", message='" + message + '\'' +
				'}';
	}
}

public class ObjectMapperDemo {
	public static void main(String ... args) throws JsonProcessingException {
		var mapper = new ObjectMapper();

		var str = mapper.writeValueAsString(new Entry2(1, 2, "Hello"));
		System.out.println(str);

		var obj = mapper.readValue(str, Entry2.class);
		System.out.println(obj);
	}
}
