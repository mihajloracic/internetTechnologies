package mihajlo.exampleantony.it.entity.dto;

public class CommentDTO {
    public String text;
    public Long userId;
    public Long placesId;
    public CommentDTO(String text, Long userId,Long placeId) {
        this.text = text;
        this.userId = userId;
        this.placesId = placeId;
    }

    public CommentDTO(){

    }

    public Long getPlacesId() {
        return placesId;
    }

    public void setPlacesId(Long placesId) {
        this.placesId = placesId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
