package android.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    EditText inputText;
    ListView todoList;
    ArrayList<Todo> list;
    TodoAdapter todoAdapter;

    public void onCompleteButton(View view){
        View parentView = (RelativeLayout) view.getParent();
        int index = Integer.parseInt(parentView.getTag().toString());
        todoAdapter.checkCompleted(index);
        todoList.setAdapter(todoAdapter);
    }

    public void onAddItem(View view){
        String text = inputText.getText().toString();

        if(!text.equals("")){

            Todo todo = new Todo(text);
            list.add(todo);

           todoList.setAdapter(todoAdapter);

            inputText.setText("");

        }




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.addButton);
        inputText = findViewById(R.id.inputField);
        todoList = findViewById(R.id.todoListView);
        list = new ArrayList<>();

        todoAdapter = new TodoAdapter(list, this);
    }
}