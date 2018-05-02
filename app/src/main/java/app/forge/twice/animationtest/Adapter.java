package app.forge.twice.animationtest;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import app.forge.twice.animationtest.handlers.IUpdate;
import app.forge.twice.animationtest.handlers.OnBinder;
import app.forge.twice.animationtest.handlers.Updater;
import app.forge.twice.animationtest.models.Contact;
import app.forge.twice.animationtest.models.Logic;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    public OnBinder binder;
    ArrayList<Contact> data;
    public Updater updater;

    public Updater onPressed = ()->{};
    public Updater onNormal = ()->{
        notifyDataSetChanged();
    };


    public Adapter() {
        Logic.getInstance().onUpdate(onUpdate);
    }

    IUpdate onUpdate = (logic) -> {
        data = logic.data;
        Log.d("my","tut");
        if(updater!=null){
            updater.update();
        }
    };


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_view_for_recycler_view, parent, false);
        Holder h = new Holder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tv.setText(data.get(position).toString());
        binder.bind(holder.tv, data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        Button tv;

        public Holder(View itemView) {
            super(itemView);
            tv = (Button) itemView.findViewById(R.id.textViewInRV);
        }
    }
}
