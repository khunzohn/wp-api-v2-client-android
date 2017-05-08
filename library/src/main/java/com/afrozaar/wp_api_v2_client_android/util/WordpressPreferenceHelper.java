package com.afrozaar.wp_api_v2_client_android.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.afrozaar.athena.preferences.BasePreferenceHelper;
import com.afrozaar.wp_api_v2_client_android.R;


/**
 * Created by jlo on 2015/05/18.
 */
public class WordpressPreferenceHelper extends BasePreferenceHelper {

    private static final String APP_PREFS = "wordpress_preferences";

    private static final String PREF_INITIAL_SETUP_DONE = "pref.initial_setup_done";

    private static final int PREF_USER_WP_ID = R.string.pref_id_wordpress_id;
    private static final int PREF_USER_WP_USERNAME = R.string.pref_id_wordpress_username;
    private static final int PREF_USER_WP_ADMIN = R.string.pref_id_wordpress_admin;
    private static final int PREF_USER_WP_ROLE = R.string.pref_id_wordpress_role;

    public static WordpressPreferenceHelper with(Context context) {
        return new WordpressPreferenceHelper(context);
    }

    private Context context;

    private WordpressPreferenceHelper(Context context) {
        if (context == null) {
            throw new IllegalStateException("Context can not be null!");
        }
        this.context = context;
    }

    @Override
    protected String getAppPreferenceName() {
        return APP_PREFS;
    }

    /* APP PREFERENCES */

    public boolean isInitialSetupDone() {
        return getBooleanPref(context, PREF_INITIAL_SETUP_DONE);
    }

    public void setInitialSetupDone(boolean value) {
        putBooleanPref(context, PREF_INITIAL_SETUP_DONE, value);
    }

    public void resetUserState() {
        SharedPreferences preferences = getPreferences(context);
        preferences.edit().clear().commit();
    }

    public WordpressPreferenceHelper setWordPressUserId(long id) {
        String pref = context.getString(PREF_USER_WP_ID);
        putLongPref(context, pref, id);
        return this;
    }

    public long getWordPressUserId() {
        String pref = context.getString(PREF_USER_WP_ID);
        return getLongPref(context, pref);
    }

    public boolean hasWordPressUserId() {
        return getWordPressUserId() != -1;
    }

    public WordpressPreferenceHelper setWordPressUsername(String username) {
        String pref = context.getString(PREF_USER_WP_USERNAME);
        putStringPref(context, pref, username);
        return this;
    }

    public String getWordPressUsername() {
        String pref = context.getString(PREF_USER_WP_USERNAME);
        return getStringPref(context, pref);
    }

    public WordpressPreferenceHelper setWordPressAdmin(boolean isAdmin) {
        String pref = context.getString(PREF_USER_WP_ADMIN);
        putBooleanPref(context, pref, isAdmin);
        return this;
    }

    public boolean isWordPressAdmin() {
        String pref = context.getString(PREF_USER_WP_ADMIN);
        return getBooleanPref(context, pref);
    }

    public WordpressPreferenceHelper setWordPressRole(String role) {
        String pref = context.getString(PREF_USER_WP_ROLE);
        putStringPref(context, pref, role);
        return this;
    }

    public String getWordPressRole() {
        String pref = context.getString(PREF_USER_WP_ROLE);
        return getStringPref(context, pref);
    }
}
