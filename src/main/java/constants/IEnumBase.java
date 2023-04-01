package main.java.constants;

import java.util.Objects;
import java.util.Optional;

public interface IEnumBase {

	@SuppressWarnings("unchecked")
	public static <E extends Enum<E> & IEnumBase> Optional<E> getConstByKey(String key, E... obj) {

		if (Objects.isNull(obj)) {
			// 実装不良
			throw new AssertionError();
		}
		
		E[] elements = obj.length == 0 ? (E[]) obj.getClass().getComponentType().getEnumConstants() : obj;

		for (E elem : elements) {
			if (elem.getKey().equals(key)) {
				return Optional.of(elem);
			}
		}
		return Optional.empty();
	}

	String getKey();

}
