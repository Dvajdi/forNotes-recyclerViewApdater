package app.forge.twice.animationtest.models;

import java.util.ArrayList;

import app.forge.twice.animationtest.handlers.IManager;
import app.forge.twice.animationtest.handlers.IUpdate;

public class Logic {

    private IManager manager;
    public ArrayList<Contact> data = new ArrayList<>();
    private ArrayList<IUpdate> iUpdates = new ArrayList<>();


    private Logic() {
    }

    public static Logic getInstance() {
        return LogicHolder.INSTANCE;
    }

    public static class LogicHolder {
        private final static Logic INSTANCE = new Logic();
    }


    public void onUpdate(IUpdate update) {
        iUpdates.add(update);
    }



    public void update() {
        if (iUpdates != null) {
            for (IUpdate iUpdate : iUpdates) {
                if (iUpdates != null) iUpdate.update(this);
            }
        }
    }



    public void removeIUpdate(IUpdate update) {
        iUpdates.remove(update);
    }


    public void setData(ArrayList<Contact> data) {
        this.data = data;
        update();
    }

    public Logic getData(){
        return this;
    }

    public void setManager(IManager manager) {
        this.manager = manager;
    }
}
