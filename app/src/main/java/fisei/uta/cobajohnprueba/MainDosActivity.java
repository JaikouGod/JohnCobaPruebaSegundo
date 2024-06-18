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

public class MainDosActivity extends AppCompatActivity {

    public EditText textViewnombre,textViewapellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_dos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewnombre= findViewById(R.id.editTextName);
        textViewapellido= findViewById(R.id.editTextLastName);

    }
    public void clickNextPage3(View view){
        String nombreEnviar = textViewnombre.getText().toString();
        String apellidoEnviar = textViewapellido.getText().toString();
        Intent intent = new Intent(this, MainTerceroActivity.class);
        intent.putExtra("nombreEnviar",nombreEnviar);
        intent.putExtra("apellidoEnviar",apellidoEnviar);
        startActivity(intent);
    }
}