package teo.dim.gomena.mydaggerexample;

import dagger.Module;
import dagger.Provides;

/**
 * Created by css on 6/17/15.
 */
@Module(
        injects = { MainActivity.class }
)
public class MyDataModule {

    public MyDataModule() {
    }

    @Provides
    public MyDataModule provideMyData() {
        return new MyDataModule();
    }


    public String createMyDataItems() {
        return "MyDataString";
    }

}
