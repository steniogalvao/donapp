package br.com.vsgdev.donapp.dao;

import br.com.vsgdev.donapp.models.Category;

/**
 * interface used to persist a category entity in database
 * <p/>
 * <hr/>
 * Creation Date: 22/10/16 <br/>
 * Update Date: 22/10/16 <br/>
 * <hr/>
 *
 * @author Stênio Galvão
 * @version 1.0.0
 */
public interface CategoryDAO {

    /**
     * Method that create a category in the Backendless
     *
     * @param category some system category
     * @return An object that can be String or an Category
     */
    Object createCategory(Category category);

    /**
     * Method that load one category in the Backendless
     *
     * @param category some system category
     * @return An object that can be String or an Category
     */
    Object loadCategory(Category category);

    /**
     * Method that search a category in the Backendless
     *
     * @param category some system category
     * @return An object that can be String or an Category
     */
    Object searchCategory(Category category);

    /**
     * Method that update a category in the Backendless
     *
     * @param category some system category
     * @return An object that can be String or an Category
     */
    Object updateCategory(Category category);

    /**
     * Method that delete a category in the Backendless
     *
     * @param category some system category
     * @return An object that can be String or an Category
     */
    Object deleteCategory(Category category);


}
