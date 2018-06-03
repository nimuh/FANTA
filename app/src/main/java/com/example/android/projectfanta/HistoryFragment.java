package com.example.android.projectfanta;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HistoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    private SectionsPageAdapter myAdapters;
    private ViewPager myPagers;
    private FragmentActivity myContext;

    public HistoryFragment() {
        // Required empty public constructor
    }

    private void setUpViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getFragmentManager());
        adapter.addFragment(new WeekFragment(), "Week");
        adapter.addFragment(new MonthFragment(), "Month");
        adapter.addFragment(new YearFragment(), "Year");
        viewPager.setAdapter(adapter);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onAttach(Context context) {
        myContext=(FragmentActivity)context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(getActivity(),drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        //NavigationView myNav = (NavigationView) view.findViewById(R.id.nv);
        toggle.syncState();
        //((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //setupDrawerContent(myNav);

        myAdapters = new SectionsPageAdapter(getFragmentManager());

        myPagers = (ViewPager) view.findViewById(R.id.historyContainer);
        setUpViewPager(myPagers);

        TabLayout tab = (TabLayout)view.findViewById(R.id.historyTabs);
        tab.setupWithViewPager(myPagers);
        return view;
    }

//    public void selectItemDrawer(MenuItem menuItem) {
//        Fragment myFragment = null;
//        Class fragmentClass;
//        switch (menuItem.getItemId()) {
//            case R.id.cal:
//                fragmentClass = HistoryFragment.class;
//                break;
//            case R.id.car:
//                fragmentClass = HistoryFragment.class;
//                break;
//            case R.id.fats:
//                fragmentClass = HistoryFragment.class;
//                break;
//            case R.id.prot:
//                fragmentClass = HistoryFragment.class;
//                break;
//            case R.id.sod:
//                fragmentClass = HistoryFragment.class;
//                break;
//            case R.id.sug:
//                fragmentClass = HistoryFragment.class;
//                break;
//            case R.id.cholesterol:
//                fragmentClass = HistoryFragment.class;
//                break;
//            case R.id.potassium:
//                fragmentClass = HistoryFragment.class;
//                break;
//            case R.id.fiber:
//                fragmentClass = HistoryFragment.class;
//                break;
//            default:
//                fragmentClass = HistoryFragment.class;
//        }
//        try {
//            myFragment = (Fragment) fragmentClass.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        FragmentManager fragmentManager = myContext.getSupportFragmentManager();
//        fragmentManager.beginTransation().replace(R.id.main_content,myFragment).commit();
//        menuItem.setCheckable(true);
//        //setTitle(menuItem.getTitle());
//        drawerLayout.closeDrawers();


//    private void setupDrawerContent(NavigationView navigationView){
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                selectItemDrawer(item);
//                return true;
//            }
//        });

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

