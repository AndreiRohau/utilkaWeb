package by.ras.utilkaWeb.service;

import java.util.List;

import by.ras.utilkaWeb.dao.domain.Image;
import by.ras.utilkaWeb.dao.domain.StorageType;
import by.ras.utilkaWeb.service.exception.ImageStoreServiceException;

/**
 * Service interface for Image domain
 * 
 * @author Andrei_Rohau
 */
public interface ImageService {

	/**
	 * @param storageType
	 *            defines the storage place
	 * @param images
	 *            that are to be saved
	 * @throws ImageStoreServiceException
	 */
	void save(StorageType storageType, List<Image> images) throws ImageStoreServiceException;

	/**
	 * @param key
	 *            of the image to be found
	 * @return found Image or null
	 * @throws ImageStoreServiceException
	 */
	Image findByKey(StorageType storageType, String key) throws ImageStoreServiceException;

	/**
	 * @param key is an identifier of the deleting image
	 * @throws ImageStoreServiceException
	 */
	void delete(StorageType storageType, String key) throws ImageStoreServiceException;
	
	/**
	 * @param criteria
	 *            is an object in the meaning of searching criteria
	 * @return List<Image> images that comply with criteria
	 * @throws ImageStoreServiceException
	 */
	List<Image> findAll(Image criteria) throws ImageStoreServiceException;

}
