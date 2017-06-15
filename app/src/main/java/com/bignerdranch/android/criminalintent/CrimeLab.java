package com.bignerdranch.android.criminalintent;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/15 0015.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLeb;
    private List<Crime> mCrimes;

    public static CrimeLab get(Context context) {
        if (sCrimeLeb == null) {
            sCrimeLeb = new CrimeLab(context);
        }
        return sCrimeLeb;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for (int i = 0; i<100;i++) {
            Crime crime = new Crime();
            crime.setmTitle("Crime #" + i);
            crime.setmSolved(i % 2 == 0);
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getmId().equals(id)) {
                return crime;
            }
        }
        return null;
    }

}
