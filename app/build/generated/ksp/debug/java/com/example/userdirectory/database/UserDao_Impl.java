package com.example.userdirectory.database;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.userdirectory.model.Address;
import com.example.userdirectory.model.Company;
import com.example.userdirectory.model.Geo;
import com.example.userdirectory.model.User;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `users` (`id`,`name`,`username`,`email`,`phone`,`website`,`address_street`,`address_suite`,`address_city`,`address_zipcode`,`address_geo_lat`,`address_geo_lng`,`company_companyName`,`company_catchPhrase`,`company_bs`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final User entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getUsername());
        statement.bindString(4, entity.getEmail());
        statement.bindString(5, entity.getPhone());
        statement.bindString(6, entity.getWebsite());
        final Address _tmpAddress = entity.getAddress();
        statement.bindString(7, _tmpAddress.getStreet());
        statement.bindString(8, _tmpAddress.getSuite());
        statement.bindString(9, _tmpAddress.getCity());
        statement.bindString(10, _tmpAddress.getZipcode());
        final Geo _tmpGeo = _tmpAddress.getGeo();
        statement.bindString(11, _tmpGeo.getLat());
        statement.bindString(12, _tmpGeo.getLng());
        final Company _tmpCompany = entity.getCompany();
        statement.bindString(13, _tmpCompany.getCompanyName());
        statement.bindString(14, _tmpCompany.getCatchPhrase());
        statement.bindString(15, _tmpCompany.getBs());
      }
    };
  }

  @Override
  public Object insertAll(final List<User> users, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUser.insert(users);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<User>> getUsers() {
    final String _sql = "SELECT * FROM users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"users"}, new Callable<List<User>>() {
      @Override
      @NonNull
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfWebsite = CursorUtil.getColumnIndexOrThrow(_cursor, "website");
          final int _cursorIndexOfStreet = CursorUtil.getColumnIndexOrThrow(_cursor, "address_street");
          final int _cursorIndexOfSuite = CursorUtil.getColumnIndexOrThrow(_cursor, "address_suite");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "address_city");
          final int _cursorIndexOfZipcode = CursorUtil.getColumnIndexOrThrow(_cursor, "address_zipcode");
          final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "address_geo_lat");
          final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "address_geo_lng");
          final int _cursorIndexOfCompanyName = CursorUtil.getColumnIndexOrThrow(_cursor, "company_companyName");
          final int _cursorIndexOfCatchPhrase = CursorUtil.getColumnIndexOrThrow(_cursor, "company_catchPhrase");
          final int _cursorIndexOfBs = CursorUtil.getColumnIndexOrThrow(_cursor, "company_bs");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final User _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpUsername;
            _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            final String _tmpWebsite;
            _tmpWebsite = _cursor.getString(_cursorIndexOfWebsite);
            final Address _tmpAddress;
            final String _tmpStreet;
            _tmpStreet = _cursor.getString(_cursorIndexOfStreet);
            final String _tmpSuite;
            _tmpSuite = _cursor.getString(_cursorIndexOfSuite);
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            final String _tmpZipcode;
            _tmpZipcode = _cursor.getString(_cursorIndexOfZipcode);
            final Geo _tmpGeo;
            final String _tmpLat;
            _tmpLat = _cursor.getString(_cursorIndexOfLat);
            final String _tmpLng;
            _tmpLng = _cursor.getString(_cursorIndexOfLng);
            _tmpGeo = new Geo(_tmpLat,_tmpLng);
            _tmpAddress = new Address(_tmpStreet,_tmpSuite,_tmpCity,_tmpZipcode,_tmpGeo);
            final Company _tmpCompany;
            final String _tmpCompanyName;
            _tmpCompanyName = _cursor.getString(_cursorIndexOfCompanyName);
            final String _tmpCatchPhrase;
            _tmpCatchPhrase = _cursor.getString(_cursorIndexOfCatchPhrase);
            final String _tmpBs;
            _tmpBs = _cursor.getString(_cursorIndexOfBs);
            _tmpCompany = new Company(_tmpCompanyName,_tmpCatchPhrase,_tmpBs);
            _item = new User(_tmpId,_tmpName,_tmpUsername,_tmpEmail,_tmpPhone,_tmpWebsite,_tmpAddress,_tmpCompany);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<User>> searchUsers(final String query) {
    final String _sql = "SELECT * FROM users WHERE name LIKE ? OR email LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindString(_argIndex, query);
    _argIndex = 2;
    _statement.bindString(_argIndex, query);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"users"}, new Callable<List<User>>() {
      @Override
      @NonNull
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfWebsite = CursorUtil.getColumnIndexOrThrow(_cursor, "website");
          final int _cursorIndexOfStreet = CursorUtil.getColumnIndexOrThrow(_cursor, "address_street");
          final int _cursorIndexOfSuite = CursorUtil.getColumnIndexOrThrow(_cursor, "address_suite");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "address_city");
          final int _cursorIndexOfZipcode = CursorUtil.getColumnIndexOrThrow(_cursor, "address_zipcode");
          final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "address_geo_lat");
          final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "address_geo_lng");
          final int _cursorIndexOfCompanyName = CursorUtil.getColumnIndexOrThrow(_cursor, "company_companyName");
          final int _cursorIndexOfCatchPhrase = CursorUtil.getColumnIndexOrThrow(_cursor, "company_catchPhrase");
          final int _cursorIndexOfBs = CursorUtil.getColumnIndexOrThrow(_cursor, "company_bs");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final User _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpUsername;
            _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            final String _tmpWebsite;
            _tmpWebsite = _cursor.getString(_cursorIndexOfWebsite);
            final Address _tmpAddress;
            final String _tmpStreet;
            _tmpStreet = _cursor.getString(_cursorIndexOfStreet);
            final String _tmpSuite;
            _tmpSuite = _cursor.getString(_cursorIndexOfSuite);
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            final String _tmpZipcode;
            _tmpZipcode = _cursor.getString(_cursorIndexOfZipcode);
            final Geo _tmpGeo;
            final String _tmpLat;
            _tmpLat = _cursor.getString(_cursorIndexOfLat);
            final String _tmpLng;
            _tmpLng = _cursor.getString(_cursorIndexOfLng);
            _tmpGeo = new Geo(_tmpLat,_tmpLng);
            _tmpAddress = new Address(_tmpStreet,_tmpSuite,_tmpCity,_tmpZipcode,_tmpGeo);
            final Company _tmpCompany;
            final String _tmpCompanyName;
            _tmpCompanyName = _cursor.getString(_cursorIndexOfCompanyName);
            final String _tmpCatchPhrase;
            _tmpCatchPhrase = _cursor.getString(_cursorIndexOfCatchPhrase);
            final String _tmpBs;
            _tmpBs = _cursor.getString(_cursorIndexOfBs);
            _tmpCompany = new Company(_tmpCompanyName,_tmpCatchPhrase,_tmpBs);
            _item = new User(_tmpId,_tmpName,_tmpUsername,_tmpEmail,_tmpPhone,_tmpWebsite,_tmpAddress,_tmpCompany);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
