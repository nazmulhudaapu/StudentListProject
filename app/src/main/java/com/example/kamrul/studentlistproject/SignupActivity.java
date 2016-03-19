package com.example.kamrul.studentlistproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SignupActivity extends AppCompatActivity {
    EditText name, email, phone, address, password;
    ArrayList<Student> studentArrayList;
    Button saveBtn;
    StudentListManager manager;
    Student student;
    int imgCount = 0;
    ListView listView;
    boolean operation = false;
    int upId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.address);
        password = (EditText) findViewById(R.id.password);
        listView = (ListView) findViewById(R.id.showList);
        saveBtn = (Button) findViewById(R.id.save);
        manager = new StudentListManager(this);
        studentArrayList = new ArrayList<>();
        upId = getIntent().getIntExtra("id", 0);
        operation = getIntent().getBooleanExtra("up_key", false);
        if (operation) {
            student = manager.getStudent(upId);
            name.setText(student.getName());
            email.setText(student.getEmail());
            email.setText(student.getPhone());
            email.setText(student.getAddress());
            email.setText(student.getPassword());
            saveBtn.setText("Update");
        }
    }

    public void doSave(View view) {
        String nameStr = name.getText().toString();
        String emailStr = email.getText().toString();
        String phoneStr = phone.getText().toString();
        String addressStr = address.getText().toString();
        String passwordStr = password.getText().toString();
        if (operation) {

            if (nameStr.isEmpty() || phoneStr.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Field is Empty", Toast.LENGTH_SHORT).show();
            } else {
                student = new Student(nameStr, emailStr, phoneStr, addressStr, passwordStr);
                manager.updateData(upId, student);
                Intent intent = new Intent(SignupActivity.this, StudentListShowActivity.class);
                startActivity(intent);
                finish();
            }
        } else {


            if (nameStr.length() > 0 && emailStr.length() > 0 && phoneStr.length() > 0 && addressStr.length() > 0 && passwordStr.length() > 0) {

                if (imgCount == 0) {
                    student = new Student(nameStr, emailStr, phoneStr, addressStr, passwordStr, R.drawable.act1);
                    boolean b = manager.addContact(student);
                    if (b) {
                        Toast.makeText(getApplicationContext(), "DATA INSERTED", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "DATA NOT INSERTED", Toast.LENGTH_LONG).show();
                    }
                } else if (imgCount == 1) {
                    student = new Student(nameStr, emailStr, phoneStr, addressStr, passwordStr, R.drawable.act6);
                    boolean b = manager.addContact(student);
                    if (b) {
                        Toast.makeText(getApplicationContext(), "DATA INSERTED", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "DATA NOT INSERTED", Toast.LENGTH_LONG).show();
                    }
                } else if (imgCount == 2) {
                    student = new Student(nameStr, emailStr, phoneStr, addressStr, passwordStr, R.drawable.act2);
                    boolean b = manager.addContact(student);
                    if (b) {
                        Toast.makeText(getApplicationContext(), "DATA INSERTED", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "DATA NOT INSERTED", Toast.LENGTH_LONG).show();
                    }
                } else if (imgCount == 3) {
                    student = new Student(nameStr, emailStr, phoneStr, addressStr, passwordStr, R.drawable.act7);
                    boolean b = manager.addContact(student);
                    if (b) {
                        Toast.makeText(getApplicationContext(), "DATA INSERTED", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "DATA NOT INSERTED", Toast.LENGTH_LONG).show();
                    }
                } else if (imgCount == 4) {
                    student = new Student(nameStr, emailStr, phoneStr, addressStr, passwordStr, R.drawable.act3);
                    boolean b = manager.addContact(student);
                    if (b) {
                        Toast.makeText(getApplicationContext(), "DATA INSERTED", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "DATA NOT INSERTED", Toast.LENGTH_LONG).show();
                    }
                } else if (imgCount == 5) {
                    student = new Student(nameStr, emailStr, phoneStr, addressStr, passwordStr, R.drawable.act8);
                } else if (imgCount == 6) {
                    student = new Student(nameStr, emailStr, phoneStr, addressStr, passwordStr, R.drawable.act4);
                    boolean b = manager.addContact(student);
                    if (b) {
                        Toast.makeText(getApplicationContext(), "DATA INSERTED", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "DATA NOT INSERTED", Toast.LENGTH_LONG).show();
                    }
                } else if (imgCount == 7) {
                    student = new Student(nameStr, emailStr, phoneStr, addressStr, passwordStr, R.drawable.act9);
                    boolean b = manager.addContact(student);
                    if (b) {
                        Toast.makeText(getApplicationContext(), "DATA INSERTED", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "DATA NOT INSERTED", Toast.LENGTH_LONG).show();
                    }
                } else if (imgCount == 8) {
                    student = new Student(nameStr, emailStr, phoneStr, addressStr, passwordStr, R.drawable.act5);
                    boolean b = manager.addContact(student);
                    if (b) {
                        Toast.makeText(getApplicationContext(), "DATA INSERTED", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "DATA NOT INSERTED", Toast.LENGTH_LONG).show();
                    }
                } else if (imgCount == 9) {
                    student = new Student(nameStr, emailStr, phoneStr, addressStr, passwordStr, R.drawable.act10);
                    boolean b = manager.addContact(student);
                    if (b) {
                        Toast.makeText(getApplicationContext(), "DATA INSERTED", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "DATA NOT INSERTED", Toast.LENGTH_LONG).show();
                    }
                }
                imgCount++;
                if (imgCount >= 9) {
                    imgCount = 0;
                }
                // StudentAdapter adapter = new StudentAdapter(getBaseContext(), studentArrayList);
                //listView.setAdapter(adapter);
                name.setText("");
                email.setText("");
                phone.setText("");
                address.setText("");
                password.setText("");

                Intent intent = new Intent(SignupActivity.this, StudentListShowActivity.class);
                startActivity(intent);

            } else {
                Toast.makeText(this, "Field is empty", Toast.LENGTH_LONG).show();
            }
        }

    }

    public void goshow(View view) {
        Intent intent = new Intent(SignupActivity.this, StudentListShowActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signup, menu);
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
