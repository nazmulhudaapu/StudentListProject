package com.example.kamrul.studentlistproject;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SingleStudentActivity extends AppCompatActivity {
    TextView id,name,email,phone,address;
    ImageView imageView;
    EditText password;
    String phonestr,mail;
    StudentListManager manager;
    int showId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_student);
        id=(TextView)findViewById(R.id.showSingleId);
        name=(TextView)findViewById(R.id.showSingleName);
        email=(TextView)findViewById(R.id.showSingleEmail);
        phone=(TextView)findViewById(R.id.showSinglePhone);
        address=(TextView)findViewById(R.id.showSinglAddress);
        password=(EditText)findViewById(R.id.showSinglePassword);
        imageView=(ImageView)findViewById(R.id.showSingleImage);
        manager=new StudentListManager(this);
        Intent intent=getIntent();
        phonestr=intent.getStringExtra("phone");
        mail=intent.getStringExtra("email");
        showId=intent.getIntExtra("id", 0);
        id.setText("ID : "+Integer.toString(showId));
        name.setText("NAME : "+intent.getStringExtra("name"));
        email.setText("EMAIL : "+intent.getStringExtra("email"));
        phone.setText("PHONE : "+intent.getStringExtra("phone"));
        address.setText("ADDRESS : "+intent.getStringExtra("address"));
        password.setText("PASSWORD : "+intent.getStringExtra("password"));
        int image=intent.getIntExtra("image", 0);
        imageView.setImageResource(image);


    }
    public void deleteStudent(View view){
        if (manager.delete(showId)) {
            Intent intent = new Intent(SingleStudentActivity.this, StudentListShowActivity.class);
            startActivity(intent);
            finish();
        }
    }
    public void editStudent(View view) {
        Intent intent = new Intent(SingleStudentActivity.this, SignupActivity.class);
        intent.putExtra("id", showId);
        intent.putExtra("up_key", true);
        startActivity(intent);
        finish();
    }
    public void makeCall(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phonestr));

        startActivity(callIntent);

    }
    public void sendSms(View view) {
        Intent msgIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phonestr));
        startActivity(msgIntent);
    }
    public void sendMail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO)
                .setData(new Uri.Builder().scheme("mailto").build())
                .putExtra(Intent.EXTRA_EMAIL, new String[]{ "John Smith <johnsmith@yourdomain.com>" })
                .putExtra(Intent.EXTRA_SUBJECT, "Email subject")
                .putExtra(Intent.EXTRA_TEXT, "Email body");
        startActivity(intent);

        ComponentName emailApp = intent.resolveActivity(getPackageManager());
        ComponentName unsupportedAction = ComponentName.unflattenFromString("com.android.fallback/.Fallback");
        if (emailApp != null && !emailApp.equals(unsupportedAction))
            try {
                // Needed to customise the chooser dialog title since it might default to "Share with"
                // Note that the chooser will still be skipped if only one app is matched
                Intent chooser = Intent.createChooser(intent, "Send email with");
                startActivity(chooser);
                return;
            }
            catch (ActivityNotFoundException ignored) {
            }

        Toast
                .makeText(this, "Couldn't find an email app and account", Toast.LENGTH_LONG)
                .show();

//        Intent i = new Intent(Intent.ACTION_SEND);
//        i.setType("message/rfc822");
//        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{mail});
//        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
//        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
//        try {
//            startActivity(Intent.createChooser(i, "Send mail..."));
//        } catch (android.content.ActivityNotFoundException ex) {
//            Toast.makeText(SingleStudentActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
//        }
      //  Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
//        emailIntent.setData(Uri.parse("mailto:" + mail));
//        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My email's subject");
//        emailIntent.putExtra(Intent.EXTRA_TEXT, "My email's body");
//
//        try {
//            startActivity(Intent.createChooser(emailIntent, "Send email using..."));
//        } catch (android.content.ActivityNotFoundException ex) {
//            Toast.makeText(SingleStudentActivity.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_student, menu);
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
