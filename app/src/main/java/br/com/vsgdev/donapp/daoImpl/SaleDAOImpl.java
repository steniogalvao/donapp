package br.com.vsgdev.donapp.daoImpl;

import android.os.AsyncTask;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.exceptions.BackendlessException;

import br.com.vsgdev.donapp.dao.SaleDAO;
import br.com.vsgdev.donapp.models.Sale;

/**
 * Implementantio of {@link SaleDAO}, responsable to interact with Backendless API
 * <p>
 * <hr/>
 * Creation Date: 22/10/16 <br/>
 * Update Date: 22/10/16 <br/>
 * <hr/>
 *
 * @author Stênio Galvão
 * @version 1.0.0
 */
public class SaleDAOImpl implements SaleDAO {


    @Override
    public Object createSale(Sale sale) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Sale sale;
                    try {
                        sale = Backendless.Persistence.of(Sale.class).save((Sale) objects[0]);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return sale;
                }

            };
            Object response = asyncTask.execute(sale).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object loadSale(Sale sale) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Sale sale;
                    try {
                        sale = Backendless.Persistence.of(Sale.class).findById(((Sale) objects[0]).getObjectId());
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return sale;
                }

            };
            Object response = asyncTask.execute(sale).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object searchSale(Sale sale) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    BackendlessCollection<Sale> itens;
                    try {
                        itens = Backendless.Persistence.of(Sale.class).find();
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return itens;
                }

            };
            Object response = asyncTask.execute(sale).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object updateSale(Sale sale) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Sale sale;
                    try {
                        sale = Backendless.Persistence.of(Sale.class).save((Sale) objects[0]);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return sale;
                }

            };
            Object response = asyncTask.execute(sale).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object deleteSale(Sale sale) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Object object;
                    try {
                        object = Backendless.Persistence.of(Sale.class).remove((Sale) objects[0]);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return object;
                }

            };
            Object response = asyncTask.execute(sale).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
