package br.com.vsgdev.donapp.daoImpl;

import android.os.AsyncTask;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.exceptions.BackendlessException;

import br.com.vsgdev.donapp.dao.InstitutionDAO;
import br.com.vsgdev.donapp.models.Institution;

/**
 * Implementantio of {@link InstitutionDAO}, responsable to interact with Backendless API
 * <p>
 * <hr/>
 * Creation Date: 22/10/16 <br/>
 * Update Date: 22/10/16 <br/>
 * <hr/>
 *
 * @author Stênio Galvão
 * @version 1.0.0
 */
public class InstitutionDAOImpl implements InstitutionDAO {


    @Override
    public Object createInstitution(Institution institution) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Institution savedInstitution = new Institution();
                    try {
                        savedInstitution = Backendless.Persistence.of(Institution.class).save((Institution) objects[0]);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return savedInstitution;
                }

            };
            Object response = asyncTask.execute(institution).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object loadInstitution(Institution institution) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Institution institution = new Institution();
                    try {
                        institution = Backendless.Persistence.of(Institution.class).findById(((Institution) objects[0]).getObjectId());
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return institution;
                }

            };
            Object response = asyncTask.execute(institution).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object searchInstitution(Institution institution) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    BackendlessCollection<Institution> itens;
                    try {
                        itens = Backendless.Persistence.of(Institution.class).find();
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return itens;
                }

            };
            Object response = asyncTask.execute(institution).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object updateInstitution(Institution institution) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Institution institution = new Institution();
                    try {
                        institution = Backendless.Persistence.of(Institution.class).save((Institution) objects[0]);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return institution;
                }

            };
            Object response = asyncTask.execute(institution).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object deleteInstitution(Institution institution) {
        try {
            AsyncTask asyncTask = new AsyncTask<Object, Void, Object>() {

                @Override
                protected Object doInBackground(Object... objects) {
                    Object object;
                    try {
                        object = Backendless.Persistence.of(Institution.class).remove((Institution) objects[0]);
                    } catch (BackendlessException e) {
                        return e.getMessage();
                    }
                    return object;
                }

            };
            Object response = asyncTask.execute(institution).get();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
