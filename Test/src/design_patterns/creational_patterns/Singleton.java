package design_patterns.creational_patterns;

class AudioSettings{
    private static AudioSettings instance;

    public float getSfx() {
        return sfx;
    }

    public void setSfx(float sfx) {
        this.sfx = sfx;
    }

    private float sfx;

    public float getMusic() {
        return music;
    }

    public void setMusic(float music) {
        this.music = music;
    }

    private float music;

    private AudioSettings(){
        sfx=music=1.0f;
    }

    public static AudioSettings getInstance(){
            if (instance == null)
                instance=new AudioSettings();
            return instance;
    }

    @Override
    public String toString() {
        return "AudioSettings{" +
                "sfx=" + sfx +
                ", music=" + music +
                '}';
    }
}
public class Singleton {
    public static void main(String[] args) {
        AudioSettings a=AudioSettings.getInstance();
        a.setMusic(0.6f);
        a.setSfx(0.5f);
        System.out.println(a);
        AudioSettings b=AudioSettings.getInstance();
        b.setMusic(0.2f);
        System.out.println(b);
        AudioSettings c=AudioSettings.getInstance();
        c.setSfx(0.8f);
        System.out.println(c);
    }
}
