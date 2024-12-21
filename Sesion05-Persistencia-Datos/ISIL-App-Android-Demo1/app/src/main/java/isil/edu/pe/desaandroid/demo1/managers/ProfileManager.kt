package isil.edu.pe.desaandroid.demo1.managers

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProfileManager(private val context: Context) {

    val Context.dbDataStore1: DataStore<Preferences> by preferencesDataStore(name = "dbDataStorePerfil1")

    companion object {
        private val CLAVE_NOMBRE = stringPreferencesKey("nombre")
        private val CLAVE_ID_USUARIO = stringPreferencesKey("id_usuario")
        private val CLAVE_FOTO = stringPreferencesKey("foto")
    }

    val datosPerfil1: Flow<Profile> = context.dbDataStore1.data.map { preferencias ->
        Profile(
            nombre = preferencias[CLAVE_NOMBRE] ?: "",
            idUsuario = preferencias[CLAVE_ID_USUARIO] ?: "",
            uriFoto = preferencias[CLAVE_FOTO] ?: ""
        )
    }

    suspend fun guardarPerfil(nombre: String, idUsuario: String, uriFoto: String) {
        context.dbDataStore1.edit { preferencias ->
            preferencias[CLAVE_NOMBRE] = nombre
            preferencias[CLAVE_ID_USUARIO] = idUsuario
            preferencias[CLAVE_FOTO] = uriFoto
        }
    }

}

data class Profile(val nombre: String, val idUsuario: String, val uriFoto: String)