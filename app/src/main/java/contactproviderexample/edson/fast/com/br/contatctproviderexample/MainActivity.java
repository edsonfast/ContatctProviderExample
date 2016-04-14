package contactproviderexample.edson.fast.com.br.contatctproviderexample;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    // For the SimpleCursorAdapter to match the UserDictionary columns to layout items.
    private static final String[] COLUMNS_TO_BE_BOUND  = new String[] {
            ContactsContract.Data.DISPLAY_NAME,
            ContactsContract.Data.DATA1
    };

    private static final int[] LAYOUT_ITEMS_TO_FILL = new int[] {
            android.R.id.text1,
            android.R.id.text2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView conListView = (ListView) findViewById(R.id.contact_list_view);

        ContentResolver contentResolver = getContentResolver();

        Cursor cursor = contentResolver.query(ContactsContract.Data.CONTENT_URI, null, null, null, null);

        Log.v("URI", ContactsContract.Data.CONTENT_URI.toString());
        Log.v("Contatos", cursor.getCount() + " contatos\n");

        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item,
                cursor,
                COLUMNS_TO_BE_BOUND,
                LAYOUT_ITEMS_TO_FILL,
                0);

        conListView.setAdapter(simpleCursorAdapter);
    }
}
