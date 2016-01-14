package com.afrozaar.wp_api_v2_client_android.rest.interceptor;

import com.afrozaar.wp_api_v2_client_android.util.LogUtils;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import okio.Buffer;

/**
 * @author Jan-Louis Crafford
 *         Created on 2016/01/14.
 */
public class OkHttpDebugInterceptor implements Interceptor {

    private boolean mShowResponse = false;

    private static final String DEBUG_TAG = "OkHttpRequest";

    public OkHttpDebugInterceptor() {
        this(false);
    }

    public OkHttpDebugInterceptor(boolean showResponse) {
        mShowResponse = showResponse;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        LogUtils.d(DEBUG_TAG, "******** [REQUEST START] ********");
        LogUtils.d(DEBUG_TAG, "** URL : " + request.url().toString());
        LogUtils.d(DEBUG_TAG, "** HTTP Method : " + request.method());
        for (String head : request.headers().names()) {
            LogUtils.d(DEBUG_TAG, "HEADER : " + head);
        }

        if (request.body() != null) {
            Buffer buffer = new Buffer();
            request.body().writeTo(buffer);
            String bodyStr = buffer.readUtf8();
            LogUtils.d(DEBUG_TAG, "BODY : " + bodyStr);
        }

        LogUtils.d(DEBUG_TAG, "******** [REQUEST END] ********");

        com.squareup.okhttp.Response response = chain.proceed(request);

        LogUtils.d(DEBUG_TAG, "******** [RESPONSE START] ********");
        LogUtils.d(DEBUG_TAG, "** (" + response.code() + ") " + response.message());

        // Enabling this stops the callbacks from being able to read the response body because the inputstream gets closed.
        // only really useful to check what responses are to create proper handlers
        if (mShowResponse) {
            if (response.body() != null) {
                LogUtils.d(DEBUG_TAG, "** BODY : " + response.body().string());
            }
        }

        LogUtils.d(DEBUG_TAG, "******** [RESPONSE END ********");

        return response;
    }
}
