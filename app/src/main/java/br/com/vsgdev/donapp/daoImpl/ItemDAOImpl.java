package br.com.vsgdev.donapp.daoImpl;

import android.os.AsyncTask;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.exceptions.BackendlessException;

import br.com.vsgdev.donapp.dao.ItemDAO;
import br.com.vsgdev.donapp.models.Item;

/**
 * Implementantio of {@link ItemDAO}, responsable to interact with Backendless API
 * <p>
 * <hr/>
 * Creation Date: 22/10/16 <br/>
 * Update Date: 22/10/16 <br/>
 * <hr/>
 *
 * @author Stênio Galvão
 * @version 1.0.0
 */
public class ItemDAOImpl implements ItemDAO {


    @Override
    public Object createItem(Item item) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Item savedItem = (Item) objects[0];
                    try {
                        savedItem = Backendless.Persistence.of(Item.class).save(savedItem);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return savedItem;
                }

            };
            Object response = asyncTask.execute(item).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object loadItem(Item item) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Item item = new Item();
                    try {
                        item = Backendless.Persistence.of(Item.class).findById(((Item) objects[0]).getObjectId());
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return item;
                }

            };
            Object response = asyncTask.execute(item).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object searchItem(Item item) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    BackendlessCollection<Item> itens;
                    try {
                        itens = Backendless.Persistence.of(Item.class).find();
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return itens;
                }

            };
            Object response = asyncTask.execute(item).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object updateItem(Item item) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Item item = new Item();
                    try {
                        item = Backendless.Persistence.of(Item.class).save((Item) objects[0]);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return item;
                }

            };
            Object response = asyncTask.execute(item).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object deleteItem(Item item) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Object object;
                    try {
                        object = Backendless.Persistence.of(Item.class).remove((Item) objects[0]);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return object;
                }

            };
            Object response = asyncTask.execute(item).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
