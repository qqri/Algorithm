package Sep2;

import java.util.*;

class Music{
    int index;
    int play;

    public Music(int index , int play) {
        this.index = index;
        this.play = play;
    }
}

class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        Map<String , List<Music> > msMap = new HashMap<String, List<Music>>();

        for(int i = 0 ; i < genres.length ; i++) {
            String gen = genres[i];
            int play = plays[i];

            map.put(gen , map.getOrDefault(gen,0)+play );
            if( !msMap.containsKey(gen) ){
                List<Music> list = new ArrayList<>();
                msMap.put( gen , list );
            }
            Music ms = new Music(i , play);
            msMap.get(gen).add(ms);
        }
        List<Map.Entry<String, Integer>> listEnt = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(listEnt, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //msMap 정렬함
        for(String gen : map.keySet() ) {
            Collections.sort(msMap.get(gen), new Comparator<Music>() {
                        @Override
                        public int compare(Music o1, Music o2) {
                            if(o2.play != o1.play) return o2.play - o1.play;
                            else return o1.index-o2.index;
                        }
                    }
            );}

        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < listEnt.size() ; i++ ) {
            String curGen = listEnt.get(i).getKey();
            List<Music> curMs = msMap.get(curGen);
            ans.add( curMs.get(0).index );
            if(curMs.size() > 1) ans.add( curMs.get(1).index );
        }
        int[] answer = new int[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++ ) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
