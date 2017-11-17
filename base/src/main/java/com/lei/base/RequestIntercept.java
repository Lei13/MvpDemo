package com.lei.base;


import com.lei.base.util.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;


/**
 * Created by jess on 7/1/16.
 */
public class RequestIntercept implements Interceptor {
    private String message;
    private long last_iglletime;
    private static final long INTERCEPTTIME = 20 * 1000;//防止连续收到非法请求导致的闪屏

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Buffer requestbuffer = new Buffer();
        if (request.body() != null) {
            request.body().writeTo(requestbuffer);
        }
        else {
            LogUtils.e("request.body() == null");
        }

        //打印url信息
        LogUtils.e("Request",
                String.format("Sending Request %s on %n Params --->  %s%n Connection ---> %s%n Headers ---> %s", request.url()
                        , request.body() != null ? requestbuffer.readUtf8() : "null"
                        , chain.connection()
                        , request.headers()));

        long t1 = System.nanoTime();
        Response originalResponse;
        Buffer buffer;
        Charset charset;
        try {
            originalResponse = chain.proceed(request);
            long t2 = System.nanoTime();
            //打赢响应时间
            LogUtils.e("Response", String.format("Received response  in %.1fms%n%s", (t2 - t1) / 1e6d, originalResponse.headers()));

            //读取服务器返回的结果
            ResponseBody responseBody = originalResponse.body();
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            buffer = source.buffer();
            charset = Charset.forName("UTF-8");
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }
        } catch (IllegalStateException e) {
            LogUtils.e("app", "exception------>" + e);
            // this method "throws IOException" anyway so we will not get a crash.
            throw new IOException(e);
        }

        String bodyString = buffer.clone().readString(charset);
        LogUtils.e("app", "Body------>" + bodyString);

        return originalResponse;
    }

    private String JSONTokener(String in) {
        // consume an optional byte order mark (BOM) if it exists
        if (in != null && in.startsWith("\ufeff")) {
            in = in.substring(1);
        }
        return in;
    }
}
