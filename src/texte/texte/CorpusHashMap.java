package texte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public abstract class CorpusHashMap implements Corpus {

	private int cpt;
	private ArrayList<Integer> ids;
	private HashMap<Integer, String> categories;

	private int size;

	public void go(int i) {
//		if (ids == null)
			cpt = i;
//		else
                    /*
			cpt = ids.indexOf((Integer) i);
                     *
                     */

	}

	public void setCategories(HashMap<Integer, String> categories) {
		this.categories = categories;
	}

	public CorpusHashMap(int size) {
		this.size = size;
	}

	public CorpusHashMap(ArrayList<Integer> ids) {
		super();
		this.ids = ids;
		cpt = 0;
		size = ids.size();
	}

	public void next() {
		cpt++;
	}

	public void reset() {
		cpt = 0;
	}

	public int getCurrentID() {
		if (ids == null)
			return cpt;

                //Add
                Iterator<Integer> itr = ids.iterator();
                int i=0;
                while(itr.hasNext()){

                    Integer tmp = itr.next();

                    if(i == cpt)
                        return tmp;
                    i++;
                }
                // End add

                return ids.get(cpt);
	}

	public String getCategory() {
		if (categories == null)
			return "-1";

		return categories.get(getCurrentID());
	}

	public int size() {
		return size;
	}

	public boolean hasNext() {
		return (cpt < size);
	}

}
