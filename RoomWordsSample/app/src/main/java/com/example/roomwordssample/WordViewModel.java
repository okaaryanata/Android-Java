package com.example.roomwordssample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWord;

    public WordViewModel(Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWord = mRepository.getmAllWords();
    }

    LiveData<List<Word>> getmAllWords(){
        return mAllWord;
    }

    public void insert(Word word){
        mRepository.insert(word);
    }
}
