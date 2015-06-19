package teo.dim.gomena.mydaggerexample;

import android.app.Application;

import dagger.ObjectGraph;

/**
 * Created by css on 6/17/15.
 */
public class MyApplication extends Application {
    private ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();
        graph = ObjectGraph.create(new MyDataModule());
    }

    public ObjectGraph getObjectGraph() {
        return graph;
    }

}
