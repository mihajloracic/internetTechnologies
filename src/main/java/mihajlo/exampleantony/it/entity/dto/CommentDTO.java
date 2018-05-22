package mihajlo.exampleantony.it.entity.dto;

public class CommentDTO {
    public String commentText;
    public Long userId;
    public Long placesId;
    public CommentDTO(String commentText, Long userId, Long placeId) {
        this.commentText = commentText;
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

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
