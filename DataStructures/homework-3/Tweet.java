/**
 * Represent a tweet, including the content, author's username
 * and time when it was posted. 
 */

import java.util.Objects;

public class Tweet {
    
    public String user;
    public DateTime datetime; 
    public String content;
    
    public Tweet(String user, DateTime datetime, String content) {
            this.user = user; 
            this.datetime = datetime;
            this.content = content;       
    }
    
    public String toString(){
        return "@"+this.user+" ["+datetime.toString()+"]: "+content;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(user, datetime, content);
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) {return true;}
        if (that == null) {return false;}
        if (getClass() != that.getClass()) {return false;}
        
        Tweet otherTweet = (Tweet)that;
        
        return (user.equals(otherTweet.user) 
                && datetime.equals(otherTweet.datetime) 
                && content.equals(otherTweet.content));
    }
    
}