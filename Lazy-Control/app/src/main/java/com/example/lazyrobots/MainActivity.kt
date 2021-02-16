package com.example.lazyrobots

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(),AdapterView.OnItemClickListener {

    private var listView:ListView ? = null
    private var arrayAdapter:ArrayAdapter<String> ? = null
    private var itemList = arrayOf("dupa1","dupa2","dupa1","dupa2")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        var searchDeviceButton=findViewById(R.id.searchDeviceButton) as Button
        var button=findViewById(R.id.button2) as Button
        listView=findViewById(R.id.deviceList)
        listView?.choiceMode=ListView.TRANSCRIPT_MODE_NORMAL
        listView?.onItemClickListener=this
        searchDeviceButton.setOnClickListener()
        {
            Toast.makeText(applicationContext,"Dupadaad",Toast.LENGTH_LONG).show()
            arrayAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,itemList)
            listView?.adapter=arrayAdapter
        }
        button.setOnClickListener()
        {
            itemList = arrayOf("dupa1","huwei","dupa1","xiaomi")
            Toast.makeText(applicationContext,"Dupadaad",Toast.LENGTH_LONG).show()
            arrayAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,itemList)
            listView?.adapter=arrayAdapter
        }



        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var items:String=parent?.getItemAtPosition(position) as String
        Toast.makeText(applicationContext,"$items",Toast.LENGTH_LONG).show()
    }
}