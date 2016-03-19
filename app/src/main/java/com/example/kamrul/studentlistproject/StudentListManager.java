package com.example.kamrul.studentlistproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kamrul on 3/17/2016.
 */
public class StudentListManager {
    private Student student;
    private DatabaseHelper healper;
    private SQLiteDatabase database;

    public StudentListManager(Context context) {
        healper = new DatabaseHelper(context);
    }

    public void open() {
        database = healper.getWritableDatabase();
    }

    public void close() {
        healper.close();
    }
    public boolean addContact(Student student){
        this.open();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_NAME,student.getName());
        contentValues.put(DatabaseHelper.COL_EMAIL,student.getEmail());
        contentValues.put(DatabaseHelper.COL_PHONE,student.getPhone());
        contentValues.put(DatabaseHelper.COL_ADDRESS,student.getAddress());
        contentValues.put(DatabaseHelper.COL_PASSWORD,student.getPassword());
        contentValues.put(DatabaseHelper.COL_IMGID,student.getImageId());

        long inserted=database.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
        database.close();

        if(inserted>0){
            return true;
        }else return false;

    }
    public ArrayList<Student> getAllStudentList(){
        this.open();
        ArrayList<Student> studentList=new ArrayList<>();
        Cursor cursor=database.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        if(cursor !=null && cursor.getCount()>0){
            for (int i=0; i<cursor.getCount();i++){
                int id=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
                String name=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
                String email=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EMAIL));
                String phone=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PHONE));
                String address=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ADDRESS));
                String password=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PASSWORD));
                int imgId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_IMGID));
                student=new Student(id,name,email,phone,address,password,imgId);
               studentList.add(student);
                cursor.moveToNext();
            }
        }
        this.close();
        return studentList;
    }

    public boolean delete(int id){
        this.open();
        int deleted=database.delete(DatabaseHelper.TABLE_NAME,DatabaseHelper.COL_ID+"= "+id,null);
        this.close();
        if(deleted>0){
            return true;
        }else return false;
    }
    public boolean updateData(int id,Student student){
        this.open();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_NAME,student.getName());
        contentValues.put(DatabaseHelper.COL_PHONE, student.getPhone());
        long inserted=database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.COL_ID + " = " + id, null);

        this.close();
        if(inserted>0){
            return true;
        }else return false;

    }
    public Student getStudent(int id){

        this.open();

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME,
                new String[]{DatabaseHelper.COL_ID,DatabaseHelper.COL_NAME,DatabaseHelper.COL_EMAIL,DatabaseHelper.COL_PHONE,DatabaseHelper.COL_ADDRESS,DatabaseHelper.COL_PASSWORD},
                DatabaseHelper.COL_ID + " = " + id,null,null,null,null);

        cursor.moveToFirst();

        int mId = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
        String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
        String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EMAIL));
        String phone = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PHONE));
        String address = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ADDRESS));
        String password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PASSWORD));


        student = new Student(mId,name,email,phone,address,password);
        this.close();
        return student;
    }

    public boolean loginChq(String userName, String userPassword) {
        try {
            this.open();

            String qry="select * from "+DatabaseHelper.TABLE_NAME +" where "+DatabaseHelper.COL_NAME+" = '"+userName+"' and "+DatabaseHelper.COL_PASSWORD+" = '"+userPassword+"'";

            Cursor cursor=database.rawQuery(qry,null);

            if(cursor!=null && cursor.getCount()>0)
            {
                this.close();
                return true;
            }
            else{

                this.close();
                return  false;
            }


        }
        catch (Exception e){
            return false;
        }


    }
}
