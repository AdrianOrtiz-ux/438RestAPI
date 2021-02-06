package info.adrian.a438restapi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Destination extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_layout);


        Bundle bundle = this.getIntent().getExtras();
        String checkId = bundle.getString("id");
                    Retrofit retroFit = new Retrofit.Builder()
                            .baseUrl("https://jsonplaceholder.typicode.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    JsonPlaceHolderApi jsonPlaceHolderApi = retroFit.create(JsonPlaceHolderApi.class);

                    Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

                    call.enqueue(new Callback<List<Post>>() {
                        @Override
                        public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                            if (!response.isSuccessful()) {
                                textViewResult.setText("Code: " + response.code());
                                return;
                            }

                            List<Post> posts = response.body();
                            for(Post post:posts){
                                if(post.getUserId() == 1) {
                                    String content = "";
                                    content += "ID: " + post.getId() + "\n";
                                    content += "User ID: " + post.getUserId() + "\n";
                                    content += "Title: " + post.getTitle() + "\n";
                                    content += "Text: " + post.getText() + "\n\n";
                                    textViewResult = findViewById(R.id.text_view_result);
                                    textViewResult.append(content);
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Post>> call, Throwable t) {
                            textViewResult.setText(t.getMessage());
                        }
                    });

            }



}
