package br.com.vsgdev.donapp.dao;

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

    User createUser(User user);

    User loadUser(User user);

    User searchUser(User user);

    User updateUser(User user);

    User deleteUser(User user);


}
