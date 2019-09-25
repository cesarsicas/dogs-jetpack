package com.cesarsicas.data.features.breeds.dao

import androidx.room.*
import com.cesarsicas.data.features.breeds.entities.Breed

@Dao
interface BreedDao {
    @Query("SELECT * FROM breed")
    fun getAll(): List<Breed>

    @Insert
    fun insertAll(vararg breeds: Breed)

    @Delete
    fun delete(breed: Breed)

    @Update
    fun update(breed: Breed)

//    @Query("SELECT * FROM breed WHERE i IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<User>

//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): User


}