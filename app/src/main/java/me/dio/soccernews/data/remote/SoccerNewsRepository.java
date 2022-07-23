package me.dio.soccernews.data.remote;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import me.dio.soccernews.App;
import me.dio.soccernews.data.remote.local.SoccerNewsDb;
import me.dio.soccernews.data.remote.SoccerNewsApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SoccerNewsRepository {

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

        localDb = Room.databaseBuilder(App.getInstance(), SoccerNewsDb.class, LOCAL_DB_NAME).build();

    }

    public static SoccerNewsRepository getInstance(){return LazyHolder.INSTANCE;}

    private static class LazyHolder {
        private static final SoccerNewsRepository INSTANCE = new SoccerNewsRepository();
    }

}
