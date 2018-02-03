package app.project.virtualdiary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class MainActiviti extends AppCompatActivity {
    EditText mUsername,mPhone;
    Button mButton;
    Firebase url;
    TextView mResult;
    /*Hey hero*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiti_main);
        Firebase.setAndroidContext(this);
       initializeVariable();

/* 1.
        url = new Firebase("https://virtual-diary-project.firebaseio.com/photos");
*/
        url = new Firebase("https://virtual-diary-project.firebaseio.com/");

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name,value;

                value = mPhone.getText().toString();
                name = mUsername.getText().toString();

                Firebase firebase = url.child(name);
                firebase.push().setValue(value);



            }
        });
    }
    public void initializeVariable(){
        mResult=findViewById(R.id.activity_main_eResult);
        mUsername = findViewById(R.id.activity_main_eusername);
        mPhone = findViewById(R.id.activity_main_ePhone);
        mButton = findViewById(R.id.activity_main_sendbtn);
    }

}
