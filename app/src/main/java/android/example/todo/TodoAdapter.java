package android.example.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TodoAdapter extends BaseAdapter {
    private ArrayList<Todo> todoList;
    private LayoutInflater inflater;


    public TodoAdapter(ArrayList todoList, Context context) {
        this.todoList = todoList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void checkCompleted(int index){
        todoList.get(index).checkCompleted();
    }

    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public Object getItem(int position) {
        return todoList.get(position) ;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.todo_detail,null);
        TextView todoText = view.findViewById(R.id.todoText);
        Button completeButton = view.findViewById(R.id.completeButton);

        if(todoList.get(position).isCompleted()) completeButton.setText("Completed");
        else completeButton.setText("Incompleted");

        view.setTag(position);
        todoText.setText(todoList.get(position).getTask());

        return view;
    }
}
