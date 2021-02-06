package info.adrian.a438restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button enterButton = (Button) findViewById(R.id.enter_button);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gets all the edittexts
                EditText tempUserName;
                EditText tempPassWord;
                EditText tempId;
                String userName;
                String passWord;
                String id;

                tempUserName = (EditText) findViewById(R.id.new_username);
                tempPassWord = (EditText) findViewById(R.id.new_password);
                tempId = (EditText) findViewById(R.id.new_Id);

                //converts from EditText to string
                userName = tempUserName.getText().toString();
                passWord = tempPassWord.getText().toString();
                id = tempId.getText().toString();

                String correctUserName = "din_djarin";
                String correctPassWord = "baby_yoda_ftw";

                if(userName.equals(correctUserName) && passWord.equals(correctPassWord)){
                    startNewActivity(id, userName);
                } if(!userName.equals("din_djarin")){
                    Toast newToast = Toast.makeText(MainActivity.this, "Wrong Username", Toast.LENGTH_SHORT);
                    newToast.show();
                } if(!passWord.equals("baby_yoda_ftw")){
                    Toast newToast = Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT);
                    newToast.show();
                }
            }
        });

    }

    public void startNewActivity(String num, String userName){
        Intent newIntent = new Intent(this, Destination.class);
        newIntent.putExtra("passedInfo", num);
        newIntent.putExtra("userName", userName);
        startActivity(newIntent);
    }

}


