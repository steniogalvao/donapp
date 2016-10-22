package br.com.vsgdev.donapp.daoImpl;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.VisibleForTesting;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessException;
import com.backendless.exceptions.BackendlessFault;

import br.com.vsgdev.donapp.R;
import br.com.vsgdev.donapp.dao.UserDAO;
import br.com.vsgdev.donapp.models.User;

/**
 * Put the class description here
 * <p/>
 * <hr/>
 * Creation Date: 22/10/16 <br/>
 * Update Date: 22/10/16 <br/>
 * <hr/>
 *
 * @author Stênio Galvão
 * @version 1.0.0
 */
public class userDAOImpl implements UserDAO {
    @VisibleForTesting
    public ProgressDialog mProgressDialog;

    /**
     * Show a progressDialog to user, give the idea that are something running in background
     */

    public void showProgressDialog(Context context) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(context);
            mProgressDialog.setMessage(context.getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    /**
     * hide a progressDialog to user, give the idea that what we are doing in background are finish
     */
    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
    @Override
    public User createUser(User user) throws BackendlessException {
        user.setUser(Backendless.UserService.register(user.getUser()));
        AsyncTask asyncTask = new AsyncTask<User, Void, Void>() {
            @Override
            protected void onPreExecute() {
            }

            @Override
            protected Void doInBackground(User... users) {
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
            }
        };
        return null;
    }

    @Override
    public User loadUser(User user) {
        return null;
    }

    @Override
    public User searchUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }
}
