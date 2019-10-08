package com.cesarsicas.data.features.breeds.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cesarsicas.data.features.breeds.entities.BreedEntity


@Dao
interface BreedDao {
    @Query("SELECT * FROM breed")
    fun getAll(): LiveData<List<BreedEntity>>

    @Insert
    fun insertAll(vararg breeds: BreedEntity)

    @Insert
    fun insertFromList(reeds: List<BreedEntity>)

    @Delete
    fun delete(breed: BreedEntity)

    @Update
    fun update(breed: BreedEntity)

//    @Query("SELECT * FROM breed WHERE i IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<User>

//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): User


}