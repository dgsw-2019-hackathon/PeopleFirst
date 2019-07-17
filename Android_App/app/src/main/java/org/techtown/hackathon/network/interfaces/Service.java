package org.techtown.hackathon.network.interfaces;

import org.techtown.hackathon.Constants;

public final class Service {
    private Service() {}

    public static void setHostURL(String hostURL) {
        Constants.DEFAULT_HOST = hostURL;
    }

    public static String getHostURL() {
        return Constants.DEFAULT_HOST;
    }
}
