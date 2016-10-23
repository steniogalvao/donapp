package br.com.vsgdev.donapp.dao;

import android.content.Context;

import br.com.vsgdev.donapp.models.User;

/**
 * interface used to persist a user entity in database
 * <p/>
 * <hr/>
 * Creation Date: 22/10/16 <br/>
 * Update Date: 22/10/16 <br/>
 * <hr/>
 *
 * @author Stênio Galvão
 * @version 1.0.0
 */
public interface UserDAO {

    /**
     * Method that create a user in the Backendless
     * @param user some system user
     * @return  An object that can be String or an User
     */
    Object createUser(User user);

    Object loadUser(User user);

    Object searchUser(User user);

    Object updateUser(User user);

    Object deleteUser(User user);


}
