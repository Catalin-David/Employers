package com.example.roomdatabase2;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Employee.class, Hobbies.class, EmployeeHobbyLink.class}, version = 1)
public abstract class CompanyDatabase extends RoomDatabase {

    public abstract EmployeeDao employeeDao();
    public abstract HobbiesDao hobbiesDao();
    public abstract EmployeeHobbyLinkDao employeeHobbyLinkDao();

    public static CompanyDatabase instance;

    public static CompanyDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, CompanyDatabase.class, "company_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(initialCallBack)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback initialCallBack = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new InitialAsyncTask(instance).execute();
        }
    };

    private static class InitialAsyncTask extends AsyncTask<Void, Void, Void>{

        private EmployeeDao employeeDao;
        private HobbiesDao hobbiesDao;
        private EmployeeHobbyLinkDao linkDao;

        public InitialAsyncTask(CompanyDatabase database){
            hobbiesDao = database.hobbiesDao();
            employeeDao = database.employeeDao();
            linkDao = database.employeeHobbyLinkDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            employeeDao.insert(new Employee("David", "cata02dav@yahoo.com", new Address("Cluj-Napoca", "Victoriei", "430122")));
            employeeDao.insert(new Employee("Sherlock", "sherlock@yahoo.com", new Address("Munchen", "Bavaria", "324231")));
            employeeDao.insert(new Employee("Meisam", "meisam@meicode.org", new Address("New-York", "1st", "111111")));

            hobbiesDao.insert(new Hobbies(5, "Hiking"));
            hobbiesDao.insert(new Hobbies(10, "Hooking up"));

            linkDao.insert(new EmployeeHobbyLink(employeeDao.getEmployeeIdByName("Sherlock"), hobbiesDao.getHobbyIdByName("Hiking")));
            linkDao.insert(new EmployeeHobbyLink(employeeDao.getEmployeeIdByName("David"), hobbiesDao.getHobbyIdByName("Hooking up")));
            linkDao.insert(new EmployeeHobbyLink(employeeDao.getEmployeeIdByName("Meisam"), hobbiesDao.getHobbyIdByName("Hooking up")));

            return null;
        }
    }
}
