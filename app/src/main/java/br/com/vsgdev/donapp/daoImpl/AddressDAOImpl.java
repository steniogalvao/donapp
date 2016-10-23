package br.com.vsgdev.donapp.daoImpl;

import android.os.AsyncTask;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.exceptions.BackendlessException;

import br.com.vsgdev.donapp.dao.AddressDAO;
import br.com.vsgdev.donapp.models.Address;

/**
 * Implementantio of {@link AddressDAO}, responsable to interact with Backendless API
 * <p>
 * <hr/>
 * Creation Date: 22/10/16 <br/>
 * Update Date: 22/10/16 <br/>
 * <hr/>
 *
 * @author Stênio Galvão
 * @version 1.0.0
 */
public class AddressDAOImpl implements AddressDAO {


    @Override
    public Object createAddress(Address address) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Address savedAddress = new Address();
                    try {
                        savedAddress = Backendless.Persistence.of(Address.class).save((Address) objects[0]);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return savedAddress;
                }

            };
            Object response = asyncTask.execute(address).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object loadAddress(Address address) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Address address = new Address();
                    try {
                        address = Backendless.Persistence.of(Address.class).findById(((Address) objects[0]).getObjectId());
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return address;
                }

            };
            Object response = asyncTask.execute(address).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object searchAddress(Address address) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    BackendlessCollection<Address> itens;
                    try {
                        itens = Backendless.Persistence.of(Address.class).find();
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return itens;
                }

            };
            Object response = asyncTask.execute(address).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object updateAddress(Address address) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Address address = new Address();
                    try {
                        address = Backendless.Persistence.of(Address.class).save((Address) objects[0]);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return address;
                }

            };
            Object response = asyncTask.execute(address).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object deleteAddress(Address address) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Object object;
                    try {
                        object = Backendless.Persistence.of(Address.class).remove((Address) objects[0]);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return object;
                }

            };
            Object response = asyncTask.execute(address).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
