/*
Tyler McHugh
CSC 249-N801
3/10/2023
*/

public class Playlist{
   private Song head;
   private Song tail;
   private int size;
  
   public Playlist() //no arg constructor 
   {
      head = new Song();
      tail = new Song();
      head.setNext(tail);
      tail.setPrev(head);
      size = 0; 
   
   }
   //adding a new song to the doubly linked list
   public void addSong(Song song)
   {
      Song endSong = tail.getPrev();
      endSong.setNext(song);
      song.setPrev(endSong);
      song.setNext(tail);
      tail.setPrev(song);
      size++;
      
    }
      
   //inserting a song after the song that is currently playing
   public void insertAfter(Song songOne, Song currentSong)
   {
       if(currentSong == tail.getPrev()) //if the current song is the last song in the playlist it will just add the song
       {
         addSong(songOne);
       }
       else //inserts the song between current song and current songs next song and updates the next and prev values for songOne, currentSong, and nextSong
       {
         Song nextSong = currentSong.getNext();
         songOne.setNext(nextSong);
         songOne.setPrev(currentSong);
         currentSong.setNext(songOne);
         nextSong.setPrev(songOne);
         size++;
       
       }
      
      
      
   
   }
   //removes a song that is selected
   public void removeSong(Song song)
   {
      if(size > 0) //gets the prevSong of song and nextSong of song, then sets the next for prevSong to nextSong and sets the prev for nextSong to prevSong removing the song in the middle which is song. 
      {
         Song prevSong = song.getPrev();
         Song nextSong = song.getNext();
         prevSong.setNext(nextSong);
         nextSong.setPrev(prevSong);
         size--;
      
      }
      
   
   }
   public Song getHead()//return the head
   {
      return head;
   }
   public Song getTail()//return the tail
   {
      return tail;
   }
   public int getSize()//get the size of the list 
   {
      return size; 
   }
   //tostring method to print out everything
   public String toString()
   {
      
      String playlist = ""; //creates a string called playlist to add songs to in order to print out the playlist 
      int mins = 0;
      int secs = 0;
      Song currentSong = head.getNext(); //gets the first song in the playlist
      while(currentSong != tail) //uses while loop to print out the entire playlist until it reaches the tail 
      {
         playlist +=  currentSong.getName() + " by " + currentSong.getArtist() + " from album " + currentSong.getAlbum() + " (" + currentSong.getLength() + "s)\n";
         mins += currentSong.getLength() / 60; //calculates minutes for playlist length
         secs += currentSong.getLength() % 60;//calculates seconds for playlist length
         currentSong = currentSong.getNext();    //retrieves the next song in the playlist
      }
      if(secs >= 60) //makes sure that seconds is not over 60, if it is it will adjust accordingly 
      {
         mins += secs / 60;
         secs %= 60;
      }
      playlist += "Playlist Length: " + mins + "m " + secs + "s\n";
      playlist += "Number of songs: " + size + "\n";
      
      return playlist;
     
   
   }



}