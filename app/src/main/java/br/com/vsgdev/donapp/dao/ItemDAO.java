package br.com.vsgdev.donapp.dao;

import br.com.vsgdev.donapp.models.Item;

/**
 * interface used to persist a item entity in database
 * <p/>
 * <hr/>
 * Creation Date: 22/10/16 <br/>
 * Update Date: 22/10/16 <br/>
 * <hr/>
 *
 * @author Stênio Galvão
 * @version 1.0.0
 */
public interface ItemDAO {

    /**
     * Method that create a item in the Backendless
     *
     * @param item some system item
     * @return An object that can be String or an Item
     */
    Object createItem(Item item);

    /**
     * Method that load one item in the Backendless
     *
     * @param item some system item
     * @return An object that can be String or an Item
     */
    Object loadItem(Item item);

    /**
     * Method that search a item in the Backendless
     *
     * @param item some system item
     * @return An object that can be String or an Item
     */
    Object searchItem(Item item);

    /**
     * Method that update a item in the Backendless
     *
     * @param item some system item
     * @return An object that can be String or an Item
     */
    Object updateItem(Item item);

    /**
     * Method that delete a item in the Backendless
     *
     * @param item some system item
     * @return An object that can be String or an Item
     */
    Object deleteItem(Item item);


}
