package br.com.vsgdev.donapp.daoImpl;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.VisibleForTesting;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessException;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;

import br.com.vsgdev.donapp.R;
import br.com.vsgdev.donapp.dao.UserDAO;
import br.com.vsgdev.donapp.models.User;

/**
 * Implementantio of {@link UserDAO}, responsable to interact with Backendless API
 * <p>
 * <hr/>
 * Creation Date: 22/10/16 <br/>
 * Update Date: 22/10/16 <br/>
 * <hr/>
 *
 * @author Stênio Galvão
 * @version 1.0.0
 */
public class userDAOImpl implements UserDAO {


    @Override
    public Object createUser(User user) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    User savedUser = new User();
                    try {
                        savedUser.setUser(
                                Backendless.UserService.register(((User) (objects[0])).getUser()));
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return savedUser;
                }

            };
            Object response = asyncTask.execute(user).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object loadUser(User user) {
        return null;
    }

    @Override
    public Object searchUser(User user) {
        return null;
    }

    @Override
    public Object updateUser(User user) {
        return null;
    }

    @Override
    public Object deleteUser(User user) {
        return null;
    }
}
