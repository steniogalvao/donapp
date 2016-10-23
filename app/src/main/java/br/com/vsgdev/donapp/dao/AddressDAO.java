package br.com.vsgdev.donapp.dao;

import br.com.vsgdev.donapp.models.Address;

/**
 * interface used to persist a address entity in database
 * <p/>
 * <hr/>
 * Creation Date: 22/10/16 <br/>
 * Update Date: 22/10/16 <br/>
 * <hr/>
 *
 * @author Stênio Galvão
 * @version 1.0.0
 */
public interface AddressDAO {

    /**
     * Method that create a address in the Backendless
     *
     * @param address some system address
     * @return An object that can be String or an Address
     */
    Object createAddress(Address address);

    /**
     * Method that load one address in the Backendless
     *
     * @param address some system address
     * @return An object that can be String or an Address
     */
    Object loadAddress(Address address);

    /**
     * Method that search a address in the Backendless
     *
     * @param address some system address
     * @return An object that can be String or an Address
     */
    Object searchAddress(Address address);

    /**
     * Method that update a address in the Backendless
     *
     * @param address some system address
     * @return An object that can be String or an Address
     */
    Object updateAddress(Address address);

    /**
     * Method that delete a address in the Backendless
     *
     * @param address some system address
     * @return An object that can be String or an Address
     */
    Object deleteAddress(Address address);


}
