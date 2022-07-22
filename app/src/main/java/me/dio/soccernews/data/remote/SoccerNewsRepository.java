package me.dio.soccernews.data.remote;

import androidx.room.RoomDatabase;

import me.dio.soccernews.App;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SoccerNewsRepository<SoccerNewsDb> {

    //Region Constrants
    private static final String REMOTE_API_URL="https://github.com/luanamouro/soccer-news-api";
    private static final String LOCAL_DB_NAME="soccer-news";

    //Atributos
    private SoccerNewsApi remoteApi;
    private SoccerNewsDb localDb;

    public SoccerNewsApi getRemoteApi(){ return remoteApi;}

    public SoccerNewsDb getLocalDb() {return localDb;}

    //region Singleton
    private SoccerNewsRepository () {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SoccerNewsApi.class);

        localDb = RoomDatabaseBuilder(App.getInstance(), SoccerNewsDb.class, LOCAL_DB_NAME).build();

    }

    public static SoccerNewsRepository getInstance(){return LazyHolder.INSTANCE;}
    private static class LazyHolder {
        private static final SoccerNewsRepository INSTANCE = new SoccerNewsRepository();

    }

    private SoccerNewsDb RoomDatabaseBuilder(App instance) {
    }

}
