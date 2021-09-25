package com.example.roomdemo.DaoClass;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdemo.EntityClass.UserModel;

import java.util.List;

@Dao
public interface Daoclass {

    @Insert
    void insertAllData(UserModel model);

    @Query("select * from user")
    List<UserModel> getAllData() ;

    //DELETE DATA
    @Query("delete from user where `key`= :id")
    void deleteData(int id);

    //Update Data

    @Query("update user SET name= :name ,age =:age, gender =:gender where `key`= :key")
    void updateData(String name, String age, String gender, int key);
}
