/*
Tyler McHugh
CSC 249-N801
3/10/2023
*/

public class Song{
   //declare variables
   String name;
   String artist;
   String album;
   int length;
   Song next;
   Song prev;
   
   public Song()// no arg constructor 
   {
      this.name = "";
      this.artist = "";
      this.album = "";
      this.length = 0;
      this.next = null;
      this.prev = null;
   }
   public Song(String name, String artist, String album, int length)
   {
      this.name = name;
      this.artist = artist;
      this.album = album;
      this.length = length;
      this.next = null;
      this.prev = null;
      
      
   }
   //various getters and setters
   public void setName(String name)
   {
      this.name = name;
   }
   public String getName()
   {
      return name;
   }
   public void setArtist(String artist)
   {
      this.artist = artist;
   }
   public String getArtist()
   {
      return artist;
   }
   public void setAlbum(String album)
   {
      this.album = album;
   }
   public String getAlbum()
   {
      return album;
   }
   public void setLength(int length)
   {
      this.length = length;
   }
   public int getLength()
   {
      return length;
   }
   public Song getNext()
   {
      return next;
   }
   public Song getPrev()
   {
      return prev;
   }
   public void setNext(Song next)
   {
      this.next = next;
   }
   public void setPrev(Song prev)
   {
      this.prev = prev;
   }
  

}