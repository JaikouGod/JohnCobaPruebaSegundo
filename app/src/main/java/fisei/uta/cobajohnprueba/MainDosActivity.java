package fisei.uta.cobajohnprueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainDosActivity extends AppCompatActivity {

    public EditText textViewnombre,textViewapellido;
    ActivityResultLauncher<Intent>resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {
                    if (o.getResultCode()==MainDosActivity.RESULT_OK){
                        //Procesar los datos

                    }
                }
            }
    );

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
        //resultLauncher.launch(intent);
        startActivity(intent);
    }
}