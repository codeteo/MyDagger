package teo.dim.gomena.mydaggerexample;

import java.util.ArrayList;

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


    public ArrayList<String > createMyDataItems() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(i, "Wow  Android " + i);
        }
        return arrayList;
    }

}
