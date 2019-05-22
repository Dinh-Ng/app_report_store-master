package com.zero.rua.reporttracking.Service;

public class APIService {
    private APIService(){
    }
    private static final String base_url = "https://rp.mmgame.asia/";

    public static Dataservice getService() {
        return RetrofitClient.getClient(base_url).create(Dataservice.class);
    }

    private static final String base_url_cam = "https://rp.camgames.live/";

    public static Dataservice getService_cam() {
        return RetrofitClient.getClient(base_url_cam).create(Dataservice.class);
    }
}