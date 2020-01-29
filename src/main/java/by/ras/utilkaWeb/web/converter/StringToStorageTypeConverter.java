package by.ras.utilkaWeb.web.converter;

import org.springframework.core.convert.converter.Converter;

import by.ras.utilkaWeb.dao.domain.StorageType;

/**
 * Converter is used to convert String from Client side to ENUM StorageType
 * object on the Back
 * 
 * @author Andrei_Rohau
 */
public class StringToStorageTypeConverter implements Converter<String, StorageType> {

	@Override
	public StorageType convert(String storageType) {
		return StorageType.valueOf(storageType.toUpperCase());
	}

}
