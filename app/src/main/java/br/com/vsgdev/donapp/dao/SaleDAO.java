package br.com.vsgdev.donapp.dao;

import br.com.vsgdev.donapp.models.Sale;

/**
 * interface used to persist a sale entity in database
 * <p/>
 * <hr/>
 * Creation Date: 22/10/16 <br/>
 * Update Date: 22/10/16 <br/>
 * <hr/>
 *
 * @author Stênio Galvão
 * @version 1.0.0
 */
public interface SaleDAO {

    /**
     * Method that create a sale in the Backendless
     *
     * @param sale some system sale
     * @return An object that can be String or an Sale
     */
    Object createSale(Sale sale);

    /**
     * Method that load one sale in the Backendless
     *
     * @param sale some system sale
     * @return An object that can be String or an Sale
     */
    Object loadSale(Sale sale);

    /**
     * Method that search a sale in the Backendless
     *
     * @param sale some system sale
     * @return An object that can be String or an Sale
     */
    Object searchSale(Sale sale);

    /**
     * Method that update a sale in the Backendless
     *
     * @param sale some system sale
     * @return An object that can be String or an Sale
     */
    Object updateSale(Sale sale);

    /**
     * Method that delete a sale in the Backendless
     *
     * @param sale some system sale
     * @return An object that can be String or an Sale
     */
    Object deleteSale(Sale sale);


}
