package fisei.uta.cobajohnprueba;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ManuActivity extends AppCompatActivity {
    public EditText textViewnombre,textViewapellido;
    public EditText textViewDividendo , textViewDivisor,textViewNumero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewnombre = findViewById(R.id.editTextName);
        textViewapellido = findViewById(R.id.editTextLastName);
        textViewDividendo = findViewById(R.id.editTextDiviendo);
        textViewDivisor = findViewById(R.id.editTextDivisor);
        textViewNumero = findViewById(R.id.editTextNumeroEnviar);
        Bundle bundle = getIntent().getExtras();
        String nombre= bundle.getString("nombreEnviar");
        String apellido = bundle.getString("apellidoEnviar");
        textViewnombre.setText(nombre);
       textViewapellido.setText(apellido);

    }
    public void onclickRetornar(View view){
        String dividendo = textViewDividendo.getText().toString();
        String divisor = textViewDivisor.getText().toString();
        String numero = textViewNumero.getText().toString();
        Intent intent = new Intent();
        intent.setData(Uri.parse(dividendo));
        intent.setData(Uri.parse(divisor));
        intent.setData(Uri.parse(numero));
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

}