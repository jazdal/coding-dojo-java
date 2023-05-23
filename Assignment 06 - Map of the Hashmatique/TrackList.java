import java.util.HashMap;
import java.util.Set;

public class TrackList {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("Uhaw", "Bakit uhaw sa 'yong sayaw? \nBakit ikaw? \n'Di bibitaw, sa 'yong sa 'yo, \nLaging ikaw \nAko'y giniginaw, halika rito \nDito ka lang sa tabi ko \nMananatiling uhaw, uhaw, uhaw...\n");
        trackList.put("Cupid", "I gave a second chance to Cupid \nBut now I'm left here feeling stupid \nOh, the way he makes me feel that love isn't real \nCupid is so dumb...\n");
        trackList.put("Angels Like You", "I know that you're wrong for me \nGonna wish we never met on the day I leave \nI brought you down to your knees \n'Cause they say that misery loves company \nIt's not your fault I ruin everything \nAnd it's not your fault I can't be what you need \nBaby, angels like you can't fly down hell with me \nI'm everything they said I would be...\n");
        trackList.put("Mahika", "Giliw, 'di mapigil ang bugso ng damdamin ko \nMukhang mapapaamin mo, amin mo, oh \nGiliw, nagpapahiwatig na sa 'yo \nAng damdamin kong napagtanto na gusto kita...\n");

        System.out.println(trackList.get("Mahika"));
        System.out.println("");

        Set<String> keys = trackList.keySet();
        for (String key: keys) {
            System.out.println(key + ":");
            System.out.println(trackList.get(key));
        }
    }
}