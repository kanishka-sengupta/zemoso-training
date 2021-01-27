package design_patterns;

interface MediaPlayer{
    void play(String audioType,String fileName);
}
interface AdvancedMediaPlayer{
    void playMP4Files(String fileName);
    void playVLCFiles(String fileName);
}
class AudioPlayer implements MediaPlayer{

    MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3"))
            System.out.println("Playing mp3 file:"+fileName+"."+audioType);
        else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);
        }else{
            System.out.println("File format "+audioType+" is not supported");
        }
    }
}
class MP4Player implements AdvancedMediaPlayer{

    @Override
    public void playMP4Files(String fileName) {
        System.out.println("MP4 Playing "+fileName);
    }

    @Override
    public void playVLCFiles(String fileName) {
        System.out.println("VLC Not Supported");
    }
}
class VLCPlayer implements AdvancedMediaPlayer{

    @Override
    public void playMP4Files(String fileName) {
        System.out.println("MP4 Player Not supported");
    }

    @Override
    public void playVLCFiles(String fileName) {
        System.out.println("VLC Playing "+fileName);
    }
}
//Acts as an adapter
class MediaAdapter implements MediaPlayer{
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc"))
            this.advancedMediaPlayer=new VLCPlayer();
        else if (audioType.equalsIgnoreCase("mp4"))
            this.advancedMediaPlayer=new MP4Player();
    }
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc"))
            this.advancedMediaPlayer.playVLCFiles(fileName);
        else if(audioType.equalsIgnoreCase("mp4"))
            this.advancedMediaPlayer.playMP4Files(fileName);
    }
}
public class AdapterPattern {
    public static void main(String[] args) {
        AudioPlayer audioPlayer=new AudioPlayer();
        audioPlayer.play("mp3","teen_spirit");
        audioPlayer.play("mp4","family_guy");
        audioPlayer.play("avi","home_work");
    }
}
