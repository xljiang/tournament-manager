package edu.gatech.seclass.tourneymanager;

import android.app.Instrumentation;
import android.content.Intent;
import android.test.TouchUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.junit.Test;

import java.util.ArrayList;

import edu.gatech.seclass.tourneymanager.activity.ManagerMode;
import edu.gatech.seclass.tourneymanager.activity.PlayerList4ManagerMode;
import edu.gatech.seclass.tourneymanager.controller.PlayerRepo;
import edu.gatech.seclass.tourneymanager.model.Player;

import static android.R.attr.button;
import static android.support.v4.app.ActivityCompatJB.startActivity;
import static junit.framework.Assert.assertNotNull;
import android.widget.AdapterView.OnItemSelectedListener;
/**
 * Created by vidyakv on 3/9/2017.
 */

public class UnitTests {

    @Test
    public void testAssertions() {
        //test data
        String name= new String ("abcd");
        String username = new String ("ab1234");
        String phonenum = "1234567890";

        //Check that an object isn't null
        assertNotNull(name);

        //Check that an object isn't null
        assertNotNull(username);

        //Check that an object isn't null
        assertNotNull(phonenum);

    }
@Test
public void onClick(View view)
    EditText editTextName;
    EditText editTextUsername;
    EditText editTextPhone;
    String deck = "Engineer";
    Spinner spinnerDropdown;
    Button buttonRegister;
    Button buttonClear;
    editTextName= (EditText) findViewById(R.id.editTextName);
    editTextUsername = (EditText) findViewById(R.id.editTextUsername);
    editTextPhone = (EditText) findViewById(R.id.editTextPhone);



    if (View view == findViewById(R.id.buttonRegistor)){
        PlayerRepo playerRepo = new PlayerRepo(this);
        Player player = new Player();
        ArrayList items2 = playerRepo.getPlayerUsernames();


        if (items2.contains(editTextUsername.getText().toString())) {
            editTextUsername.setError("Username already exists!");

        }
        else {
            // get player properties from UI
            //player.setPlayerID(Integer.parseInt(editTextId.getText().toString()));
            player.setUsername(editTextUsername.getText().toString());
            player.setName(editTextName.getText().toString());
            player.setPhone(editTextPhone.getText().toString());
            player.setDeck(deck);

            // add new player to database
            playerRepo.insert(player);

            Toast.makeText(this, "New Player Added", Toast.LENGTH_SHORT).show();
        }
    }

    if (View view== findViewById(R.id.buttonClear)){

        //editTextId.setText("");
        editTextUsername.setText(String.valueOf(""));
        editTextName.setText(String.valueOf(""));
        editTextPhone.setText(String.valueOf(""));
        spinnerDropdown.setSelection(0);

    }

}
}
    @Test

        public void testButton() {

        button buttonRegistor;
        TouchUtils.clickView(this,buttonRegistor);


}


