package com.example.muradmomani.anothaone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.text.Editable;
import android.text.TextWatcher;

import android.widget.AdapterView;

import android.widget.EditText;

import android.widget.ListView;

import android.widget.SimpleAdapter;

import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MovieFragment extends Fragment {
    ArrayAdapter<CharSequence> adapter;
    LinkedHashMap<String, String> mp;
    Spinner sp;
    ListView lv;
    EditText et;

    int listviewImage[] = new int[]{R.drawable.venom, R.drawable.red2, R.drawable.meg, R.drawable.avengers, R.drawable.madmax, R.drawable.diehard, R.drawable.enemy, R.drawable.superman, R.drawable.darkknight, R.drawable.inception,
            R.drawable.shaun, R.drawable.johnny, R.drawable.deadpool, R.drawable.deadpool2, R.drawable.mask,
            R.drawable.starisborn, R.drawable.titanic, R.drawable.notebook, R.drawable.pianist,
            R.drawable.halloween, R.drawable.nun, R.drawable.it, R.drawable.psycho,
            R.drawable.incredibles, R.drawable.coco, R.drawable.yourname, R.drawable.spiritedaway,
            R.drawable.bohemian, R.drawable.alpha, R.drawable.firstmman, R.drawable.room, R.drawable.colonia, R.drawable.memento, R.drawable.doubleid, R.drawable.origins};

    ArrayList<String> listviewTitle;
    String[] listviewShortDescription = new String[]{
            "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego \"Venom\" to save his life. ", "When his peaceful life is threatened by a high-tech assassin, former black-ops agent Frank Moses reassembles his old team in a last ditch effort to survive and uncover his assailants.", "After escaping an attack by what he claims was a 70-foot shark, Jonas Taylor must confront his fears to save those trapped in a sunken submersible.", "The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.",
            "In a post-apocalyptic wasteland, a woman rebels against a tyrannical ruler in search for her homeland with the aid of a group of female prisoners, a psychotic worshiper, and a drifter named Max.", "John McClane, officer of the NYPD, tries to save his wife Holly Gennaro and several others that were taken hostage by German terrorist Hans Gruber during a Christmas party at the Nakatomi Plaza in Los Angeles.", "A man seeks out his exact look-alike after spotting him in a movie.", "Superman reappears after a long absence, but is challenged by an old foe who uses Kryptonian technology for world domination.",
            "When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.",
            "A man decides to turn his moribund life around by winning back his ex-girlfriend, reconciling his relationship with his mother and dealing with an entire community that has returned from the dead to eat the living.", "After a cyber-attack reveals the identity of all of the active undercover agents in Britain, Johnny English is forced to come out of retirement to find the mastermind hacker.", "A fast-talking mercenary with a morbid sense of humor is subjected to a rogue experiment that leaves him with accelerated healing powers and a quest for revenge.", "Foul-mouthed mutant mercenary Wade Wilson (AKA. Deadpool), brings together a team of fellow mutant rogues to protect a young boy with supernatural abilities from the brutal, time-traveling cyborg, Cable.", "Bank clerk Stanley Ipkiss is transformed into a manic superhero when he wears a mysterious mask.",
            "A musician helps a young singer find fame, even as age and alcoholism send his own career into a downward spiral.", "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.", "A poor yet passionate young man falls in love with a rich young woman, giving her a sense of freedom, but they are soon separated because of their social differences.", "A Polish Jewish musician struggles to survive the destruction of the Warsaw ghetto of World War II.",
            "Laurie Strode confronts her long-time foe Michael Myers, the masked figure who has haunted her since she narrowly escaped his killing spree on Halloween night four decades ago.", "A priest with a haunted past and a novice on the threshold of her final vows are sent by the Vatican to investigate the death of a young nun in Romania and confront a malevolent force in the form of a demonic nun.", "In the summer of 1989, a group of bullied kids band together to destroy a shape-shifting monster, which disguises itself as a clown and preys on the children of Derry, their small Maine town.", "A Phoenix secretary embezzles forty thousand dollars from her employer's client, goes on the run, and checks into a remote motel run by a young man under the domination of his mother.",
            "A family of undercover superheroes, while trying to live the quiet suburban life, are forced into action to save the world.", "Aspiring musician Miguel, confronted with his family's ancestral ban on music, enters the Land of the Dead to find his great-great-grandfather, a legendary singer.", "Two strangers find themselves linked in a bizarre way. When a connection forms, will distance be the only thing to keep them apart?", "During her family's move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches, and spirits, and where humans are changed into beasts.",
            "A chronicle of the years leading up to Queen's legendary appearance at the Live Aid (1985) concert.", "In the prehistoric past, a young man struggles to return home after being separated from his tribe during a buffalo hunt. He finds a similarly lost wolf companion and starts a friendship that would change humanity.", "A look at the life of the astronaut, Neil Armstrong, and the legendary space mission that led him to become the first man to walk on the Moon on July 20, 1969.", "Held captive for years in an enclosed space, a woman and her young son finally gain their freedom, allowing the boy to experience the outside world for the first time.", "A young woman's desperate search for her abducted boyfriend draws her into the infamous Colonia Dignidad, a sect nobody has ever escaped from.",
            "A man with short-term memory loss attempts to track down his wife's murderer.", "In Sofia, Bulgaria in 1992, an American doctor takes a detour in life when he helps a mysterious woman escape from her would-be assailant and becomes a victim of mistaken identity, as seen in the Alfred Hitchcock classic North by Northwest.", "A molecular biologist and his laboratory partner uncover evidence that may fundamentally change society as we know it."
    };

    private CustomAdapter mCustomAdapter;
    private CustomAdapter mCustomAdapter2;
    private ArrayList<movies> _Movies = new ArrayList<movies>();
    private ArrayList<movies> _Movies2 = new ArrayList<movies>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        try {

            lv = view.findViewById(R.id.list_view);


            sp = (Spinner) view.findViewById(R.id.spn);


            adapter = ArrayAdapter.createFromResource(getContext(), R.array.genres, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp.setAdapter(adapter);


            List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

            mp = new LinkedHashMap<String, String>();
            mp.put("VENOM", "Action");
            mp.put("RED", "Action");
            mp.put("THE MEG", "Action");
            mp.put("AVENGERS: INFINITY WAR", "Action");
            mp.put("MAD MAX", "Action");
            mp.put("DIE HARD", "Action");
            mp.put("ENEMY", "Action");
            mp.put("SUPERMAN", "Action");
            mp.put("THE DARK KNIGHT", "Action");
            mp.put("INCEPTION", "Action");

            mp.put("SHAUN OF THE DEAD", "Comedy");
            mp.put("JOHNNY ENGLISH", "Comedy");
            mp.put("DEADPOOL", "Comedy");
            mp.put("DEADPOOL 2", "Comedy");
            mp.put("THE MASK", "Comedy");

            mp.put("A STAR IS BORN", "Romance");
            mp.put("TITANIC", "Romance");
            mp.put("THE NOTEBOOK", "Romance");
            mp.put("THE PIANIST", "Romance");


            mp.put("HALLOWEEN", "Horror");
            mp.put("THE NUN", "Horror");
            mp.put("IT", "Horror");
            mp.put("PSYCHO", "Horror");

            mp.put("INCREDIBLES", "Animation");
            mp.put("COCO", "Animation");
            mp.put("YOUR NAME", "Animation");
            mp.put("SPIRITED AWAY", "Animation");

            mp.put("BOHEMIAN RHAPSODY", "Drama");
            mp.put("ALPHA", "Drama");
            mp.put("FIRST MAN", "Drama");
            mp.put("ROOM", "Drama");
            mp.put("COLONIA", "Drama");
            mp.put("MEMENTO", "Drama");
            mp.put("DOUBLE INDEMNITY", "Drama");
            mp.put("I ORIGINS", "Drama");


            listviewTitle = new ArrayList<>();
            Set keys = mp.keySet();
            listviewTitle.addAll(keys);


            for (int i = 0; i < listviewTitle.size(); i++) {
                movies contacts = new movies();
                contacts.setDescription(listviewShortDescription[i]);
                contacts.setTitle(listviewTitle.get(i));
                contacts.setImages(listviewImage[i]);
                _Movies.add(contacts);
            }
            mCustomAdapter = new CustomAdapter(getActivity(), _Movies);
            lv.setAdapter(mCustomAdapter);


            et = (EditText) view.findViewById(R.id.search);

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

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                    Snackbar.make(view, "Add \""+listviewTitle.get(position)+"\" to Watchlist?", Snackbar.LENGTH_LONG)
                            .setAction("ADD", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String title=listviewTitle.get(position);
                                    movies m1=new movies();
                                    m1.setTitle(title);


                                    Intent intent = new Intent(getActivity().getBaseContext(),
                                            WatchlistFragment.class);

                                    intent.putExtra("wTitle",m1.getTitle());

                                    Toast.makeText(getContext(), "added "+title+" to watchlist", Toast.LENGTH_SHORT).show();
                                }
                            }).show();
                }
            });


        } catch (RuntimeException e) {
            Toast.makeText(getContext(), "Error loading page please contact us", Toast.LENGTH_SHORT).show();
        }
        return view;
    }


}