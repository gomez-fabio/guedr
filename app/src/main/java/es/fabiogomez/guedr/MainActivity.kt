package es.fabiogomez.guedr

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.canonicalName // De esta manera al mensaje que mostramos abajo, le anteponemos el nombre de la clase.

    override fun onCreate(savedInstanceState: Bundle?) {  // este método recibe como parámetro el savedInstanceState que guardo en el método onSaveInstanceState
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v(TAG, "He pasado por onCreate") // luego en logcat podemos filtrar por el valor del tag.

        if (savedInstanceState == null) {
            Log.v(TAG, "savedInstanceState es null")      // Cuando se crea la activity por primera vez, el parámetro pasado al método siempre será nulo
        } else {
            Log.v(TAG, "savedInstanceState no es null")   // Cuando se destruye y recrea la activity ya no es nulo, ojo, aunque no guarde nada yo, parece que aut. ya guarda algo.
            Log.v(TAG, savedInstanceState.getString("clave"))  // Así recupero, por su clave, las cosas que he guardado en el método onSaveInstanceState
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) { // Metodo que uso, antes de que la activity se destruya, para guardar el estado de las cosas
        super.onSaveInstanceState(outState)
        Log.v(TAG, "He pasado por onSaveInstanceState")

        // Es opcional, comprobamos que no es nulo
        if (outState != null){
            outState.putString("clave", "valor") // Así guardo las cosas que no se guardan automáticamente al ejecutarse el método onSaveInstanceState. Es un diccionario

        }

        outState?.putString("clave", "valor") // esto es lo mismo que lo de arriba, con la interrogación le digo al opcional, si no eres null ejecuta putString.
    }
}
