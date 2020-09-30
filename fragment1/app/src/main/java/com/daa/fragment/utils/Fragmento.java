package com.daa.fragment.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.daa.fragment.R;

/*
    Refatoring 3
    Cumple con la (S), del principio de SOLID de buenas prácticas de desarrollo a nivel clases
*/

public class Fragmento {
    private Fragment fragment;
    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;

    public Fragmento(Fragment fragment, FragmentManager fragmentManager) {
        this.fragment = fragment;
        this.fragmentManager = fragmentManager;
    }

    public void cargarFragmento() {
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framePrincipal,fragment);
        transaction.commit();
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }


    public FragmentTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(FragmentTransaction transaction) {
        this.transaction = transaction;
    }

}
