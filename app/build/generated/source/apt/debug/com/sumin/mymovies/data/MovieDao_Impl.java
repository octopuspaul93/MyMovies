package com.sumin.mymovies.data;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import android.support.annotation.NonNull;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfMovie;

  private final EntityInsertionAdapter __insertionAdapterOfFavouriteMovie;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfMovie;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfFavouriteMovie;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllMovies;

  public MovieDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovie = new EntityInsertionAdapter<Movie>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `movies`(`uniqueId`,`id`,`voteCount`,`title`,`originalTitle`,`overview`,`posterPath`,`bigPosterPath`,`backdropPath`,`voteAverage`,`releaseDate`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Movie value) {
        stmt.bindLong(1, value.getUniqueId());
        stmt.bindLong(2, value.getId());
        stmt.bindLong(3, value.getVoteCount());
        if (value.getTitle() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTitle());
        }
        if (value.getOriginalTitle() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOriginalTitle());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getOverview());
        }
        if (value.getPosterPath() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPosterPath());
        }
        if (value.getBigPosterPath() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBigPosterPath());
        }
        if (value.getBackdropPath() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getBackdropPath());
        }
        stmt.bindDouble(10, value.getVoteAverage());
        if (value.getReleaseDate() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getReleaseDate());
        }
      }
    };
    this.__insertionAdapterOfFavouriteMovie = new EntityInsertionAdapter<FavouriteMovie>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `favourite_movies`(`uniqueId`,`id`,`voteCount`,`title`,`originalTitle`,`overview`,`posterPath`,`bigPosterPath`,`backdropPath`,`voteAverage`,`releaseDate`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavouriteMovie value) {
        stmt.bindLong(1, value.getUniqueId());
        stmt.bindLong(2, value.getId());
        stmt.bindLong(3, value.getVoteCount());
        if (value.getTitle() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTitle());
        }
        if (value.getOriginalTitle() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOriginalTitle());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getOverview());
        }
        if (value.getPosterPath() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPosterPath());
        }
        if (value.getBigPosterPath() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBigPosterPath());
        }
        if (value.getBackdropPath() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getBackdropPath());
        }
        stmt.bindDouble(10, value.getVoteAverage());
        if (value.getReleaseDate() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getReleaseDate());
        }
      }
    };
    this.__deletionAdapterOfMovie = new EntityDeletionOrUpdateAdapter<Movie>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `movies` WHERE `uniqueId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Movie value) {
        stmt.bindLong(1, value.getUniqueId());
      }
    };
    this.__deletionAdapterOfFavouriteMovie = new EntityDeletionOrUpdateAdapter<FavouriteMovie>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `favourite_movies` WHERE `uniqueId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavouriteMovie value) {
        stmt.bindLong(1, value.getUniqueId());
      }
    };
    this.__preparedStmtOfDeleteAllMovies = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM movies";
        return _query;
      }
    };
  }

  @Override
  public void insertMovie(Movie movie) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMovie.insert(movie);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertFavouriteMovie(FavouriteMovie movie) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfFavouriteMovie.insert(movie);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteMovie(Movie movie) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfMovie.handle(movie);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteFavouriteMovie(FavouriteMovie movie) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfFavouriteMovie.handle(movie);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllMovies() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllMovies.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllMovies.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Movie>> getAllMovies() {
    final String _sql = "SELECT * FROM movies";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Movie>>() {
      private Observer _observer;

      @Override
      protected List<Movie> compute() {
        if (_observer == null) {
          _observer = new Observer("movies") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfUniqueId = _cursor.getColumnIndexOrThrow("uniqueId");
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfVoteCount = _cursor.getColumnIndexOrThrow("voteCount");
          final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
          final int _cursorIndexOfOriginalTitle = _cursor.getColumnIndexOrThrow("originalTitle");
          final int _cursorIndexOfOverview = _cursor.getColumnIndexOrThrow("overview");
          final int _cursorIndexOfPosterPath = _cursor.getColumnIndexOrThrow("posterPath");
          final int _cursorIndexOfBigPosterPath = _cursor.getColumnIndexOrThrow("bigPosterPath");
          final int _cursorIndexOfBackdropPath = _cursor.getColumnIndexOrThrow("backdropPath");
          final int _cursorIndexOfVoteAverage = _cursor.getColumnIndexOrThrow("voteAverage");
          final int _cursorIndexOfReleaseDate = _cursor.getColumnIndexOrThrow("releaseDate");
          final List<Movie> _result = new ArrayList<Movie>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Movie _item;
            final int _tmpUniqueId;
            _tmpUniqueId = _cursor.getInt(_cursorIndexOfUniqueId);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpVoteCount;
            _tmpVoteCount = _cursor.getInt(_cursorIndexOfVoteCount);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpOriginalTitle;
            _tmpOriginalTitle = _cursor.getString(_cursorIndexOfOriginalTitle);
            final String _tmpOverview;
            _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            final String _tmpPosterPath;
            _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
            final String _tmpBigPosterPath;
            _tmpBigPosterPath = _cursor.getString(_cursorIndexOfBigPosterPath);
            final String _tmpBackdropPath;
            _tmpBackdropPath = _cursor.getString(_cursorIndexOfBackdropPath);
            final double _tmpVoteAverage;
            _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            _item = new Movie(_tmpUniqueId,_tmpId,_tmpVoteCount,_tmpTitle,_tmpOriginalTitle,_tmpOverview,_tmpPosterPath,_tmpBigPosterPath,_tmpBackdropPath,_tmpVoteAverage,_tmpReleaseDate);
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
    }.getLiveData();
  }

  @Override
  public LiveData<List<FavouriteMovie>> getAllFavouriteMovies() {
    final String _sql = "SELECT * FROM favourite_movies";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<FavouriteMovie>>() {
      private Observer _observer;

      @Override
      protected List<FavouriteMovie> compute() {
        if (_observer == null) {
          _observer = new Observer("favourite_movies") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfUniqueId = _cursor.getColumnIndexOrThrow("uniqueId");
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfVoteCount = _cursor.getColumnIndexOrThrow("voteCount");
          final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
          final int _cursorIndexOfOriginalTitle = _cursor.getColumnIndexOrThrow("originalTitle");
          final int _cursorIndexOfOverview = _cursor.getColumnIndexOrThrow("overview");
          final int _cursorIndexOfPosterPath = _cursor.getColumnIndexOrThrow("posterPath");
          final int _cursorIndexOfBigPosterPath = _cursor.getColumnIndexOrThrow("bigPosterPath");
          final int _cursorIndexOfBackdropPath = _cursor.getColumnIndexOrThrow("backdropPath");
          final int _cursorIndexOfVoteAverage = _cursor.getColumnIndexOrThrow("voteAverage");
          final int _cursorIndexOfReleaseDate = _cursor.getColumnIndexOrThrow("releaseDate");
          final List<FavouriteMovie> _result = new ArrayList<FavouriteMovie>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FavouriteMovie _item;
            final int _tmpUniqueId;
            _tmpUniqueId = _cursor.getInt(_cursorIndexOfUniqueId);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpVoteCount;
            _tmpVoteCount = _cursor.getInt(_cursorIndexOfVoteCount);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpOriginalTitle;
            _tmpOriginalTitle = _cursor.getString(_cursorIndexOfOriginalTitle);
            final String _tmpOverview;
            _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            final String _tmpPosterPath;
            _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
            final String _tmpBigPosterPath;
            _tmpBigPosterPath = _cursor.getString(_cursorIndexOfBigPosterPath);
            final String _tmpBackdropPath;
            _tmpBackdropPath = _cursor.getString(_cursorIndexOfBackdropPath);
            final double _tmpVoteAverage;
            _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            _item = new FavouriteMovie(_tmpUniqueId,_tmpId,_tmpVoteCount,_tmpTitle,_tmpOriginalTitle,_tmpOverview,_tmpPosterPath,_tmpBigPosterPath,_tmpBackdropPath,_tmpVoteAverage,_tmpReleaseDate);
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
    }.getLiveData();
  }

  @Override
  public Movie getMovieById(int movieId) {
    final String _sql = "SELECT * FROM movies WHERE id == ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, movieId);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUniqueId = _cursor.getColumnIndexOrThrow("uniqueId");
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfVoteCount = _cursor.getColumnIndexOrThrow("voteCount");
      final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
      final int _cursorIndexOfOriginalTitle = _cursor.getColumnIndexOrThrow("originalTitle");
      final int _cursorIndexOfOverview = _cursor.getColumnIndexOrThrow("overview");
      final int _cursorIndexOfPosterPath = _cursor.getColumnIndexOrThrow("posterPath");
      final int _cursorIndexOfBigPosterPath = _cursor.getColumnIndexOrThrow("bigPosterPath");
      final int _cursorIndexOfBackdropPath = _cursor.getColumnIndexOrThrow("backdropPath");
      final int _cursorIndexOfVoteAverage = _cursor.getColumnIndexOrThrow("voteAverage");
      final int _cursorIndexOfReleaseDate = _cursor.getColumnIndexOrThrow("releaseDate");
      final Movie _result;
      if(_cursor.moveToFirst()) {
        final int _tmpUniqueId;
        _tmpUniqueId = _cursor.getInt(_cursorIndexOfUniqueId);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpVoteCount;
        _tmpVoteCount = _cursor.getInt(_cursorIndexOfVoteCount);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpOriginalTitle;
        _tmpOriginalTitle = _cursor.getString(_cursorIndexOfOriginalTitle);
        final String _tmpOverview;
        _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
        final String _tmpPosterPath;
        _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
        final String _tmpBigPosterPath;
        _tmpBigPosterPath = _cursor.getString(_cursorIndexOfBigPosterPath);
        final String _tmpBackdropPath;
        _tmpBackdropPath = _cursor.getString(_cursorIndexOfBackdropPath);
        final double _tmpVoteAverage;
        _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
        final String _tmpReleaseDate;
        _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
        _result = new Movie(_tmpUniqueId,_tmpId,_tmpVoteCount,_tmpTitle,_tmpOriginalTitle,_tmpOverview,_tmpPosterPath,_tmpBigPosterPath,_tmpBackdropPath,_tmpVoteAverage,_tmpReleaseDate);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public FavouriteMovie getFavouriteMovieById(int movieId) {
    final String _sql = "SELECT * FROM favourite_movies WHERE id == ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, movieId);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUniqueId = _cursor.getColumnIndexOrThrow("uniqueId");
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfVoteCount = _cursor.getColumnIndexOrThrow("voteCount");
      final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
      final int _cursorIndexOfOriginalTitle = _cursor.getColumnIndexOrThrow("originalTitle");
      final int _cursorIndexOfOverview = _cursor.getColumnIndexOrThrow("overview");
      final int _cursorIndexOfPosterPath = _cursor.getColumnIndexOrThrow("posterPath");
      final int _cursorIndexOfBigPosterPath = _cursor.getColumnIndexOrThrow("bigPosterPath");
      final int _cursorIndexOfBackdropPath = _cursor.getColumnIndexOrThrow("backdropPath");
      final int _cursorIndexOfVoteAverage = _cursor.getColumnIndexOrThrow("voteAverage");
      final int _cursorIndexOfReleaseDate = _cursor.getColumnIndexOrThrow("releaseDate");
      final FavouriteMovie _result;
      if(_cursor.moveToFirst()) {
        final int _tmpUniqueId;
        _tmpUniqueId = _cursor.getInt(_cursorIndexOfUniqueId);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpVoteCount;
        _tmpVoteCount = _cursor.getInt(_cursorIndexOfVoteCount);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpOriginalTitle;
        _tmpOriginalTitle = _cursor.getString(_cursorIndexOfOriginalTitle);
        final String _tmpOverview;
        _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
        final String _tmpPosterPath;
        _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
        final String _tmpBigPosterPath;
        _tmpBigPosterPath = _cursor.getString(_cursorIndexOfBigPosterPath);
        final String _tmpBackdropPath;
        _tmpBackdropPath = _cursor.getString(_cursorIndexOfBackdropPath);
        final double _tmpVoteAverage;
        _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
        final String _tmpReleaseDate;
        _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
        _result = new FavouriteMovie(_tmpUniqueId,_tmpId,_tmpVoteCount,_tmpTitle,_tmpOriginalTitle,_tmpOverview,_tmpPosterPath,_tmpBigPosterPath,_tmpBackdropPath,_tmpVoteAverage,_tmpReleaseDate);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
