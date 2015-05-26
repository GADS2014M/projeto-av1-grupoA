package br.model.enums;

public class UtilEnum {
	
	public static <T extends Enum<T>> void mostraOpcao(Class<T> enumClass) {
		for (Enum<T> item : enumClass.getEnumConstants()) {
			// Mostra valor -> representacao
			System.out.println((item.ordinal() + 1) + "->" + item.toString());
		}
	}
	
	public static <T extends Enum<T>> String getGenericsEnumByCode(
			Class<T> enumClass, int code) {
		for (Enum<T> item : enumClass.getEnumConstants()) {
			if (item.ordinal() == (code - 1)) {
				return item.toString();
			}
		}
		throw new RuntimeException("Id não encontrada");

	}
	
	
	

}
