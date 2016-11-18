package br.com.vsgdev.donapp.daoImpl;

import android.os.AsyncTask;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.exceptions.BackendlessException;
import com.backendless.persistence.BackendlessDataQuery;


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
public class UserDAOImpl implements UserDAO {

    @Override
    public void logout() {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    try {
                        Backendless.UserService.logout();
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return null;
                }

            };
            Object response = asyncTask.execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public Object login(final User user) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    try {
                        Backendless.UserService.login(user.getEmail(), user.getPassword(), true);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return null;
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
    public Object loginFacebook(final User user) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    try {
                        Backendless.UserService.login(user.getEmail(), user.getPassword(), true);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return null;
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
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    User user = new User();
                    try {
                        user.setUser(Backendless.UserService.findById(((User) objects[0]).getObjectId()));
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return user;
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
    public Object searchUser(User user) {
        return null;
    }

    @Override
    public Object searchByEmail(final User user) {

        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    BackendlessCollection<BackendlessUser> result;
                    try {
                        String whereClause = "email = '" + ((User) objects[0]).getEmail()+"'";
                        BackendlessDataQuery dataQuery = new BackendlessDataQuery();
                        dataQuery.setWhereClause(whereClause);
                        result = Backendless.Persistence.of(BackendlessUser.class).find(dataQuery);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return result;
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
    public Object updateUser(User user) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    User user = new User();
                    try {
                        user.setUser(Backendless.UserService.update(((User) objects[0]).getUser()));
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return user;
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
    public Object deleteUser(User user) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    User user = (User) objects[0];
                    Object result;
                    try {
                        result = Backendless.Persistence.of(BackendlessUser.class).remove(user.getUser());
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return result;
                }

            };
            Object response = asyncTask.execute(user).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
