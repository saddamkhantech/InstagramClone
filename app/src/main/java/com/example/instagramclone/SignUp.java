package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

public class SignUp extends AppCompatActivity {

    private TextView name, roll, branch, contact, email;
    Button listActive;
    TextView textView2;
String allData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.name);
        roll = findViewById(R.id.roll);
        branch = findViewById(R.id.branch);
        contact = findViewById(R.id.contact);
        email = findViewById(R.id.email);
        listActive = findViewById(R.id.listActive);
        textView2 = findViewById(R.id.textView2);
        this.getData();

    }

    public void tap(View v) {

        final ParseObject student = new ParseObject("Student");
        student.put("Name", name.getText().toString());
        student.put("Roll", roll.getText().toString());
        student.put("Branch", branch.getText().toString());
        student.put("Contact", contact.getText().toString());
        student.put("Email", email.getText().toString());


        student.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(SignUp.this, student.get("Name") + " Save Successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    public void getData()
    {
        listActive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("Student");
                parseQuery.getInBackground("RLbelXHfE3", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {
                        if (object != null && e == null) {
                            textView2.setText(object.get("Name") + "");
                        }
                    }
                });

            }
        });

    }

    public void getAllData(View view)
    {
        allData="";
        ParseQuery<ParseObject> allQuerry=ParseQuery.getQuery("Student");
        allQuerry.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null)
                {
                    for(ParseObject allname : objects)
                    {
                        allData=allData+allname.getString("Name");
                        textView2.setText(allData);

                    }
                }
            }
        });
    }




}

