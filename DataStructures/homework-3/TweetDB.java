import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class TweetDB {
   /* Note: I have changed the map values to Sets instead of Lists. 
    * I have also changed the return types for the get methods to Set instead of List.
    * I asked if I could do this on piazza which the Professor said I could do. 
    * Check out the first follow up question in the link below.
    * Here is the link to that question and answer: https://piazza.com/class/jzvrxqd33vw619?cid=463
    */
    
    HashMap<String, Set<Tweet>> tweetsPerUser;
    HashMap<String, Set<Tweet>> tweetsPerKeyword;  
    TreeMap<DateTime, Set<Tweet>> tweetsByTime;
    
    public TweetDB(String pathToFile) throws FileNotFoundException, IOException {
        tweetsPerUser = new HashMap<>();               
        tweetsPerKeyword = new HashMap<>();   
        tweetsByTime = new TreeMap<>(); 
        
        FileReader f = new FileReader(pathToFile);
        BufferedReader bf = new BufferedReader(f);
        CsvReader csv = new CsvReader(bf);
        
        for (String[] s = csv.nextLine(); s != null; s = csv.nextLine()) {
            DateTime dt = new DateTime(s[2]);
            Tweet tweet = new Tweet(s[0], dt, s[1]);
            
            Set<Tweet> set = tweetsPerUser.get(s[0]);
            
            if (set == null) {
               Set<Tweet> hs = new HashSet<>();
               tweetsPerUser.put(s[0], hs);
               hs.add(tweet);
            }
            else {
               set.add(tweet);
            }
            
            String[] keywords = removePunctuation(s[1]);
            for (int i = 0; i < keywords.length; i++) {
                Set<Tweet> set2 = tweetsPerKeyword.get(keywords[i]);
                if (set2 == null) {
                   Set<Tweet> hs = new HashSet<>();
                   tweetsPerKeyword.put(keywords[i], hs);
                   hs.add(tweet); 
                }
                else {
                    set2.add(tweet);
                }
            }
            Set<Tweet> set3 = tweetsByTime.get(dt);
            if (set3 == null) {
               Set<Tweet> hs = new HashSet<>();
               tweetsByTime.put(dt, hs);
               hs.add(tweet);
            }
            else {
                set3.add(tweet);
            }
        }
    } 
    
    public Set<Tweet> getTweetsByUser(String user) {
        Set<Tweet> s = tweetsPerUser.get(user);
        if (s == null) {throw new IllegalArgumentException("Could not find user: " + user);}
        return s;
    }
    
    
    public Set<Tweet> getTweetsByKeyword(String kw) {
        Set<Tweet> s = tweetsPerKeyword.get(kw);
        if (s == null) {throw new IllegalArgumentException("Could not find keyword: " + kw);}
        return s;
    }
    
    public Set<Tweet> getTweetsInRange(DateTime start, DateTime end) {
        Set<Tweet> set = new HashSet<>();
        SortedMap<DateTime, Set<Tweet>> sm = tweetsByTime.subMap(start, end);
        for (DateTime dt : sm.keySet()) {
            Set<Tweet> tmp = sm.get(dt);
            for (Tweet t : tmp)
                set.add(t);
        }
        return set; 
    } 
    
    public String[] removePunctuation(String content) {
        String[] str = content.replaceAll("\\p{Punct}", "").split("\\s+");
        
        return str;
    }
    
    public static void main(String[] args) {
          
        try {
            TweetDB tdb = new TweetDB("coachella_tweets.csv");

           /** Part 1: Search by username */
            for(Tweet t : tdb.getTweetsByUser("hannah_frog"))
                System.out.println(t);
            
              
           /** Part 2: Search by keyword */
            for(Tweet t : tdb.getTweetsByKeyword("99"))
                System.out.println(t);
            
            
           /** Part 3: Search by date/time interval */         
            for(Tweet t : tdb.getTweetsInRange(new DateTime("1/6/15 00:00"), new DateTime("1/6/15 5:00")))
                System.out.println(t);
           
            
        } catch (FileNotFoundException e) {
            System.out.println(".csv File not found.");
        } catch (IOException e) {
            System.out.println("Error reading from .csv file.");
        }
        
        
        
        
    }
    
}