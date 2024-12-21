package isil.edu.pe.desaandroid.demo1.repositories

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import isil.edu.pe.desaandroid.demo1.data.PerfilUsuario
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PerfilUsuarioRepository(private val context: Context) {

    val Context.dbDataStore1: DataStore<Preferences> by preferencesDataStore(name = "dbDataStorePerfil1")

    companion object {
        private val CLAVE_NOMBRE = stringPreferencesKey("nombre")
        private val CLAVE_ID_USUARIO = stringPreferencesKey("id_usuario")
        private val CLAVE_FOTO = stringPreferencesKey("foto")
    }

    val datosPerfil1: Flow<PerfilUsuario> = context.dbDataStore1.data.map { preferencias ->
        PerfilUsuario(
            nombre = preferencias[PerfilUsuarioRepository.CLAVE_NOMBRE] ?: "",
            idUsuario = preferencias[PerfilUsuarioRepository.CLAVE_ID_USUARIO] ?: "",
            uriFoto = preferencias[PerfilUsuarioRepository.CLAVE_FOTO] ?: ""
        )
    }

    suspend fun guardarPerfil(perfilUsuario: PerfilUsuario) {
        context.dbDataStore1.edit { preferencias ->
            preferencias[PerfilUsuarioRepository.CLAVE_NOMBRE] = perfilUsuario.nombre
            preferencias[PerfilUsuarioRepository.CLAVE_ID_USUARIO] = perfilUsuario.idUsuario
            preferencias[PerfilUsuarioRepository.CLAVE_FOTO] = perfilUsuario.uriFoto
        }
    }

}