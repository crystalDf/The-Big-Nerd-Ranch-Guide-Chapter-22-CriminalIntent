package com.star.criminalintent;



import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class CrimeListActivity extends SingleFragmentActivity
        implements CrimeListFragment.Callbacks, CrimeFragment.Callbacks {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId() {
//        return R.layout.activity_twopane;
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onCrimeSelected(Crime crime) {
        if (findViewById(R.id.detailFragmentContainer) == null) {
            if (crime != null) {
                Intent i = new Intent(this, CrimePagerActivity.class);
                i.putExtra(CrimeFragment.EXTRA_CRIME_ID, crime.getId());
                startActivityForResult(i, CrimeListFragment.REQUEST_CRIME);
            }
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Fragment oldDetail = fragmentManager.findFragmentById(R.id.detailFragmentContainer);

            if (oldDetail != null) {
                fragmentTransaction.remove(oldDetail);
            }

            if (crime != null) {
                Fragment newDetail = CrimeFragment.newInstance(crime.getId());
                fragmentTransaction.add(R.id.detailFragmentContainer, newDetail);
            }

            fragmentTransaction.commit();
        }
    }

    @Override
    public void onCrimeUpdated(Crime crime) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        CrimeListFragment crimeListFragment = (CrimeListFragment)
                fragmentManager.findFragmentById(R.id.fragmentContainer);

        crimeListFragment.updateUI();
    }
}
