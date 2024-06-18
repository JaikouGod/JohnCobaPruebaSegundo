package fisei.uta.cobajohnprueba;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
    public EditText textViewDividendo , textViewDivisor, textViewNumero;
    private int code = 1 ;
    ActivityResultLauncher<Intent>resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {
                    if (o.getResultCode()==MainDosActivity.RESULT_OK){
                        //Procesar los datos
                        Bundle  bundleExtras  = getIntent().getExtras();
                        String numero = bundleExtras.getString("numero");
                        textViewDividendo.setText(o.getData().getDataString());
                        textViewDivisor.setText(o.getData().getDataString());
                        textViewNumero.setText(o.getData().getDataString());
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
        textViewDividendo = findViewById(R.id.editTextDiviendo);
        textViewDivisor = findViewById(R.id.editTextDivisor);
        textViewNumero = findViewById(R.id.editTextNumero);

    }
    public void clickNextPage(View view){
        String nombreEnviar = textViewnombre.getText().toString();
        String apellidoEnviar = textViewapellido.getText().toString();
        Intent intent = new Intent(this, ManuActivity.class);
        intent.putExtra("nombreEnviar",nombreEnviar);
        intent.putExtra("apellidoEnviar",apellidoEnviar);
        //startActivity(intent);
        resultLauncher.launch(intent);
        //startActivityForResult(intent,code);
    }
    public void clicCerrar(View view){
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
    public void cerrar(View view){

    }
}