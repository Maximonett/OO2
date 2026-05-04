public class VideoStreamAdapter extends Media{
    private VideoStream videoStream;

    public VideoStreamAdapter(VideoStream videoStream){
        this.videoStream=videoStream;
    }

    public void play(){
        this.videoStream.reproduce();
    }

}
