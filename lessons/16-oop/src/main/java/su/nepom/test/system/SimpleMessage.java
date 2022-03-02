package su.nepom.test.system;

public class SimpleMessage implements Message {
	public enum Type {
		ANSWER_OUT_OF_RANGE,
	}
	private final Type type;

	public SimpleMessage(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "SimpleMessage{" +
				"type=" + type +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SimpleMessage that = (SimpleMessage) o;

		return type == that.type;
	}

	@Override
	public int hashCode() {
		return type != null ? type.hashCode() : 0;
	}
}
