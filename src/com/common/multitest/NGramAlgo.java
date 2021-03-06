package com.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class NGramAlgo implements Comparable<Object> {

    String word;
    Integer frequency = 1;
    Map<NGramAlgo, NGramAlgo> map = new HashMap<>();

    public NGramAlgo() {
        this.word = "";
    }

    public NGramAlgo(String word) {
        this.word = word;
    }

    public void addToTree(List<List<String>> ngrams) {
        for (List ngram : ngrams) {
            addNgrams(ngram);
        }

    }

    private void addNgrams(List<String> ngram) {
        if (ngram == null || ngram.isEmpty()) {
            return;
        }
        NGramAlgo t = new NGramAlgo(ngram.remove(0).toLowerCase());
        if (this.map.containsKey(t)) {
            t = this.map.get(t);
            t.frequency++;
            this.map.put(t, t);
        } else {
            this.map.put(t, t);
        }
        try {
            this.map.get(t).addNgrams(ngram);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        NGramAlgo t = new NGramAlgo();
        /*t.addToTree(WordChunker.ngrams(4, "A Red-Black tree based NavigableMap implementation. The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time, depending on which constructor is used. Map is pretty cool too\n"
                + "\n"));*/
        System.out.println(t.suggestNext(chunkLastN(3, "Red-Black tree based")));
    }

    public static List<String> chunkLastN(int n,String string){
        List<String> chunks = new ArrayList<>();
        if(string!=null && string.lastIndexOf(" ")==-1){
            chunks.add(string);
        }
        while(string!=null && n>0 && string.lastIndexOf(" ")>0){
            chunks.add(0,string.substring(string.lastIndexOf(" ")).trim());
            string = string.substring(0, string.lastIndexOf(" "));
            n--;
        }
        System.out.println(chunks);
        return chunks;
    }
    @Override
    public int compareTo(Object o) {
        if (!(o instanceof NGramAlgo)) {
            throw new ClassCastException("The object must be compared with NGramAlgo type");
        }
        NGramAlgo w = (NGramAlgo) o;
        if (this.frequency < w.frequency) {            
            return 1;
        } else if (this.frequency == w.frequency) {
            return  0;
        } else {
            return -1;
        }

    }

    public List<NGramAlgo> suggestNext(List<String> chunks) {
        List<String> lst = new ArrayList<>();
        if (chunks == null || chunks.isEmpty()) {
            return Collections.EMPTY_LIST;
        } else if (chunks.size() == 1) {
            Set<NGramAlgo> keySet = this.map.get(new NGramAlgo(chunks.remove(0))).map.keySet();
            ArrayList<NGramAlgo> suggestions = new ArrayList<>(keySet);
              Collections.sort(suggestions);
              return suggestions;
        } else {
            return this.map.get(new NGramAlgo(chunks.remove(0))).suggestNext(chunks);
        }

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.word);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NGramAlgo other = (NGramAlgo) obj;
        if (!Objects.equals(this.word, other.word)) {
            return false;
        }
        return true;
    }

    public void print() {
        System.out.println("word " + this.word + " can be followd by " + this.map.keySet());
        for (Map.Entry e : this.map.entrySet()) {
            ((NGramAlgo) e.getValue()).print();
        }

    }

    @Override
    public String toString() {
        return " \"" + word + "\":" + frequency; //To change body of generated methods, choose Tools | Templates.
    }
}