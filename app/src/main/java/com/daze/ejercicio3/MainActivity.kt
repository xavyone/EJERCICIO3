package com.daze.ejercicio3

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.daze.ejercicio3.AppDatabases.AppDatabase
import com.daze.ejercicio3.Entities.Usuario
import com.daze.ejercicio3.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val db= AppDatabase.getDatabase(this)

        var user = Usuario(null, "carlos", "perrito123", true )

        lifecycleScope.launch  (Dispatchers.IO) {

            var usuario = db.UsuarioDao().selectUsuario(1 )

            withContext(Dispatchers.Main)
            {
                //db.UsuarioDao().insertUsuario(user)
                binding.txtUsuario.text = usuario.username
                binding.txtPassword.text = usuario.password
            }
        }



    }
}
