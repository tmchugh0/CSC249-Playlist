import java.util.*;
/*
Tyler McHugh
CSC 249-N801
3/10/2023
Purpose: To create a Playlist that allows the user to add songs, insert songs at a certain location in the playlist, remove songs, display the current song, 
print the contents of the playlist, skip to the next song, or return to the previous song. 
*/

public class Demo{

   public static void main(String[] args)
   {
      //declare variables
      int answer = 0; //selection from the menu by the user
      String songName; //string to hold the name of the song
      String artistName;//string to hold the name of the artist
      String albumName;//string to hold the album name
      int songLength;//int to hold length of song in seconds
      
      
      Scanner keyboard = new Scanner(System.in);//create scanner
      Playlist newPlaylist = new Playlist();//create playlist object
      Song currentSong = newPlaylist.getHead();//create current song object
      //Song nextSong = currentSong.getNext();//create next song object
      
      //displays the list of choices for the user
      System.out.println("Please select an option from the list:");
      System.out.println("    1. Add a song to the playlist");
      System.out.println("    2. Insert new song after current song");
      System.out.println("    3. Print contents of playlist");
      System.out.println("    4. Display the current song");
      System.out.println("    5. Remove the current song");
      System.out.println("    6. Skip to the next song");
      System.out.println("    7. Return to the previous song");
      System.out.println("    8. Exit");
   do{ //do while loop to continue running the program until the user decides to exit
      System.out.print("Choice: ");
      answer = keyboard.nextInt();
      
      switch(answer) //switch to determine the users choice from the list 
      {
         case 1: //case 1 to add a new song to the playlist 
            System.out.print("Enter the name of the song: ");
            songName = keyboard.next();
            System.out.print("Enter the name of the artist: ");
            artistName = keyboard.next();
            System.out.print("Enter the name of the album: ");
            albumName = keyboard.next();
            keyboard.nextLine();
            System.out.print("Enter the song length: ");
            songLength = keyboard.nextInt();
            Song one = new Song(songName, artistName, albumName, songLength); //create new song object to add to playlist
            newPlaylist.addSong(one);
            if(newPlaylist.getSize()==1)
            {
               currentSong = newPlaylist.getHead().getNext();
            }
            System.out.println("Song has been added to the playlist.");
            break;
         case 2: //asks the user to enter information to create a new song objet and add it to the list after the current song
            System.out.print("Enter the name of the song: ");
            songName = keyboard.next();
            System.out.print("Enter the name of the artist: ");
            artistName = keyboard.next();
            System.out.print("Enter the name of the album: ");
            albumName = keyboard.next();
            keyboard.nextLine();
            System.out.print("Enter the song length: ");
            songLength = keyboard.nextInt();
            Song song = new Song(songName, artistName, albumName, songLength);
            if(currentSong == newPlaylist.getTail()) //if there is no other song in the playlist it simply just adds a song
            {
               newPlaylist.addSong(song);
            }
            else //else it will add the song after the current song
            {
               newPlaylist.insertAfter(song, currentSong);
            }
            break;
         case 3: //prints the current playlist
            System.out.println("Current playlist: ");
            System.out.println(newPlaylist); 
            break;
         case 4://will displasy the current song that is playing 
            System.out.println("Current song playing: " + currentSong.getName() + " by " + currentSong.getArtist()+ " from album " + currentSong.getAlbum());
            break;

         case 5:// will remove the current song from the playlist calling the remove method and updating the current song
            if(currentSong == newPlaylist.getTail()) //if the current song is the last song in the playlist it will give an error not allowing it to be removed
            {
               System.out.println("Cannot remove the last song in the playlist");
            }
            newPlaylist.removeSong(currentSong); //remove song
            System.out.println(currentSong.getName() + " has been removed from the playlist."); //update the user that the song has been removed
            currentSong = newPlaylist.getHead().getNext();
            break;
         case 6://will skip to the next song in the playlist and upon reaching the last song will point back to the first song
            currentSong = currentSong.getNext();
            if(currentSong != newPlaylist.getTail()) //checks to see if the current song is the last song in the list if so then it proceeds to the else statement
            {
            System.out.println("Song skipped to new song " + currentSong.getName());
            }
            else //makes the next position after the last song move back to the beginning of the playlist
            {
               currentSong = newPlaylist.getHead().getNext();
               System.out.println("Song skipped to new song " + currentSong.getName());
            }
            break;
            
         case 7: //will go to the previous song and upon reaching the first song will then point to the last song in the playlist
            Song temp = currentSong.getPrev();
            currentSong = temp;
            if(currentSong != newPlaylist.getHead()) //to decide if the current song is at the head position or not. If it is then it will proceed to the else
            {
            System.out.println("Previous song is: " + currentSong.getName());
            }
            else //since the position is at the head the following previous song will be the last song in the list
            {
               currentSong = newPlaylist.getTail().getPrev();
               System.out.println("Previous song is: " + currentSong.getName());
            }
            break;
         case 8: //exits the program upon selecting this
            System.out.println("Exiting the program, have a nice day!");
            System.exit(0);
            break;
         default://if an invalid input is entered then it lets the user know and asks for another input
            System.out.println("Invalid Option, try again.");
            break;
      
      
      }
      }while(answer!=8);//will continue as long as the answer doesn't equal 8
   
   
   }
   

}