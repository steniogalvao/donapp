package br.com.vsgdev.donapp.dao;

import br.com.vsgdev.donapp.models.Institution;

/**
 * interface used to persist a institution entity in database
 * <p/>
 * <hr/>
 * Creation Date: 22/10/16 <br/>
 * Update Date: 22/10/16 <br/>
 * <hr/>
 *
 * @author Stênio Galvão
 * @version 1.0.0
 */
public interface InstitutionDAO {

    /**
     * Method that create a institution in the Backendless
     *
     * @param institution some system institution
     * @return An object that can be String or an Institution
     */
    Object createInstitution(Institution institution);

    /**
     * Method that load one institution in the Backendless
     *
     * @param institution some system institution
     * @return An object that can be String or an Institution
     */
    Object loadInstitution(Institution institution);

    /**
     * Method that search a institution in the Backendless
     *
     * @param institution some system institution
     * @return An object that can be String or an Institution
     */
    Object searchInstitution(Institution institution);

    /**
     * Method that update a institution in the Backendless
     *
     * @param institution some system institution
     * @return An object that can be String or an Institution
     */
    Object updateInstitution(Institution institution);

    /**
     * Method that delete a institution in the Backendless
     *
     * @param institution some system institution
     * @return An object that can be String or an Institution
     */
    Object deleteInstitution(Institution institution);


}
