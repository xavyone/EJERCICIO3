package com.daze.ejercicio3.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.daze.ejercicio3.Entities.Usuario


@Dao

interface UsuarioDAO {
    @Insert
    fun insertUsuario(usuario : Usuario)

    @Update
    fun updateUsuario(usuario : Usuario)
    @Delete

    fun deleteUsuario(usuario : Usuario)

    @Query("SELECT * FROM Usuario")
    fun selectAllusuarios() :  List<Usuario>



    @Query("SELECT * FROM usuario WHERE id =:id ")
    fun selectUsuario(id : Int) : Usuario
}