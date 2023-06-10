package telran.photo.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Photo implements Comparable<Photo>{
int alumId;
int photoId;
String title;
String url;
LocalDateTime data;

public Photo(int alumId, int photoId, String title, String url, LocalDateTime data) {
	super();
	this.alumId = alumId;
	this.photoId = photoId;
	this.title = title;
	this.url = url;
	this.data = data;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}

public int getAlumId() {
	return alumId;
}

public int getPhotoId() {
	return photoId;
}

public LocalDateTime getData() {
	return data;
}

@Override
public String toString() {
	return "Photo [alumId=" + alumId + ", photoId=" + photoId + ", title=" + title + ", url=" + url + ", data=" + data
			+ "]";
}

@Override
public int hashCode() {
	return Objects.hash(alumId, photoId);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Photo other = (Photo) obj;
	return alumId == other.alumId && photoId == other.photoId;
}

@Override
public int compareTo(Photo o) {
	// TODO Auto-generated method stub
	return data.compareTo(o.data);
}







}
