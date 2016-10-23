package br.com.vsgdev.donapp.daoImpl;

import android.os.AsyncTask;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.exceptions.BackendlessException;

import br.com.vsgdev.donapp.dao.CategoryDAO;
import br.com.vsgdev.donapp.models.Category;

/**
 * Implementantio of {@link CategoryDAO}, responsable to interact with Backendless API
 * <p>
 * <hr/>
 * Creation Date: 22/10/16 <br/>
 * Update Date: 22/10/16 <br/>
 * <hr/>
 *
 * @author Stênio Galvão
 * @version 1.0.0
 */
public class CategoryDAOImpl implements CategoryDAO {


    @Override
    public Object createCategory(Category category) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Category savedCategory = new Category();
                    try {
                        savedCategory = Backendless.Persistence.of(Category.class).save((Category) objects[0]);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return savedCategory;
                }

            };
            Object response = asyncTask.execute(category).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object loadCategory(Category category) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Category category = new Category();
                    try {
                        category = Backendless.Persistence.of(Category.class).findById(((Category) objects[0]).getObjectId());
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return category;
                }

            };
            Object response = asyncTask.execute(category).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object searchCategory(Category category) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    BackendlessCollection<Category> itens;
                    try {
                        itens = Backendless.Persistence.of(Category.class).find();
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return itens;
                }

            };
            Object response = asyncTask.execute(category).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object updateCategory(Category category) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Category category = new Category();
                    try {
                        category = Backendless.Persistence.of(Category.class).save((Category) objects[0]);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return category;
                }

            };
            Object response = asyncTask.execute(category).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object deleteCategory(Category category) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Object object;
                    try {
                        object = Backendless.Persistence.of(Category.class).remove((Category) objects[0]);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return object;
                }

            };
            Object response = asyncTask.execute(category).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
