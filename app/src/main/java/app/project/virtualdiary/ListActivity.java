package app.project.virtualdiary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    Firebase url;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = findViewById(R.id.activity_list_list);
        Firebase.setAndroidContext(this);
        url = new Firebase("https://virtual-diary-project.firebaseio.com/List");
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        url.addChildEventListener(new ChildEventListener()
        {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                String value = dataSnapshot.getValue(String.class);
                arrayList.add(value);
                arrayAdapter.notifyDataSetChanged(); }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s)
            {
            }
            @Override public void onChildRemoved(DataSnapshot dataSnapshot)
            {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s)
            {
            }
            @Override
            public void onCancelled(FirebaseError firebaseError)
            {
            }
        });
    }
}
