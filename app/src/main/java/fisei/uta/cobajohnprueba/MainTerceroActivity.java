package fisei.uta.cobajohnprueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainTerceroActivity extends AppCompatActivity {

    public EditText textViewnombre,textViewapellido;
    public EditText textViewDividendo , textViewDivisor,textViewNumero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_tercero);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewDividendo = findViewById(R.id.editTextDiviendo);
        textViewDivisor = findViewById(R.id.editTextDivisor);
        textViewNumero = findViewById(R.id.editTextNumeroEnviar);
        Bundle bundlexd = getIntent().getExtras();
       String nombre= bundlexd.getString("nombreEnviar");
       String apellido = bundlexd.getString("apellidoEnviar");
       textViewnombre.setText(nombre);
       textViewapellido.setText(apellido);

    }
    public void onclickReturnPage(View view){
        //Intent intent = new Intent(this, MainDosActivity.class);

        finish();

    }
}