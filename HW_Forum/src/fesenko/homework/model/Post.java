package fesenko.homework.model;
import java.time.LocalDateTime;
import java.util.Objects;

public class Post implements Comparable <Post> {
	String autor;
	int postId;
	String title;
	String content;
	LocalDateTime date;
	int likes;

	public Post(String autor, int postId, String title, String content) {

		this.autor = autor;
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.date = LocalDateTime.now();
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getAutor() {
		return autor;
	}

	public int getPostId() {
		return postId;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public int getLikes() {
		return likes;
	}

	@Override
	public String toString() {
		return "Post [autor=" + autor + ", postId=" + postId + ", title=" + title + ", content=" + content + ", date="
				+ date + ", likes=" + likes + "]";
	}

	public int addLike() {
		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(postId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return postId == other.postId;
	}

	@Override
	public int compareTo(Post o) {
		int res = date.compareTo(o.date);
		return res != 0 ? res: Integer.compare(postId, o.postId);
	}

}
