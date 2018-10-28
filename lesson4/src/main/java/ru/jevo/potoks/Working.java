package ru.jevo.potoks;

import lombok.Data;
import lombok.SneakyThrows;
import ru.jevo.potoks.make.MakeIron;
import ru.jevo.potoks.make.MakeWood;
import ru.jevo.potoks.structures.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class Working {

    private int count = 20; // Число производства ресурсов по плану
    List<AbstractStructure> structures = new ArrayList<>();
    AbstractStructure currentBuild;
    boolean isBuilding = true;

    public Working() {
        buildProject();
    }

    @SneakyThrows
    public synchronized void build() {
        System.out.println("строим...");
        for (AbstractStructure structure : structures) {
            currentBuild = structure;
            isWork();
            while (isBuilding == false)
                wait();
            MakeWood.wood = MakeWood.wood - structure.getWood();
            MakeIron.iron = MakeIron.iron - structure.getIron();
            System.out.println(structure.getName() + " построен");
            notify();
        }
    }

    @SneakyThrows
    public synchronized void make() {

        for (int i = 0; i <= count; i++) {
            isWork();
            while (isBuilding == true)
                wait();
            final ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.submit(new MakeWood()).get();
            executorService.submit(new MakeIron()).get();
            notify();
        }
    }


    public void isWork() {
        isBuilding = (currentBuild.getIron() < MakeIron.iron && currentBuild.getWood() < MakeWood.wood) ? true : false;
    }

    public void buildProject() {
        structures.add(new Brewery());
        structures.add(new Arsenal());
        structures.add(new Temple());
        structures.add(new Palace());
    }
}
