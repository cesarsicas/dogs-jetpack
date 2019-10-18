package com.cesarsicas.data.features.breeds.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cesarsicas.data.features.breeds.entities.BreedEntity


@Dao
interface BreedDao {
    @Query("SELECT * FROM breed")
    fun getAll(): LiveData<List<BreedEntity>>

    @Query("SELECT * FROM breed WHERE id=:id ")
    fun getById(id: Int): LiveData<BreedEntity>

    @Insert
    fun insertAll(vararg breeds: BreedEntity)

    @Insert
    fun insertFromList(reeds: List<BreedEntity>)

    @Delete
    fun delete(breed: BreedEntity)

    @Update
    fun update(breed: BreedEntity)

}