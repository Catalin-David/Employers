package com.example.roomdatabase2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CompanyDatabase database;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        new DatabaseAsyncTask().execute();

    }

    private class DatabaseAsyncTask extends AsyncTask<Void, Void, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            database = CompanyDatabase.getInstance(MainActivity.this);
        }

        @Override
        protected String doInBackground(Void... voids) {

//            String employees = "";
//            List<Employee> allEmployees = database.employeeDao().getAllEmployees();
//            for(Employee e: allEmployees){
//                employees += e.get_id() + ": " + e.getName() + "\n" + e.getEmail() + "\n" + e.getAddress().getCity()
//                                + "\n" + e.getAddress().getStreet() + "\n" + e.getAddress().getZipCode() + "\n";
//            }
//
//            String abstractString = "";
//            List<AbstractEmployee> abstractEmployees = database.employeeDao().getAbstractEmployees();
//            for(AbstractEmployee e: abstractEmployees){
//                abstractString += e.getName() + " " + e.getEmail() + "\n";
//            }
//
//            return employees;
//            return abstractString;
            String string = "Employees who like Hooking Up: ";
            List<Employee> employeesHo = database.employeeHobbyLinkDao().getEmployeesByHobby("Hooking up");
            for(Employee e: employeesHo){
                string += "\n" + "Id: " + e.get_id() + '\n' + "Name: " + e.getName() + '\n' + "Email: " + e.getEmail() + '\n' + "City: " + e.getAddress().getCity()
                        + '\n' + "Street: " + e.getAddress().getStreet() + '\n' + "Zip code: " + e.getAddress().getZipCode() + '\n' + "--------------------" + '\n';
            }
            string = string + "Employees who like Hiking: ";
            List<Employee> employeesHi = database.employeeHobbyLinkDao().getEmployeesByHobby("Hiking");
            for(Employee e: employeesHi){
                string += "\n" + "Id: " + e.get_id() + '\n' + "Name: " + e.getName() + '\n' + "Email: " + e.getEmail() + '\n' + "City: " + e.getAddress().getCity()
                        + '\n' + "Street: " + e.getAddress().getStreet() + '\n' + "Zip code: " + e.getAddress().getZipCode() + '\n' + "--------------------" + '\n';
            }
            return string;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            textView.setText(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }
}
