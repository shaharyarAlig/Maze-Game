import javazoom.jl.player.*;
import java.io.FileInputStream;
public class bgmusic implements Runnable{
	
	public bgmusic(){
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream file=new FileInputStream("music/music.mp3");
			Player playmp3=new Player(file);
			playmp3.play();
		}
		catch(Exception ex)
		{
			
		}
		
	}
	
	
}
