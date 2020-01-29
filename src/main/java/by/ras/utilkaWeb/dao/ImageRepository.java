package by.ras.utilkaWeb.dao;

import java.util.List;

import by.ras.utilkaWeb.dao.domain.Image;
import by.ras.utilkaWeb.dao.exception.ImageStoreDAOException;

/**
 * DAO interface for Image domain
 * 
 * @author Andrei_Rohau
 */
public interface ImageRepository {

	/**
	 * @param images
	 *            is a list of domain Image to save into database
	 * @throws ImageStoreDAOException
	 */
	void save(List<Image> images) throws ImageStoreDAOException;

	/**
	 * @param id
	 *            of the Image to be found
	 * @return found Image or null
	 * @throws ImageStoreDAOException
	 */
	Image findById(Long id) throws ImageStoreDAOException;

	/**
	 * @param id
	 *            of the Image to be deleted
	 * @return amount of deleted rows
	 * @throws ImageStoreDAOException
	 */
	int deleteById(Long id) throws ImageStoreDAOException;

	/**
	 * @param criteria
	 *            is an object in the meaning of searching criteria
	 * @return List<Image> images that comply with criteria
	 * @throws ImageStoreDAOException
	 */
	List<Image> findAll(Image criteria) throws ImageStoreDAOException;

}
