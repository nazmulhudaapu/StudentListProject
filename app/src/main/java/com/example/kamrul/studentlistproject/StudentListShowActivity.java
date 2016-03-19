package com.example.kamrul.studentlistproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class StudentListShowActivity extends AppCompatActivity {
    StudentListManager manager;
    ListView listView;
    ArrayList<Student> studentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list_show);
        listView=(ListView)findViewById(R.id.listView);
        manager=new StudentListManager(this);
        studentArrayList=manager.getAllStudentList();
        StudentAdapter adapter=new StudentAdapter(getBaseContext(),studentArrayList);
        listView.setAdapter(adapter);
        listitemClick();
    }
public void listitemClick(){
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent=new Intent(StudentListShowActivity.this,SingleStudentActivity.class);
            intent.putExtra("id",studentArrayList.get(position).getId());
            intent.putExtra("name",studentArrayList.get(position).getName());
            intent.putExtra("email",studentArrayList.get(position).getEmail());
            intent.putExtra("phone",studentArrayList.get(position).getPhone());
            intent.putExtra("address",studentArrayList.get(position).getAddress());
            intent.putExtra("password",studentArrayList.get(position).getPassword());
            intent.putExtra("image",studentArrayList.get(position).getImageId());
            startActivity(intent);

        }
    });
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_student_list_show, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
