package com.example.muradmomani.anothaone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TvFragment extends Fragment {
    ArrayAdapter<CharSequence> adapter;
    LinkedHashMap<String, String> mp;
    Spinner sp;
    ListView lv;
    //ArrayList<String>als;
    EditText et;
    HashMap<String, String> hm2;
    SimpleAdapter simpleAdapter;
    SimpleAdapter simpleAdapter2;
    List<HashMap<String, String>> bList;

    int listviewImage[] = new int[]{R.drawable.wire, R.drawable.taboo, R.drawable.mentalist, R.drawable.punisher, R.drawable.following, R.drawable.robot, R.drawable.gotham,
            R.drawable.lost, R.drawable.detective, R.drawable.fargo, R.drawable.friends, R.drawable.itc, R.drawable.fras, R.drawable.office, R.drawable.will, R.drawable.family,
            R.drawable.seinfeild, R.drawable.riverdale, R.drawable.love, R.drawable.nineoh, R.drawable.gossip, R.drawable.ahs, R.drawable.chalet, R.drawable.dark, R.drawable.requiem, R.drawable.hannibal,
            R.drawable.ram, R.drawable.deathnote, R.drawable.aot, R.drawable.punch,
            R.drawable.handmade, R.drawable.lies, R.drawable.thisus, R.drawable.got, R.drawable.sherlock, R.drawable.breakingbad, R.drawable.crown, R.drawable.peaky};

    ArrayList<String> listviewTitle;

    String[] listviewShortDescription = new String[]{
            "Baltimore drug scene, seen through the eyes of drug dealers and law enforcement.", "Adventurer James Keziah Delaney returns to London during the War of 1812 to rebuild his late father's shipping empire. However, both the government and his biggest competitor want his inheritance at any cost - even murder.",
            "A famous \"psychic\" outs himself as a fake, and starts working as a consultant for the California Bureau of Investigation so he can find \"Red John\", the madman who killed his wife and daughter.", "After the murder of his family, Marine veteran Frank Castle becomes the vigilante known as \"The Punisher,\" with only one goal in mind: to avenge them.",
            "A brilliant and charismatic, yet psychotic serial killer communicates with other active serial killers and activates a cult of believers following his every command.", "Elliot, a brilliant but highly unstable young cyber-security engineer and vigilante hacker, becomes a key figure in a complex game of global dominance when he and his shadowy allies try to take down the corrupt corporation he works for.",
            "The story behind Detective James Gordon's rise to prominence in Gotham City in the years before Batman's arrival.", "The survivors of a plane crash are forced to work together in order to survive on a seemingly deserted tropical island.", "Seasonal anthology series in which police investigations unearth the personal and professional secrets of those involved, both within and outside the law.",
            "Various chronicles of deception, intrigue and murder in and around frozen Minnesota. Yet all of these tales mysteriously lead back one way or another to Fargo, North Dakota.", "Follows the personal and professional lives of six twenty to thirty-something-year-old friends living in Manhattan.", "The comedic misadventures of Roy, Moss and their grifting supervisor Jen, a rag-tag team of IT support workers at a large corporation headed by a hotheaded yuppie.",
            "Dr. Frasier Crane moves back to his hometown of Seattle, where he lives with his father, and works as a radio psychiatrist.", "A mockumentary on a group of typical office workers, where the workday consists of ego clashes, inappropriate behavior, and tedium.", "Will and Grace live together in an apartment in New York City. He's a gay lawyer, she's a straight interior designer. Their best friends are Jack, a gleeful but proud gay man, and Karen, a charismatic, filthy rich, amoral socialite.",
            "Three different but related families face trials and tribulations in their own uniquely comedic ways.", "The continuing misadventures of neurotic New York City stand-up comedian Jerry Seinfeld and his equally neurotic New York City friends.", "A subversive take on Archie and his friends, exploring small town life, the darkness and weirdness bubbling beneath Riverdale's wholesome facade.", "A program that follows a couple who must navigate the exhilarations and humiliations of intimacy, commitment and other things they were hoping to avoid.", "A group of friends living in Beverly Hills, California make their way through life from their school days into adulthood.",
            "Privileged teens living on the Upper East Side of New York can hide no secret from the ruthless blogger who is always watching.", "An anthology series centering on different characters and locations, including a house with a murderous past, an insane asylum, a witch coven, a freak show, a hotel, a possessed farmhouse, a cult, and the apocalypse.", "A reunion of childhood friends at a remote chalet in the French Alps soon turns into a desperate struggle for survival as they get cut off from rest of the world and a shocking dark secret from the past surfaces.",
            "A family saga with a supernatural twist, set in a German town, where the disappearance of two young children exposes the relationships among four families.", "In 1994, a toddler disappeared from a small Welsh village, never to be seen again. 23 years later, in London, the mother of rising cello star Matilda Gray takes her own life, without ...", "Explores the early relationship between the renowned psychiatrist and his patient, a young FBI criminal profiler, who is haunted by his ability to empathize with serial killers.",
            "An animated series that follows the exploits of a super scientist and his not-so-bright grandson.", "An intelligent high school student goes on a secret crusade to eliminate criminals from the world after discovering a notebook capable of killing anyone whose name is written into it.", "After his hometown is destroyed and his mother is killed, young Eren Yeager vows to cleanse the earth of the giant humanoid Titans that have brought humanity to the brink of extinction.",
            "The story of Saitama, a hero that does it just for fun & can defeat his enemies with a single punch.", "Set in a dystopian future, a woman is forced to live as a concubine under a fundamentalist theocratic dictatorship.", "The apparently perfect lives of three mothers of first graders unravel to the point of murder.", "A heartwarming and emotional story about a unique set of triplets, their struggles, and their wonderful parents.",
            "Nine noble families fight for control over the mythical lands of Westeros, while an ancient enemy returns after being dormant for thousands of years.", "A modern update finds the famous sleuth and his doctor partner solving crime in 21st century London.", "A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's future.", "Follows the political rivalries and romance of Queen Elizabeth II's reign and the events that shaped the second half of the 20th century.",
            "A gangster family epic set in 1919 Birmingham, England; centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby."
    };
    private CustomAdapter mCustomAdapter;
    private CustomAdapter mCustomAdapter2;
    private ArrayList<movies> _Movies = new ArrayList<movies>();
    private ArrayList<movies> _Movies2 = new ArrayList<movies>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv, container, false);

        try {
            int primary = getResources().getColor(R.color.colorPrimaryDark);
            int sec = getResources().getColor(R.color.colorPrimaryDark);

            lv = view.findViewById(R.id.list_view);

            // als =new ArrayList<>();
            sp = (Spinner) view.findViewById(R.id.spn);

            adapter = ArrayAdapter.createFromResource(getContext(), R.array.genres, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp.setAdapter(adapter);

            List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

            mp = new LinkedHashMap<String, String>();

            mp.put("THE WIRE", "Action");
            mp.put("TABOO", "Action");
            mp.put("THE MENTALIST", "Action");
            mp.put("THE PUNISHER", "Action");
            mp.put("THE FOLLOWING", "Action");
            mp.put("MR. ROBOT", "Action");
            mp.put("GOTHAM", "Action");
            mp.put("LOST", "Action");
            mp.put("TRUE DETECTIVE", "Action");
            mp.put("FARGO", "Action");

            mp.put("FRIENDS", "Comedy");
            mp.put("THE IT CROWD", "Comedy");
            mp.put("FRASIER", "Comedy");
            mp.put("THE OFFICE", "Comedy");
            mp.put("WILL & GRACE", "Comedy");
            mp.put("MODERN FAMILY", "Comedy");
            mp.put("SEINFELD", "Comedy");

            mp.put("RIVERDALE", "Romance");
            mp.put("LOVE", "Romance");
            mp.put("90210", "Romance");
            mp.put("GOSSIP GIRL", "Romance");

            mp.put("AMERICAN HORROR STORY", "Horror");
            mp.put("THE CHALET", "Horror");
            mp.put("DARK", "Horror");
            mp.put("REQUIEM", "Horror");
            mp.put("HANNIBAL", "Horror");

            mp.put("RICK & MORTY", "Animation");
            mp.put("DEATHNOTE", "Animation");
            mp.put("ATTACK ON TITAN", "Animation");
            mp.put("ONE-PUNCH MAN", "Animation");

            mp.put("THE HANDMAID TALE", "Drama");
            mp.put("BIG LITTLE LIES", "Drama");
            mp.put("THIS IS US", "Drama");
            mp.put("GAME OF THRONES", "Drama");
            mp.put("SHERLOCK", "Drama");
            mp.put("BREAKING BAD", "Drama");
            mp.put("THE CROWN", "Drama");
            mp.put("PEAKY BLINDERS", "Drama");

            listviewTitle = new ArrayList<>();
            Set keys = mp.keySet();
            listviewTitle.addAll(keys);

           /* for(Object key: keys){
                als.add(mp.get(key));
            }*/

            et = (EditText) view.findViewById(R.id.search);


            for (int i = 0; i < listviewTitle.size(); i++) {
                movies contacts = new movies();
                contacts.setDescription(listviewShortDescription[i]);
                contacts.setTitle(listviewTitle.get(i));
                contacts.setImages(listviewImage[i]);
                _Movies.add(contacts);
            }
            mCustomAdapter = new CustomAdapter(getActivity(), _Movies);
            lv.setAdapter(mCustomAdapter);

            sp.setSelection(1);


            sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (sp.getSelectedItem().equals("All"))
                        lv.setAdapter(mCustomAdapter);
                    else {
                        int x = 0;
                        _Movies2 = new ArrayList<>();

                        for (Map.Entry<String, String> entry : mp.entrySet()) {
                            // Check if value matches with given value

                            if (entry.getValue().equals(sp.getSelectedItem())) {
                                movies contacts2 = new movies();

                                contacts2.setDescription(listviewShortDescription[x]);
                                contacts2.setTitle(listviewTitle.get(x));
                                contacts2.setImages(listviewImage[x]);
                                _Movies2.add(contacts2);

                                // Store the key from entry to the list
                            }
                            x++;

                        }
                        mCustomAdapter2 = new CustomAdapter(getActivity(), _Movies2);
                        lv.setAdapter(mCustomAdapter2);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            et.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    sp.setSelection(0);
                    lv.setAdapter(mCustomAdapter);
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    mCustomAdapter.getFilter().filter(s);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

           /* lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });*/

        } catch (
                RuntimeException e)

        {
            Toast.makeText(getContext(), "Error Loading page please contact us", Toast.LENGTH_LONG).show();
        }
        return view;
    }

    }
